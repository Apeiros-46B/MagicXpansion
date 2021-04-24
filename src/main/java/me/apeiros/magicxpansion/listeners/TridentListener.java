package me.apeiros.magicxpansion.listeners;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import me.apeiros.magicxpansion.setup.MagicXpansionItems;

import java.util.concurrent.ThreadLocalRandom;

public class TridentListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onTridentShoot(ProjectileLaunchEvent e) {
        Entity shooter = (Entity) e.getEntity().getShooter();

        if (shooter instanceof Player) {
            Player player = (Player) shooter;

            if (e.getEntity().getType() == EntityType.TRIDENT &&
                    (SlimefunUtils.isItemSimilar(player.getInventory().getItemInMainHand(), MagicXpansionItems.POSEIDONS_TRIDENT, false, false))
                    || (SlimefunUtils.isItemSimilar(player.getInventory().getItemInOffHand(), MagicXpansionItems.POSEIDONS_TRIDENT, false, false))) {
                Projectile trident = e.getEntity();
                trident.setVelocity(trident.getVelocity().multiply(2.5));
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onTridentHit(ProjectileHitEvent e) {
        if (e.getEntity().getType() == EntityType.TRIDENT && e.getHitEntity() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) e.getHitEntity();
            Projectile trident = e.getEntity();
            Entity shooter = (Entity) e.getEntity().getShooter();

            World world = entity.getWorld();

            if (!world.isThundering()) {
                Location location = entity.getLocation();

                ThreadLocalRandom r = ThreadLocalRandom.current();
                int rNum = r.nextInt(4);

                if (rNum == 0) {
                    world.strikeLightning(location);
                    world.playSound(location, Sound.ITEM_TRIDENT_THUNDER, 1, 1);
                }
            }

            if (shooter instanceof Player) {
                trident.teleport(shooter.getLocation());
                world.spawnParticle(Particle.NAUTILUS, shooter.getLocation(), 40, 0.4, 0.4, 0.4);
            }
        }
    }

}
