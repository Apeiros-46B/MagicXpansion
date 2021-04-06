package me.hexagone.magicxpansion.setup.magicxpansionitems.electric;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.hexagone.magicxpansion.setup.MagicXpansionItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AGenerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class MagicGenerator extends AGenerator {

    public MagicGenerator(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public ItemStack getProgressBar() {
        ItemStack progressBar = new ItemStack(Material.BEACON);
        progressBar.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        progressBar.getItemMeta().addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return progressBar;
    }

    @Override
    protected void registerDefaultFuelTypes() {
        // Magic Lumps
        registerFuel(new MachineFuel(1, new ItemStack(SlimefunItems.MAGIC_LUMP_1)));
        registerFuel(new MachineFuel(2, new ItemStack(SlimefunItems.MAGIC_LUMP_2)));
        registerFuel(new MachineFuel(4, new ItemStack(SlimefunItems.MAGIC_LUMP_3)));
        registerFuel(new MachineFuel(8, new ItemStack(MagicXpansionItems.MagicLump4Item)));
        registerFuel(new MachineFuel(16, new ItemStack(MagicXpansionItems.MagicLump5Item)));

        // Ender Lumps
        registerFuel(new MachineFuel(1, new ItemStack(SlimefunItems.ENDER_LUMP_1)));
        registerFuel(new MachineFuel(2, new ItemStack(SlimefunItems.ENDER_LUMP_2)));
        registerFuel(new MachineFuel(4, new ItemStack(SlimefunItems.ENDER_LUMP_3)));
        registerFuel(new MachineFuel(8, new ItemStack(MagicXpansionItems.EnderLump4Item)));
        registerFuel(new MachineFuel(16, new ItemStack(MagicXpansionItems.EnderLump5Item)));

        // Low-tier Magical Items
        registerFuel(new MachineFuel(8, new ItemStack(SlimefunItems.MAGICAL_BOOK_COVER)));
        registerFuel(new MachineFuel(8, new ItemStack(SlimefunItems.MAGICAL_GLASS)));
        registerFuel(new MachineFuel(8, new ItemStack(SlimefunItems.FLASK_OF_KNOWLEDGE)));

        // Mid-tier Magical Items
        registerFuel(new MachineFuel(20, new ItemStack(SlimefunItems.FILLED_FLASK_OF_KNOWLEDGE)));
        registerFuel(new MachineFuel(20, new ItemStack(SlimefunItems.COMMON_TALISMAN)));
        registerFuel(new MachineFuel(20, new ItemStack(SlimefunItems.COMMON_TALISMAN)));
        registerFuel(new MachineFuel(20, new ItemStack(SlimefunItems.STAFF_ELEMENTAL)));
        registerFuel(new MachineFuel(20, new ItemStack(SlimefunItems.BLANK_RUNE)));

        // Basic Ancient Runes
        registerFuel(new MachineFuel(30, new ItemStack(SlimefunItems.AIR_RUNE)));
        registerFuel(new MachineFuel(30, new ItemStack(SlimefunItems.EARTH_RUNE)));
        registerFuel(new MachineFuel(30, new ItemStack(SlimefunItems.FIRE_RUNE)));
        registerFuel(new MachineFuel(30, new ItemStack(SlimefunItems.WATER_RUNE)));

        // Advanced Ancient Runes
        registerFuel(new MachineFuel(60, new ItemStack(SlimefunItems.LIGHTNING_RUNE)));
        registerFuel(new MachineFuel(60, new ItemStack(SlimefunItems.ENDER_RUNE)));
        registerFuel(new MachineFuel(60, new ItemStack(SlimefunItems.ENCHANTMENT_RUNE)));
        registerFuel(new MachineFuel(60, new ItemStack(SlimefunItems.RAINBOW_RUNE)));
        registerFuel(new MachineFuel(60, new ItemStack(SlimefunItems.SOULBOUND_RUNE)));
        registerFuel(new MachineFuel(60, new ItemStack(SlimefunItems.VILLAGER_RUNE)));
    }

}
