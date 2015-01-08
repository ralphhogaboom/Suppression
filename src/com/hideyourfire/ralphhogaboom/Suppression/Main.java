package com.hideyourfire.ralphhogaboom.Suppression;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
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
