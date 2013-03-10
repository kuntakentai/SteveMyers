package me.desty.plugin.Functions;

import me.desty.plugin.GameTimer;
import me.desty.plugin.SteveMyers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;

public class FunctionEliminate {
    private SteveMyers plugin;
    
    public FunctionEliminate(SteveMyers plugin) {
            this.plugin = plugin;
    }
    public void eliminatePlayer(Player player) {
        if (plugin.qPlayer.contains(player)) {
        		plugin.qPlayer.remove(player);
        		plugin.dcAPI.undisguisePlayer(player);
                player.kickPlayer("\u00A7cMyers Got You! Better Luck Next Time");
        }
        if (plugin.Myers.contains(player)) {
        		plugin.Myers.remove(player);
        		plugin.dcAPI.undisguisePlayer(player);
                player.kickPlayer("\u00A7cYou Have Been Defeated! Try Harder Next Time!");
        }
        if (plugin.qPlayer.size() == 1) {
        		plugin.Godmode = false;
        		plugin.qPlayer.get(plugin.qPlayer.size() - 1).sendMessage(ChatColor.GREEN + "You're the last alive! Kill Myers to win the game!");
        		plugin.Myers.get(plugin.Myers.size() - 1).sendMessage(ChatColor.GREEN + "You're almost there! Only 1 runner left! Be careful though, he can KILL you!");
        }
}
}
