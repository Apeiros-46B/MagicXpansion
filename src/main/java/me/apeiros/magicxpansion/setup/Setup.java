package me.apeiros.magicxpansion.setup;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.core.multiblocks.MultiBlockMachine;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.VanillaItem;
import me.apeiros.magicxpansion.listeners.CrossbowListener;
import me.apeiros.magicxpansion.listeners.TridentListener;
import me.apeiros.magicxpansion.setup.items.georesources.NautilusFossilResource;
import me.apeiros.magicxpansion.setup.items.weapons.NetherCrossbow;
import me.gallowsdove.foxymachines.Items;
import me.apeiros.magicxpansion.setup.items.georesources.ArcaniumOreResource;
import me.apeiros.magicxpansion.setup.items.materials.*;
import me.apeiros.magicxpansion.setup.items.multiblocks.CarbonCrusherMachine;
import me.apeiros.magicxpansion.setup.items.tools.ContainerItem;
import me.apeiros.magicxpansion.setup.items.tools.EnergizedWindStaff;
import me.apeiros.magicxpansion.setup.items.weapons.InfinityCrossbow;
import me.apeiros.magicxpansion.setup.items.weapons.PoseidonsTrident;
import me.apeiros.magicxpansion.setup.items.weapons.RapidCrossbow;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import static me.apeiros.magicxpansion.setup.MagicXpansionItems.*;
import static org.bukkit.Bukkit.getServer;

public class Setup {

    public static void setup(JavaPlugin plugin) {
        // Basic setup
        ItemStack categoryItem = new CustomItem(Material.END_PORTAL_FRAME, "&6MagicXpansion", "", "⇨ &aClick to open");
        NamespacedKey categoryId = new NamespacedKey(plugin, "magicxpansion_category");
        Category category = new Category(categoryId, categoryItem);

        // Register Ender Lumps IV and V
        SlimefunItem enderLump4 = new Lump(category, ENDER_LUMP_4, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                        SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_LUMP_3, null,
                        SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_LUMP_3, null,
                        null, null, null});
        enderLump4.register((SlimefunAddon) plugin);

        SlimefunItem enderLump5 = new Lump(category, ENDER_LUMP_5, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                        ENDER_LUMP_4, ENDER_LUMP_4, null,
                        ENDER_LUMP_4, ENDER_LUMP_4, null,
                        null, null, null});
        enderLump5.register((SlimefunAddon) plugin);

        // Register Nether Star Block
        SlimefunItem netherStarBlock = new NetherStarBlock(category, NETHER_STAR_BLOCK, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        new ItemStack(Material.NETHER_STAR), SlimefunItems.STRANGE_NETHER_GOO, new ItemStack(Material.NETHER_STAR),
                        Items.DEMONIC_INGOT, new ItemStack(Material.NETHERITE_BLOCK), Items.DEMONIC_INGOT,
                        new ItemStack(Material.NETHER_STAR), SlimefunItems.STRANGE_NETHER_GOO, new ItemStack(Material.NETHER_STAR)
                });
        netherStarBlock.register((SlimefunAddon) plugin);

        // Register Carbon Crusher
        MultiBlockMachine carbonCrusher = new CarbonCrusherMachine(category, new SlimefunItemStack("CARBON_CRUSHER", Material.PISTON, "&bCarbon Crusher", "", "&bCrushes Diamonds into Carbon"));
        carbonCrusher.register((SlimefunAddon) plugin);

        // Register Arcanium Ore and Arcanium Ingot
        SlimefunItem arcaniumOre = new UnplaceableHeadResource(category, ARCANIUM_ORE, RecipeType.GEO_MINER, new ItemStack[9]);
        arcaniumOre.register((SlimefunAddon) plugin);

        SlimefunItem arcaniumIngot = new Resource(category, ARCANIUM_INGOT, RecipeType.SMELTERY,
                new ItemStack[] {
                        ARCANIUM_ORE, null, null,
                        null, null, null,
                        null, null, null});
        arcaniumIngot.register((SlimefunAddon) plugin);

        // Register Reinforced Shulker Shell and Reinforced Shulker Box
        SlimefunItem reinforcedShulkerShell = new CraftingItem(category, REINFORCED_SHULKER_SHELL, RecipeType.SMELTERY,
                new ItemStack[] {
                        new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL),
                        new ItemStack(Material.SHULKER_SHELL), SlimefunItems.REINFORCED_PLATE, new ItemStack(Material.SHULKER_SHELL),
                        new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL)});
        reinforcedShulkerShell.register((SlimefunAddon) plugin);

        SlimefunItem reinforcedShulkerBox = new ContainerItem(category, REINFORCED_SHULKER_BOX, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.OBSIDIAN), REINFORCED_SHULKER_SHELL, new ItemStack(Material.OBSIDIAN),
                        new ItemStack(Material.OBSIDIAN), new ItemStack(Material.CHEST), new ItemStack(Material.OBSIDIAN),
                        new ItemStack(Material.OBSIDIAN), REINFORCED_SHULKER_SHELL, new ItemStack(Material.OBSIDIAN)});
        reinforcedShulkerBox.register((SlimefunAddon) plugin);

        // Register Shulkerium Alloys
        SlimefunItem shulkerAlloyIngot = new ShulkerAlloy(category, SHULKER_ALLOY_INGOT, RecipeType.SMELTERY,
                new ItemStack[] {
                        REINFORCED_SHULKER_SHELL, SlimefunItems.BLISTERING_INGOT_3, null, null, null, null, null, null, null});
        shulkerAlloyIngot.register((SlimefunAddon) plugin);

        SlimefunItem refinedShulkerAlloyChunk = new RefinedShulkerAlloy(category, REFINED_SHULKER_ALLOY, RecipeType.SMELTERY,
                new ItemStack[] {
                        SHULKER_ALLOY_INGOT, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.HARDENED_METAL_INGOT,
                        SlimefunItems.CARBONADO, Items.DEMONIC_INGOT, new ItemStack(Material.NETHERITE_BLOCK),
                        SlimefunItems.SYNTHETIC_SHULKER_SHELL, ARCANIUM_INGOT, SlimefunItems.SYNTHETIC_EMERALD});
        refinedShulkerAlloyChunk.register((SlimefunAddon) plugin);

        // Register Crossbow of Infinity
        SlimefunItem infinityCrossbow = new InfinityCrossbow(category, INFINITY_CROSSBOW, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        SlimefunItems.CARBON_CHUNK, SlimefunItems.ENDER_RUNE, SlimefunItems.CARBON_CHUNK,
                        SlimefunItems.SYNTHETIC_EMERALD, new ItemStack(Material.CROSSBOW), SlimefunItems.SYNTHETIC_EMERALD,
                        ARCANIUM_INGOT, SlimefunItems.ENDER_RUNE, ARCANIUM_INGOT});
        infinityCrossbow.register((SlimefunAddon) plugin);

        // Register Crossbow of Rapidity
        SlimefunItem rapidCrossbow = new RapidCrossbow(category, RAPID_CROSSBOW, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        ARCANIUM_INGOT, SlimefunItems.SLIME_LEGGINGS_STEEL, ARCANIUM_INGOT,
                        SlimefunItems.MAGIC_SUGAR, new ItemStack(Material.CROSSBOW), SlimefunItems.MAGIC_SUGAR,
                        SlimefunItems.ENCHANTMENT_RUNE, SlimefunItems.MAGICAL_GLASS, SlimefunItems.ENDER_RUNE
                });
        rapidCrossbow.register((SlimefunAddon) plugin);

        // Register Crossbow of the Nether
        SlimefunItem netherCrossbow = new NetherCrossbow(category, NETHER_CROSSBOW, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        new ItemStack(Material.BLAZE_ROD), SlimefunItems.NETHER_ICE, new ItemStack(Material.BLAZE_ROD),
                        SlimefunItems.FIRE_RUNE, new ItemStack(Material.CROSSBOW), SlimefunItems.FIRE_RUNE,
                        SlimefunItems.HEATING_COIL, new ItemStack(Material.NETHERITE_INGOT), SlimefunItems.HEATING_COIL
                });
        netherCrossbow.register((SlimefunAddon) plugin);

        // Register Nautilus Fossil
        SlimefunItem nautilusFossil = new UnplaceableHeadResource(category, NAUTILUS_FOSSIL, RecipeType.GEO_MINER, new ItemStack[9]);
        nautilusFossil.register((SlimefunAddon) plugin);

        // Register Nautilus Shell
        VanillaItem nautilusShell = new VanillaItem(category, new ItemStack(Material.NAUTILUS_SHELL), "NAUTILUS_SHELL", RecipeType.ORE_WASHER,
                new ItemStack[] {
                        NAUTILUS_FOSSIL, null, null,
                        null, null, null,
                        null, null, null
        });
        nautilusShell.register((SlimefunAddon) plugin);

        // Register Trident
        VanillaItem trident = new VanillaItem(category, new ItemStack(Material.TRIDENT), "TRIDENT", RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        Items.AQUATIC_NETHERITE_INGOT, new ItemStack(Material.NAUTILUS_SHELL), Items.AQUATIC_NETHERITE_INGOT,
                        Items.MAGIC_LUMP_5, new ItemStack(Material.HEART_OF_THE_SEA), Items.MAGIC_LUMP_5,
                        Items.AQUATIC_NETHERITE_INGOT, Items.POSEIDONS_BLESSING, Items.AQUATIC_NETHERITE_INGOT
                });
        trident.register((SlimefunAddon) plugin);

        // Register Pristinium Orb
        SlimefunItem pristiniumOrb = new Resource(category, PRISTINIUM_ORB, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        Items.AQUATIC_NETHERITE_INGOT, new ItemStack(Material.NAUTILUS_SHELL), Items.AQUATIC_NETHERITE_INGOT,
                        new ItemStack(Material.BLUE_ICE), new ItemStack(Material.HEART_OF_THE_SEA), new ItemStack(Material.BLUE_ICE),
                        Items.AQUATIC_NETHERITE_INGOT, new ItemStack(Material.NAUTILUS_SHELL), Items.AQUATIC_NETHERITE_INGOT
                });
        pristiniumOrb.register((SlimefunAddon) plugin);

        // Register Blessed Aquatic Netherite Ingot
        SlimefunItem blessedAquaticNetheriteIngot = new Resource(category, BLESSED_AQUATIC_NETHERITE_INGOT, RecipeType.SMELTERY,
                new ItemStack[] {
                        Items.AQUATIC_NETHERITE_INGOT, Items.MAGIC_LUMP_5, Items.POSEIDONS_BLESSING,
                        null, null, null,
                        null, null, null});
        blessedAquaticNetheriteIngot.register((SlimefunAddon) plugin);

        // Register Poseidon's Trident
        SlimefunItem poseidonsTrident = new PoseidonsTrident(category, POSEIDONS_TRIDENT, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        BLESSED_AQUATIC_NETHERITE_INGOT, SlimefunItems.REINFORCED_PLATE, BLESSED_AQUATIC_NETHERITE_INGOT,
                        SlimefunItems.GPS_TELEPORTATION_MATRIX, new ItemStack(Material.TRIDENT), SlimefunItems.GPS_TRANSMITTER,
                        BLESSED_AQUATIC_NETHERITE_INGOT, PRISTINIUM_ORB, BLESSED_AQUATIC_NETHERITE_INGOT
                });
        poseidonsTrident.register((SlimefunAddon) plugin);

        // Register Core of Energy and Energized Wind Staff
        SlimefunItem energyCore = new EnergyCore(category, ENERGY_CORE, RecipeType.SMELTERY,
                new ItemStack[] {
                        SHULKER_ALLOY_INGOT, SlimefunItems.URANIUM, SHULKER_ALLOY_INGOT,
                        Items.MAGIC_LUMP_5, SlimefunItems.CARBONADO, Items.MAGIC_LUMP_5,
                        SHULKER_ALLOY_INGOT, SlimefunItems.LIGHTNING_RUNE, SHULKER_ALLOY_INGOT});
        energyCore.register((SlimefunAddon) plugin);

        SlimefunItem staffEnergizedWind = new EnergizedWindStaff(category, STAFF_ENERGIZED_WIND, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        SlimefunItems.ELYTRA_SCALE, Items.ELECTRIC_WIND_STAFF, SlimefunItems.AIR_RUNE,
                        ENERGY_CORE, SlimefunItems.INFUSED_MAGNET, ENERGY_CORE,
                        SlimefunItems.ELECTRO_MAGNET, Items.ELECTRIC_WIND_STAFF, SlimefunItems.ELECTRO_MAGNET});
        staffEnergizedWind.register((SlimefunAddon) plugin);

        // Register GEO-Resources
        ArcaniumOreResource arcaniumOreResource = new ArcaniumOreResource(plugin, ARCANIUM_ORE);
        arcaniumOreResource.register();

        NautilusFossilResource nautilusFossilResource = new NautilusFossilResource(plugin, NAUTILUS_FOSSIL);
        nautilusFossilResource.register();

        // Register Listeners
        getServer().getPluginManager().registerEvents(new TridentListener(), plugin);
        getServer().getPluginManager().registerEvents(new CrossbowListener(), plugin);
    }
}