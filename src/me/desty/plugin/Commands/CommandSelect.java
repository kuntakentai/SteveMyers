package me.desty.plugin.Commands;
 
import java.util.ArrayList;
import java.util.List;
 
import me.desty.plugin.SteveMyers;
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
 
public class CommandSelect implements CommandExecutor {
        Player player;
        private SteveMyers plugin;
 
        public CommandSelect(SteveMyers plugin) {
                this.plugin = plugin;
 
        }
 
        public boolean toggleBlockLock = true;
 
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                Player player = (Player) sender;
 
                FileConfiguration config = plugin.getCustomConfig();
 
                Inventory inventory = Bukkit.createInventory(player, 18, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Disguises");
                inventory.addItem(getPig());
                inventory.addItem(getSheep());
                inventory.addItem(getCow());
                inventory.addItem(getChicken());
                if (config.getBoolean(player.getName().toLowerCase() + ".dog") == true) {
                        inventory.addItem(getDog());
                }
                if (config.getBoolean(player.getName().toLowerCase() + ".bat") == true) {
                        inventory.addItem(getBat());
                }
                if (config.getBoolean(player.getName().toLowerCase() + ".sand") == true) {
                        inventory.addItem(getSand());
                }
                if (config.getBoolean(player.getName().toLowerCase() + ".grass") == true) {
                        inventory.addItem(getGrass());
                }
                if (config.getBoolean(player.getName().toLowerCase() + ".snow") == true) {
                        inventory.addItem(getSnow());
                }
                if (config.getBoolean(player.getName().toLowerCase() + ".blocklock") == true) {
                        inventory.setItem(9, getBlockLock());
                }
                if(plugin.started == false){
                	player.openInventory(inventory);	
                } else
                	player.sendMessage(ChatColor.RED + "You cannot disguise during a game!");
                return true;
        }
 
        private ItemStack getPig() {
                ItemStack itemstack = new ItemStack(Material.MONSTER_EGG, 1, (short) 90);
                ItemMeta im = itemstack.getItemMeta();
                im.setDisplayName("§6Pig");
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getChicken() {
                ItemStack itemstack = new ItemStack(Material.MONSTER_EGG, 1, (short) 93);
                ItemMeta im = itemstack.getItemMeta();
                im.setDisplayName("§6Chicken");
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getCow() {
                ItemStack itemstack = new ItemStack(Material.MONSTER_EGG, 1, (short) 92);
                ItemMeta im = itemstack.getItemMeta();
                im.setDisplayName("§6Cow");
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getSheep() {
                ItemStack itemstack = new ItemStack(Material.MONSTER_EGG, 1, (short) 91);
                ItemMeta im = itemstack.getItemMeta();
                im.setDisplayName("§6Sheep");
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getDog() {
                ItemStack itemstack = new ItemStack(Material.MONSTER_EGG, 1, (short) 95);
                ItemMeta im = itemstack.getItemMeta();
                im.setDisplayName("§6Dog");
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getBat() {
                ItemStack itemstack = new ItemStack(Material.MONSTER_EGG, 1);
                ItemMeta im = itemstack.getItemMeta();
                im.setDisplayName("§6Bat");
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getSand() {
                ItemStack itemstack = new ItemStack(Material.SAND, 1);
                ItemMeta im = itemstack.getItemMeta();
                im.setDisplayName("§6Sand");
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getGrass() {
                ItemStack itemstack = new ItemStack(Material.GRASS, 1);
                ItemMeta im = itemstack.getItemMeta();
                im.setDisplayName("§6Grass");
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getSnow() {
                ItemStack itemstack = new ItemStack(Material.SNOW, 1);
                ItemMeta im = itemstack.getItemMeta();
                im.setDisplayName("§6Snow");
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getBlockLock() {
                List<String> myList = new ArrayList<String>();
                myList.add("§6&oClick to toggle");
                if (toggleBlockLock = true) {
                        myList.add("§2§o~Enabled");
                } else
                        myList.add("§4§o~Disabled");
                ItemStack itemstack = new ItemStack(Material.COMPASS, 1);
                ItemMeta im = itemstack.getItemMeta();
                im.setDisplayName("§6Block Auto Allign");
                itemstack.setItemMeta(im);
                return itemstack;
        }
}