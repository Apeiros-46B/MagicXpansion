package me.apeiros.magicxpansion;

import io.github.mooy1.infinitylib.AbstractAddon;
import io.github.mooy1.infinitylib.bstats.bukkit.Metrics;
import io.github.mooy1.infinitylib.commands.AbstractCommand;
import lombok.SneakyThrows;
import me.apeiros.magicxpansion.listeners.CrossbowListener;
import me.apeiros.magicxpansion.listeners.MobDeathListener;
import me.apeiros.magicxpansion.listeners.TridentListener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.apeiros.magicxpansion.setup.Setup;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.List;

public class MagicXpansion extends AbstractAddon {

    private static MagicXpansion instance;

    @SneakyThrows
    @Override
    public void onEnable() {
        instance = this;
        super.onEnable();

        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        // Setup items
        Setup.setup();

        // Register Listeners
        new TridentListener(this);
        new CrossbowListener(this);
        new MobDeathListener(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Nullable
    @Override
    protected Metrics setupMetrics() {
        return null;
    }

    @Nonnull
    @Override
    protected String getGithubPath() {
        return "https://github.com/Apeiros-46B/MagicXpansion";
    }

    @Nonnull
    @Override
    protected List<AbstractCommand> getSubCommands() {
        return null;
    }

    @Nonnull
    public static MagicXpansion getInstance() {
        return instance;
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
