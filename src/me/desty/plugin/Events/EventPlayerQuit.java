package me.desty.plugin.Events;

import me.desty.plugin.GameTimer;
import me.desty.plugin.SteveMyers;
import me.desty.plugin.Functions.FunctionEndGame;
import me.desty.plugin.Functions.FunctionGrabSpot;
import me.desty.plugin.Functions.FunctionPick;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class EventPlayerQuit implements Listener{
	private SteveMyers plugin;
	
    public EventPlayerQuit(SteveMyers plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
            Player player = event.getPlayer();
            event.setQuitMessage(null);
            if (plugin.Myers.contains(player)) {
            		plugin.Myers.remove(player);
                    if (plugin.started == true) {
                            if (plugin.Myers.size() == 0) {
                                    if (plugin.qPlayer.size() == 1) {
                                    		plugin.getServer().broadcastMessage(ChatColor.YELLOW + "" + event.getPlayer().getName() + ChatColor.RED + " Gave up! Win by default because there is not enough players to continue.");
                                    		plugin.getServer().broadcastMessage(ChatColor.RED + "Ending game...");
                                            new BukkitRunnable() {
                                                    public void run() {
                                                    	plugin.funcEnd.endGame("qplayer");
                                                    }
                                            }.runTaskLater(plugin, 40L);
                                    } else if (plugin.qPlayer.size() >= plugin.getConfig().getInt("GameSettings.MinimiumPlayers")) { // more than min = repick
                                    		plugin.getServer().broadcastMessage(ChatColor.YELLOW + "" + event.getPlayer().getName() + ChatColor.RED + " Gave up! Repicking Myers in 10s!");
                                            new BukkitRunnable() {
                                                    public void run() {
                                                    		plugin.funcPick.pickMyers();
                                                            for (int x = 1; x <= plugin.Myers.size(); x++) {
                                                            		plugin.Myers.get(x - 1).teleport(plugin.funcGrab.grabRandomSpot(plugin.Myers.get(x - 1).getLocation(), "myers"));
                                                            }
                                                    }
                                            }.runTaskLater(plugin, 200L);
                                    } else if (plugin.qPlayer.size() < plugin.getConfig().getInt("GameSettings.MinimiumPlayers")) {
                                    		plugin.getServer().broadcastMessage(ChatColor.YELLOW + "" + event.getPlayer().getName() + ChatColor.RED + " gave up! Win by default because there is not enough players to continue.");
                                    		plugin.getServer().broadcastMessage(ChatColor.RED + "Ending game...");
                                            new BukkitRunnable() {
                                                    public void run() {
                                                    		plugin.funcEnd.endGame("forfeit");
                                                    }
                                            }.runTaskLater(plugin, 40L);
                                    } else if (plugin.qPlayer.size() == 0 && plugin.Myers.size() == 0) {
                                		plugin.getServer().broadcastMessage(ChatColor.YELLOW + "" + event.getPlayer().getName() + ChatColor.RED + " Was in a bugged game! Please report to owner how this error happened!");
                                        new BukkitRunnable() {
                                                public void run() {
                                                		plugin.funcEnd.endGame("error");
                                                }
                                        }.runTaskLater(plugin, 40L);
                                    }	

                                    return;
                            }
                    }
            }
            if (plugin.qPlayer.contains(player)) {
            		plugin.qPlayer.remove(player);

                    if (plugin.started == true) {
                            if (plugin.qPlayer.size() == 1) {
                            		plugin.qPlayer.get(plugin.qPlayer.size() - 1).sendMessage(ChatColor.GREEN + "You're the last alive! Kill Myers to win the game!");
                            		plugin.Myers.get(plugin.Myers.size() - 1).sendMessage(ChatColor.GREEN + "You're almost there! Only 1 runner left! Be careful though, he can KILL you!");
                                    return;
                            } else if (plugin.qPlayer.size() == 0) {
                            		plugin.getServer().broadcastMessage(ChatColor.YELLOW + "" + event.getPlayer().getName() + ChatColor.RED + " Gave up! Win by default because there is not enough players to continue.");
                            		plugin.getServer().broadcastMessage(ChatColor.RED + "Ending game...");
                                    new BukkitRunnable() {
                                            public void run() {
                                            		plugin.funcEnd.endGame("myers");
                                            }
                                    }.runTaskLater(plugin, 20L);
                            } else {
                            		plugin.getServer().broadcastMessage(ChatColor.RED + "Runners left: " + ChatColor.WHITE + "" + plugin.qPlayer.size());
                            }
                            if (plugin.qPlayer.size() < plugin.getConfig().getInt("GameSettings.MinimiumPlayer") && plugin.countdown == true) {
                            		plugin.countdown = false;
                            		plugin.run.stopit();
                            		plugin.getServer().broadcastMessage(ChatColor.RED + "Not enough players, waiting for more to restart countdown");
                            }
                    }
            }
    }

}
