package me.hexagone.magicxpansion.setup.items.tools;

import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.settings.IntRangeSetting;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EnergizedWindStaff extends SimpleSlimefunItem<ItemUseHandler> {
    private final ItemSetting<Integer> multiplier = new IntRangeSetting(this, "power", 1, 4, 2147483647);

    public EnergizedWindStaff(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        this.addItemSetting(this.multiplier);
    }

    public ItemUseHandler getItemHandler() {
        return (e) -> {
            Player p = e.getPlayer();
            p.setVelocity(p.getEyeLocation().getDirection().multiply(this.multiplier.getValue()));
            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1.0F, 1.0F);
            p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
            p.setFallDistance(0.0F);
        };
    }
}
