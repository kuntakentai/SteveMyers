package me.desty.plugin.Events;

import me.desty.plugin.SteveMyers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import pgDev.bukkit.DisguiseCraft.DisguiseCraft;
import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;
import pgDev.bukkit.DisguiseCraft.disguise.Disguise;
import pgDev.bukkit.DisguiseCraft.disguise.DisguiseType;

public class EventInventoryClicked implements Listener{
    private SteveMyers plugin;
    
    public EventInventoryClicked(SteveMyers plugin) {
            this.plugin = plugin;
    }
    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
            Player player = (Player) event.getWhoClicked();
            String b = event.getInventory().getTitle();
            ItemStack item = event.getCurrentItem();
            if (b.equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Disguise Shop")) {
                    if (item == null) {
                            return;
                    } else if (item.getType() == Material.AIR) {
                            return;
                    }
                    // fucking leave this.. unless u want error
                    if (item.getItemMeta().getDisplayName() == "§6Dog") {
                            int dog_cost = Integer.parseInt(plugin.getConfig().getString("dog_cost"));
                            int buyer = Integer.parseInt(plugin.getCustomConfig().getString(event.getWhoClicked().getName().toLowerCase() + ".money"));
                            int newB = buyer - dog_cost;
                            Boolean bool = Boolean.valueOf(plugin.getCustomConfig().getBoolean(event.getWhoClicked().getName().toLowerCase() + ".dog"));
                            if (bool == false) {
                                    if (buyer - dog_cost >= 0) {
                                            plugin.getCustomConfig().set(event.getWhoClicked().getName().toLowerCase() + ".money", newB);
                                            plugin.getCustomConfig().set(event.getWhoClicked().getName().toLowerCase() + ".dog", true);
                                            plugin.saveCustomConfig();
                                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Dog disguise has been purchased!");

                                    } else {
                                            player.sendMessage(ChatColor.RED + "You don't have enough money to purchase that!");
                                    }

                            } else if (bool == true) {
                                    player.sendMessage(ChatColor.RED + "You've already purchased that disguise!");

                            }
                    }
                    if (item.getItemMeta().getDisplayName() == "§6Bat") {
                            int bat_cost = Integer.parseInt(plugin.getConfig().getString("bat_cost"));
                            int buyer = Integer.parseInt(plugin.getCustomConfig().getString(event.getWhoClicked().getName().toLowerCase() + ".money"));
                            int newB = buyer - bat_cost;
                            Boolean bool = Boolean.valueOf(plugin.getCustomConfig().getBoolean(event.getWhoClicked().getName().toLowerCase() + ".bat"));
                            if (bool == false) {
                                    if (buyer - bat_cost >= 0) {
                                    		plugin.getCustomConfig().set(event.getWhoClicked().getName().toLowerCase() + ".money", newB);
                                            plugin.getCustomConfig().set(event.getWhoClicked().getName().toLowerCase() + ".bat", true);
                                            plugin.saveCustomConfig();
                                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Bat disguise has been purchased!");
                                    } else {
                                            player.sendMessage(ChatColor.RED + "You don't have enough money to purchase that!");
                                    }
                            } else if (bool == true) {
                                    player.sendMessage(ChatColor.RED + "You've already purchased that disguise!");
                            }
                    }
                    if (item.getItemMeta().getDisplayName() == "§6Sand") {
                            int sand_cost = Integer.parseInt(plugin.getConfig().getString("sand_cost"));
                            int buyer = Integer.parseInt(plugin.getCustomConfig().getString(event.getWhoClicked().getName().toLowerCase() + ".money"));
                            int newB = buyer - sand_cost;
                            Boolean bool = Boolean.valueOf(plugin.getCustomConfig().getBoolean(event.getWhoClicked().getName().toLowerCase() + ".sand"));
                            if (bool == false) {
                                    if (buyer - sand_cost >= 0) {
                                            plugin.getCustomConfig().set(event.getWhoClicked().getName().toLowerCase() + ".money", newB);
                                            plugin.getCustomConfig().set(event.getWhoClicked().getName().toLowerCase() + ".sand", true);
                                            plugin.saveCustomConfig();
                                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Sand disguise has been purchased!");
                                    } else {
                                            player.sendMessage(ChatColor.RED + "You don't have enough money to purchase that!");
                                    }
                            } else if (bool == true) {
                                    player.sendMessage(ChatColor.RED + "You've already purchased that disguise!");
                                    // player.performCommand("d 12");
                            }
                    }
                    if (item.getItemMeta().getDisplayName() == "§6Grass") {
                            int grass_cost = Integer.parseInt(plugin.getConfig().getString("grass_cost"));
                            int buyer = Integer.parseInt(plugin.getCustomConfig().getString(event.getWhoClicked().getName().toLowerCase() + ".money"));
                            int newB = buyer - grass_cost;
                            Boolean bool = Boolean.valueOf(plugin.getCustomConfig().getBoolean(event.getWhoClicked().getName().toLowerCase() + ".grass"));
                            if (bool == false) {
                                    if (buyer - grass_cost >= 0) {
                                            plugin.getCustomConfig().set(event.getWhoClicked().getName().toLowerCase() + ".money", newB);
                                            plugin.getCustomConfig().set(event.getWhoClicked().getName().toLowerCase() + ".grass", true);
                                            plugin.saveCustomConfig();
                                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Grass disguise has been purchased!");
                                    } else {
                                            player.sendMessage(ChatColor.RED + "You don't have enough money to purchase that!");
                                    }
                            } else if (bool == true) {
                                    player.sendMessage(ChatColor.RED + "You've already purchased that disguise!");
                                    // player.performCommand("d 2");
                            }
                    }
                    if (item.getItemMeta().getDisplayName() == "§6Snow") {
                            int snow_cost = Integer.parseInt(plugin.getConfig().getString("snow_cost"));
                            int buyer = Integer.parseInt(plugin.getCustomConfig().getString(event.getWhoClicked().getName().toLowerCase() + ".money"));
                            int newB = buyer - snow_cost;
                            Boolean bool = Boolean.valueOf(plugin.getCustomConfig().getBoolean(event.getWhoClicked().getName().toLowerCase() + ".snow"));
                            if (bool == false) {
                                    if (buyer - snow_cost >= 0) {
                                            plugin.getCustomConfig().set(event.getWhoClicked().getName().toLowerCase() + ".money", newB);
                                            plugin.getCustomConfig().set(event.getWhoClicked().getName().toLowerCase() + ".snow", true);
                                            plugin.saveCustomConfig();
                                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Snow disguise has been purchased!");
                                    } else {
                                            player.sendMessage(ChatColor.RED + "You don't have enough money to purchase that!");
                                    }
                            } else if (bool == true) {
                                    player.sendMessage(ChatColor.RED + "You've already purchased that disguise!");

                            }
                    }
                    if (item.getItemMeta().getDisplayName() == "§6Block Auto Allign") {
                            int blocklock_cost = Integer.parseInt(plugin.getConfig().getString("blocklock_cost"));
                            int buyer = Integer.parseInt(plugin.getCustomConfig().getString(event.getWhoClicked().getName().toLowerCase() + ".money"));
                            int newB = buyer - blocklock_cost;
                            Boolean bool = Boolean.valueOf(plugin.getCustomConfig().getBoolean(event.getWhoClicked().getName().toLowerCase() + ".blocklock"));
                            if (bool == false) {
                                    if (buyer - blocklock_cost >= 0) {
                                            plugin.getCustomConfig().set(event.getWhoClicked().getName().toLowerCase() + ".money", newB);
                                            plugin.getCustomConfig().set(event.getWhoClicked().getName().toLowerCase() + ".blocklock", true);
                                            plugin.saveCustomConfig();
                                            player.sendMessage(ChatColor.LIGHT_PURPLE + "Block Auto Allign perk has been purchased!");
                                    } else {
                                            player.sendMessage(ChatColor.RED + "You don't have enough money to purchase that!");
                                    }
                            } else if (bool == true) {
                                    player.sendMessage(ChatColor.RED + "You've already purchased that disguise!");
                            }
                    }
                    if (item.getType() == Material.MONSTER_EGG) {

                    } else if (item.getType() != Material.MONSTER_EGG) {
                            // leave this..
                    }
                    event.setCancelled(true);
            }

            /** DISGUISE SELECTION **/
            if (b.equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Disguises")) {
                    if (item == null) {
                            return;
                    } else if (item.getType() == Material.AIR) {
                            return;
                    }
                    if (item.getType() == Material.MONSTER_EGG) {
                            Short durability = item.getDurability();
                            switch (durability) {
                            case 65:
                            		plugin.dcAPI.undisguisePlayer(player);
                            		plugin.dcAPI.disguisePlayer(player, new Disguise(plugin.dcAPI.newEntityID(), DisguiseType.Bat));
                            		player.sendMessage(ChatColor.AQUA + "You are now disguised as a BAT!");
                                    break;
                            case 90:
                            		plugin.dcAPI.undisguisePlayer(player);
                            		plugin.dcAPI.disguisePlayer(player, new Disguise(plugin.dcAPI.newEntityID(), DisguiseType.Pig));
                                    player.sendMessage(ChatColor.AQUA + "You are now disguised as a PIG!");
                                    break;
                            case 91:
                            		plugin.dcAPI.undisguisePlayer(player);
                            		plugin.dcAPI.disguisePlayer(player, new Disguise(plugin.dcAPI.newEntityID(), DisguiseType.Sheep));
                                    player.sendMessage(ChatColor.AQUA + "You are now disguised as a SHEEP!");
                                    break;
                            case 92:
                            		plugin.dcAPI.undisguisePlayer(player);
                            		plugin.dcAPI.disguisePlayer(player, new Disguise(plugin.dcAPI.newEntityID(), DisguiseType.Cow));
                                    player.sendMessage(ChatColor.AQUA + "You are now disguised as a COW!");
                                    break;
                            case 93:
                            		plugin.dcAPI.undisguisePlayer(player);
                            		plugin.dcAPI.disguisePlayer(player, new Disguise(plugin.dcAPI.newEntityID(), DisguiseType.Chicken));
                                    player.sendMessage(ChatColor.AQUA + "You are now disguised as a CHICKEN!");
                                    break;
                            case 95:
                            		plugin.dcAPI.undisguisePlayer(player);
                            		plugin.dcAPI.disguisePlayer(player, new Disguise(plugin.dcAPI.newEntityID(), DisguiseType.Wolf));
                                    player.sendMessage(ChatColor.AQUA + "You are now disguised as a WOLF!");
                                    break;
                            }
                            player.closeInventory();
                    }
                    if (item.getType() == Material.SAND && item.getItemMeta().getDisplayName() == "§6Sand") {
                    		plugin.dcAPI.undisguisePlayer(player);
                    		plugin.dcAPI.disguisePlayer(player, new Disguise(plugin.dcAPI.newEntityID(), "blockID:12", DisguiseType.FallingBlock));
                            player.sendMessage(ChatColor.AQUA + "You are now disguised as SAND!");
                            player.closeInventory();
                    }
                    if (item.getType() == Material.GRASS && item.getItemMeta().getDisplayName() == "§6Grass") {
                    		plugin.dcAPI.undisguisePlayer(player);
                    		plugin.dcAPI.disguisePlayer(player, new Disguise(plugin.dcAPI.newEntityID(), "blockID:2", DisguiseType.FallingBlock));
                            player.sendMessage(ChatColor.AQUA + "You are now disguised as GRASS!");
                            player.closeInventory();
                    }
                    if (item.getType() == Material.SNOW && item.getItemMeta().getDisplayName() == "§6Snow") {
                    		plugin.dcAPI.undisguisePlayer(player);
                            Disguise sand = new Disguise(plugin.dcAPI.newEntityID(), "blockID:78", DisguiseType.FallingBlock);
                            plugin.dcAPI.disguisePlayer(player, sand);
                            player.sendMessage(ChatColor.AQUA + "You are now disguised as SNOW!");
                            player.closeInventory();
                    }
                    event.setCancelled(true);
                    plugin.disguiseList.put(player, plugin.dcAPI.getDisguise(player));
                    plugin.dcAPI.undisguisePlayer(player);
            }
    }
}
