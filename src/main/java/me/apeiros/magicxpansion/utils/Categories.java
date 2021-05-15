package me.apeiros.magicxpansion.utils;

import io.github.mooy1.infinitylib.slimefun.utils.MultiCategory;
import io.github.mooy1.infinitylib.slimefun.utils.SubCategory;
import lombok.experimental.UtilityClass;
import me.apeiros.magicxpansion.MagicXpansion;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

@UtilityClass
public final class Categories {

   public static final Category GENERAL = new SubCategory(
            new NamespacedKey(MagicXpansion.getInstance(), "magicxpansion_general"),
            new CustomItem(Material.ENCHANTED_BOOK, "&6MagicXpansion &7- &aGeneral", "", "&a⇨ Click to open")
    );

   public static final Category RESOURCES = new SubCategory(
            new NamespacedKey(MagicXpansion.getInstance(), "magicxpansion_resources"),
            new CustomItem(Material.NETHERITE_INGOT, "&6MagicXpansion &7- &bResources", "", "&b⇨ Click to open")
   );

   public static final Category MAGICAL = new SubCategory(
            new NamespacedKey(MagicXpansion.getInstance(), "magicxpansion_magical"),
            new CustomItem(Material.BLAZE_POWDER, "&6MagicXpansion &7- &eMagical Items", "", "&e⇨ Click to open")
   );

   public static final Category TOOLS = new SubCategory(
            new NamespacedKey(MagicXpansion.getInstance(), "magicxpansion_tools"),
            new CustomItem(Material.IRON_PICKAXE, "&6MagicXpansion &7- &dTools", "", "&d⇨ Click to open")
   );

   public static final Category WEAPONS = new SubCategory(
            new NamespacedKey(MagicXpansion.getInstance(), "magicxpansion_weapons"),
            new CustomItem(Material.NETHERITE_SWORD, "&6MagicXpansion &7- &cWeapons", "", "&c⇨ Click to open")
   );

   public static final Category ARMOR = new SubCategory(
            new NamespacedKey(MagicXpansion.getInstance(), "magicxpansion_armor"),
            new CustomItem(Material.DIAMOND_CHESTPLATE, "&6MagicXpansion &7- &cArmor", "", "&c⇨ Click to open")
   );

   public static final Category MACHINES = new SubCategory(
           new NamespacedKey(MagicXpansion.getInstance(), "magicxpansion_machines"),
           new CustomItem(Material.PISTON, "&6MagicXpansion &7- &eMachines", "", "&e⇨ Click to open")
   );

   public static final Category MAIN = new MultiCategory(
            new NamespacedKey(MagicXpansion.getInstance(), "magicxpansion"),
            new CustomItem(Material.END_PORTAL_FRAME, "&6MagicXpansion", "", "&5⇨ Click to open"),
            GENERAL, RESOURCES, MAGICAL, TOOLS, WEAPONS, ARMOR, MACHINES
   );
}