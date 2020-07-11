package pl.chlebek.adfun.waterskill;

import org.bukkit.plugin.java.JavaPlugin;
import pl.chlebek.adfun.waterskill.commands.BroadcastCommand;
import pl.chlebek.adfun.waterskill.commands.StartCommand;
import pl.chlebek.adfun.waterskill.listeners.PreventListener;

public class Main extends JavaPlugin {
    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new PreventListener(), this);

        getCommand("broadcast").setExecutor(new BroadcastCommand());
        getCommand("start").setExecutor(new StartCommand());
    }

    public static void broadcast(String message) {
        getInstance().getServer().broadcastMessage("§b§l[ADFUN] §r" + message);
    }
}
