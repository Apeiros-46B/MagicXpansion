package me.apeiros.magicxpansion.setup.items.spells;


import io.github.thebusybiscuit.slimefun4.core.attributes.RandomMobDrop;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.apeiros.magicxpansion.utils.GradientUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.awt.Color;

public class IllusionSpellbook extends SimpleSlimefunItem<ItemUseHandler> implements RandomMobDrop {

    private static final int[] EXP_INPUT = {10, 19, 28, 37};
    private static final int[] EXP_INPUT_BG = {0, 1, 2, 9, 11, 18, 20, 27, 29, 36, 38, 45, 47};

    private static final int[] SPELL_LIST = {13, 14, 15, 16, 22, 23, 24, 25, 31, 32, 33, 34, 40, 41, 42, 43};
    private static final int[] SPELL_LIST_BG = {3, 4, 5, 6, 7, 8, 12, 17, 21, 26, 30, 35, 39, 44, 48, 49, 50, 51, 52, 53};

    public IllusionSpellbook(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public int getMobDropChance() {
        return 15;
    }

    @Override
    public ItemUseHandler getItemHandler() {
        return (e) -> {
            openIllusionSpellbookMenu(e.getPlayer());
        };
    }

    public void openIllusionSpellbookMenu(Player p) {
        ChestMenu menu = new ChestMenu(ChatColor.BOLD + "" +
                    GradientUtils.makeStringGradient("Spellbook of Illusions",
                            new Color(85, 85, 255),
                            new Color(147, 0, 255)));

        for (int slot : SPELL_LIST_BG) {
            menu.addItem(slot, new CustomItem(new ItemStack(Material.ORANGE_STAINED_GLASS_PANE),
                    GradientUtils.makeStringGradient("Spell List",
                            new Color(254, 75, 75),
                            new Color(255, 160, 18))),
                    ChestMenuUtils.getEmptyClickHandler());
        }

        for (int slot : EXP_INPUT_BG) {
            menu.addItem(slot, new CustomItem(new ItemStack(Material.LIME_STAINED_GLASS_PANE),
                    GradientUtils.makeStringGradient("EXP Crystal Input",
                            new Color(85, 255, 85),
                            new Color(84, 255, 237))),
                    ChestMenuUtils.getEmptyClickHandler());
        }

        menu.open(p);
    }

}