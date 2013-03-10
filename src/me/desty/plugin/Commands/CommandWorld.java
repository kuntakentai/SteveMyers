package me.desty.plugin.Commands;
 
import me.desty.plugin.SteveMyers;
 
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
 
public class CommandWorld implements CommandExecutor {
        private SteveMyers plugin;
        
        public CommandWorld(SteveMyers plugin) {
                this.plugin = plugin;
 
        }
 
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                Player player = (Player) sender;
                if(player.isOp() == true){
	                if(args.length == 0){
	                	player.sendMessage("/world (setspawn||force)");
	                	player.sendMessage("Caution when using /world force \nIt will force start the SteveMyers Game!");
	                }
	                if(args.length > 0){
		                if (args[0].equalsIgnoreCase("setspawn")) {
		                        player.getWorld().setSpawnLocation(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
		                        player.sendMessage("Spawn set to" + player.getLocation());
		                }
		                if (args[0].equalsIgnoreCase("force")) {
		                        plugin.started = true;
		                        plugin.funcPick.pickMyers();
		                        plugin.funcSpawn.pickSpawnPoints();
		                        plugin.countdown = false;
		                        plugin.run.stopit();
		                }
	                }
                }
                return true;
        }
}