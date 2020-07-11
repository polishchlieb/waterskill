package pl.chlebek.adfun.waterskill.listeners;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class PreventListener implements Listener {
    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player && e.getEntity() instanceof Player) || e.getDamager().isOp())
            return;
        e.setCancelled(true);
    }

    @EventHandler
    public void onWeatherCycle(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (!e.getPlayer().isOp())
            e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent e) {
        if (e.getPlayer().isOp())
            return;
        if (e.getRightClicked() instanceof ArmorStand || e.getRightClicked() instanceof ItemFrame)
            e.setCancelled(true);
    }

    @EventHandler
    public void onArmorStandManipulate(PlayerArmorStandManipulateEvent e) {
        if (!e.getPlayer().isOp())
            e.setCancelled(true);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player) || e.getDamager().isOp())
            return;
        if (e.getEntity() instanceof ItemFrame || e.getEntity() instanceof ArmorStand)
            e.setCancelled(true);
    }

    @EventHandler
    public void onItemFrameBreak(HangingBreakByEntityEvent e) {
        if (e.getEntity() instanceof ItemFrame && e.getRemover() instanceof Player && !e.getRemover().isOp())
            e.setCancelled(true);
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (!e.getPlayer().isOp()) {
            e.getPlayer().sendMessage("cicho bonc");
            e.setCancelled(true);
        }
    }
}
