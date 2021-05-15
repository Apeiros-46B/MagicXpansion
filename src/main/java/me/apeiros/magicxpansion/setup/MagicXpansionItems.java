package me.apeiros.magicxpansion.setup;

import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import me.apeiros.magicxpansion.utils.HeadTextures;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;

import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public final class MagicXpansionItems {

    public static final SlimefunItemStack ENDER_LUMP_4 = new SlimefunItemStack("ENDER_LUMP_4", Material.GOLD_NUGGET, "&5Ender Lump &7- &eIV", "", "&c&oTier: IV");
    public static final SlimefunItemStack ENDER_LUMP_5 = new SlimefunItemStack("ENDER_LUMP_5", Material.GOLD_NUGGET, "&5Ender Lump &7- &eV", "", "&c&oTier: V");

    public static final SlimefunItemStack CARBON_CRUSHER_MACHINE = new SlimefunItemStack("CARBON_CRUSHER", Material.PISTON, "&bCarbon Crusher", "", "&bCrushes Diamonds into Carbon.");

    public static final SlimefunItemStack ARCANIUM_ORE = new SlimefunItemStack("ARCANIUM_ORE", HeadTextures.ARCANIUM_ORE_TEXTURE,
            "&cArcanium Ore", "&7GEO-Mined in the End Dimension", "&7You can smelt this into an Ingot in a Smeltery.");
    public static final SlimefunItemStack ARCANIUM_INGOT = new SlimefunItemStack("ARCANIUM_INGOT", Material.NETHER_BRICK,
            "&c&lArcanium Ingot", "&5This magical ingot glows with power.");

    static {
        ARCANIUM_INGOT.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ARCANIUM_INGOT.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack REINFORCED_SHULKER_SHELL = new SlimefunItemStack("REINFORCED_SHULKER_SHELL", Material.SHULKER_SHELL, "&6Reinforced Shulker Shell", "", "&aForged from the strongest of material,", "&athis Shulker Shell is almost unbreakable.");
    public static final SlimefunItemStack REINFORCED_SHULKER_BOX = new SlimefunItemStack("REINFORCED_SHULKER_BOX", Material.SHULKER_BOX, "&5&lReinforced Shulker Box", "", "&a6-row storage.", "&aBlast-resistant.");

    public static final SlimefunItemStack SHULKER_ALLOY_INGOT = new SlimefunItemStack("SHULKER_ALLOY_INGOT", Material.IRON_INGOT,
            "&dShulkerium Alloy Ingot", "", "&aThis highly radioactive ingot is almost as durable as netherite.", "", LoreBuilder.radioactive(Radioactivity.VERY_HIGH), LoreBuilder.HAZMAT_SUIT_REQUIRED);

    static {
        SHULKER_ALLOY_INGOT.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        SHULKER_ALLOY_INGOT.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack REFINED_SHULKER_ALLOY = new SlimefunItemStack("REFINED_SHULKER_ALLOY", HeadTextures.REFINED_SHULKER_ALLOY_TEXTURE,
            "&d&lEnriched Shulkerium Alloy", "", "&aForged by the Ancient Spirits of the &bOverworld&a, &cUnderworld&a, and &dEnd &adimensions,",
            "&athis alloy is &l5 times &r&astronger than netherite.", "", LoreBuilder.radioactive(Radioactivity.VERY_DEADLY), LoreBuilder.HAZMAT_SUIT_REQUIRED);

    public static final SlimefunItemStack NETHER_STAR_BLOCK = new SlimefunItemStack("NETHER_STAR_BLOCK", Material.IRON_BLOCK,
            "&dNether Star Block", "", "&cWith fury fueled by the power of the ancient souls,", "&cit glows with the radiance of The Wither.", "",
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

    public static final SlimefunItemStack NETHER_CROSSBOW = new SlimefunItemStack("NETHER_CROSSBOW", Material.CROSSBOW,
            "&cCrossbow of the Nether", "", "&cSets arrows ablaze and has a chance",  "&cto shoot a blaze fireball.");

    static {
        NETHER_CROSSBOW.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 5);
        NETHER_CROSSBOW.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
        NETHER_CROSSBOW.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
    }

    public static final SlimefunItemStack NAUTILUS_FOSSIL = new SlimefunItemStack("NAUTILUS_FOSSIL", HeadTextures.NAUTILUS_FOSSIL_TEXTURE,
            "&9Nautilus Fossil", "", "&7GEO-Mined from Cold, Normal, and Lukewarm Oceans.");

    public static final SlimefunItemStack PRISTINIUM_ORB = new SlimefunItemStack("PRISTINIUM_ORB", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRiYTY0MmVmZmZhMTNlYzM3MzBlYWZjNTkxNGFiNjgxMTVjMWY5OTg4MDNmNzQ0NTJlMmUwY2QyNmFmMGI4In19fQ==",
            "&bPristinium Orb", "", "&7Crystal clear.", "&7There are no impurities.");

    public static final SlimefunItemStack BLESSED_AQUATIC_NETHERITE_INGOT = new SlimefunItemStack("BLESSED_AQUATIC_NETHERITE_INGOT", Material.NETHERITE_INGOT,
            "&b&lBlessed Aquatic Netherite Ingot", "", "&a&oBlessed by Poseidon himself.");

    static {
        BLESSED_AQUATIC_NETHERITE_INGOT.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        BLESSED_AQUATIC_NETHERITE_INGOT.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack POSEIDONS_TRIDENT = new SlimefunItemStack("POSEIDONS_TRIDENT", Material.TRIDENT,
            "&bPoseidon's Trident", "", "&a&oNever leaves your hand.", "&a&oHas the power to summon lightning", "&a&oin the middle of a sunny day.");

    static {
        POSEIDONS_TRIDENT.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
        POSEIDONS_TRIDENT.addUnsafeEnchantment(Enchantment.DURABILITY, 8);
        POSEIDONS_TRIDENT.addUnsafeEnchantment(Enchantment.CHANNELING, 5);
        POSEIDONS_TRIDENT.addUnsafeEnchantment(Enchantment.LOYALTY, 7);
        POSEIDONS_TRIDENT.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
    }

    public static final SlimefunItemStack ENERGY_CORE = new SlimefunItemStack("ENERGY_CORE", HeadTextures.ENERGY_CORE_TEXTURE,
            "&bCore of Energy", "", "&a&oIt radiates with a forgotten energy...", "", LoreBuilder.radioactive(Radioactivity.VERY_HIGH), LoreBuilder.HAZMAT_SUIT_REQUIRED);
    public static final SlimefunItemStack STAFF_ENERGIZED_WIND = new SlimefunItemStack("STAFF_ENERGIZED_WIND", Material.BLAZE_ROD,
            "&6&lEnergized Staff &7- &bWind", "", "&7Element: &b&oWind", "", "&eRight Click &7to launch yourself forward.", "&aDoesn't require an energy source.");

    static {
        STAFF_ENERGIZED_WIND.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        STAFF_ENERGIZED_WIND.addFlags(ItemFlag.HIDE_ENCHANTS);
    }
    public static final SlimefunItemStack REAPER_SCYTHE = new SlimefunItemStack("REAPER_SCYTHE", Material.IRON_HOE,
            "&cThe Reaper's Scythe", "&7Extricate III", "", "&cThis scythe can extract &bSouls &cfrom killed", "&cmobs and drop them on the ground in", "&ca condensed, corporeal form.", "", "&5&oWithers may drop extra souls.");

    static {
        ItemMeta meta = REAPER_SCYTHE.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,
                new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 5,
                        AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));

        REAPER_SCYTHE.setItemMeta(meta);

        REAPER_SCYTHE.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
        REAPER_SCYTHE.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
        REAPER_SCYTHE.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
    }

    public static final SlimefunItemStack SOUL = new SlimefunItemStack("SOUL", Material.BLUE_DYE,
            "&bSoul");

    static {
        SOUL.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        SOUL.addFlags(ItemFlag.HIDE_ENCHANTS);
    }

    public static final SlimefunItemStack BASIC_SPELLBOOK = new SlimefunItemStack("BASIC_SPELLBOOK", Material.ENCHANTED_BOOK,
            "&a&lBasic Spellbook", "", "&2A repository of ancient spells", "&2used by the Evoker illagers.", "&2&oI wonder if I can make use of this too...");

    public static final SlimefunItemStack SOUL_MANIPULATOR = new SlimefunItemStack("SOUL_MANIPULATOR", Material.LIGHT_BLUE_STAINED_GLASS,
            "&b&lSoul Manipulator", "",
            "&aCan extract Souls from Soul Sand", "&aand Soul Soil.",
            "&9Can also compress Souls into fuel.",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(256),
            LoreBuilder.powerBuffer(128));

    public static final SlimefunItemStack SOUL_ORB = new SlimefunItemStack("SOUL_ORB", HeadTextures.SOUL_ORB_TEXTURE,
            "&9Soul Orb", "", "&bThe most dense form in which", "&bSouls can be found.", "&9&oCan be used as fuel", "&9&oin the Soul Reactor.");

    public static final SlimefunItemStack SOUL_REACTOR_COOLANT = new SlimefunItemStack ("SOUL_COOLANT", HeadTextures.SOUL_REACTOR_COOLANT_TEXTURE,
            "&b&lSoul Reactor Coolant Cell", "", "&boUsed to cool a Soul Reactor.", "&4Your reactor will explode otherwise.");

    public static final SlimefunItemStack SOUL_REACTOR_CATALYST = new SlimefunItemStack("SOUL_REACTOR_CATALYST", HeadTextures.SOUL_REACTOR_CATALYST_TEXTURE,
            "&9&lSoul Reactor Catalyst", "", "&b&oPart of a Soul Reactor");

    public static final SlimefunItemStack SOUL_REACTOR_CORE = new SlimefunItemStack("SOUL_REACTOR_CORE", HeadTextures.SOUL_REACTOR_CORE_TEXTURE,
            "&9&lSoul Reactor Core", "", "&b&oThe heart of a Soul Reactor");

    public static final SlimefunItemStack SOUL_REACTOR = new SlimefunItemStack("SOUL_REACTOR", HeadTextures.SOUL_REACTOR_TEXTURE,
            "&bSoul Reactor", "",
            "&9&oExtracts cosmic energy from Souls",
            "&8⇨ &bMust be surrounded by Water",
            "&8⇨ &bMust be supplied with Soul Coolant Cells", "",
            "&9Celestial Generator",
            LoreBuilder.powerBuffer(65536), LoreBuilder.powerPerSecond(2048));
}
