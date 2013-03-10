package me.desty.plugin.Functions;

import me.desty.plugin.SteveMyers;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import pgDev.bukkit.DisguiseCraft.disguise.Disguise;
import pgDev.bukkit.DisguiseCraft.disguise.DisguiseType;

public class FunctionAssign {
	private SteveMyers plugin;

	public FunctionAssign(SteveMyers plugin) {
		this.plugin = plugin;
	}

	public void assignMyers(Player player) {
		Disguise pigman = new Disguise(plugin.dcAPI.newEntityID(), DisguiseType.PigZombie);
		plugin.qPlayer.remove(player);
		plugin.Myers.add(player);
		plugin.dcAPI.disguisePlayer(player, pigman);
		player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 420, 2)); // leave 320 due to 1s delay in pickspawnpoints
		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 420, 2));
		player.sendMessage(ChatColor.YELLOW + "Effects Will ware off in 20 seconds! Give the runners time to hide!");
		plugin.MyersMove = false;
		new BukkitRunnable() {
			public void run() {
				plugin.MyersMove = true;
			}
		}.runTaskLater(plugin, 400L);
		plugin.Godmode = true;
	}
}
