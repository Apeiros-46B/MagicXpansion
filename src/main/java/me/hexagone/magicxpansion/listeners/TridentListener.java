package me.hexagone.magicxpansion.listeners;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.hexagone.magicxpansion.setup.MagicXpansionItems;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.Random;

import static me.hexagone.magicxpansion.setup.MagicXpansionItems.POSEIDONS_TRIDENT;

public class TridentListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onTridentShoot(ProjectileLaunchEvent e) {
        Entity shooter = (Entity) e.getEntity().getShooter();

        boolean shooterIsPlayer = false;

        if (shooter instanceof Player) {
            shooterIsPlayer = true;
        }

        if (shooterIsPlayer) {
            Player player = (Player) shooter;

            if (e.getEntity().getType() == EntityType.TRIDENT &&
                    (SlimefunUtils.isItemSimilar(player.getInventory().getItemInMainHand(), POSEIDONS_TRIDENT, false, false))
                    || (SlimefunUtils.isItemSimilar(player.getInventory().getItemInOffHand(), POSEIDONS_TRIDENT, false, false))) {
                Projectile trident = e.getEntity();
                trident.setVelocity(trident.getVelocity().multiply(2.5));
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onTridentHit(ProjectileHitEvent e) {
        if (e.getEntity().getType() == EntityType.TRIDENT && e.getHitEntity() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) e.getHitEntity();
            Projectile trident = e.getEntity();
            Entity shooter = (Entity) e.getEntity().getShooter();

            World world = entity.getWorld();

            if (!world.isThundering()) {
                Location location = entity.getLocation();

                Random r = new Random();
                int rNum = r.nextInt(8);

                if (rNum == 0) {
                    world.strikeLightning(location);
                }
            }

            if (shooter instanceof Player) {
                trident.remove();
                ((Player) shooter).getInventory().setItem(((Player) shooter).getInventory().firstEmpty(), POSEIDONS_TRIDENT);
            }
        }
    }

}
