package me.desty.plugin.Functions;

import me.desty.plugin.SteveMyers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class FunctionSpawn {
	private SteveMyers plugin;

	public FunctionSpawn(SteveMyers plugin) {
		this.plugin = plugin;
	}

	public void pickSpawnPoints() {
		if (plugin.started = true) {
			for (int x = 1; x <= plugin.qPlayer.size(); x++) {
				Player player = plugin.qPlayer.get(x - 1);
				if (plugin.disguiseList.containsKey(player)) {
					plugin.dcAPI.disguisePlayer(player, plugin.disguiseList.get(player));
				}
				player.teleport(plugin.funcGrab.grabRandomSpot(plugin.qPlayer.get(x - 1).getLocation(), "runners"));
				player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Myers will be free to kill in 20 Seconds! Hide quick!");
			}
			for (int x = 1; x <= plugin.Myers.size(); x++) {
				plugin.Myers.get(x - 1).teleport(plugin.funcGrab.grabRandomSpot(plugin.Myers.get(x - 1).getLocation(), "myers"));
			}
		} else {
			plugin.getServer().broadcastMessage(ChatColor.YELLOW + "Something went wrong picking spawnpoints..");
			plugin.started = false;
		}
	}
}
