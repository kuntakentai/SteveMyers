package me.desty.plugin.Commands;
 
import me.desty.plugin.SteveMyers;
 
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
 
public class CommandMoney implements CommandExecutor {
        private SteveMyers plugin;
    public CommandMoney(SteveMyers plugin) {
        this.plugin = plugin;
     
}
   
 
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                Player player = (Player) sender;
                
                if(args.length == 0){
                	int bal = plugin.getCustomConfig().getInt(player.getName().toLowerCase() + ".money");
                	player.sendMessage(ChatColor.LIGHT_PURPLE + "You have" + ChatColor.RED + " $" + bal);
                }
            if(args.length > 0){
                    if(args[0].equalsIgnoreCase(args[0])){
                    		   if(args.length == 1){
                    			   if(plugin.getCustomConfig().contains(args[0].toLowerCase())){
	                                    player.sendMessage(ChatColor.RED + args[0] + ChatColor.LIGHT_PURPLE + " has" + ChatColor.RED + " $" + plugin.getCustomConfig().getInt(args[0].toLowerCase() + ".money"));
                    			   } else
	                                    player.sendMessage(ChatColor.RED + args[0] + ChatColor.LIGHT_PURPLE + " Does not have an account!");
	                           }
                               if(args.length > 1){
				                    if(args[1].equalsIgnoreCase("pay")){
				                            if(args.length == 2){
				                                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Correct usage: " + ChatColor.RED + "/money [User] pay [Amount]");
				                            }
				                            if(args.length > 2){
					                            if(args[2].equalsIgnoreCase(args[2])){
					                                    if(plugin.getCustomConfig().contains(args[0].toLowerCase() + ".money")){
					                                    	if(args.length == 3){
							                                    int owner = Integer.parseInt(plugin.getCustomConfig().getString(player.getName().toLowerCase() + ".money"));
							                                    int reciever = Integer.parseInt(plugin.getCustomConfig().getString(args[0].toLowerCase() + ".money"));
							                                    int sent = Integer.parseInt(args[2]);
							                                    int owner_new = owner - sent;
							                                    int reciever_new = reciever + sent;
							                                    if(owner - sent >= 0){
							                                            plugin.getCustomConfig().set(player.getName().toLowerCase() + ".money", owner_new);
							                                            plugin.getCustomConfig().set(args[0].toLowerCase() + ".money", reciever_new);
							                                            player.sendMessage(ChatColor.LIGHT_PURPLE + "You have sent: " + ChatColor.RED + "$" + sent + ChatColor.LIGHT_PURPLE + " To " + args[0]);
									                                    try {
								                                            Player targetPlayer = player.getServer().getPlayer(args[0]);
								                                            targetPlayer.sendMessage(ChatColor.RED + "$" + args[2] + ChatColor.LIGHT_PURPLE + " Has been recieved from: " + ChatColor.RED + player.getName());
									                                    } catch(Exception e){} finally{}
							                                    } else
							                                    if(owner - sent < 0){
							                                            player.sendMessage(ChatColor.RED + player.getName() + ChatColor.LIGHT_PURPLE + " You do not have enough money!");
							                                    }
							                                    plugin.saveCustomConfig();
					                                    	}
						                                    if(args.length > 3){
						                                   		player.sendMessage(ChatColor.RED + "Too many arguments");
						                                   	}
					                                    } else
					                                            player.sendMessage(ChatColor.RED + args[0] + ChatColor.LIGHT_PURPLE + "Does not have account!");
					                            }
				                            }
				                    } else
				                    if(args[1].equalsIgnoreCase("give") && player.isOp() == true){
				                            if(args.length == 2){
				                                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Correct usage: " + ChatColor.RED + "/money [User] give [Amount]");
				                            } 
				                            if(args.length > 2){
				                                    if(args[2].equalsIgnoreCase(args[2])){
					                                    if(plugin.getCustomConfig().contains(args[0].toLowerCase() + ".money")){
					                                    	if(args.length == 3){
					                                            int reciever = Integer.parseInt(plugin.getCustomConfig().getString(args[0].toLowerCase() + ".money"));
					                                            int sent = Integer.parseInt(args[2]);
					                                            int reciever_new = reciever + sent;
					                                            plugin.getCustomConfig().set(args[0].toLowerCase() + ".money", reciever_new);
					                                            plugin.saveCustomConfig();
					                                            try {
					                                            Player targetPlayer = player.getServer().getPlayer(args[0]);
					                                                    targetPlayer.sendMessage(ChatColor.RED + "$" + args[2] + ChatColor.LIGHT_PURPLE + " Has been recieved!");
					                                            } catch(Exception e){} finally{}
					                                    	} else
					                                    	if(args.length > 3){
					                                    		player.sendMessage(ChatColor.RED + "Too many arguments");
					                                    	}
					                                    } else
					                                        player.sendMessage(ChatColor.RED + args[0] + ChatColor.LIGHT_PURPLE + "Does not have account!");
				                                    }
				                            }
				                    }
                               }
                    }
            }
                return true;
        }
 
}