package me.desty.plugin.Events;

import me.desty.plugin.GameTimer;
import me.desty.plugin.SteveMyers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class EventPlayerLogin implements Listener{
	private SteveMyers plugin;
	
    public EventPlayerLogin(SteveMyers plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
            Player joined = event.getPlayer();
            if (!(plugin.qPlayer.contains(joined))) {
            	plugin.qPlayer.add(joined);
                    // joined.sendMessage(this.getConfig().getString("WELCOME_MESSAGE"));
            }
            int online = plugin.qPlayer.size();
            int least = plugin.getConfig().getInt("GameSettings.MinimiumPlayers");
            if (plugin.started == true) {
                    event.getResult();
                    event.disallow(Result.KICK_OTHER, "Game in Progress. Try again later.");
            } else if (online >= least && plugin.countdown == false) {
                    if ((plugin.getConfig().get("SpawnPoints.Runners." + plugin.getConfig().get("GameSettings.MaxSpawnPoints.Runners"))) == null || (plugin.getConfig().get("SpawnPoints.Myers." + plugin.getConfig().get("GameSettings.MaxSpawnPoints.Myers"))) == null) {
                    	plugin.getServer().broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "PLEASE SET SPAWN POINTS FOR RUNNERS AND MYERS WITH /SETLOBBY!");
                    } else {
                    	plugin.run.resumeit();
                    	plugin.countdown = true;
                    }
            }
    }
}
