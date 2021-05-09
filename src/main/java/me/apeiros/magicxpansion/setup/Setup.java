package me.apeiros.magicxpansion.setup;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.core.multiblocks.MultiBlockMachine;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.VanillaItem;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.HeatedPressureChamber;
import me.apeiros.magicxpansion.setup.items.georesources.*;
import me.apeiros.magicxpansion.setup.items.materials.*;
import me.apeiros.magicxpansion.setup.items.multiblocks.*;
import me.apeiros.magicxpansion.setup.items.tools.*;
import me.apeiros.magicxpansion.setup.items.weapons.*;
import me.apeiros.magicxpansion.utils.Categories;
import me.gallowsdove.foxymachines.Items;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import static me.apeiros.magicxpansion.setup.MagicXpansionItems.*;
import static me.apeiros.magicxpansion.utils.RecipeTypes.*;

public class Setup {

    public static void setup(JavaPlugin plugin) {
        // Register Category
        Categories.MAIN.register((SlimefunAddon) plugin);

        // Register Ender Lumps IV and V
        SlimefunItem enderLump4 = new Lump(Categories.RESOURCES, ENDER_LUMP_4, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                        SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_LUMP_3, null,
                        SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_LUMP_3, null,
                        null, null, null});
        enderLump4.register((SlimefunAddon) plugin);

        SlimefunItem enderLump5 = new Lump(Categories.RESOURCES, ENDER_LUMP_5, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                        ENDER_LUMP_4, ENDER_LUMP_4, null,
                        ENDER_LUMP_4, ENDER_LUMP_4, null,
                        null, null, null});
        enderLump5.register((SlimefunAddon) plugin);

        // Register Nether Star Block
        SlimefunItem netherStarBlock = new NetherStarBlock(Categories.RESOURCES, NETHER_STAR_BLOCK, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        new ItemStack(Material.NETHER_STAR), SlimefunItems.STRANGE_NETHER_GOO, new ItemStack(Material.NETHER_STAR),
                        Items.DEMONIC_INGOT, new ItemStack(Material.NETHERITE_BLOCK), Items.DEMONIC_INGOT,
                        new ItemStack(Material.NETHER_STAR), SlimefunItems.STRANGE_NETHER_GOO, new ItemStack(Material.NETHER_STAR)
                });
        netherStarBlock.register((SlimefunAddon) plugin);

        // Register Carbon Crusher
        MultiBlockMachine carbonCrusher = new CarbonCrusherMachine(Categories.MACHINES, CARBON_CRUSHER_MACHINE);
        carbonCrusher.register((SlimefunAddon) plugin);

        // Register Arcanium Ore and Arcanium Ingot
        SlimefunItem arcaniumOre = new UnplaceableHeadResource(Categories.RESOURCES, ARCANIUM_ORE, RecipeType.GEO_MINER, new ItemStack[9]);
        arcaniumOre.register((SlimefunAddon) plugin);

        SlimefunItem arcaniumIngot = new Resource(Categories.RESOURCES, ARCANIUM_INGOT, RecipeType.SMELTERY,
                new ItemStack[] {
                        ARCANIUM_ORE, null, null,
                        null, null, null,
                        null, null, null});
        arcaniumIngot.register((SlimefunAddon) plugin);

        // Register Reinforced Shulker Shell and Reinforced Shulker Box
        SlimefunItem reinforcedShulkerShell = new CraftingItem(Categories.RESOURCES, REINFORCED_SHULKER_SHELL, RecipeType.SMELTERY,
                new ItemStack[] {
                        new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL),
                        new ItemStack(Material.SHULKER_SHELL), SlimefunItems.REINFORCED_PLATE, new ItemStack(Material.SHULKER_SHELL),
                        new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL)});
        reinforcedShulkerShell.register((SlimefunAddon) plugin);

        SlimefunItem reinforcedShulkerBox = new ContainerItem(Categories.UTILITIES, REINFORCED_SHULKER_BOX, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.OBSIDIAN), REINFORCED_SHULKER_SHELL, new ItemStack(Material.OBSIDIAN),
                        new ItemStack(Material.OBSIDIAN), new ItemStack(Material.CHEST), new ItemStack(Material.OBSIDIAN),
                        new ItemStack(Material.OBSIDIAN), REINFORCED_SHULKER_SHELL, new ItemStack(Material.OBSIDIAN)});
        reinforcedShulkerBox.register((SlimefunAddon) plugin);

        // Register Shulkerium Alloys
        SlimefunItem shulkerAlloyIngot = new ShulkerAlloy(Categories.RESOURCES, SHULKER_ALLOY_INGOT, RecipeType.SMELTERY,
                new ItemStack[] {
                        REINFORCED_SHULKER_SHELL, Items.DEMONIC_INGOT, null, null, null, null, null, null, null});
        shulkerAlloyIngot.register((SlimefunAddon) plugin);

        SlimefunItem refinedShulkerAlloyChunk = new RefinedShulkerAlloy(Categories.RESOURCES, REFINED_SHULKER_ALLOY, RecipeType.SMELTERY,
                new ItemStack[] {
                        Items.DEMONIC_INGOT, SlimefunItems.REINFORCED_ALLOY_INGOT, ARCANIUM_INGOT,
                        SlimefunItems.CARBONADO, SHULKER_ALLOY_INGOT, SlimefunItems.CARBONADO,
                        SlimefunItems.SYNTHETIC_SHULKER_SHELL, SlimefunItems.HARDENED_METAL_INGOT, SlimefunItems.SYNTHETIC_SHULKER_SHELL});
        refinedShulkerAlloyChunk.register((SlimefunAddon) plugin);

        // Register Crossbow of Infinity
        SlimefunItem infinityCrossbow = new CustomCrossbow(Categories.WEAPONS, INFINITY_CROSSBOW, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        SlimefunItems.CARBON_CHUNK, SlimefunItems.ENDER_RUNE, SlimefunItems.CARBON_CHUNK,
                        SlimefunItems.SYNTHETIC_EMERALD, new ItemStack(Material.CROSSBOW), SlimefunItems.SYNTHETIC_EMERALD,
                        ARCANIUM_INGOT, SlimefunItems.ENDER_RUNE, ARCANIUM_INGOT});
        infinityCrossbow.register((SlimefunAddon) plugin);

        // Register Crossbow of Rapidity
        SlimefunItem rapidCrossbow = new CustomCrossbow(Categories.WEAPONS, RAPID_CROSSBOW, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        ARCANIUM_INGOT, SlimefunItems.SLIME_LEGGINGS_STEEL, ARCANIUM_INGOT,
                        SlimefunItems.MAGIC_SUGAR, new ItemStack(Material.CROSSBOW), SlimefunItems.MAGIC_SUGAR,
                        SlimefunItems.ENCHANTMENT_RUNE, SlimefunItems.MAGICAL_GLASS, SlimefunItems.ENDER_RUNE
                });
        rapidCrossbow.register((SlimefunAddon) plugin);

        // Register Crossbow of the Nether
        SlimefunItem netherCrossbow = new CustomCrossbow(Categories.WEAPONS, NETHER_CROSSBOW, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        new ItemStack(Material.BLAZE_ROD), SlimefunItems.NETHER_ICE, new ItemStack(Material.BLAZE_ROD),
                        SlimefunItems.FIRE_RUNE, new ItemStack(Material.CROSSBOW), SlimefunItems.FIRE_RUNE,
                        SlimefunItems.HEATING_COIL, new ItemStack(Material.NETHERITE_INGOT), SlimefunItems.HEATING_COIL
                });
        netherCrossbow.register((SlimefunAddon) plugin);

        // Register Nautilus Fossil and Nautilus Shell
        SlimefunItem nautilusFossil = new UnplaceableHeadResource(Categories.GENERAL, NAUTILUS_FOSSIL, RecipeType.GEO_MINER, new ItemStack[9]);
        nautilusFossil.register((SlimefunAddon) plugin);

        VanillaItem nautilusShell = new VanillaItem(Categories.GENERAL, new ItemStack(Material.NAUTILUS_SHELL), "NAUTILUS_SHELL", RecipeType.ORE_WASHER,
                new ItemStack[] {
                        NAUTILUS_FOSSIL, null, null,
                        null, null, null,
                        null, null, null
        });
        nautilusShell.register((SlimefunAddon) plugin);

        // Register Trident
        VanillaItem trident = new VanillaItem(Categories.WEAPONS, new ItemStack(Material.TRIDENT), "TRIDENT", RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        Items.AQUATIC_NETHERITE_INGOT, new ItemStack(Material.NAUTILUS_SHELL), Items.AQUATIC_NETHERITE_INGOT,
                        Items.MAGIC_LUMP_5, new ItemStack(Material.HEART_OF_THE_SEA), Items.MAGIC_LUMP_5,
                        Items.AQUATIC_NETHERITE_INGOT, Items.POSEIDONS_BLESSING, Items.AQUATIC_NETHERITE_INGOT
                });
        trident.register((SlimefunAddon) plugin);

        // Register Pristinium Orb
        SlimefunItem pristiniumOrb = new Resource(Categories.RESOURCES, PRISTINIUM_ORB, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        Items.AQUATIC_NETHERITE_INGOT, new ItemStack(Material.NAUTILUS_SHELL), Items.AQUATIC_NETHERITE_INGOT,
                        new ItemStack(Material.BLUE_ICE), new ItemStack(Material.HEART_OF_THE_SEA), new ItemStack(Material.BLUE_ICE),
                        Items.AQUATIC_NETHERITE_INGOT, new ItemStack(Material.NAUTILUS_SHELL), Items.AQUATIC_NETHERITE_INGOT
                });
        pristiniumOrb.register((SlimefunAddon) plugin);

        // Register Blessed Aquatic Netherite Ingot
        SlimefunItem blessedAquaticNetheriteIngot = new Resource(Categories.RESOURCES, BLESSED_AQUATIC_NETHERITE_INGOT, RecipeType.SMELTERY,
                new ItemStack[] {
                        Items.AQUATIC_NETHERITE_INGOT, Items.MAGIC_LUMP_5, Items.POSEIDONS_BLESSING,
                        null, null, null,
                        null, null, null});
        blessedAquaticNetheriteIngot.register((SlimefunAddon) plugin);

        // Register Poseidon's Trident
        SlimefunItem poseidonsTrident = new PoseidonsTrident(Categories.WEAPONS, POSEIDONS_TRIDENT, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        BLESSED_AQUATIC_NETHERITE_INGOT, SlimefunItems.REINFORCED_PLATE, BLESSED_AQUATIC_NETHERITE_INGOT,
                        SlimefunItems.GPS_TELEPORTATION_MATRIX, new ItemStack(Material.TRIDENT), SlimefunItems.GPS_TRANSMITTER,
                        BLESSED_AQUATIC_NETHERITE_INGOT, PRISTINIUM_ORB, BLESSED_AQUATIC_NETHERITE_INGOT
                });
        poseidonsTrident.register((SlimefunAddon) plugin);

        // Register Core of Energy and Energized Wind Staff
        SlimefunItem energyCore = new EnergyCore(Categories.GENERAL, ENERGY_CORE, RecipeType.SMELTERY,
                new ItemStack[] {
                        SHULKER_ALLOY_INGOT, SlimefunItems.URANIUM, SHULKER_ALLOY_INGOT,
                        Items.MAGIC_LUMP_5, SlimefunItems.CARBONADO, Items.MAGIC_LUMP_5,
                        SHULKER_ALLOY_INGOT, SlimefunItems.LIGHTNING_RUNE, SHULKER_ALLOY_INGOT});
        energyCore.register((SlimefunAddon) plugin);

        SlimefunItem staffEnergizedWind = new EnergizedWindStaff(Categories.UTILITIES, STAFF_ENERGIZED_WIND, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        SlimefunItems.ELYTRA_SCALE, Items.ELECTRIC_WIND_STAFF, SlimefunItems.AIR_RUNE,
                        ENERGY_CORE, SlimefunItems.INFUSED_MAGNET, ENERGY_CORE,
                        SlimefunItems.ELECTRO_MAGNET, Items.ELECTRIC_WIND_STAFF, SlimefunItems.ELECTRO_MAGNET});
        staffEnergizedWind.register((SlimefunAddon) plugin);

        // Register Reaper Scythe and Soul
        SlimefunItem reaperScythe = new MeleeWeapon(Categories.WEAPONS, REAPER_SCYTHE, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        NETHER_STAR_BLOCK, NETHER_STAR_BLOCK, NETHER_STAR_BLOCK,
                        SlimefunItems.ESSENCE_OF_AFTERLIFE, new ItemStack(Material.TOTEM_OF_UNDYING), Items.DEMONIC_INGOT,
                        SlimefunItems.ESSENCE_OF_AFTERLIFE, SlimefunItems.ESSENCE_OF_AFTERLIFE, Items.DEMONIC_INGOT});
        reaperScythe.register((SlimefunAddon) plugin);

        SlimefunItem soul = new MeleeWeapon(Categories.WEAPONS, SOUL, REAPER_SCYTHE_TYPE,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItem(Material.DROWNED_SPAWN_EGG, "&aAny mob"), null,
                        null, null, null});
        soul.register((SlimefunAddon) plugin);

        // Register GEO-Resources
        ArcaniumOreResource arcaniumOreResource = new ArcaniumOreResource(plugin, ARCANIUM_ORE);
        arcaniumOreResource.register();

        NautilusFossilResource nautilusFossilResource = new NautilusFossilResource(plugin, NAUTILUS_FOSSIL);
        nautilusFossilResource.register();

    }
}