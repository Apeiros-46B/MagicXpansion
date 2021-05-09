package me.apeiros.magicxpansion.setup.items.electric;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.reactors.Reactor;
import me.apeiros.magicxpansion.setup.MagicXpansionItems;
import me.apeiros.magicxpansion.utils.HeadTextures;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public abstract class SoulReactor extends Reactor {

    private final SlimefunItemStack PROGRESS_BAR = new SlimefunItemStack("SOUL_REACTOR_PROGRESS_BAR", HeadTextures.SOUL_FIRE_TEXTURE, "", "");

    public SoulReactor(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public ItemStack getCoolant() {
        return SlimefunItems.NETHER_ICE_COOLANT_CELL;
    }

    @Nonnull
    @Override
    public ItemStack getFuelIcon() {
        return MagicXpansionItems.SOUL;
    }

    @Nonnull
    @Override
    public ItemStack getProgressBar() {
        return PROGRESS_BAR;
    }

    @Override
    protected void registerDefaultFuelTypes() {
        this.registerFuel(new MachineFuel(25, new ItemStack(Material.SOUL_SAND), new ItemStack(Material.SAND)));
        this.registerFuel(new MachineFuel(50, new ItemStack(Material.SOUL_SOIL), new ItemStack(Material.DIRT)));
        this.registerFuel(new MachineFuel(100, MagicXpansionItems.SOUL, null));
    }

    @Override
    public void extraTick(@Nonnull Location location) {
    }
}
