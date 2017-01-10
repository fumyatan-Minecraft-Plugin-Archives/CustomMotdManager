package net.unlimi_server.custommotdmanager.listener;

import java.util.Collections;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import net.unlimi_server.custommotdmanager.CustomMotdManager;

public class PingEventListener implements Listener {

	@EventHandler
	public void onPingEvent(ServerListPingEvent e){

		List<String> Motd_l = CustomMotdManager.plugin.getConfig().getStringList("Motd");
		Collections.shuffle(Motd_l);
		String Motd = Motd_l.get(0);
		String Motd_c = ChatColor.translateAlternateColorCodes('&', Motd);

		e.setMotd(Motd_c);

	}

}
