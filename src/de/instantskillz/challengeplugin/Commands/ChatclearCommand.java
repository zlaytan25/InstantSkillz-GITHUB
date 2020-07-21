//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatclearCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.chatclear")) {
                if (args.length == 0) {

                    for (int i = 0; i <= 500; i++)
                        Bukkit.broadcastMessage(" ");

                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze den §6/chatclear§c!");
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDafür hast du keine Rechte! Wie Frauen!!!");

        }
        return false;
    }

}

