package pl.chlebek.adfun.waterskill.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLocationCommand implements CommandExecutor {
    private static Location location;
    public static Location getLocation() {
        return location;
    }
    public static void setLocation(Location value) {
        location = value;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        setLocation(((Player) sender).getLocation());
        sender.sendMessage("ustawiono");
        return false;
    }
}
