package me.desty.plugin.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import me.desty.plugin.SteveMyers;

public class EventHunger implements Listener{
	private SteveMyers plugin;
	
    public EventHunger(SteveMyers plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void hungerWatch(FoodLevelChangeEvent event) {
            event.setCancelled(true);
    }
    
}
