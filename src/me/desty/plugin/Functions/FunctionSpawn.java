package me.desty.plugin.Functions;

import me.desty.plugin.GameTimer;
import me.desty.plugin.SteveMyers;

import org.bukkit.ChatColor;

import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;

public class FunctionSpawn {
    private SteveMyers plugin;
    
    public FunctionSpawn(SteveMyers plugin) {
            this.plugin = plugin;
    }
    public void pickSpawnPoints() {
        if (plugin.started = true) {
                for (int x = 1; x <= plugin.qPlayer.size(); x++) {
                	plugin.qPlayer.get(x - 1).teleport(plugin.funcGrab.grabRandomSpot(plugin.qPlayer.get(x - 1).getLocation(), "runners"));
                	plugin.qPlayer.get(x - 1).sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Myers will be free to kill in 20 Seconds! Hide quick!");
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
