//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("§aServer " + "§8>> " + "schnellerHase.heal")) {
                if (args.length == 0) {
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.sendMessage("§aServer " + "§8>> " + "§aDu wurdest geheilt!");
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        target.sendMessage("§aServer " + "§8>> " + "§aDu wurdest von §6" + player.getName() + " §ageheilt!");
                        player.sendMessage("§aServer " + "§8>> " + "§aDu hast den Spieler §6" + target.getName() + " §ageheilt.");
                    } else
                        player.sendMessage("§aServer " + "§8>> " + "§cDer Spieler §6" + args[0] + " §cist nicht auf dem Server.");
                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/heal <SPIELER>§c!");
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte!");
        } else
            sender.sendMessage("§aServer " + "§8>> " + "Dieses Kommando darfst du nur als Spieler benutzen!");

        return false;
    }

}
