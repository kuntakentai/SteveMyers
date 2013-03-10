package me.desty.plugin.Functions;

import java.util.Random;

import me.desty.plugin.GameTimer;
import me.desty.plugin.SteveMyers;

import org.bukkit.Location;

import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;

public class FunctionGrabSpot {
    private SteveMyers plugin;

    public FunctionGrabSpot(SteveMyers plugin) {
            this.plugin = plugin;
    }
    public Location grabRandomSpot(Location loc, String string) {
   	 
        Random random = new Random();
        if (string.equalsIgnoreCase("runners")) {
                int rand = random.nextInt(plugin.getConfig().getInt("GameSettings.MaxSpawnPoints.Runners"));
                if (rand == 0) {
                        rand = plugin.getConfig().getInt("GameSettings.MaxSpawnPoints.Runners") - 1;
                }
                Float pitch = (float) plugin.getConfig().getDouble("SpawnPoints.Runners." + rand + ".Pitch");
                Float yaw = (float) plugin.getConfig().getDouble("SpawnPoints.Runners." + rand + ".Yaw");
                loc.setX(plugin.getConfig().getDouble("SpawnPoints.Runners." + rand + ".X"));
                loc.setY(plugin.getConfig().getDouble("SpawnPoints.Runners." + rand + ".Y"));
                loc.setZ(plugin.getConfig().getDouble("SpawnPoints.Runners." + rand + ".Z"));
                loc.setPitch(pitch);
                loc.setYaw(yaw);

        }
        if (string.equalsIgnoreCase("myers")) {
                int rand = random.nextInt(plugin.getConfig().getInt("GameSettings.MaxSpawnPoints.Myers"));
                if (rand == 0) {
                        rand = plugin.getConfig().getInt("GameSettings.MaxSpawnPoints.Myers") - 1;
                }
                Float pitch = (float) plugin.getConfig().getDouble("SpawnPoints.Myers." + rand + ".Pitch");
                Float yaw = (float) plugin.getConfig().getDouble("SpawnPoints.Myers." + rand + ".Yaw");
                loc.setX(plugin.getConfig().getDouble("SpawnPoints.Myers." + rand + ".X"));
                loc.setY(plugin.getConfig().getDouble("SpawnPoints.Myers." + rand + ".Y"));
                loc.setZ(plugin.getConfig().getDouble("SpawnPoints.Myers." + rand + ".Z"));
                loc.setPitch(pitch);
                loc.setYaw(yaw);
        }
        return loc;
}
}
