package me.apeiros.magicxpansion.setup.items.georesources;

import io.github.thebusybiscuit.slimefun4.api.geo.GEOResource;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class NautilusFossilResource implements GEOResource {

    private final NamespacedKey key;
    private final ItemStack item;

    public NautilusFossilResource(Plugin plugin, ItemStack item) {
        this.key = new NamespacedKey(plugin, "nautilus_fossil");
        this.item = item;
    }

    @Override
    public int getDefaultSupply(World.Environment environment, Biome biome) {
        if (biome == Biome.COLD_OCEAN || biome == Biome.DEEP_COLD_OCEAN || biome == Biome.OCEAN || biome == Biome.DEEP_OCEAN || biome == Biome.LUKEWARM_OCEAN || biome == Biome.DEEP_LUKEWARM_OCEAN) {
            return 5;
        } else {
            return 0;
        }
    }

    @Override
    public int getMaxDeviation() {
        return 5;
    }

    @Override
    public String getName() {
        return "Nautilus Fossil";
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
