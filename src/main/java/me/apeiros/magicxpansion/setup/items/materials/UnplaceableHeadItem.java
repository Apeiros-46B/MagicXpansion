package me.apeiros.magicxpansion.setup.items.materials;

import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class UnplaceableHeadItem extends UnplaceableBlock {

    public UnplaceableHeadItem(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

}
