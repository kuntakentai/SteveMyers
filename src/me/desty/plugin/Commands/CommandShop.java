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
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
 
public class CommandShop implements CommandExecutor {
 
        private SteveMyers plugin;
 
        public CommandShop(SteveMyers plugin) {
                this.plugin = plugin;
 
        }
 
        List<String> bought = new ArrayList<String>();
 
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                Player player = (Player) sender;
                if (plugin.started == true) {
                        player.sendMessage(ChatColor.RED + "You can't use the shop while in-game!");
                        return true;
                }
 
                Inventory inventory = Bukkit.createInventory(player, 9, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Disguise Shop");
 
                inventory.addItem(getDog(player));
                inventory.addItem(getBat(player));
                inventory.addItem(getSand(player));
                inventory.addItem(getGrass(player));
                inventory.addItem(getSnow(player));
                inventory.setItem(8, getBlockLock(player));
 
                player.openInventory(inventory);
 
                return true;
        }
 
        private ItemStack getDog(Player player) {
                List<String> myList = new ArrayList<String>();
                ItemStack itemstack = new ItemStack(Material.MONSTER_EGG, 1, (short) 95);
                ItemMeta im = itemstack.getItemMeta();
                if (plugin.getCustomConfig().getBoolean(player.getName().toLowerCase() + ".dog") == false) {
                        myList.add("§2§o~Costs: §4$" + plugin.getConfig().getString("dog_cost"));
                        im.setDisplayName("§6Dog");
                } else {
                        myList.add("§4§o~Purchased");
                        im.setDisplayName("§6§mDog");
                }
                im.setLore(myList);
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getBat(Player player) {
                List<String> myList = new ArrayList<String>();
                ItemStack itemstack = new ItemStack(Material.MONSTER_EGG, 1, (short) 65);
                ItemMeta im = itemstack.getItemMeta();
                if (plugin.getCustomConfig().getBoolean(player.getName().toLowerCase() + ".bat") == false) {
                        myList.add("§2§o~Costs: §4$" + plugin.getConfig().getString("bat_cost"));
                        im.setDisplayName("§6Bat");
                } else {
                        myList.add("§4§o~Purchased");
                        im.setDisplayName("§6§mBat");
                }
                im.setLore(myList);
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getSand(Player player) {
                List<String> myList = new ArrayList<String>();
                ItemStack itemstack = new ItemStack(Material.SAND, 1, (short) 95);
                ItemMeta im = itemstack.getItemMeta();
                if (plugin.getCustomConfig().getBoolean(player.getName().toLowerCase() + ".sand") == false) {
                        myList.add("§2§o~Costs: §4$" + plugin.getConfig().getString("sand_cost"));
                        im.setDisplayName("§6Sand");
                } else {
                        myList.add("§4§o~Purchased");
                        im.setDisplayName("§6§mSand");
                }
                im.setLore(myList);
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getGrass(Player player) {
                List<String> myList = new ArrayList<String>();
                ItemStack itemstack = new ItemStack(Material.GRASS, 1);
                ItemMeta im = itemstack.getItemMeta();
                if (plugin.getCustomConfig().getBoolean(player.getName().toLowerCase() + ".grass") == false) {
                        myList.add("§2§o~Costs: §4$" + plugin.getConfig().getString("grass_cost"));
                        im.setDisplayName("§6Grass");
                } else {
                        myList.add("§4§o~Purchased");
                        im.setDisplayName("§6§mGrass");
                }
                im.setLore(myList);
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getSnow(Player player) {
                List<String> myList = new ArrayList<String>();
                ItemStack itemstack = new ItemStack(Material.SNOW, 1);
                ItemMeta im = itemstack.getItemMeta();
                if (plugin.getCustomConfig().getBoolean(player.getName().toLowerCase() + ".snow") == false) {
                        myList.add("§2§o~Costs: §4$" + plugin.getConfig().getString("snow_cost"));
                        im.setDisplayName("§6Snow");
                } else {
                        myList.add("§4§o~Purchased");
                        im.setDisplayName("§6§mSnow");
                }
                im.setLore(myList);
                itemstack.setItemMeta(im);
                return itemstack;
        }
 
        private ItemStack getBlockLock(Player player) {
                List<String> myList = new ArrayList<String>();
                ItemStack itemstack = new ItemStack(Material.COMPASS, 1);
                ItemMeta im = itemstack.getItemMeta();
                if (plugin.getCustomConfig().getBoolean(player.getName().toLowerCase() + ".blocklock") == false) {
                        myList.add("§2§o~Costs: §4$" + plugin.getConfig().getString("blocklock_cost"));
                        myList.add("§2§o~Automatically snaps block disguises to grid");
                        im.setDisplayName("§6Block Auto Allign");
                } else {
                        myList.add("§4§o~Purchased");
                        im.setDisplayName("§6§mBlock Auto Allign");
                }
                im.setLore(myList);
                itemstack.setItemMeta(im);
                return itemstack;
        }
}