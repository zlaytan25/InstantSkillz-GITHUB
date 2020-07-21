//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class BackPackCommand implements CommandExecutor {

    Inventory backpack = Bukkit.createInventory(null, 9 * 3, "§6§lBackpack");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (Main.getPlugin().getBP() == false) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("schnellerHase.bp")) {
                    if (args.length == 0) {

                        player.openInventory(backpack);
                        player.sendMessage("§aServer " + "§8>> " + "§aDu hast das Backpack geöffnet!");

                    } else
                        player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/bp§c!");
                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte!");
            }
        }
        if (Main.getPlugin().getBP() == true) {
            return false;
        }

        return false;
    }


}
