//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import de.instantskillz.challengeplugin.Listener.GameModeListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModesStartStop implements CommandExecutor {

    private GameModeListener gl = new GameModeListener();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.modes")) {
                if (args.length == 0) {
                    gl.openGUI(player.getPlayer());
                    //player.sendMessage(Main.getPlugin().PREFIX + "§aDir wurde die Spiel-Modi-Auswahl geöffnet!");
                }
            }
        }
        return false;
    }


}