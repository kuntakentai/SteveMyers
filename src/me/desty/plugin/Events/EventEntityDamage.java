package me.desty.plugin.Events;

import me.desty.plugin.GameTimer;
import me.desty.plugin.SteveMyers;
import me.desty.plugin.Functions.FunctionEliminate;
import me.desty.plugin.Functions.FunctionEndGame;
import me.desty.plugin.Functions.FunctionPick;
import me.desty.plugin.Functions.FunctionSpawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EventEntityDamage implements Listener{
	private SteveMyers plugin;
    public EventEntityDamage(SteveMyers plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void playerhurt(EntityDamageByEntityEvent event) {
            if (event.getEntityType().equals(EntityType.PLAYER)) {
                    Player player = (Player) event.getEntity();
                    if (plugin.Myers.contains(event.getDamager())) {
                            if (plugin.qPlayer.size() == 1) {
                            		plugin.funcEnd.endGame("myers");
                                    plugin.funcEli.eliminatePlayer(player);
                            } else
                            		plugin.funcEli.eliminatePlayer(player);
                            		Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + "Runners Left: " + ChatColor.RED + plugin.qPlayer.size());
                            // myers killed sum1
                    }
                    if (plugin.qPlayer.contains(event.getDamager())) {
                            if (plugin.Myers.contains(player)) {
                                    // if (Godmode == false) {
                                    // eliminatePlayer(player);
                                    // endGame("qplayer");
                                    // } else {
                                    // event.setCancelled(true);
                            		plugin.funcEli.eliminatePlayer(player);
                            		plugin.funcEnd.endGame("qplayer");

                            } else {
                                    event.setCancelled(true);
                            }

                    }
            }
            if (!event.getEntityType().equals(EntityType.PLAYER)) {
            	event.setDamage(4);
            }
            if(event.getDamage() >= 1){
            	if(event.getEntityType().equals(EntityType.PLAYER)){
            		Player player = (Player) event.getEntity();
            		player.setHealth(20);
            	}
            }
            /*if (!(event.getEntityType().equals(EntityType.PLAYER))) {
                    event.setCancelled(true);
            }*/
    }
    @EventHandler
    public void damage(EntityDamageEvent event){
    	if (event.getEntityType().equals(EntityType.PLAYER)) {
    		Player player = (Player) event.getEntity();
    		event.setDamage(0);
    		player.setHealth(19);
    		//player.addPotionEffect(PotionEffectType.REGENERATION.createEffect(player.getFireTicks(), 4));
        	if(!plugin.Myers.contains(player)){
        		if(plugin.disguiseList.containsKey(player)){
        			if(plugin.dcAPI.getDisguise(player) != null){
        				plugin.dcAPI.undisguisePlayer(player);
        				plugin.getServer().broadcastMessage("Undisguised");
        			}
        		}
        	}
        }
    }
    @EventHandler
    public void heal(EntityRegainHealthEvent event){
    	Player player = (Player) event.getEntity();
        if(plugin.disguiseList.containsKey(player)){
        	if(player.getFireTicks() == 0){
        		plugin.dcAPI.disguisePlayer(player, plugin.disguiseList.get(player));
        		plugin.getServer().broadcastMessage("Redisguised");
        	}
    	}
    }
}
