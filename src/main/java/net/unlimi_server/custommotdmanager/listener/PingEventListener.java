package net.unlimi_server.custommotdmanager.listener;

import static net.unlimi_server.custommotdmanager.MotdConfig.*;

import java.util.Collections;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingEventListener implements Listener {

	@EventHandler
	public void onPingEvent(ServerListPingEvent e){
		Collections.shuffle(Motd_l);
		String Motd = Motd_l.get(0);
		String Motd_c = ChatColor.translateAlternateColorCodes('&', Motd);

		e.setMotd(Motd_c);
	}
}
