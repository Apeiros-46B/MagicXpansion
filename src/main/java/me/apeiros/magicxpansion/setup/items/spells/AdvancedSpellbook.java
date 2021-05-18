package me.apeiros.magicxpansion.setup.items.spells;

import org.bukkit.inventory.ItemStack;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class AdvancedSpellbook extends SimpleSlimefunItem<ItemUseHandler> {

    private static final int[] EXP_INPUT = {10, 19, 28, 37};
    private static final int[] EXP_INPUT_BG = {0, 1, 2, 9, 11, 18, 20, 27, 29, 36, 38, 45, 47};

    private static final int[] SPELL_LIST = {13, 14, 15, 16, 22, 23, 24, 25, 31, 32, 33, 34, 40, 41, 42, 43};
    private static final int[] SPELL_LIST_BG = {3, 4, 5, 6, 7, 8, 12, 17, 21, 26, 30, 35, 39, 44, 48, 50, 51, 53};

    private static final int PREVIOUS_PAGE = 49;
    private static final int NEXT_PAGE = 52;

    public AdvancedSpellbook(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public ItemUseHandler getItemHandler() {
        return (e) -> {
        };
    }

}