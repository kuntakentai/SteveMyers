package me.desty.plugin;
 
import me.desty.plugin.Functions.FunctionPick;
import me.desty.plugin.Functions.FunctionSpawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
 
public class GameTimer implements Runnable {
        private SteveMyers plugin;
        private int id = -1;
        public boolean gameinsession = true;
        
 
        /**
         * Generic constructor
         *
         * @param Plugin
         *            task is associated with
         */
        public GameTimer(SteveMyers instance) {
                plugin = instance;
                // if(gameinsession = false){
                // id = Bukkit.getServer().getScheduler().runTaskTimer(plugin, this, 0L, 20L).getTaskId();
                // }
        }
 
        public void resumeit() {
 
                j = 0;
                id = Bukkit.getServer().getScheduler().runTaskTimer(plugin, this, 0L, 20L).getTaskId();
 
        }
 
        public void stopit() {
                if (id != -1) {
                        Bukkit.getScheduler().cancelTask(id);
                }
 
        }
 
        /**
         * Do stuff when scheduler tells task to run
         */
        public int j = 0;
 
        @Override
        public void run() {
        	int time = plugin.getConfig().getInt("GameSettings.GameTime");
                if (j == 0) {
                	if(!(time == 300 || time == 240 || time == 180 || time == 120 || time == 60)){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Invalid GameTime" + ChatColor.YELLOW + "\nStopping Countdown, Please do even minute intervals" + ChatColor.RED + "\nApplicable times are: " + ChatColor.YELLOW + "300, 240, 180, 120, 60");
                		stopit();
                		plugin.countdown = false;
                	}
                	if(time == 300){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "5 Minutes");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(time == 240){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "4 Minutes");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(time == 180){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "3 Minutes");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(time == 120){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "2 Minutes");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(time == 60){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "1 Minute");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                }
                if(time == 60){
                	if(j == 30){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "30 Seconds");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(j == 50){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "10 Seconds");
                	}
                	if(j == 55){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "5 Seconds");
                	}
                	if(j == 56){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "4 Seconds");
                	}
                	if(j == 57){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "3 Seconds");
                	}
                	if(j == 58){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "2 Seconds");
                	}
                	if(j == 59){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "1 Second");
                	}
                	if(j == 61){
                		plugin.funcSpawn.pickSpawnPoints();
                        plugin.countdown = false;
                        stopit();
                        j = 0;
                	}
                }
                if (j == 60) {
                	if(time == 60){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Game Starting!");
                        plugin.started = true;
                        plugin.funcPick.pickMyers();
                	}
                	if(time == 120){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "1 Minute");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(time == 180){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "2 Minutes");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(time == 240){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "3 Minutes");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(time == 300){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "4 Minutes");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                }
                if(time == 120){
                	if(j == 90){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "30 Seconds");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(j == 110){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "10 Seconds");
                	}
                	if(j == 115){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "5 Seconds");
                	}
                	if(j == 116){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "4 Seconds");
                	}
                	if(j == 117){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "3 Seconds");
                	}
                	if(j == 118){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "2 Seconds");
                	}
                	if(j == 119){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "1 Second");
                	}
                	if(j == 121){
                		plugin.funcSpawn.pickSpawnPoints();
                        plugin.countdown = false;
                        stopit();
                        j = 0;
                	}
                }
                if (j == 120) {
                	if(time == 120){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Game Starting!");
                        plugin.started = true;
                        plugin.funcPick.pickMyers();
                	}
                	if(time == 180){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "1 Minute");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(time == 240){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "2 Minutes");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(time == 300){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "3 Minutes");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                }
                if(time == 180){
                	if(j == 50){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "30 Seconds");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(j == 170){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "10 Seconds");
                	}
                	if(j == 175){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "5 Seconds");
                	}
                	if(j == 176){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "4 Seconds");
                	}
                	if(j == 177){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "3 Seconds");
                	}
                	if(j == 178){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "2 Seconds");
                	}
                	if(j == 179){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "1 Second");
                	}
                	if(j == 181){
                		plugin.funcSpawn.pickSpawnPoints();
                        plugin.countdown = false;
                        stopit();
                        j = 0;
                	}
                }
                if (j == 180) {
                	if(time == 180){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Game Starting!");
                        plugin.started = true;
                        plugin.funcPick.pickMyers();
                	}
                	if(time == 240){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "1 Minute");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(time == 300){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "2 Minutes");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                }
                if(time == 240){
                	if(j == 210){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "30 Seconds");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                	if(j == 230){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "10 Seconds");
                	}
                	if(j == 235){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "5 Seconds");
                	}
                	if(j == 236){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "4 Seconds");
                	}
                	if(j == 237){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "3 Seconds");
                	}
                	if(j == 238){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "2 Seconds");
                	}
                	if(j == 239){
                		Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "1 Second");
                	}
                	if(j == 241){
                		plugin.funcSpawn.pickSpawnPoints();
                        plugin.countdown = false;
                        stopit();
                        j = 0;
                	}
                }
                if (j == 240) {
                	if(time == 240){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Game Starting!");
                        plugin.started = true;
                        plugin.funcPick.pickMyers();
                	}
                	if(time == 300){
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "1 Minute");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                	}
                }
                if (j == 270) {
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "30 Seconds");
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "Player " + ChatColor.YELLOW + " Choose your disguise if you have not already!");
                }
                if (j == 290) {
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "10 Seconds");
                }
                if (j == 295) {
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "5 Seconds");
                }
                if (j == 296) {
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "4 Seconds");
                }
                if (j == 297) {
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "3 Seconds");
                }
                if (j == 298) {
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "2 Seconds");
                }
                if (j == 299) {
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "New Game Starts in: " + ChatColor.YELLOW + "1 Second");
                }
                if (j == 300) {
                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Game Starting!");
                        plugin.started = true;
                        plugin.funcPick.pickMyers();
                }
                if (j == 301) {
                		plugin.funcSpawn.pickSpawnPoints();
                        plugin.countdown = false;
                        stopit();
                        j = 0;
                }
 
                j++;
        }
 
        /**
         * Remove task from scheduler
         *
         * @return True if successfully stopped. Else false.
         */
 
}