package me.apeiros.magicxpansion.listeners;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.apeiros.magicxpansion.MagicXpansion;
import me.apeiros.magicxpansion.setup.MagicXpansionItems;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class CrossbowListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onCrossbowShoot(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Player && e.getProjectile().getType() == EntityType.ARROW &&
                SlimefunUtils.isItemSimilar(e.getBow(), MagicXpansionItems.INFINITY_CROSSBOW, false, false)) {
            Player p = (Player) e.getEntity();
            Inventory inv = p.getInventory();

            if (p.getGameMode() == GameMode.CREATIVE) {
                // Do nothing because the player is in creative; they don't use arrows
            } else {
                if (MagicXpansion.doesInvHaveSpace(inv, new ItemStack(Material.ARROW), 1)) {
                    inv.addItem(new ItemStack(Material.ARROW));
                }
            }
        } else if (e.getEntity() instanceof Player && e.getProjectile().getType() == EntityType.ARROW &&
               SlimefunUtils.isItemSimilar(e.getBow(), MagicXpansionItems.NETHER_CROSSBOW, false, false)) {
            Projectile projectile = (Projectile) e.getProjectile();

            ThreadLocalRandom r = ThreadLocalRandom.current();
            int rNum = r.nextInt(3);

            projectile.setFireTicks(32767);

            if (rNum == 0) {
                World world = projectile.getWorld();

                Entity fireball = world.spawnEntity(projectile.getLocation(), EntityType.SMALL_FIREBALL);
                fireball.setVelocity(projectile.getVelocity());
                fireball.setGravity(true);
                fireball.setFireTicks(32767);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onCrossbowHit(ProjectileHitEvent e) {
        if (e.getEntity().getShooter() instanceof Player && e.getEntityType() == EntityType.ARROW) {
            Player shooter = (Player) e.getEntity().getShooter();

            if (SlimefunUtils.isItemSimilar(shooter.getInventory().getItemInMainHand(), MagicXpansionItems.INFINITY_CROSSBOW, false, false)) {
                Arrow arrow = (Arrow) e.getEntity();

                if (e.getHitEntity() == null) {
                    arrow.remove();
                }
            }
        }
    }

}
