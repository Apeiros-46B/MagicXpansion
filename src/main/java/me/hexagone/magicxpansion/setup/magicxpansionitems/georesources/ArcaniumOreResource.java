package me.hexagone.magicxpansion.setup.magicxpansionitems.georesources;

import io.github.thebusybiscuit.slimefun4.api.geo.GEOResource;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class ArcaniumOreResource implements GEOResource {

    private final NamespacedKey key;
    private final ItemStack item;

    public ArcaniumOreResource(Plugin plugin, ItemStack item) {
        this.key = new NamespacedKey(plugin, "arcanium_ore");
        this.item = item;
    }

    @Override
    public int getDefaultSupply(World.Environment environment, Biome biome) {
        if (environment == World.Environment.THE_END) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getMaxDeviation() {
        return 3;
    }

    @Override
    public String getName() {
        return "Arcanium Ore";
    }

    @Override
    public ItemStack getItem() {
        return item.clone();
    }

    @Override
    public boolean isObtainableFromGEOMiner() {
        return true;
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }
}
