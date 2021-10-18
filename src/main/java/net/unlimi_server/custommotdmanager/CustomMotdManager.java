package net.unlimi_server.custommotdmanager;

import net.unlimi_server.custommotdmanager.listener.CommandManager;
import net.unlimi_server.custommotdmanager.listener.PingEventListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomMotdManager extends JavaPlugin {
	private static CustomMotdManager instance;
	private MotdConfig motdConfig;

	public static CustomMotdManager getInstance() {
		if (instance == null)
			instance = (CustomMotdManager) Bukkit.getServer().getPluginManager().getPlugin("CustomMotdManager");
		return instance;
	}

	public MotdConfig getMotdConfig() {
		return motdConfig;
	}

	@Override
	public void onEnable() {
		saveDefaultConfig();
		motdConfig = new MotdConfig();
		motdConfig.reloadConfig();
		getServer().getPluginManager().registerEvents(new PingEventListener(), this);
		getCommand("custommotdmanager").setExecutor(new CommandManager());
	}
}
