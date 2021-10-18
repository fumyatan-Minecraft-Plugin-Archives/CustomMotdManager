package net.unlimi_server.custommotdmanager;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class MotdConfig {
	private FileConfiguration config;
	private List<String> motdList = new ArrayList<>();

	public void reloadConfig() {
		CustomMotdManager.getInstance().reloadConfig();
		config = CustomMotdManager.getInstance().getConfig();

		motdList = config.getStringList("Motd");
		CustomMotdManager.getInstance().getLogger().log(Level.INFO, "Loaded Motds: \n" + String.join("\n", motdList));
	}

	public List<String> getMotdList() {
		return motdList;
	}

	public void saveConfig() {
		config.set("Motd", motdList);
		CustomMotdManager.getInstance().saveConfig();
	}
}
