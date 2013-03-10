package me.desty.plugin.Events;

import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Note.Tone;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import me.desty.plugin.GameTimer;
import me.desty.plugin.SteveMyers;
import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;

public class EventServerMOTD implements Listener{
    private SteveMyers plugin;
    
    public EventServerMOTD(SteveMyers plugin) {
            this.plugin = plugin;
    }
    @EventHandler
    public void changeMOTD(ServerListPingEvent event) {
    	int time = plugin.getConfig().getInt("GameSettings.GameTime");
            if (plugin.started == true) {
                    event.setMotd("\u00A7cGame In Progress!");
            } else {
                    if (plugin.qPlayer.size() > plugin.getConfig().getInt("GameSettings.MinimiumPlayers")) {
                            event.setMotd("\u00A72Lobby Open! New game in " + (time - plugin.run.j) + " Secs");
                    } else
                            event.setMotd("\u00A72Lobby Open!");
            }
    }
    /*@EventHandler
    public void blockDamage(EntityDamageByBlockEvent event){
    	Player player = (Player) event.getEntity();
    	event.setDamage(1);
    	if(event.getDamage() >= 1){
    		player.setHealth(20);
    		player.playNote(player.getLocation(), Instrument.PIANO, Note.sharp(1, Tone.G));
    		/*if(!plugin.Myers.contains(player)){
    			if(plugin.disguiseList.containsKey(player)){
    				if(plugin.dcAPI.getDisguise(player) != null){
    					plugin.dcAPI.undisguisePlayer(player);
    					player.setHealth(20);
    				}
    			}
    		}
    	} else 
        if(plugin.disguiseList.containsKey(player)){
    		plugin.dcAPI.disguisePlayer(player, plugin.disguiseList.get(player));
    	}
    }*/
}
