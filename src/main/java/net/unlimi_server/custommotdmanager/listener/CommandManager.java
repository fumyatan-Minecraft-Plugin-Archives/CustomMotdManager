package net.unlimi_server.custommotdmanager.listener;

import static net.unlimi_server.custommotdmanager.MotdConfig.*;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.unlimi_server.custommotdmanager.MotdConfig;

public class CommandManager implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		if (args.length == 0 ){
			sender.sendMessage("/cmm help");
			return true;
		}
		else if (args[0].equals("help")){
			if (sender.hasPermission("CMM.help")){
				sender.sendMessage(ChatColor.GOLD + "========CustomMotdManager Help========");
				sender.sendMessage("/cmm getmotd: 設定されているMotdを表示します");
				sender.sendMessage("/cmm addmotd: Motdを追加します");
				sender.sendMessage("/cmm remmotd: Motdを削除します");
				sender.sendMessage("/cmm reload: Configをリロードします");
			}
			else {
				sender.sendMessage(ChatColor.RED + "You don't have Permission");
			}
		}
		else if (args[0].equalsIgnoreCase("getmotd")){
			if (sender.hasPermission("CMM.getmotd")){
				int i = 0;
				for (String Motd: Motd_l){
					sender.sendMessage(i + ": " + ChatColor.translateAlternateColorCodes('&', Motd));
					i++;
				}
				sender.sendMessage("------------------------");
			}
			else {
				sender.sendMessage(ChatColor.RED + "You don't have Permission");
			}
		}
		else if (args[0].equalsIgnoreCase("addmotd")){
			if (sender.hasPermission("cmm.addmotd")){
				StringBuilder motd = new StringBuilder();
				for (int i = 1; i<args.length; i++){
					motd.append(args[i] + " ");
				}

				Motd_l.add(motd.toString());
				sender.sendMessage(ChatColor.GREEN + "Success!");
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have Permission");
			}
		}
		else if (args[0].equalsIgnoreCase("remmotd")){
			if (sender.hasPermission("cmm.remmotd")){
				int rem_i = Integer.parseInt(args[1]);
				Motd_l.remove(rem_i);
				sender.sendMessage(ChatColor.GREEN + "Success!");
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have Permission");
			}
		}
		else if (args[0].equals("reload")){
			if (sender.hasPermission("cmm.reload")){
				MotdConfig.reloadConfig();
				sender.sendMessage(ChatColor.GREEN + "Configをリロードしました");
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have Permission");
			}
		}
		return true;
	}
}
