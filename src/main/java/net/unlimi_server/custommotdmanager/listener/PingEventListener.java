package net.unlimi_server.custommotdmanager.listener;

import net.unlimi_server.custommotdmanager.CustomMotdManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PingEventListener implements Listener {

	@EventHandler
	public void onPingEvent(ServerListPingEvent e) {
		List<String> motdList = new ArrayList<>(CustomMotdManager.getInstance().getMotdConfig().getMotdList());
		Collections.shuffle(motdList);
		String Motd = motdList.get(0);
		String Motd_c = ChatColor.translateAlternateColorCodes('&', Motd);

		e.setMotd(Motd_c);
	}
}
