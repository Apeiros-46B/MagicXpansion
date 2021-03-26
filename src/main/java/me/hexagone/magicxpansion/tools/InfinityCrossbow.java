package me.hexagone.magicxpansion.tools;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InfinityCrossbow extends SlimefunItem {

    public InfinityCrossbow(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @EventHandler
    public void onCrossBowShoot(EntityShootBowEvent e) {

        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("&aNever runs out of arrows.");

        if (Objects.requireNonNull(e.getBow()).getType() == Material.CROSSBOW) {
            if (e.getBow().hasItemMeta()) {
                if (Objects.requireNonNull(e.getBow().getItemMeta()).hasLore()) {
                    if (e.getBow().getItemMeta().getLore() == lore) {

                        Player p = (Player) e.getEntity();
                        // Player.getInventory();
                        //ItemStack arrow = p.getInventory().getItem(p.getInventory().first(Material.ARROW));
                        if (p.getInventory().contains(Material.FIREWORK_ROCKET)) {
                            ItemStack ammo = p.getInventory().getItem(p.getInventory().first(Material.FIREWORK_ROCKET));
                            if (ammo != null && ammo.getAmount() != 64) {
                                ammo.setAmount(ammo.getAmount()+1);
                            }
                        } else {
                            if (p.getInventory().contains(Material.TIPPED_ARROW)) {
                                ItemStack ammo = p.getInventory().getItem(p.getInventory().first(Material.TIPPED_ARROW));
                                if (ammo != null && ammo.getAmount() != 64) {
                                    ammo.setAmount(ammo.getAmount()+1);
                                }
                            } else {
                                if (p.getInventory().contains(Material.SPECTRAL_ARROW)) {
                                    ItemStack ammo = p.getInventory().getItem(p.getInventory().first(Material.SPECTRAL_ARROW));
                                    if (ammo != null && ammo.getAmount() != 64) {
                                        ammo.setAmount(ammo.getAmount()+1);
                                    }
                                } else {
                                    if (p.getInventory().contains(Material.ARROW)) {
                                        ItemStack ammo = p.getInventory().getItem(p.getInventory().first(Material.ARROW));
                                        if (ammo != null && ammo.getAmount() != 64) {
                                            ammo.setAmount(ammo.getAmount()+1);
                                        }
                                    } else {
                                        e.setCancelled(true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
