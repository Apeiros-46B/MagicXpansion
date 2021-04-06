package me.hexagone.magicxpansion.setup.magicxpansionitems.tools;

import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import me.hexagone.magicxpansion.setup.MagicXpansionItems;
import me.mrCookieSlime.Slimefun.cscorelib2.inventory.ItemUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;

import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class KnowledgeVessel extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {

    public KnowledgeVessel(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();

            if (p.getLevel() >= 16 && (!e.getClickedBlock().isPresent() || !(e.getClickedBlock().get().getType().isInteractable()))) {
                p.setLevel(p.getLevel() - 16);

                ItemStack item = MagicXpansionItems.FilledKnowledgeVesselItem;

                if (!p.getInventory().addItem(item).isEmpty()) {
                    // The Item could not be added, let's drop it to the ground (fixes #2728)
                    p.getWorld().dropItemNaturally(p.getLocation(), item);
                }

                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1F, 0.5F);

                ItemUtils.consumeItem(e.getItem(), false);
                e.cancel();
            }
        };
    }
}
