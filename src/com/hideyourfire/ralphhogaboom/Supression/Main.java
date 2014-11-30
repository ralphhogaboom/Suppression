package com.hideyourfire.ralphhogaboom.Supression;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static Plugin plugin;
	
    File configFile;
    FileConfiguration config;
	
	public void onEnable() {	
		plugin = this;
		registerEvents(this, new EventListener());
	}
	
	private void registerEvents(org.bukkit.plugin.Plugin plugin, Listener...listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}

	public void onDisable() {
		plugin = null; // Stops memory leaks.
	}

	
	public static Plugin getPlugin() {
		return plugin;
	}
	
}
