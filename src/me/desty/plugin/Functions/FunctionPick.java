package me.desty.plugin.Functions;

import java.util.Random;
import me.desty.plugin.GameTimer;
import me.desty.plugin.SteveMyers;
import me.desty.plugin.Functions.FunctionAssign;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;

public class FunctionPick {
    private SteveMyers plugin;
    
    public FunctionPick(SteveMyers plugin) {
            this.plugin = plugin;
    }
    public void pickMyers() {
        Random rand = new Random();
        int chose = rand.nextInt(plugin.qPlayer.size());
        Player chosen = plugin.qPlayer.get(chose);
        if(plugin.disguiseList.containsKey(chosen)){
        	plugin.disguiseList.remove(chosen);
        }
        plugin.funcAssign.assignMyers(chosen);
        
    }
}
