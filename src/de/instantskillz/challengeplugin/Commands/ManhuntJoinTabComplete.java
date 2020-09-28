//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ManhuntJoinTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.manhunt")) {
                if (args.length == 1) {


                    if (Main.getPlugin().getStart() == false) {
                        List<String> startstatusfalse = new ArrayList<>();
                        startstatusfalse.add("start");
                        return startstatusfalse;
                    } else {
                        List<String> startstatustrue = new ArrayList<>();
                        startstatustrue.add("joinhunter");
                        startstatustrue.add("joinplayer");
                        return startstatustrue;
                    }


                }
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte");

        }
        return null;
    }

}
