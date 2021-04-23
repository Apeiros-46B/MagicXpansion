package me.hexagone.magicxpansion.setup.items.weapons;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

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
