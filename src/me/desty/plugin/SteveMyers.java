package me.desty.plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import me.desty.plugin.Commands.CommandMoney;
import me.desty.plugin.Commands.CommandSelect;
import me.desty.plugin.Commands.CommandSetLobby;
import me.desty.plugin.Commands.CommandShop;
import me.desty.plugin.Commands.CommandWorld;
import me.desty.plugin.Events.EventEntityDamage;
import me.desty.plugin.Events.EventHunger;
import me.desty.plugin.Events.EventInventoryClicked;
import me.desty.plugin.Events.EventPlayerJoin;
import me.desty.plugin.Events.EventPlayerLogin;
import me.desty.plugin.Events.EventPlayerQuit;
import me.desty.plugin.Events.EventPlayerSprint;
import me.desty.plugin.Events.EventServerMOTD;
import me.desty.plugin.Functions.FunctionAssign;
import me.desty.plugin.Functions.FunctionEliminate;
import me.desty.plugin.Functions.FunctionEndGame;
import me.desty.plugin.Functions.FunctionGrabSpot;
import me.desty.plugin.Functions.FunctionPick;
import me.desty.plugin.Functions.FunctionSpawn;
import me.desty.plugin.Functions.FunctionStartGame;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pgDev.bukkit.DisguiseCraft.DisguiseCraft;
import pgDev.bukkit.DisguiseCraft.api.DisguiseCraftAPI;
import pgDev.bukkit.DisguiseCraft.disguise.Disguise;

public class SteveMyers extends JavaPlugin {
	SteveMyers plugin;
	public DisguiseCraftAPI dcAPI;
	/** Custom Configuration **/
	private FileConfiguration customConfig = null;
	private File customConfigFile = null;
	/** Essential ArrayList/HashMaps **/
	public final ArrayList<Player> Myers = new ArrayList<Player>();
	public final ArrayList<Player> qPlayer = new ArrayList<Player>();
	public Map<Player, Disguise> disguiseList = new HashMap<Player, Disguise>();
	/** Booleans **/
	public boolean Godmode = true;
	public boolean started;
	public boolean countdown;
	public boolean MyersMove = false;;
	/** Timer **/
	public GameTimer run = new GameTimer(this);
	/** Command Classes Implementation **/
	CommandShop shop = new CommandShop(this);
	CommandWorld world = new CommandWorld(this);
	CommandSetLobby set = new CommandSetLobby(this);
	CommandMoney money = new CommandMoney(this);
	CommandSelect select = new CommandSelect(this);
	/** Event Classes Implementation **/
	public EventInventoryClicked PlayerInvClick = new EventInventoryClicked(this);
	public EventPlayerSprint PlayerSprint = new EventPlayerSprint(this);
	public EventPlayerJoin PlayerJoin = new EventPlayerJoin(this);
	public EventHunger PlayerHunger = new EventHunger(this);
	public EventPlayerLogin PlayerLogin = new EventPlayerLogin(this);
	public EventPlayerQuit PlayerQuit = new EventPlayerQuit(this);
	public EventEntityDamage EntityDamage = new EventEntityDamage(this);
	public EventServerMOTD ServerMotd = new EventServerMOTD(this);
	/** Function Class Implementation **/
	public FunctionAssign funcAssign = new FunctionAssign(this);
	public FunctionEliminate funcEli = new FunctionEliminate(this);
	public FunctionEndGame funcEnd = new FunctionEndGame(this);
	public FunctionGrabSpot funcGrab = new FunctionGrabSpot(this);
	public FunctionPick funcPick = new FunctionPick(this);
	public FunctionSpawn funcSpawn = new FunctionSpawn(this);
	public FunctionStartGame funcStart = new FunctionStartGame(this);

	/** PLUGIN SETUP **/
	@Override
	public void onEnable() {
		getLogger().info("Enabled");
		PluginManager pm = getServer().getPluginManager();
		/** DisguiseCraft **/
		setupDisguiseCraft();
		/** Events **/
		pm.registerEvents(PlayerInvClick, this);
		pm.registerEvents(PlayerSprint, this);
		pm.registerEvents(PlayerJoin, this);
		pm.registerEvents(PlayerHunger, this);
		pm.registerEvents(PlayerLogin, this);
		pm.registerEvents(PlayerQuit, this);
		pm.registerEvents(EntityDamage, this);
		pm.registerEvents(ServerMotd, this);
		/** Commands **/
		this.getCommand("setlobby").setExecutor(new CommandSetLobby(this));
		this.getCommand("world").setExecutor(new CommandWorld(this));
		this.getCommand("money").setExecutor(new CommandMoney(this));
		this.getCommand("shop").setExecutor(new CommandShop(this));
		this.getCommand("select").setExecutor(new CommandSelect(this));
		/** Configuration Setup **/
		FileConfiguration config = getConfig();
		config.addDefault("SteveMyers", "Version 1.0");
		config.addDefault("GameSettings.MaxSpawnPoints.Runners", 10);
		config.addDefault("GameSettings.GameTime", 180L);
		config.addDefault("GameSettings.MaxSpawnPoints.Myers", 4);
		config.addDefault("GameSettings.WIN_AMOUNT", 5);
		config.addDefault("GameSettings.MinimiumPlayers", 5); // change to higher later on
		config.addDefault("StartMoney", 5);
		config.addDefault("dog_cost", 1);
		config.addDefault("bat_cost", 1);
		config.addDefault("sand_cost", 1);
		config.addDefault("grass_cost", 1);
		config.addDefault("snow_cost", 1);
		config.addDefault("blocklock_cost", 1);
		config.options().copyDefaults(true);
		saveDefaultCustomConfig();
		saveConfig();
	}

	@Override
	public void onDisable() {
		getLogger().info("Disable");
		saveConfig();
	}

	/** Custom Configuration Composition **/
	public void reloadCustomConfig() {
		if (customConfigFile == null) {
			customConfigFile = new File(getDataFolder(), "players.yml");
		}
		customConfig = YamlConfiguration.loadConfiguration(customConfigFile);

		InputStream defConfigStream = this.getResource("players.yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			customConfig.setDefaults(defConfig);
		}
	}

	public FileConfiguration getCustomConfig() {
		if (customConfig == null) {
			this.reloadCustomConfig();
		}
		return customConfig;
	}

	public void saveCustomConfig() {
		if (customConfig == null || customConfigFile == null) {
			return;
		}
		try {
			getCustomConfig().save(customConfigFile);
		} catch (IOException ex) {
			this.getLogger().log(Level.SEVERE, "Could not save config to " + customConfigFile, ex);
		}
	}

	public void saveDefaultCustomConfig() {
		File customFile = new File(getDataFolder(), "players.yml");
		if (!customFile.exists()) {
			this.saveResource("players.yml", false);

			saveCustomConfig();
		}
	}

	/** Disguise Craft Setup **/
	public void setupDisguiseCraft() {
		dcAPI = DisguiseCraft.getAPI();
	}
}