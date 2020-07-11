package pl.chlebek.adfun.waterskill.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.chlebek.adfun.waterskill.Main;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("uzyj: /start <gracz>");
            return true;
        }

        Player p = Main.getInstance().getServer().getPlayer(args[0]);
        if (p == null || !p.isOnline()) {
            sender.sendMessage("uzyj: /start <gracz>");
            return true;
        }

        p.teleport(((Player) sender).getLocation());
        Main.broadcast("teraz skacze §e" + p.getName());

        return false;
    }
}
