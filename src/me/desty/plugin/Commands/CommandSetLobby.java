package me.desty.plugin.Commands;
 
import me.desty.plugin.SteveMyers;
 
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
 
public class CommandSetLobby implements CommandExecutor {
        private SteveMyers plugin;
        Player player;
 
        public CommandSetLobby(SteveMyers plugin) {
                this.plugin = plugin;
 
        }
 
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                Player player = (Player) sender;
 
                // plugin.lobby_join = player.getLocation();;
	            if(player.isOp() == true){
	                if (args.length == 0) {
	                        return false;
	                }
	                if (args.length > 0) {
	 
	                        if (args[0].equalsIgnoreCase("Runner")) {
	                                int j = plugin.getConfig().getInt("GameSettings.MaxSpawnPoints.Runners");
	 
	                                if (args.length > 1) {
	                                        int i = Integer.parseInt(args[1]);
	                                        if (i <= j) {
	                                                plugin.getConfig().set("SpawnPoints.Runners." + i + ".X", player.getLocation().getX());
	                                                plugin.getConfig().set("SpawnPoints.Runners." + i + ".Y", player.getLocation().getY());
	                                                plugin.getConfig().set("SpawnPoints.Runners." + i + ".Z", player.getLocation().getZ());
	                                                plugin.getConfig().set("SpawnPoints.Runners." + i + ".Yaw", player.getLocation().getYaw());
	                                                plugin.getConfig().set("SpawnPoints.Runners." + i + ".Pitch", player.getLocation().getPitch());
	                                                plugin.saveConfig();
	                                                player.sendMessage(ChatColor.YELLOW + "X: " + Math.round(player.getLocation().getX()));
	                                                player.sendMessage(ChatColor.YELLOW + "Y: " + Math.round(player.getLocation().getY()));
	                                                player.sendMessage(ChatColor.YELLOW + "Z: " + Math.round(player.getLocation().getZ()));
	                                                player.sendMessage(ChatColor.YELLOW + "Yaw: " + player.getLocation().getYaw());
	                                                player.sendMessage(ChatColor.YELLOW + "Pitch: " + player.getLocation().getPitch());
	                                                player.sendMessage(ChatColor.RED + "Point " + i + " Set!");
	                                        } else {
	                                                player.sendMessage("Value too high! Max is: " + plugin.getConfig().getInt("GameSettings.MaxSpawnPoints.Runners"));
	                                        }
	                                } else {
	                                        player.sendMessage("/setlobby runner 1-" + plugin.getConfig().getInt("GameSettings.MaxSpawnPoints.Runners"));
	                                }
	 
	                        }
	 
	                        if (args[0].equalsIgnoreCase("Myers")) {
	                                int j = plugin.getConfig().getInt("GameSettings.MaxSpawnPoints.Myers");
	 
	                                if (args.length > 1) {
	                                        int i = Integer.parseInt(args[1]);
	                                        if (i <= j) {
	                                                plugin.getConfig().set("SpawnPoints.Myers." + i + ".X", player.getLocation().getX());
	                                                plugin.getConfig().set("SpawnPoints.Myers." + i + ".Y", player.getLocation().getY());
	                                                plugin.getConfig().set("SpawnPoints.Myers." + i + ".Z", player.getLocation().getZ());
	                                                plugin.getConfig().set("SpawnPoints.Myers." + i + ".Yaw", player.getLocation().getYaw());
	                                                plugin.getConfig().set("SpawnPoints.Myers." + i + ".Pitch", player.getLocation().getPitch());
	                                                plugin.saveConfig();
	                                                player.sendMessage(ChatColor.YELLOW + "X: " + Math.round(player.getLocation().getX()));
	                                                player.sendMessage(ChatColor.YELLOW + "Y: " + Math.round(player.getLocation().getY()));
	                                                player.sendMessage(ChatColor.YELLOW + "Z: " + Math.round(player.getLocation().getZ()));
	                                                player.sendMessage(ChatColor.YELLOW + "Yaw: " + player.getLocation().getYaw());
	                                                player.sendMessage(ChatColor.YELLOW + "Pitch: " + player.getLocation().getPitch());
	                                                player.sendMessage(ChatColor.RED + "Point " + i + " Set!");
	                                        } else {
	                                                player.sendMessage("Value too high! Max is: " + plugin.getConfig().getInt("GameSettings.MaxSpawnPoints.Myers"));
	                                        }
	                                } else {
	                                        player.sendMessage("/setlobby myers 1-" + plugin.getConfig().getInt("GameSettings.MaxSpawnPoints.Myers"));
	                                }
	 
	                        }
	 
	                        if (args[0].equalsIgnoreCase("Max")) {
	                                if (args.length > 1) {
	                                        int total = Integer.parseInt(args[1]);
	                                        plugin.getConfig().set("GameSettings.MaxSpawnPoints.Runners", (int) total);
	                                        plugin.saveConfig();
	                                        player.sendMessage("Total available points to set: " + total);
	                                } else {
	                                        player.sendMessage("Enter a value to set max amount of spawn points to set"); // differ myers and runners some day
	                                }
	                        }
	 
	                }
	        } else 
	        	player.sendMessage("No permission!");
                return true;
 
        }
}