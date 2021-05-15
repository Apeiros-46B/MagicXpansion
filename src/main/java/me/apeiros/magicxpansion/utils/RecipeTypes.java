package me.apeiros.magicxpansion.utils;

import lombok.experimental.UtilityClass;
import me.apeiros.magicxpansion.MagicXpansion;
import me.apeiros.magicxpansion.setup.MagicXpansionItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import org.bukkit.NamespacedKey;

@UtilityClass
public class RecipeTypes {

    public static RecipeType REAPER_SCYTHE_TYPE = new RecipeType(new NamespacedKey(MagicXpansion.getInstance(), "reaper_scythe_type"), MagicXpansionItems.REAPER_SCYTHE, "", "&cHarvest it with The Reaper's Scythe");
    public static RecipeType SOUL_MANIPULATOR_TYPE = new RecipeType(new NamespacedKey(MagicXpansion.getInstance(), "soul_manipulator_type"), MagicXpansionItems.SOUL_MANIPULATOR, "", "&9Create it with the Soul Manipulator");
    public static RecipeType ADVANCED_BREWER_TYPE = new RecipeType(new NamespacedKey(MagicXpansion.getInstance(), "advanced_brewer_type"), MagicXpansionItems.SOUL_MANIPULATOR, "", "&aBrew it with the Advanced Brewer");

}
