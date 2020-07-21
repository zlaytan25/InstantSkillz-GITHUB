//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class InvCommand implements CommandExecutor {

    private HashMap<String, ItemStack[]> inventorySave = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("save")) {
                    inventorySave.put(player.getName(), player.getInventory().getContents());
                    player.getInventory().clear();
                    player.sendMessage("§aServer " + "§8>> " + "§aDein Inventar wurde §6gespeichert§a.");

                } else if (args[0].equalsIgnoreCase("get")) {
                    if (inventorySave.containsKey(player.getName())) {
                        player.getInventory().setContents(inventorySave.get(player.getName()));
                        inventorySave.remove(player.getName());
                        player.sendMessage("§aServer " + "§8>> " + "§aDein Inventar wurde §6geladen§a.");
                    } else
                        player.sendMessage("§aServer " + "§8>> " + "§cDu hast noch kein Inventar gespeichert!");
                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/inv save/get§c!");
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/inv save/get§c!");
        }
        return false;
    }
}
