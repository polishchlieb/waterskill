package pl.chlebek.adfun.waterskill;

import org.bukkit.plugin.java.JavaPlugin;
import pl.chlebek.adfun.waterskill.commands.BroadcastCommand;
import pl.chlebek.adfun.waterskill.commands.SetLocationCommand;
import pl.chlebek.adfun.waterskill.commands.StartCommand;
import pl.chlebek.adfun.waterskill.listeners.ChatListener;
import pl.chlebek.adfun.waterskill.listeners.JoinAndLeaveListener;
import pl.chlebek.adfun.waterskill.listeners.PlayerDeathListener;
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
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new JoinAndLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);

        getCommand("broadcast").setExecutor(new BroadcastCommand());
        getCommand("start").setExecutor(new StartCommand());
        getCommand("setlocation").setExecutor(new SetLocationCommand());
    }

    public static void broadcast(String message) {
        getInstance().getServer().broadcastMessage("§b§l[ADFUN] §r" + message);
    }
}
