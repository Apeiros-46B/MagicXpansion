package me.apeiros.magicxpansion.setup.items.electric;

import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import me.apeiros.magicxpansion.setup.MagicXpansionItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class SoulManipulator extends AContainer implements RecipeDisplayItem {

    public SoulManipulator(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    protected void registerDefaultRecipes() {
        this.addRecipe(15, new ItemStack(Material.SOUL_SAND, 4), MagicXpansionItems.SOUL);
        this.addRecipe(30, new ItemStack(Material.SOUL_SOIL, 2), MagicXpansionItems.SOUL);
        this.addRecipe(60, new SlimefunItemStack(MagicXpansionItems.SOUL, 6), MagicXpansionItems.SOUL_ORB);
    }

    private void addRecipe(int seconds, ItemStack input, ItemStack output) {
        this.registerRecipe(seconds, new ItemStack[]{input}, new ItemStack[]{output});
    }

    public ItemStack getProgressBar() {
        return MagicXpansionItems.SOUL;
    }

    @Nonnull
    public String getMachineIdentifier() {
        return "SOUL_PRESS";
    }
}
