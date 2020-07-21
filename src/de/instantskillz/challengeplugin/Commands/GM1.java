//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GM1 implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.GM1")) {
                if (args.length == 0) {

                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage("§aServer " + "§8>> " + "§cDu bist nun im Kreativ-Modus!");

                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/gm1§c!");
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte!");
        }
        return false;
    }
}