package me.apeiros.magicxpansion.setup.items.multiblocks;

import java.util.List;
import java.util.stream.Collectors;

import io.github.thebusybiscuit.slimefun4.libraries.paperlib.PaperLib;
import me.apeiros.magicxpansion.setup.MagicXpansionItems;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.core.multiblocks.MultiBlockMachine;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class CarbonCrusherMachine extends MultiBlockMachine {

    public CarbonCrusherMachine(Category category, SlimefunItemStack item) {
        super(category, item, new ItemStack[]{
                        new CustomItem(Material.PISTON, "Piston (Pointing inwards)"), new CustomItem(Material.DISPENSER, "Dispenser (Facing down)"), new CustomItem(Material.PISTON, "Piston (Pointing inwards)"),
                        new ItemStack(Material.NETHER_BRICK_STAIRS), new ItemStack(Material.NETHER_BRICK_FENCE), new ItemStack(Material.NETHER_BRICK_STAIRS),
                        new ItemStack(Material.NETHER_BRICK_WALL), MagicXpansionItems.NETHER_STAR_BLOCK, new ItemStack(Material.NETHER_BRICK_WALL)},
                BlockFace.SELF);

    }

    @Override
    protected void registerDefaultRecipes(List<ItemStack> recipes) {
        recipes.add(new ItemStack(Material.DIAMOND, 1));
        recipes.add(new SlimefunItemStack(SlimefunItems.CARBON, 1));

        recipes.add(new ItemStack(Material.DIAMOND_ORE, 1));
        recipes.add(new SlimefunItemStack(SlimefunItems.CARBON, 4));
    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
        return recipes.stream().map(items -> items[0]).collect(Collectors.toList());
    }

    @Override
    public void onInteract(Player p, Block b) {
        Block dispBlock = b.getRelative(BlockFace.UP);
        BlockState state = PaperLib.getBlockState(dispBlock, false).getState();

        if (state instanceof Dispenser) {
            Dispenser disp = (Dispenser) state;
            Inventory inv = disp.getInventory();

            for (ItemStack current : inv.getContents()) {
                for (ItemStack convert : RecipeType.getRecipeInputs(this)) {
                    if (convert != null && SlimefunUtils.isItemSimilar(current, convert, true)) {
                        ItemStack adding = RecipeType.getRecipeOutput(this, convert);
                        Inventory outputInv = findOutputInventory(adding, dispBlock, inv);

                        if (SlimefunUtils.canPlayerUseItem(p, adding, true)) {
                            if (outputInv != null) {
                                ItemStack removing = current.clone();
                                removing.setAmount(convert.getAmount());
                                inv.removeItem(removing);
                                outputInv.addItem(adding);
                                p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, 1);
                            } else {
                                SlimefunPlugin.getLocalization().sendMessage(p, "machines.full-inventory", true);
                            }
                        }

                        return;
                    }
                }
            }

            SlimefunPlugin.getLocalization().sendMessage(p, "machines.unknown-material", true);

        }
    }
}