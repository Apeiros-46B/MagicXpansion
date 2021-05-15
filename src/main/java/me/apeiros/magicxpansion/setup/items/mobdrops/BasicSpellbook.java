package me.apeiros.magicxpansion.setup.items.mobdrops;

import org.bukkit.inventory.ItemStack;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.attributes.RandomMobDrop;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class BasicSpellbook extends SimpleSlimefunItem<ItemUseHandler> implements RandomMobDrop {

    public BasicSpellbook(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public int getMobDropChance() {
        return 15;
    }

    public boolean isDroppedFromEvokers() {
        return true;
    }

    @Override
    public ItemUseHandler getItemHandler() {
        return PlayerRightClickEvent::cancel;
    }

}