package pl.chlebek.adfun.waterskill.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onMessage(AsyncPlayerChatEvent e) {
        if (e.getPlayer().isOp())
            e.setFormat("§c%s§7: §f%s");
        else
            e.setFormat("§7%s: §f%s");
    }
}
