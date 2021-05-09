package me.apeiros.magicxpansion;

import me.apeiros.magicxpansion.listeners.CrossbowListener;
import me.apeiros.magicxpansion.listeners.ScytheListener;
import me.apeiros.magicxpansion.listeners.TridentListener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.apeiros.magicxpansion.setup.Setup;

import javax.annotation.Nonnull;

public class MagicXpansion extends JavaPlugin implements SlimefunAddon {

    private static MagicXpansion instance;

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        // Instance
        instance = this;

        // Setup items
        Setup.setup(this);

        // Register Listeners
        new TridentListener(this);
        new CrossbowListener(this);
        new ScytheListener(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/Apeiros-46B/MagicXpansion/issues";
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    public static boolean doesInvHaveSpace(Inventory inv, ItemStack addedItem, int amount) {
        // Returns true if an Inventory has space for an amount of items being added, false if not
        if (inv.addItem(addedItem).isEmpty()) {
            inv.removeItem(addedItem);
            return true;
        } else {
            return false;
        }
    }

    @Nonnull
    public static MagicXpansion getInstance() {
        return instance;
    }
}
