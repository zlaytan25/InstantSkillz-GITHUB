//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetspawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.setspawn")) {
                if (args.length == 0) {

                    FileConfiguration config = Main.getPlugin().getConfig();
                    config.set("Spawn.World", player.getWorld().getName());
                    config.set("Spawn.X", player.getLocation().getX());
                    config.set("Spawn.Y", player.getLocation().getY());
                    config.set("Spawn.Z", player.getLocation().getZ());
                    config.set("Spawn.Yaw", player.getLocation().getYaw());
                    config.set("Spawn.Pitch", player.getLocation().getPitch());
                    Main.getPlugin().saveConfig();

                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/setspawn§c!");
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte! Wie Frauen!!!");
        }

        return false;
    }

}
