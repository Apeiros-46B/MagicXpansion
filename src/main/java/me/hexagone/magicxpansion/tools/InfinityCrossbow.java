package me.hexagone.magicxpansion.tools;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InfinityCrossbow extends SlimefunItem {

    public InfinityCrossbow(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @EventHandler
    public void onCrossBowLoad(PlayerInteractEvent e) {

        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("&aNever runs out of arrows.");

        Player p = e.getPlayer();

        if (e.getMaterial() == Material.CROSSBOW) {
            CrossbowMeta cMeta = (CrossbowMeta) e.getItem().getItemMeta();

            List<ItemStack> projectiles = null;
            if (cMeta != null) {
                projectiles = cMeta.getChargedProjectiles();
            }
            ItemStack projectileItemStack = projectiles.get(0);

            if (!p.getInventory().contains(Material.AIR)) {
                p.getInventory().setItem(p.getInventory().firstEmpty(), projectileItemStack.clone());
            } else {
                p.sendMessage("&cYou do not have enough inventory space!");
            }
        }
    }
}
