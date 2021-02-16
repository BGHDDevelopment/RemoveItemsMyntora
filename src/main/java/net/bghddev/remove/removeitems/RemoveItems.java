package net.bghddev.remove.removeitems;

import lombok.Getter;
import lombok.Setter;
import net.bghddev.remove.removeitems.events.ItemPickupEvent;
import net.bghddev.remove.removeitems.events.JoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@Setter
public final class RemoveItems extends JavaPlugin {

    @Getter
    public static RemoveItems instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getServer().getPluginManager().registerEvents(new ItemPickupEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
