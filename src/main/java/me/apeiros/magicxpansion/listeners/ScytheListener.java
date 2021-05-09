package me.apeiros.magicxpansion.listeners;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.apeiros.magicxpansion.setup.MagicXpansionItems;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ThreadLocalRandom;

public class ScytheListener implements Listener {

    public ScytheListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onMobKill(EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null) {
            Player killer = e.getEntity().getKiller();

            if (!(e.getEntity() instanceof Player) &&
                    SlimefunUtils.isItemSimilar(killer.getInventory().getItemInMainHand(), MagicXpansionItems.REAPER_SCYTHE, false, false)) {
                ThreadLocalRandom r = ThreadLocalRandom.current();
                int rNum = r.nextInt(299);

                if (e.getEntity() instanceof Wither) {
                    if (rNum <= 199) {
                        e.getDrops().add(MagicXpansionItems.SOUL);
                        e.getDrops().add(MagicXpansionItems.SOUL);

                        if (rNum <= 99) {
                            e.getDrops().add(MagicXpansionItems.SOUL_CLUSTER);
                        }
                    }
                } else {
                    if (rNum <= 99) {
                        e.getDrops().add(MagicXpansionItems.SOUL);
                    }
                }
            }
        }
    }
}
