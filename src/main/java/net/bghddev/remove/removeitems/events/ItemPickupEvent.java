package net.bghddev.remove.removeitems.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class ItemPickupEvent implements Listener {


    @EventHandler
    public void onPickup(EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (event.getItem().getItemStack().getType().equals(Material.BEDROCK) || (event.getItem().getItemStack().getType().equals(Material.END_PORTAL_FRAME) || (event.getItem().getItemStack().getType().equals(Material.BARRIER)))) {
            event.setCancelled(true);
            event.getItem().remove();
            player.updateInventory();
            player.sendMessage(ChatColor.RED + "You attempted to pick up a blacklisted block. It has been removed.");
        }
    }
}
