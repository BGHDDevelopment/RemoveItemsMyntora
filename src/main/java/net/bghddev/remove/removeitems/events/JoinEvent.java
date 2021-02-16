package net.bghddev.remove.removeitems.events;

import net.bghddev.remove.removeitems.RemoveItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;


public class JoinEvent implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Bukkit.getScheduler().runTaskLater(RemoveItems.getInstance(), () -> {
            for (ItemStack item : player.getInventory().getContents()) {
                if (item == null) continue;
                if (item.getType().equals(Material.BEDROCK) || (item.getType().equals(Material.END_PORTAL_FRAME) || (item.getType().equals(Material.BARRIER)))) {
                    item.setAmount(0);
                    player.updateInventory();
                    player.sendMessage(ChatColor.RED + "Your inventory included blacklisted blocks. They have been removed.");
                }
            }
        }, 5L);
    }
}