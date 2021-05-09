package me.apeiros.magicxpansion.listeners;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.apeiros.magicxpansion.setup.MagicXpansionItems;
import org.bukkit.entity.Player;
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
                int rNum = r.nextInt(2);

                if (rNum == 0) {
                    e.getDrops().add(MagicXpansionItems.SOUL);
                }
            }
        }
    }
}
