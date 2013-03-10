package me.desty.plugin.Functions;

import me.desty.plugin.GameTimer;
import me.desty.plugin.SteveMyers;

import org.bukkit.entity.Player;

public class FunctionEndGame {
    private SteveMyers plugin;
    
    public FunctionEndGame(SteveMyers plugin) {
            this.plugin = plugin;
    }
    
    public void endGame(String winningteam) {
        plugin.started = false;
        plugin.countdown = false;
        plugin.Godmode = false;
        int award = plugin.getConfig().getInt("GameSettings.WIN_AMOUNT");
        if (winningteam.equalsIgnoreCase("myers")) {
                Player pmyers = plugin.Myers.get(plugin.Myers.size() - 1);
                int balance = Integer.parseInt(plugin.getCustomConfig().getString(pmyers.getName().toLowerCase() + ".money"));
                plugin.dcAPI.undisguisePlayer(pmyers);
                plugin.getCustomConfig().set(pmyers.getName().toLowerCase() + ".money", balance + award);
                pmyers.kickPlayer("\u00A72Congrats you Eliminated all of the Runners! You win: $: " + plugin.getConfig().getInt("GameSettings.WIN_AMOUNT"));
        }
        if (winningteam.equalsIgnoreCase("qplayer")) {
                Player qplayer = plugin.qPlayer.get(plugin.qPlayer.size() - 1);
                plugin.dcAPI.undisguisePlayer(qplayer);
                int balance = Integer.parseInt(plugin.getCustomConfig().getString(qplayer.getName().toLowerCase() + ".money"));
                plugin.getCustomConfig().set(qplayer.getName().toLowerCase() + ".money", balance + award);
                qplayer.kickPlayer("\u00A72Congrats you Defeated Myers! You win: $" + plugin.getConfig().getInt("GameSettings.WIN_AMOUNT"));
        }
        if (winningteam.equalsIgnoreCase("forfeit")) {
                // Player qplayer = qPlayer.get(qPlayer.size() - 1);
                for (Player x : plugin.getServer().getOnlinePlayers()) {
                        int balance = Integer.parseInt(plugin.getCustomConfig().getString(x.getName().toLowerCase() + ".money"));
                        plugin.getCustomConfig().set(x.getName().toLowerCase() + ".money", balance + ((award) - (Math.round(award / 2))));
                        x.kickPlayer("\u00A72Myers gave up because your forces were to strong! You win: $" + ((award) - (Math.round(award / 2))));
                }
        }
        if (winningteam.equalsIgnoreCase("error")) {
        		//For when error occurs
        }
        plugin.saveCustomConfig();
        plugin.saveConfig();
    }
}
