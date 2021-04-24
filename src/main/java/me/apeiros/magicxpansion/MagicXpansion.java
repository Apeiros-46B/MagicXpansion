package me.apeiros.magicxpansion;

import me.apeiros.magicxpansion.listeners.TridentListener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.apeiros.magicxpansion.setup.Setup;

public class MagicXpansion extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        Setup.RegisterItems(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        // Returns a reference to this JavaPlugin
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

}
