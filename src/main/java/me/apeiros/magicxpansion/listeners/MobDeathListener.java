package me.apeiros.magicxpansion.listeners;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.apeiros.magicxpansion.setup.MagicXpansionItems;
import org.bukkit.entity.Evoker;
import org.bukkit.entity.Illusioner;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ThreadLocalRandom;

public class MobDeathListener implements Listener {

    public MobDeathListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onMobDeath(EntityDeathEvent e) {
        ThreadLocalRandom r = ThreadLocalRandom.current();

        if (e.getEntity().getKiller() != null) {
            Player killer = e.getEntity().getKiller();

            if (!(e.getEntity() instanceof Player) &&
                    SlimefunUtils.isItemSimilar(killer.getInventory().getItemInMainHand(), MagicXpansionItems.REAPER_SCYTHE, false, false)) {
                int rNum = r.nextInt(299);

                if (e.getEntity() instanceof Wither) {
                    if (rNum <= 199) {
                        e.getDrops().add(MagicXpansionItems.SOUL);
                        e.getDrops().add(MagicXpansionItems.SOUL);

                        if (rNum <= 99) {
                            e.getDrops().add(MagicXpansionItems.SOUL_ORB);
                        }
                    }
                } else {
                    if (rNum <= 99) {
                        e.getDrops().add(MagicXpansionItems.SOUL);
                    }
                }
            }
        }

        if (r.nextInt(99) <= 14 && e.getEntity().getKiller() != null && e.getEntity() instanceof Evoker) {
            e.getDrops().add(MagicXpansionItems.BASIC_SPELLBOOK);
        }

        if (e.getEntity() instanceof Illusioner) {
            // I'll add this tomorrow i'm tired
        }
    }
}
