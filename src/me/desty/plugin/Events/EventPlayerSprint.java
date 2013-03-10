package me.desty.plugin.Events;

import me.desty.plugin.SteveMyers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventPlayerSprint implements Listener {
	private SteveMyers plugin;

	public EventPlayerSprint(SteveMyers plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void playerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (plugin.started == true) {
			if (!plugin.Myers.contains(player)) {
				if (plugin.disguiseList.containsKey(player)) {
					if (player.isSprinting() == true) {
						if (plugin.disguiseList.containsKey(player)) {
							plugin.dcAPI.disguisePlayer(player, plugin.disguiseList.get(player));
							player.sendMessage("nips"); // dans titties
						}
					}
					if (player.isSprinting() == false) {
						if (plugin.dcAPI.getDisguise(player) != null) {
							plugin.disguiseList.put(player, plugin.dcAPI.getDisguise(player));
							plugin.dcAPI.undisguisePlayer(player);
						}
					}
				}
			}
		} else {

		}
	}
	/*
	 * @EventHandler public void playerSprint(PlayerToggleSprintEvent event) { Player player = event.getPlayer(); if(plugin.started == true){ if(!plugin.Myers.contains(player)){ if (plugin.disguiseList.containsKey(player)) { if (player.isSprinting() == false) { if (plugin.disguiseList.containsKey(player)) { plugin.dcAPI.disguisePlayer(player, plugin.disguiseList.get(player)); } } if (player.isSprinting() == true) { if (plugin.dcAPI.getDisguise(player) != null) { plugin.disguiseList.put(player,
	 * plugin.dcAPI.getDisguise(player)); plugin.dcAPI.undisguisePlayer(player); } } } } } else {
	 * 
	 * } }
	 */
}
