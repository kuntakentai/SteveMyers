package me.desty.plugin.Events;

import me.desty.plugin.SteveMyers;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;

public class EventPlayerJoin implements Listener{
	private SteveMyers plugin;
    
    public EventPlayerJoin(SteveMyers plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
            Player joined = event.getPlayer();
            Location loc = plugin.getServer().getWorld("world").getSpawnLocation();
            loc.setY(loc.getY() + 1);
            joined.teleport(loc);
            joined.getInventory().clear();
            joined.setGameMode(GameMode.ADVENTURE);
            String join = joined.getName().toLowerCase();
            int start = Integer.parseInt(plugin.getConfig().get("StartMoney").toString());
            event.setJoinMessage(null);
            if (plugin.getCustomConfig().getString(join) == null) {
	            	plugin.getCustomConfig().set(join + ".money", start);
	            	plugin.getCustomConfig().set(join + ".dog", false);
	            	plugin.getCustomConfig().set(join + ".bat", false);
	            	plugin.getCustomConfig().set(join + ".sand", false);
	            	plugin.getCustomConfig().set(join + ".grass", false);
	            	plugin.getCustomConfig().set(join + ".snow", false); // maybe remove? kinda cheap
	            	plugin.getCustomConfig().set(join + ".blocklock", false);
	            	plugin.saveCustomConfig();
                    event.getPlayer().sendMessage(ChatColor.GREEN + " $" + start + ChatColor.YELLOW + " Has been added to your account!");
            }
            joined.sendMessage(ChatColor.AQUA + "/shop to buy disguises!");
            joined.sendMessage(ChatColor.AQUA + "/select to choose disguise!");
            joined.removePotionEffect(PotionEffectType.BLINDNESS);
            joined.removePotionEffect(PotionEffectType.SLOW);
            plugin.dcAPI.undisguisePlayer(joined);
    }
}
