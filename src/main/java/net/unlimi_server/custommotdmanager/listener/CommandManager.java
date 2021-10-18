package net.unlimi_server.custommotdmanager.listener;

import net.unlimi_server.custommotdmanager.CustomMotdManager;
import net.unlimi_server.custommotdmanager.MotdConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandManager implements CommandExecutor {
	private static final MotdConfig config = CustomMotdManager.getInstance().getMotdConfig();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage("/cmm help");
			return true;
		} else if (args[0].equals("help")) {
			if (sender.hasPermission("cmm.help")) {
				sender.sendMessage(ChatColor.GOLD + "======== CustomMotdManager Help ========");
				sender.sendMessage("/custommotdmanager getmotd: 設定されているMotdを表示します");
				sender.sendMessage("/custommotdmanager addmotd: Motdを追加します");
				sender.sendMessage("/custommotdmanager remmotd: Motdを削除します");
				sender.sendMessage("/custommotdmanager reload: Configをリロードします");
				sender.sendMessage("Alias for this command: cmm");
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have permission");
			}
		} else if (args[0].equalsIgnoreCase("getmotd")) {
			if (sender.hasPermission("cmm.getmotd")) {
				int i = 0;
				for (String Motd : config.getMotdList()) {
					sender.sendMessage(i + ": " + ChatColor.translateAlternateColorCodes('&', Motd));
					i++;
				}
				sender.sendMessage("------------------------");
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have permission");
			}
		} else if (args[0].equalsIgnoreCase("addmotd")) {
			if (sender.hasPermission("cmm.addmotd")) {
				StringBuilder motd = new StringBuilder();
				for (int i = 1; i < args.length; i++) {
					motd.append(args[i] + " ");
				}

				config.getMotdList().add(motd.toString());
				config.saveConfig();
				sender.sendMessage(ChatColor.GREEN + "Success!");
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have permission");
			}
		} else if (args[0].equalsIgnoreCase("remmotd")) {
			if (sender.hasPermission("cmm.remmotd")) {
				int rem_i = Integer.parseInt(args[1]);
				config.getMotdList().remove(rem_i);
				config.saveConfig();
				sender.sendMessage(ChatColor.GREEN + "Success!");
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have permission");
			}
		} else if (args[0].equals("reload")) {
			if (sender.hasPermission("cmm.reload")) {
				config.reloadConfig();
				sender.sendMessage(ChatColor.GREEN + "Configをリロードしました");
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have permission");
			}
		}
		return true;
	}
}
