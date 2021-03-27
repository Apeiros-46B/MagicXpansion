package me.hexagone.magicxpansion.tools;

import io.github.thebusybiscuit.slimefun4.core.services.CustomItemDataService;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InfinityCrossbow extends SlimefunItem implements Listener {

    public InfinityCrossbow(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    // WIP
    // Add Infinity function later

    /* @EventHandler
    public void onCrossBowLoad(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        CustomItemDataService handItemData;
        CustomItemDataService
        if (p.getInventory().getItemInMainHand().getType() == Material.CROSSBOW) {
            ItemStack itemInMainHand = p.getInventory().getItemInMainHand();
            if (customItem.getItemData(itemInMainHand) == )
       }
    } */

    /* @EventHandler
    public void onCrossbowShoot(EntityShootBowEvent e) {

        if (Objects.requireNonNull(e.getBow()).getType() == Material.CROSSBOW) {
            if (e.getBow().hasItemMeta()) {
                if ((e.getBow().getItemMeta().hasLore())) {
                    if (e.getBow().) {

                        Player p = (Player) e.getEntity();

                                }
                            }
                        }
                    }
                }
            }
        }
    }*/
}
