package me.apeiros.magicxpansion.setup;

import io.github.thebusybiscuit.slimefun4.core.multiblocks.MultiBlockMachine;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.VanillaItem;
import me.apeiros.magicxpansion.MagicXpansion;
import me.apeiros.magicxpansion.setup.items.electric.SoulManipulator;
import me.apeiros.magicxpansion.setup.items.electric.SoulReactor;
import me.apeiros.magicxpansion.setup.items.georesources.ArcaniumOreResource;
import me.apeiros.magicxpansion.setup.items.georesources.NautilusFossilResource;
import me.apeiros.magicxpansion.setup.items.materials.*;
import me.apeiros.magicxpansion.setup.items.mobdrops.BasicSpellbook;
import me.apeiros.magicxpansion.setup.items.multiblocks.CarbonCrusherMachine;
import me.apeiros.magicxpansion.setup.items.tools.ContainerItem;
import me.apeiros.magicxpansion.setup.items.tools.EnergizedWindStaff;
import me.apeiros.magicxpansion.setup.items.weapons.CustomCrossbow;
import me.apeiros.magicxpansion.setup.items.weapons.MeleeWeapon;
import me.apeiros.magicxpansion.setup.items.weapons.PoseidonsTrident;
import me.apeiros.magicxpansion.utils.Categories;
import me.apeiros.magicxpansion.utils.HeadTextures;
import me.gallowsdove.foxymachines.Items;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static me.apeiros.magicxpansion.setup.MagicXpansionItems.*;
import static me.apeiros.magicxpansion.utils.RecipeTypes.*;

public class Setup {

    public static void setup() {
        // Register Category
        Categories.MAIN.register(MagicXpansion.getInstance());

        // Register Ender Lumps IV and V
        SlimefunItem enderLump4 = new Lump(Categories.RESOURCES, ENDER_LUMP_4, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                        SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_LUMP_3, null,
                        SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_LUMP_3, null,
                        null, null, null});
        enderLump4.register(MagicXpansion.getInstance());

        SlimefunItem enderLump5 = new Lump(Categories.RESOURCES, ENDER_LUMP_5, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                        ENDER_LUMP_4, ENDER_LUMP_4, null,
                        ENDER_LUMP_4, ENDER_LUMP_4, null,
                        null, null, null});
        enderLump5.register(MagicXpansion.getInstance());

        // Register Nether Star Block
        SlimefunItem netherStarBlock = new NetherStarBlock(Categories.RESOURCES, NETHER_STAR_BLOCK, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        new ItemStack(Material.NETHER_STAR), SlimefunItems.STRANGE_NETHER_GOO, new ItemStack(Material.NETHER_STAR),
                        Items.DEMONIC_INGOT, new ItemStack(Material.NETHERITE_BLOCK), Items.DEMONIC_INGOT,
                        new ItemStack(Material.NETHER_STAR), SlimefunItems.STRANGE_NETHER_GOO, new ItemStack(Material.NETHER_STAR)
                });
        netherStarBlock.register(MagicXpansion.getInstance());

        // Register Carbon Crusher
        MultiBlockMachine carbonCrusher = new CarbonCrusherMachine(Categories.MACHINES, CARBON_CRUSHER_MACHINE);
        carbonCrusher.register(MagicXpansion.getInstance());

        // Register Arcanium Ore and Arcanium Ingot
        SlimefunItem arcaniumOre = new UnplaceableHeadItem(Categories.RESOURCES, ARCANIUM_ORE, RecipeType.GEO_MINER, new ItemStack[9]);
        arcaniumOre.register(MagicXpansion.getInstance());

        SlimefunItem arcaniumIngot = new Resource(Categories.RESOURCES, ARCANIUM_INGOT, RecipeType.SMELTERY,
                new ItemStack[] {
                        ARCANIUM_ORE, null, null,
                        null, null, null,
                        null, null, null});
        arcaniumIngot.register(MagicXpansion.getInstance());

        // Register Reinforced Shulker Shell and Reinforced Shulker Box
        SlimefunItem reinforcedShulkerShell = new CraftingItem(Categories.RESOURCES, REINFORCED_SHULKER_SHELL, RecipeType.SMELTERY,
                new ItemStack[] {
                        new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL),
                        new ItemStack(Material.SHULKER_SHELL), SlimefunItems.REINFORCED_PLATE, new ItemStack(Material.SHULKER_SHELL),
                        new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL)});
        reinforcedShulkerShell.register(MagicXpansion.getInstance());

        SlimefunItem reinforcedShulkerBox = new ContainerItem(Categories.TOOLS, REINFORCED_SHULKER_BOX, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.OBSIDIAN), REINFORCED_SHULKER_SHELL, new ItemStack(Material.OBSIDIAN),
                        new ItemStack(Material.OBSIDIAN), new ItemStack(Material.CHEST), new ItemStack(Material.OBSIDIAN),
                        new ItemStack(Material.OBSIDIAN), REINFORCED_SHULKER_SHELL, new ItemStack(Material.OBSIDIAN)});
        reinforcedShulkerBox.register(MagicXpansion.getInstance());

        // Register Shulkerium Alloys
        SlimefunItem shulkerAlloyIngot = new ShulkerAlloy(Categories.RESOURCES, SHULKER_ALLOY_INGOT, RecipeType.SMELTERY,
                new ItemStack[] {
                        REINFORCED_SHULKER_SHELL, Items.DEMONIC_INGOT, null, null, null, null, null, null, null});
        shulkerAlloyIngot.register(MagicXpansion.getInstance());

        SlimefunItem refinedShulkerAlloyChunk = new RefinedShulkerAlloy(Categories.RESOURCES, REFINED_SHULKER_ALLOY, RecipeType.SMELTERY,
                new ItemStack[] {
                        Items.DEMONIC_INGOT, SlimefunItems.REINFORCED_ALLOY_INGOT, ARCANIUM_INGOT,
                        SlimefunItems.CARBONADO, SHULKER_ALLOY_INGOT, SlimefunItems.CARBONADO,
                        SlimefunItems.SYNTHETIC_SHULKER_SHELL, SlimefunItems.HARDENED_METAL_INGOT, SlimefunItems.SYNTHETIC_SHULKER_SHELL});
        refinedShulkerAlloyChunk.register(MagicXpansion.getInstance());

        // Register Crossbow of Infinity
        SlimefunItem infinityCrossbow = new CustomCrossbow(Categories.WEAPONS, INFINITY_CROSSBOW, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        SlimefunItems.CARBON_CHUNK, SlimefunItems.ENDER_RUNE, SlimefunItems.CARBON_CHUNK,
                        SlimefunItems.SYNTHETIC_EMERALD, new ItemStack(Material.CROSSBOW), SlimefunItems.SYNTHETIC_EMERALD,
                        ARCANIUM_INGOT, SlimefunItems.ENDER_RUNE, ARCANIUM_INGOT});
        infinityCrossbow.register(MagicXpansion.getInstance());

        // Register Crossbow of Rapidity
        SlimefunItem rapidCrossbow = new CustomCrossbow(Categories.WEAPONS, RAPID_CROSSBOW, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        ARCANIUM_INGOT, SlimefunItems.SLIME_LEGGINGS_STEEL, ARCANIUM_INGOT,
                        SlimefunItems.MAGIC_SUGAR, new ItemStack(Material.CROSSBOW), SlimefunItems.MAGIC_SUGAR,
                        SlimefunItems.ENCHANTMENT_RUNE, SlimefunItems.MAGICAL_GLASS, SlimefunItems.ENDER_RUNE
                });
        rapidCrossbow.register(MagicXpansion.getInstance());

        // Register Crossbow of the Nether
        SlimefunItem netherCrossbow = new CustomCrossbow(Categories.WEAPONS, NETHER_CROSSBOW, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        new ItemStack(Material.BLAZE_ROD), SlimefunItems.NETHER_ICE, new ItemStack(Material.BLAZE_ROD),
                        SlimefunItems.FIRE_RUNE, new ItemStack(Material.CROSSBOW), SlimefunItems.FIRE_RUNE,
                        SlimefunItems.HEATING_COIL, new ItemStack(Material.NETHERITE_INGOT), SlimefunItems.HEATING_COIL
                });
        netherCrossbow.register(MagicXpansion.getInstance());

        // Register Nautilus Fossil and Nautilus Shell
        SlimefunItem nautilusFossil = new UnplaceableHeadItem(Categories.GENERAL, NAUTILUS_FOSSIL, RecipeType.GEO_MINER, new ItemStack[9]);
        nautilusFossil.register(MagicXpansion.getInstance());

        VanillaItem nautilusShell = new VanillaItem(Categories.GENERAL, new ItemStack(Material.NAUTILUS_SHELL), "NAUTILUS_SHELL", RecipeType.ORE_WASHER,
                new ItemStack[] {
                        NAUTILUS_FOSSIL, null, null,
                        null, null, null,
                        null, null, null
                });
        nautilusShell.register(MagicXpansion.getInstance());

        // Register Trident
        VanillaItem trident = new VanillaItem(Categories.WEAPONS, new ItemStack(Material.TRIDENT), "TRIDENT", RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        Items.AQUATIC_NETHERITE_INGOT, new ItemStack(Material.NAUTILUS_SHELL), Items.AQUATIC_NETHERITE_INGOT,
                        Items.MAGIC_LUMP_5, new ItemStack(Material.HEART_OF_THE_SEA), Items.MAGIC_LUMP_5,
                        Items.AQUATIC_NETHERITE_INGOT, Items.POSEIDONS_BLESSING, Items.AQUATIC_NETHERITE_INGOT
                });
        trident.register(MagicXpansion.getInstance());

        // Register Pristinium Orb
        SlimefunItem pristiniumOrb = new Resource(Categories.RESOURCES, PRISTINIUM_ORB, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        Items.AQUATIC_NETHERITE_INGOT, new ItemStack(Material.NAUTILUS_SHELL), Items.AQUATIC_NETHERITE_INGOT,
                        new ItemStack(Material.BLUE_ICE), new ItemStack(Material.HEART_OF_THE_SEA), new ItemStack(Material.BLUE_ICE),
                        Items.AQUATIC_NETHERITE_INGOT, new ItemStack(Material.NAUTILUS_SHELL), Items.AQUATIC_NETHERITE_INGOT
                });
        pristiniumOrb.register(MagicXpansion.getInstance());

        // Register Blessed Aquatic Netherite Ingot
        SlimefunItem blessedAquaticNetheriteIngot = new Resource(Categories.RESOURCES, BLESSED_AQUATIC_NETHERITE_INGOT, RecipeType.SMELTERY,
                new ItemStack[] {
                        Items.AQUATIC_NETHERITE_INGOT, Items.MAGIC_LUMP_5, Items.POSEIDONS_BLESSING,
                        null, null, null,
                        null, null, null});
        blessedAquaticNetheriteIngot.register(MagicXpansion.getInstance());

        // Register Poseidon's Trident
        SlimefunItem poseidonsTrident = new PoseidonsTrident(Categories.WEAPONS, POSEIDONS_TRIDENT, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        BLESSED_AQUATIC_NETHERITE_INGOT, SlimefunItems.REINFORCED_PLATE, BLESSED_AQUATIC_NETHERITE_INGOT,
                        SlimefunItems.GPS_TELEPORTATION_MATRIX, new ItemStack(Material.TRIDENT), SlimefunItems.GPS_TRANSMITTER,
                        BLESSED_AQUATIC_NETHERITE_INGOT, PRISTINIUM_ORB, BLESSED_AQUATIC_NETHERITE_INGOT
                });
        poseidonsTrident.register(MagicXpansion.getInstance());

        // Register Core of Energy and Energized Wind Staff
        SlimefunItem energyCore = new EnergyCore(Categories.GENERAL, ENERGY_CORE, RecipeType.SMELTERY,
                new ItemStack[] {
                        SHULKER_ALLOY_INGOT, SlimefunItems.URANIUM, SHULKER_ALLOY_INGOT,
                        Items.MAGIC_LUMP_5, SlimefunItems.CARBONADO, Items.MAGIC_LUMP_5,
                        SHULKER_ALLOY_INGOT, SlimefunItems.LIGHTNING_RUNE, SHULKER_ALLOY_INGOT});
        energyCore.register(MagicXpansion.getInstance());

        SlimefunItem staffEnergizedWind = new EnergizedWindStaff(Categories.TOOLS, STAFF_ENERGIZED_WIND, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        SlimefunItems.ELYTRA_SCALE, Items.ELECTRIC_WIND_STAFF, SlimefunItems.AIR_RUNE,
                        ENERGY_CORE, SlimefunItems.INFUSED_MAGNET, ENERGY_CORE,
                        SlimefunItems.ELECTRO_MAGNET, Items.ELECTRIC_WIND_STAFF, SlimefunItems.ELECTRO_MAGNET});
        staffEnergizedWind.register(MagicXpansion.getInstance());

        // Register Reaper Scythe
        SlimefunItem reaperScythe = new MeleeWeapon(Categories.WEAPONS, REAPER_SCYTHE, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        NETHER_STAR_BLOCK, NETHER_STAR_BLOCK, NETHER_STAR_BLOCK,
                        SlimefunItems.ESSENCE_OF_AFTERLIFE, new ItemStack(Material.TOTEM_OF_UNDYING), Items.DEMONIC_INGOT,
                        SlimefunItems.ESSENCE_OF_AFTERLIFE, SlimefunItems.ESSENCE_OF_AFTERLIFE, Items.DEMONIC_INGOT});
        reaperScythe.register(MagicXpansion.getInstance());

        // Register Spell-related items
        SlimefunItem basicSpellbook = new BasicSpellbook(Categories.MAGICAL, BASIC_SPELLBOOK, RecipeType.MOB_DROP,
                new ItemStack[] {
                        null, null, null,
                        null, new SlimefunItemStack("EVOKER", HeadTextures.EVOKER_HEAD_TEXTURE, "&5Evoker", "", "&aBasic Spellbooks have a", "&a15% chance to drop from Evokers."), null,
                        null, null, null});
        basicSpellbook.register(MagicXpansion.getInstance());

        // Register Soul and Soul Orb
        SlimefunItem soul = new MeleeWeapon(Categories.MAGICAL, SOUL, REAPER_SCYTHE_TYPE,
                new ItemStack[] {
                        null, null, null,
                        null, new CustomItem(Material.DROWNED_SPAWN_EGG, "&aMob Drop"), null,
                        null, null, null});
        soul.register(MagicXpansion.getInstance());

        SlimefunItem soulOrb = new UnplaceableHeadItem(Categories.MAGICAL, SOUL_ORB, SOUL_MANIPULATOR_TYPE,
                new ItemStack[] {
                        new SlimefunItemStack(SOUL, 6), null, null,
                        null, null, null,
                        null, null, null});
        soulOrb.register(MagicXpansion.getInstance());

        // Register Soul Manipulator
        SlimefunItem soulManipulator = new SoulManipulator(Categories.MACHINES, SOUL_MANIPULATOR, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        SlimefunItems.ESSENCE_OF_AFTERLIFE, Items.BLOOD_INFUSED_SKULL, SlimefunItems.ESSENCE_OF_AFTERLIFE,
                        SlimefunItems.ELECTRIC_SMELTERY, SOUL_ORB, SlimefunItems.ELECTRIC_PRESS,
                        Items.BUCKET_OF_BLOOD, Items.DEMONIC_PLATE, Items.BUCKET_OF_BLOOD});
        soulManipulator.register(MagicXpansion.getInstance());

        // Register Soul Reactor, its parts, and Soul Coolant
        SlimefunItem soulReactorCoolant = new UnplaceableHeadItem(Categories.MAGICAL, SOUL_REACTOR_COOLANT, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        new ItemStack(Material.BLUE_ICE), SOUL, new ItemStack(Material.BLUE_ICE),
                        SOUL, SlimefunItems.REACTOR_COOLANT_CELL, SOUL,
                        new ItemStack(Material.BLUE_ICE), SOUL, new ItemStack(Material.BLUE_ICE)});
        soulReactorCoolant.register(MagicXpansion.getInstance());

        SlimefunItem soulReactorCore = new UnplaceableHeadItem(Categories.MAGICAL, SOUL_REACTOR_CORE, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        SlimefunItems.ESSENCE_OF_AFTERLIFE, SOUL_REACTOR_CATALYST, Items.EQUANIMOUS_GEM,
                        Items.DEMONIC_PLATE, SlimefunItems.NETHER_STAR_REACTOR, Items.DEMONIC_PLATE,
                        Items.EQUANIMOUS_GEM, Items.DEMONIC_PLATE, new ItemStack(Material.TOTEM_OF_UNDYING)});
        soulReactorCore.register(MagicXpansion.getInstance());

        SlimefunItem soulReactorCatalyst = new UnplaceableHeadItem(Categories.MAGICAL, SOUL_REACTOR_CATALYST, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        Items.DEMONIC_INGOT, SlimefunItems.MAGICAL_GLASS, Items.DEMONIC_INGOT,
                        SlimefunItems.MAGICAL_GLASS, SOUL_ORB, SlimefunItems.MAGICAL_GLASS,
                        Items.DEMONIC_INGOT, SlimefunItems.MAGICAL_GLASS, Items.DEMONIC_INGOT});
        soulReactorCatalyst.register(MagicXpansion.getInstance());

        SlimefunItem soulReactor = new SoulReactor(Categories.MACHINES, SOUL_REACTOR, RecipeType.ANCIENT_ALTAR,
                new ItemStack[]{
                        SOUL_MANIPULATOR, Items.DEMONIC_PLATE, SOUL_MANIPULATOR,
                        Items.DEMONIC_PLATE, SOUL_REACTOR_CORE, Items.DEMONIC_PLATE,
                        REAPER_SCYTHE, SOUL_REACTOR_CATALYST, REAPER_SCYTHE}) {
            @Override
            public int getCapacity() {
                return 0;
            }

            @Override
            public int getEnergyProduction() {
                return 0;
            }
        };
        soulReactor.register(MagicXpansion.getInstance());

        // Register GEO-Resources
        ArcaniumOreResource arcaniumOreResource = new ArcaniumOreResource(MagicXpansion.getInstance(), ARCANIUM_ORE);
        arcaniumOreResource.register();

        NautilusFossilResource nautilusFossilResource = new NautilusFossilResource(MagicXpansion.getInstance(), NAUTILUS_FOSSIL);
        nautilusFossilResource.register();

    }
}