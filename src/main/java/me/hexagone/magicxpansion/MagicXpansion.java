package me.hexagone.magicxpansion;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.hexagone.magicxpansion.georesources.ArcaniumOreResource;
import me.hexagone.magicxpansion.items.CraftingItem;
import me.hexagone.magicxpansion.items.Lump;
import me.hexagone.magicxpansion.items.ResourceIngot;
import me.hexagone.magicxpansion.tools.ContainerItem;
import me.hexagone.magicxpansion.tools.InfinityCrossbow;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

public class MagicXpansion extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        // Create category and items, then register them
        createAndRegisterItems();
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

    public void createAndRegisterItems() {
        // Create category
        ItemStack categoryItem = new CustomItem(Material.END_PORTAL_FRAME, "&6MagicXpansion", "", "⇨ &aClick to open");
        NamespacedKey categoryId = new NamespacedKey(this, "magicxpansion_category");
        Category category = new Category(categoryId, categoryItem);

        // Create Magical and Ender Lumps
        SlimefunItemStack MagicLump4Item = new SlimefunItemStack("MX_MAGIC_LUMP_4", Material.GOLD_NUGGET, "&6Magical Lump &7- &eIV", "", "&c&oTier: IV");
        SlimefunItemStack MagicLump5Item = new SlimefunItemStack("MX_MAGIC_LUMP_5", Material.GOLD_NUGGET, "&6Magical Lump &7- &eV", "", "&c&oTier: V");
        SlimefunItemStack EnderLump4Item = new SlimefunItemStack("MX_ENDER_LUMP_4", Material.GOLD_NUGGET, "&5Ender Lump &7- &eIV", "", "&c&oTier: IV");
        SlimefunItemStack EnderLump5Item = new SlimefunItemStack("MX_ENDER_LUMP_5", Material.GOLD_NUGGET, "&5Ender Lump &7- &eV", "", "&c&oTier: V");

        ItemStack[] MagicLump4Recipe = {
                SlimefunItems.MAGIC_LUMP_3, SlimefunItems.MAGIC_LUMP_3, null,
                SlimefunItems.MAGIC_LUMP_3, SlimefunItems.MAGIC_LUMP_3, null,
                null, null, null
        };
        ItemStack[] MagicLump5Recipe = {
                MagicLump4Item, MagicLump4Item, null,
                MagicLump4Item, MagicLump4Item, null,
                null, null, null
        };
        ItemStack[] EnderLump4Recipe = {
                SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_LUMP_3, null,
                SlimefunItems.ENDER_LUMP_3, SlimefunItems.ENDER_LUMP_3, null,
                null, null, null
        };
        ItemStack[] EnderLump5Recipe = {
                EnderLump4Item, EnderLump4Item, null,
                EnderLump4Item, EnderLump4Item, null,
                null, null, null
        };

        // Create Arcanium Ore
        SlimefunItemStack ArcaniumOreItem = new SlimefunItemStack("ARCANIUM_ORE",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E2ZGNmMjc1Y2Y1OGM2NGNhN2I0ZDFmYzRlYTAwOWEyYjU2OTk1ZjUxYjU0OTg3NGJhNzg5ODZjZGVhYjdkMyJ9fX0=",
                "&cArcanium Ore", "&7You can smelt this into an Ingot in a Smeltery");

        // Create Arcanium Ingot
        SlimefunItemStack ArcaniumIngotItem = new SlimefunItemStack("ARCANIUM_INGOT", Material.NETHER_BRICK, "&c&lArcanium Ingot");

        ItemStack[] ArcaniumIngotRecipe = {
                ArcaniumOreItem, null, null,
                null, null, null,
                null, null, null
        };

        // Create Reinforced Shulker Shell and Reinforced Shulker Box
        SlimefunItemStack ReinforcedShulkerShellItem = new SlimefunItemStack("REINFORCED_SHULKER_SHELL", Material.SHULKER_SHELL, "&6Reinforced Shulker Shell", "", "&aForged from the strongest of material,", "&athis Shulker Shell is almost unbreakable.");
        SlimefunItemStack ReinforcedShulkerBoxItem = new SlimefunItemStack("REINFORCED_SHULKER_BOX", Material.WHITE_SHULKER_BOX, "&5&lReinforced Shulker Box", "", "&a6-row storage", "&aBlast-resistant");

        ItemStack[] ReinforcedShulkerShellRecipe = {
                new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL),
                new ItemStack(Material.SHULKER_SHELL), SlimefunItems.REINFORCED_PLATE, new ItemStack(Material.SHULKER_SHELL),
                new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL), new ItemStack(Material.SHULKER_SHELL)
        };
        ItemStack[] ReinforcedShulkerBoxRecipe = {
                new ItemStack(Material.OBSIDIAN), ReinforcedShulkerShellItem, new ItemStack(Material.OBSIDIAN),
                new ItemStack(Material.OBSIDIAN), new ItemStack(Material.CHEST), new ItemStack(Material.OBSIDIAN),
                new ItemStack(Material.OBSIDIAN), ReinforcedShulkerShellItem, new ItemStack(Material.OBSIDIAN)
        };

        // Create Crossbow of Infinity
        SlimefunItemStack InfinityCrossbowItem = new SlimefunItemStack("INFINITY_CROSSBOW", Material.CROSSBOW, "&6Crossbow of Infinity", "", "&aNever runs out of arrows.");

        ItemStack[] InfinityCrossbowRecipe = {
                SlimefunItems.CARBON_CHUNK, SlimefunItems.ENDER_RUNE, SlimefunItems.CARBON_CHUNK,
                SlimefunItems.SYNTHETIC_EMERALD, new ItemStack(Material.CROSSBOW), SlimefunItems.SYNTHETIC_EMERALD,
                ArcaniumIngotItem, SlimefunItems.ENDER_RUNE, ArcaniumIngotItem
        };

        // Register Items
        SlimefunItem MagicLump4 = new Lump(category, MagicLump4Item, RecipeType.MAGIC_WORKBENCH, MagicLump4Recipe);
        MagicLump4.register(this);
        SlimefunItem MagicLump5 = new Lump(category, MagicLump5Item, RecipeType.MAGIC_WORKBENCH, MagicLump5Recipe);
        MagicLump5.register(this);
        SlimefunItem EnderLump4 = new Lump(category, EnderLump4Item, RecipeType.MAGIC_WORKBENCH, EnderLump4Recipe);
        EnderLump4.register(this);
        SlimefunItem EnderLump5 = new Lump(category, EnderLump5Item, RecipeType.MAGIC_WORKBENCH, EnderLump5Recipe);
        EnderLump5.register(this);
        SlimefunItem ReinforcedShulkerShell = new CraftingItem(category, ReinforcedShulkerShellItem, RecipeType.ANCIENT_ALTAR, ReinforcedShulkerShellRecipe);
        ReinforcedShulkerShell.register(this);
        SlimefunItem ReinforcedShulkerBox = new ContainerItem(category, ReinforcedShulkerBoxItem, RecipeType.ANCIENT_ALTAR, ReinforcedShulkerBoxRecipe);
        ReinforcedShulkerBox.register(this);
        SlimefunItem ArcaniumOre = new SlimefunItem(category, ArcaniumOreItem, RecipeType.GEO_MINER, new ItemStack[9]);
        ArcaniumOre.register(this);
        SlimefunItem ArcaniumIngot = new ResourceIngot(category, ArcaniumIngotItem, RecipeType.SMELTERY, ArcaniumIngotRecipe);
        ArcaniumIngot.register(this);
        SlimefunItem InfinityCrossbow = new InfinityCrossbow(category, InfinityCrossbowItem, RecipeType.ANCIENT_ALTAR, InfinityCrossbowRecipe);
        InfinityCrossbow.register(this);

        // Register GEO-Resources
        ArcaniumOreResource arcaniumOreResource = new ArcaniumOreResource(this, ArcaniumOreItem);
        arcaniumOreResource.register();
    }
}
