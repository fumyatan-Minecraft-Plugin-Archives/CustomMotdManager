package net.unlimi_server.custommotdmanager;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import net.unlimi_server.custommotdmanager.listener.CommandManager;
import net.unlimi_server.custommotdmanager.listener.PingEventListener;

public class CustomMotdManager extends JavaPlugin {

	public static Plugin plugin;

	@Override
	public void onEnable(){
		plugin = this;
		getServer().getPluginManager().registerEvents(new PingEventListener(), this);
		getCommand("custommotdmanager").setExecutor(new CommandManager());
		saveDefaultConfig();
		MotdConfig.loadConfig();
	}

	@Override
	public void onDisable(){
		MotdConfig.saveConfig();
	}

}
