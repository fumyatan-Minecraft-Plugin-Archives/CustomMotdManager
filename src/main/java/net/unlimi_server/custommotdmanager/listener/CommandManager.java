package net.unlimi_server.custommotdmanager.listener;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.unlimi_server.custommotdmanager.CustomMotdManager;

public class CommandManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		if (command.equals("custommotdmanager")){
			sender.sendMessage("/cmm help");
			return true;
		}
		else if (args.length == 0 ){
			sender.sendMessage("/cmm help");
			return true;
		}
		else if (args[0].equals("help")){
			if (sender.hasPermission("CMM.help")){
				sender.sendMessage(ChatColor.GOLD + "========CustomMotdManager Help========");
				sender.sendMessage("/cmm GetMotd: 設定されているMotdを表示します");
				sender.sendMessage("/cmm addMotd: Motdを追加します");
				sender.sendMessage("/cmm remMotd: Motdを削除します");
				sender.sendMessage("/cmm reload: Configをリロードします");
				return true;
			}
			else {
				sender.sendMessage(ChatColor.RED + "You don't have Permission");
				return true;
			}
		}
		else if (args[0].equalsIgnoreCase("GetMotd")){
			if (sender.hasPermission("CMM.getmotd")){
				List<String> Motd_l = CustomMotdManager.plugin.getConfig().getStringList("Motd");
				int i = 0;
				for (String Motd: Motd_l){
					sender.sendMessage(i + ": " + Motd);
					sender.sendMessage("------------------------");
					i++;
				}
				return true;
			}
			else {
				sender.sendMessage(ChatColor.RED + "You don't have Permission");
				return true;
			}
		}
		else if (args[0].equalsIgnoreCase("addMotd")){
			if (sender.hasPermission("CMM.addmotd")){
				StringBuilder motd = new StringBuilder();
				for (int i = 1; i<args.length; i++){
					motd.append(args[i] + " ");
				}

				List<String> Motd_l = CustomMotdManager.plugin.getConfig().getStringList("Motd");
				Motd_l.add(motd.toString());
				CustomMotdManager.plugin.getConfig().set("Motd", Motd_l);
				CustomMotdManager.plugin.saveConfig();
				sender.sendMessage(ChatColor.GREEN + "Success!");
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have Permission");
				return true;
			}
		}
		else if (args[0].equalsIgnoreCase("remMotd")){
			if (sender.hasPermission("CMM.remmotd")){
				List<String> Motd_l = CustomMotdManager.plugin.getConfig().getStringList("Motd");
				int rem_i = Integer.parseInt(args[1]);
				Motd_l.remove(rem_i);
				CustomMotdManager.plugin.getConfig().set("Motd", Motd_l);
				CustomMotdManager.plugin.saveConfig();
				sender.sendMessage(ChatColor.GREEN + "Success!");
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have Permission");
				return true;
			}
		}
		else if (args[0].equals("reload")){
			if (sender.hasPermission("CMM.reload")){
				CustomMotdManager.plugin.reloadConfig();
				sender.sendMessage(ChatColor.GREEN + "Configをリロードしました");
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have Permission");
				return true;
			}
		}
		return false;
	}

}
