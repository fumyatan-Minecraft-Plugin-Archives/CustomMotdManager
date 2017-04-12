package net.unlimi_server.custommotdmanager;

import static net.unlimi_server.custommotdmanager.CustomMotdManager.*;

import java.util.ArrayList;
import java.util.List;

public class MotdConfig {

	public static List<String> Motd_l = new ArrayList<String>();

	public static void loadConfig(){
		Motd_l = plugin.getConfig().getStringList("Motd");
	}

	public static void saveConfig(){
		plugin.getConfig().set("Motd", Motd_l);
		plugin.saveConfig();
	}

	public static void reloadConfig(){
		plugin.reloadConfig();
		List<String> cmotd = plugin.getConfig().getStringList("Motd");

		for (String motd : Motd_l){
			if (!cmotd.contains(motd)){
				cmotd.add(motd);
			}
		}

		plugin.getConfig().set("Motd", Motd_l);
		plugin.saveConfig();

		Motd_l = plugin.getConfig().getStringList("Motd");
	}
}
