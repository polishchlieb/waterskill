package pl.chlebek.adfun.waterskill.listeners;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import pl.chlebek.adfun.waterskill.Main;
import pl.chlebek.adfun.waterskill.commands.SetLocationCommand;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        final Location l = SetLocationCommand.getLocation();
        if (l == null) {
            Main.broadcast("co sie dzieje?co sie dzieje?co sie dzieje?");
            return;
        }

        e.getEntity().teleport(l);
    }
}
