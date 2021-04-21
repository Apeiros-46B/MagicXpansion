package me.hexagone.magicxpansion.setup;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;

import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public final class MagicXpansionItems {

    public static final SlimefunItemStack ENDER_LUMP_4 = new SlimefunItemStack("ENDER_LUMP_4", Material.GOLD_NUGGET, "&5Ender Lump &7- &eIV", "", "&c&oTier: IV");
    public static final SlimefunItemStack ENDER_LUMP_5 = new SlimefunItemStack("ENDER_LUMP_5", Material.GOLD_NUGGET, "&5Ender Lump &7- &eV", "", "&c&oTier: V");

    public static final SlimefunItemStack ARCANIUM_ORE = new SlimefunItemStack("ARCANIUM_ORE",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E2ZGNmMjc1Y2Y1OGM2NGNhN2I0ZDFmYzRlYTAwOWEyYjU2OTk1ZjUxYjU0OTg3NGJhNzg5ODZjZGVhYjdkMyJ9fX0=",
            "&cArcanium Ore", "&7GEO-Mined in the End Dimension", "&7You can smelt this into an Ingot in a Smeltery");
    public static final SlimefunItemStack ARCANIUM_INGOT = new SlimefunItemStack("ARCANIUM_INGOT", Material.NETHER_BRICK,
            "&c&lArcanium Ingot", "&5A magical ingot that glows with power");

    static {
        ARCANIUM_INGOT.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ARCANIUM_INGOT.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack REINFORCED_SHULKER_SHELL = new SlimefunItemStack("REINFORCED_SHULKER_SHELL", Material.SHULKER_SHELL, "&6Reinforced Shulker Shell", "", "&aForged from the strongest of material,", "&athis Shulker Shell is almost unbreakable.");
    public static final SlimefunItemStack REINFORCED_SHULKER_BOX = new SlimefunItemStack("REINFORCED_SHULKER_BOX", Material.SHULKER_BOX, "&5&lReinforced Shulker Box", "", "&a6-row storage", "&aBlast-resistant");

    public static final SlimefunItemStack SHULKER_ALLOY_INGOT = new SlimefunItemStack("SHULKER_ALLOY_INGOT", Material.IRON_INGOT,
            "&dShulkerium Alloy Ingot", "", "&aThis highly radioactive ingot is almost as durable as netherite.", "", LoreBuilder.radioactive(Radioactivity.VERY_HIGH), LoreBuilder.HAZMAT_SUIT_REQUIRED);

    static {
        SHULKER_ALLOY_INGOT.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        SHULKER_ALLOY_INGOT.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack REFINED_SHULKER_ALLOY_INGOT = new SlimefunItemStack("REFINED_SHULKER_ALLOY_INGOT",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTQwZGUxZmIxNDdkM2U1YjU3YzVkMjcxMTRkMzRjNjZkMDM4MDQzOWEzZjE4ZTA4OGJjZjQ3YzViMjM3YTcwZCJ9fX0=",
            "&d&lEnriched Shulkerium Alloy", "", "&aForged by the Ancient Spirits of the &bOverworld&a, &cUnderworld&a, and &dEnd &adimensions,",
            "&athis alloy is &l5 times &r&astronger than netherite.", "", LoreBuilder.radioactive(Radioactivity.VERY_DEADLY), LoreBuilder.HAZMAT_SUIT_REQUIRED);

    static {
        REFINED_SHULKER_ALLOY_INGOT.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        REFINED_SHULKER_ALLOY_INGOT.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack NETHER_STAR_BLOCK = new SlimefunItemStack("NETHER_STAR_BLOCK", Material.IRON_BLOCK,
            "&dNether Star Block", "", "&cWith fury fueled by the power of lost souls,", "&cit emanates with the power of The Wither.", "",
            LoreBuilder.radioactive(Radioactivity.VERY_DEADLY), LoreBuilder.HAZMAT_SUIT_REQUIRED);

    static {
        NETHER_STAR_BLOCK.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        NETHER_STAR_BLOCK.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack INFINITY_CROSSBOW = new SlimefunItemStack("INFINITY_CROSSBOW", Material.CROSSBOW,
            "&6Crossbow of Infinity", "", "&aNever runs out of arrows.");

    static {
        INFINITY_CROSSBOW.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
    }

    public static final SlimefunItemStack RAPID_CROSSBOW = new SlimefunItemStack("RAPID_CROSSBOW", Material.CROSSBOW,
            "&6Crossbow of Rapidity", "", "&aShoots at unparallelled speeds.");

    static {
        RAPID_CROSSBOW.addUnsafeEnchantment(Enchantment.QUICK_CHARGE, 4);
        RAPID_CROSSBOW.addUnsafeEnchantment(Enchantment.PIERCING, 5);
    }

    public static final SlimefunItemStack ENERGY_CORE = new SlimefunItemStack("ENERGY_CORE",
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODNlZDRjZTIzOTMzZTY2ZTA0ZGYxNjA3MDY0NGY3NTk5ZWViNTUzMDdmN2VhZmU4ZDkyZjQwZmIzNTIwODYzYyJ9fX0=",
            "&bCore of Energy", "", "&a&oIt radiates with a forgotten energy...", "",
            LoreBuilder.radioactive(Radioactivity.VERY_HIGH), LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack STAFF_ENERGIZED_WIND = new SlimefunItemStack("STAFF_ENERGIZED_WIND", Material.BLAZE_ROD,
            "&6&lEnergized Staff &7- &bWind", "", "&7Element: &b&oWind", "", "&eRight Click &7to launch yourself forward.", "&aDoesn't require an energy source");

    static {
        STAFF_ENERGIZED_WIND.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        STAFF_ENERGIZED_WIND.addFlags(ItemFlag.HIDE_ENCHANTS);
    }
}
