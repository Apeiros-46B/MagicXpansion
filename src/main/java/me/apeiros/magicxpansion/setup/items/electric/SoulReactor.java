package me.apeiros.magicxpansion.setup.items.electric;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.reactors.Reactor;
import me.apeiros.magicxpansion.setup.MagicXpansionItems;
import me.apeiros.magicxpansion.utils.HeadTextures;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nonnull;
import java.util.Iterator;

import static me.apeiros.magicxpansion.setup.MagicXpansionItems.*;

public abstract class SoulReactor extends Reactor {

    private final SlimefunItemStack PROGRESS_BAR = new SlimefunItemStack("SOUL_REACTOR_PROGRESS_BAR", HeadTextures.SOUL_FIRE_TEXTURE, "", "");

    public SoulReactor(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Override
    public ItemStack getCoolant() {
        return SOUL_REACTOR_COOLANT;
    }

    @Nonnull
    @Override
    public ItemStack getFuelIcon() {
        return MagicXpansionItems.SOUL_ORB;
    }

    @Nonnull
    @Override
    public ItemStack getProgressBar() {
        return PROGRESS_BAR;
    }

    @Override
    protected void registerDefaultFuelTypes() {
        this.registerFuel(new MachineFuel(600, MagicXpansionItems.SOUL_ORB, null));
    }

    @Override
    public void extraTick(@Nonnull Location l) {
        SlimefunPlugin.runSync(() -> {
            Iterator var1 = l.getWorld().getNearbyEntities(l, 5.0D, 5.0D, 5.0D, (n) -> {
                return n instanceof LivingEntity && n.isValid();
            }).iterator();

            while(var1.hasNext()) {
                Entity entity = (Entity) var1.next();
                if (entity instanceof LivingEntity) {
                    if (entity instanceof Player) {
                        if (((Player) entity).getGameMode() == GameMode.CREATIVE || ((Player) entity).getGameMode() == GameMode.SPECTATOR) {
                            // Do nothing, player is in creative or spectator
                        } else {
                            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 60, 3));
                            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 3));
                            ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 2));
                        }
                    } else {
                        ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 60, 3));
                        ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 3));
                        ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 2));
                    }
                }
            }
        });
    }
}
