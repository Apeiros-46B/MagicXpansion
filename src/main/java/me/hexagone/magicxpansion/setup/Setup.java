package me.hexagone.magicxpansion.setup;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.core.multiblocks.MultiBlockMachine;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.gallowsdove.foxymachines.Items;
import me.hexagone.magicxpansion.setup.magicxpansionitems.georesources.ArcaniumOreResource;
import me.hexagone.magicxpansion.setup.magicxpansionitems.items.*;
import me.hexagone.magicxpansion.setup.magicxpansionitems.multiblocks.CarbonCrusherMachine;
import me.hexagone.magicxpansion.setup.magicxpansionitems.tools.ContainerItem;
import me.hexagone.magicxpansion.setup.magicxpansionitems.tools.EnergizedWindStaff;
import me.hexagone.magicxpansion.setup.magicxpansionitems.weapons.InfinityCrossbow;
import me.hexagone.magicxpansion.setup.magicxpansionitems.weapons.RapidCrossbow;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import static me.hexagone.magicxpansion.setup.MagicXpansionItems.*;

public class Setup {

    public static void RegisterItems(JavaPlugin plugin) {
        // Create category
        ItemStack categoryItem = new CustomItem(Material.END_PORTAL_FRAME, "&6MagicXpansion", "", "⇨ &aClick to open");
        NamespacedKey categoryId = new NamespacedKey(plugin, "magicxpansion_category");
        Category category = new Category(categoryId, categoryItem);

        // Register Ender Lumps IV and V
        SlimefunItem EnderLump4 = new Lump(category, ENDER_LUMP_4, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_LUMP_3, null,
                SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_LUMP_3, null,
                null, null, null});
        EnderLump4.register((SlimefunAddon) plugin);
        SlimefunItem EnderLump5 = new Lump(category, ENDER_LUMP_5, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                MagicXpansionItems.ENDER_LUMP_4, ENDER_LUMP_4, null,
                MagicXpansionItems.ENDER_LUMP_4, ENDER_LUMP_4, null,
                null, null, null});
        EnderLump5.register((SlimefunAddon) plugin);

        // Register Nether Star Block
        SlimefunItem NetherStarBlock = new NetherStarBlock(category, NETHER_STAR_BLOCK, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        new ItemStack(Material.NETHER_STAR), SlimefunItems.STRANGE_NETHER_GOO, new ItemStack(Material.NETHER_STAR),
                        Items.DEMONIC_INGOT, new ItemStack(Material.NETHERITE_BLOCK), Items.DEMONIC_INGOT,
                        new ItemStack(Material.NETHER_STAR), SlimefunItems.STRANGE_NETHER_GOO, new ItemStack(Material.NETHER_STAR)
                });
        NetherStarBlock.register((SlimefunAddon) plugin);

        // Register Carbon Crusher
        MultiBlockMachine CarbonCrusher = new CarbonCrusherMachine(category, new SlimefunItemStack("CARBON_CRUSHER", Material.PISTON, "&bCarbon Crusher", "", "&bCrushes Diamonds into Carbon"));
        CarbonCrusher.register((SlimefunAddon) plugin);

        // Register Arcanium Ore and Arcanium Ingot
        SlimefunItem ArcaniumOre = new ArcaniumOreChunk(category, ARCANIUM_ORE, RecipeType.GEO_MINER, new ItemStack[9]);
        ArcaniumOre.register((SlimefunAddon) plugin);
        SlimefunItem ArcaniumIngot = new Resource(category, ARCANIUM_INGOT, RecipeType.SMELTERY,
                new ItemStack[] {
                ARCANIUM_INGOT, null, null,
                null, null, null,
                null, null, null});
        ArcaniumIngot.register((SlimefunAddon) plugin);

        // Register Reinforced Shulker Shell and Reinforced Shulker Box
        SlimefunItem ReinforcedShulkerShell = new CraftingItem(category, REINFORCED_SHULKER_SHELL, RecipeType.SMELTERY,
                new ItemStack[] {
                new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL),
                new ItemStack(Material.SHULKER_SHELL), SlimefunItems.REINFORCED_PLATE, new ItemStack(Material.SHULKER_SHELL),
                new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL)});
        ReinforcedShulkerShell.register((SlimefunAddon) plugin);
        SlimefunItem ReinforcedShulkerBox = new ContainerItem(category, REINFORCED_SHULKER_BOX, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                new ItemStack(Material.OBSIDIAN), REINFORCED_SHULKER_SHELL, new ItemStack(Material.OBSIDIAN),
                new ItemStack(Material.OBSIDIAN), new ItemStack(Material.CHEST), new ItemStack(Material.OBSIDIAN),
                new ItemStack(Material.OBSIDIAN), REINFORCED_SHULKER_SHELL, new ItemStack(Material.OBSIDIAN)});
        ReinforcedShulkerBox.register((SlimefunAddon) plugin);

        // Register Shulkerium Alloys
        SlimefunItem ShulkerAlloyIngot = new ShulkerAlloy(category, SHULKER_ALLOY_INGOT, RecipeType.SMELTERY,
                new ItemStack[] {
                REINFORCED_SHULKER_SHELL, SlimefunItems.BLISTERING_INGOT_3, null, null, null, null, null, null, null});
        ShulkerAlloyIngot.register((SlimefunAddon) plugin);
        SlimefunItem RefinedShulkerAlloyChunk = new RefinedShulkerAlloy(category, REFINED_SHULKER_ALLOY_INGOT, RecipeType.SMELTERY,
                new ItemStack[] {
                SHULKER_ALLOY_INGOT, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.HARDENED_METAL_INGOT,
                SlimefunItems.CARBONADO, Items.DEMONIC_INGOT, new ItemStack(Material.NETHERITE_BLOCK),
                SlimefunItems.SYNTHETIC_SHULKER_SHELL, ARCANIUM_INGOT, SlimefunItems.SYNTHETIC_EMERALD});
        RefinedShulkerAlloyChunk.register((SlimefunAddon) plugin);

        // Register Crossbow of Infinity
        SlimefunItem InfinityCrossbow = new InfinityCrossbow(category, INFINITY_CROSSBOW, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                SlimefunItems.CARBON_CHUNK, SlimefunItems.ENDER_RUNE, SlimefunItems.CARBON_CHUNK,
                SlimefunItems.SYNTHETIC_EMERALD, new ItemStack(Material.CROSSBOW), SlimefunItems.SYNTHETIC_EMERALD,
                ARCANIUM_INGOT, SlimefunItems.ENDER_RUNE, ARCANIUM_INGOT});
        InfinityCrossbow.register((SlimefunAddon) plugin);

        // Register Crossbow of Rapidity
        SlimefunItem RapidCrossbow = new RapidCrossbow(category, INFINITY_CROSSBOW, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                ARCANIUM_INGOT, SlimefunItems.SLIME_LEGGINGS_STEEL, ARCANIUM_INGOT,
                SlimefunItems.MAGIC_SUGAR, new ItemStack(Material.CROSSBOW), SlimefunItems.MAGIC_SUGAR,
                SlimefunItems.ENCHANTMENT_RUNE, SlimefunItems.MAGICAL_GLASS, SlimefunItems.ENDER_RUNE
                });
        RapidCrossbow.register((SlimefunAddon) plugin);

        // Register Core of Energy and Energized Wind Staff
        SlimefunItem EnergyCore = new EnergyCore(category, ENERGY_CORE, RecipeType.SMELTERY,
                new ItemStack[] {
                        SHULKER_ALLOY_INGOT, SlimefunItems.URANIUM, SHULKER_ALLOY_INGOT,
                        Items.MAGIC_LUMP_5, SlimefunItems.CARBONADO, Items.MAGIC_LUMP_5,
                        SHULKER_ALLOY_INGOT, SlimefunItems.LIGHTNING_RUNE, SHULKER_ALLOY_INGOT});
        EnergyCore.register((SlimefunAddon) plugin);
        SlimefunItem StaffEnergizedWind = new EnergizedWindStaff(category, STAFF_ENERGIZED_WIND, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                        SlimefunItems.ELYTRA_SCALE, Items.ELECTRIC_WIND_STAFF, SlimefunItems.AIR_RUNE,
                        ENERGY_CORE, SlimefunItems.INFUSED_MAGNET, ENERGY_CORE,
                        SlimefunItems.ELECTRO_MAGNET, Items.ELECTRIC_WIND_STAFF, SlimefunItems.ELECTRO_MAGNET});
        StaffEnergizedWind.register((SlimefunAddon) plugin);

        // Register GEO-Resources
        ArcaniumOreResource arcaniumOreResource = new ArcaniumOreResource(plugin, ARCANIUM_ORE);
        arcaniumOreResource.register();
    }
}