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
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ThreadLocalRandom;

public class TridentListener implements Listener {

    public TridentListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onTridentShoot(ProjectileLaunchEvent e) {
        Entity shooter = (Entity) e.getEntity().getShooter();

        if (shooter instanceof Player) {
            Player player = (Player) shooter;

            if (e.getEntity().getType() == EntityType.TRIDENT &&
                    (SlimefunUtils.isItemSimilar(player.getInventory().getItemInMainHand(), MagicXpansionItems.POSEIDONS_TRIDENT, false, false))
                    || (SlimefunUtils.isItemSimilar(player.getInventory().getItemInOffHand(), MagicXpansionItems.POSEIDONS_TRIDENT, false, false))) {
                Projectile trident = e.getEntity();

                trident.setVelocity(trident.getVelocity().multiply(1.75));
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onTridentHit(ProjectileHitEvent e) {
        if (e.getEntity().getShooter() != null) {
            Entity shooter = (Entity) e.getEntity().getShooter();
            Location shooterLoc = shooter.getLocation();

            if (e.getEntity().getType() == EntityType.TRIDENT && e.getHitEntity() instanceof LivingEntity && shooter instanceof Player) {
                LivingEntity entity = (LivingEntity) e.getHitEntity();
                Projectile trident = e.getEntity();
                World world = shooter.getWorld();

                if (!world.isThundering()) {
                    Location location = entity.getLocation();

                    ThreadLocalRandom r = ThreadLocalRandom.current();
                    int rNum = r.nextInt(4);

                    if (rNum == 0) {
                        world.strikeLightning(location);
                        world.playSound(location, Sound.ITEM_TRIDENT_THUNDER, 1, 1);
                        world.playSound(shooterLoc, Sound.ITEM_TRIDENT_RETURN, 1, 1);
                    }
                }

                trident.teleport(shooterLoc);
                world.spawnParticle(Particle.NAUTILUS, shooterLoc, 75, 0.4, 0.4, 0.4);
            }

            if (e.getEntity().getType() == EntityType.TRIDENT && e.getHitEntity() == null && shooter instanceof Player) {
                Trident trident = (Trident) e.getEntity();
                World world = shooter.getWorld();

                if (SlimefunUtils.isItemSimilar(trident.getItem(), MagicXpansionItems.POSEIDONS_TRIDENT, false, false)) {
                    trident.teleport(shooterLoc);
                    world.spawnParticle(Particle.NAUTILUS, shooterLoc, 30, 1, 1, 1);
                    world.playSound(shooterLoc, Sound.ITEM_TRIDENT_RETURN, 1, 1);
                }
            }
        }
    }
}
