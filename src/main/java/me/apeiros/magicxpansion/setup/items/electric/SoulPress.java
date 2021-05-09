package me.apeiros.magicxpansion.setup.items.electric;

import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.apeiros.magicxpansion.setup.MagicXpansionItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

public class SoulPress extends AContainer implements RecipeDisplayItem {

    public SoulPress(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    protected void registerDefaultRecipes() {
        this.addRecipe(60, new SlimefunItemStack(MagicXpansionItems.SOUL, 6), MagicXpansionItems.SOUL_CLUSTER);
    }

    private void addRecipe(int seconds, ItemStack input, ItemStack output) {
        this.registerRecipe(seconds, new ItemStack[]{input}, new ItemStack[]{output});
    }

    public ItemStack getProgressBar() {
        return MagicXpansionItems.SOUL;
    }

    public String getMachineIdentifier() {
        return "SOUL_PRESS";
    }
}
