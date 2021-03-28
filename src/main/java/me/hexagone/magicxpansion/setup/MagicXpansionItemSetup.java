package me.hexagone.magicxpansion.setup;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.hexagone.magicxpansion.setup.magicxpansionitems.georesources.ArcaniumOreResource;
import me.hexagone.magicxpansion.setup.magicxpansionitems.items.CraftingItem;
import me.hexagone.magicxpansion.setup.magicxpansionitems.items.Lump;
import me.hexagone.magicxpansion.setup.magicxpansionitems.items.NonPlaceableResource;
import me.hexagone.magicxpansion.setup.magicxpansionitems.items.RefinedShulkerAlloy;
import me.hexagone.magicxpansion.setup.magicxpansionitems.items.ResourceIngot;
import me.hexagone.magicxpansion.setup.magicxpansionitems.items.ShulkerAlloy;
import me.hexagone.magicxpansion.setup.magicxpansionitems.tools.ContainerItem;
import me.hexagone.magicxpansion.setup.magicxpansionitems.tools.FilledKnowledgeVessel;
import me.hexagone.magicxpansion.setup.magicxpansionitems.weapons.InfinityCrossbow;
import me.hexagone.magicxpansion.setup.magicxpansionitems.tools.KnowledgeVessel;
import me.hexagone.magicxpansion.setup.magicxpansionitems.weapons.RapidCrossbow;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import static me.hexagone.magicxpansion.setup.MagicXpansionItems.*;

public class MagicXpansionItemSetup {

    public static void RegisterItems(JavaPlugin plugin) {
        // Create category
        ItemStack categoryItem = new CustomItem(Material.END_PORTAL_FRAME, "&6MagicXpansion", "", "⇨ &aClick to open");
        NamespacedKey categoryId = new NamespacedKey(plugin, "magicxpansion_category");
        Category category = new Category(categoryId, categoryItem);

        // Register Magic and Ender Lumps IV and V
        SlimefunItem MagicLump4 = new Lump(category, MagicXpansionItems.MagicLump4Item, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_3, SlimefunItems.MAGIC_LUMP_3, null,
                SlimefunItems.MAGIC_LUMP_3, SlimefunItems.MAGIC_LUMP_3, null,
                null, null, null});
        MagicLump4.register((SlimefunAddon) plugin);
        SlimefunItem MagicLump5 = new Lump(category, MagicLump5Item, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                MagicXpansionItems.MagicLump4Item, MagicXpansionItems.MagicLump4Item, null,
                MagicXpansionItems.MagicLump4Item, MagicXpansionItems.MagicLump4Item, null,
                null, null, null});
        MagicLump5.register((SlimefunAddon) plugin);
        SlimefunItem EnderLump4 = new Lump(category, MagicXpansionItems.EnderLump4Item, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_LUMP_3, null,
                SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_LUMP_3, null,
                null, null, null});
        EnderLump4.register((SlimefunAddon) plugin);
        SlimefunItem EnderLump5 = new Lump(category, MagicXpansionItems.EnderLump5Item, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                MagicXpansionItems.EnderLump4Item, MagicXpansionItems.EnderLump4Item, null,
                MagicXpansionItems.EnderLump4Item, MagicXpansionItems.EnderLump4Item, null,
                null, null, null});
        EnderLump5.register((SlimefunAddon) plugin);

        // Register Empty and Filled Knowledge Vessels
        SlimefunItem KnowledgeVessel = new KnowledgeVessel(category, MagicXpansionItems.KnowledgeVessel, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                        null, null, null,
                        MagicLump5Item, SlimefunItems.MAGICAL_GLASS, MagicLump5Item,
                        null, MagicLump5Item, null});
        KnowledgeVessel.register((SlimefunAddon) plugin);

        SlimefunItem FilledKnowledgeVessel = new FilledKnowledgeVessel(category, MagicXpansionItems.FilledKnowledgeVessel, RecipeType.MAGIC_WORKBENCH, new ItemStack[9]);
        FilledKnowledgeVessel.setHidden(true);
        FilledKnowledgeVessel.register((SlimefunAddon) plugin);

        // Register Arcanium Ore and Arcanium Ingot
        SlimefunItem ArcaniumOre = new NonPlaceableResource(category, ArcaniumOreItem, RecipeType.GEO_MINER, new ItemStack[9]);
        ArcaniumOre.register((SlimefunAddon) plugin);
        SlimefunItem ArcaniumIngot = new ResourceIngot(category, ArcaniumIngotItem, RecipeType.SMELTERY,
                new ItemStack[] {
                ArcaniumOreItem, null, null,
                null, null, null,
                null, null, null});
        ArcaniumIngot.register((SlimefunAddon) plugin);

        // Register Reinforced Shulker Shell and Reinforced Shulker Box
        SlimefunItem ReinforcedShulkerShell = new CraftingItem(category, ReinforcedShulkerShellItem, RecipeType.SMELTERY,
                new ItemStack[] {
                new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL),
                new ItemStack(Material.SHULKER_SHELL), SlimefunItems.REINFORCED_PLATE, new ItemStack(Material.SHULKER_SHELL),
                new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL)});
        ReinforcedShulkerShell.register((SlimefunAddon) plugin);
        SlimefunItem ReinforcedShulkerBox = new ContainerItem(category, ReinforcedShulkerBoxItem, RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                new ItemStack(Material.OBSIDIAN), ReinforcedShulkerShellItem, new ItemStack(Material.OBSIDIAN),
                new ItemStack(Material.OBSIDIAN), new ItemStack(Material.CHEST), new ItemStack(Material.OBSIDIAN),
                new ItemStack(Material.OBSIDIAN), ReinforcedShulkerShellItem, new ItemStack(Material.OBSIDIAN)});
        ReinforcedShulkerBox.register((SlimefunAddon) plugin);

        // Register Shulkerium Alloys
        SlimefunItem ShulkerAlloyIngot = new ShulkerAlloy(category, ShulkerAlloyItem, RecipeType.HEATED_PRESSURE_CHAMBER,
                new ItemStack[] {
                ReinforcedShulkerShellItem, SlimefunItems.BLISTERING_INGOT_3, null, null, null, null, null, null, null});
        ShulkerAlloyIngot.register((SlimefunAddon) plugin);
        SlimefunItem RefinedShulkerAlloyChunk = new RefinedShulkerAlloy(category, RefinedShulkerAlloyItem, RecipeType.SMELTERY,
                new ItemStack[] {
                ShulkerAlloyItem, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.HARDENED_METAL_INGOT,
                SlimefunItems.CARBONADO, SlimefunItems.PLUTONIUM, new ItemStack(Material.NETHERITE_INGOT),
                SlimefunItems.SYNTHETIC_SHULKER_SHELL, ArcaniumIngotItem, SlimefunItems.SYNTHETIC_EMERALD});
        RefinedShulkerAlloyChunk.register((SlimefunAddon) plugin);

        // Register Crossbow of Infinity
        SlimefunItem InfinityCrossbow = new InfinityCrossbow(category, InfinityCrossbowItem, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                SlimefunItems.CARBON_CHUNK, SlimefunItems.ENDER_RUNE, SlimefunItems.CARBON_CHUNK,
                SlimefunItems.SYNTHETIC_EMERALD, new ItemStack(Material.CROSSBOW), SlimefunItems.SYNTHETIC_EMERALD,
                ArcaniumIngotItem, SlimefunItems.ENDER_RUNE, ArcaniumIngotItem});
        InfinityCrossbow.register((SlimefunAddon) plugin);

        // Register Crossbow of Rapidity
        SlimefunItem RapidCrossbow = new RapidCrossbow(category, RapidCrossbowItem, RecipeType.ANCIENT_ALTAR,
                new ItemStack[] {
                ArcaniumIngotItem, SlimefunItems.SLIME_LEGGINGS_STEEL, ArcaniumIngotItem,
                SlimefunItems.MAGIC_SUGAR, new ItemStack(Material.CROSSBOW), SlimefunItems.MAGIC_SUGAR,
                SlimefunItems.ENCHANTMENT_RUNE, SlimefunItems.MAGICAL_GLASS, SlimefunItems.ENDER_RUNE
                });

        // Register GEO-Resources
        ArcaniumOreResource arcaniumOreResource = new ArcaniumOreResource(plugin, ArcaniumOreItem);
        arcaniumOreResource.register();
    }

}