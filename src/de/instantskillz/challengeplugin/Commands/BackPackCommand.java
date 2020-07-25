//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BackPackCommand implements CommandExecutor {

    Inventory backpack = Bukkit.createInventory(null, 9 * 3, "§6§lBackpack");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (Main.getPlugin().getBP() == false) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("schnellerHase.bp")) {
                    if (args.length == 0) {
                        if (player.getWorld().getName().contains("Challenge")) {
                            player.openInventory(backpack);
                            player.sendMessage("§aServer " + "§8>> " + "§aDu hast das Backpack geöffnet!");

                            //FUNKTIONIERT NOCH NICHT!
                            //HIER MUSS EIN LISTENER HIN DER WARTET BIS DAS INVENTORY "BACKBACK" VIEWERS HAT ODER NICHT
                            //KEINE AHNUNG WIE DAS GEHT…
                            if (backpack.getViewers().size() == 0) {
                                this.checkDirectory();
                                ArrayList<ItemStack> list = new ArrayList<>();
                                File file = new File("plugins//InstantSkillzTV//Backpacks//" + player.getWorld().getName() + ".yml");

                                try {
                                    file.createNewFile();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
                                ItemStack[] contents = backpack.getStorageContents();

                                for (int j = 0; j < contents.length; j++) {
                                    ItemStack item = contents[j];

                                    if (!(item == null)) {
                                        list.add(item);
                                    }
                                }

                                inv.set("Backpack", list);

                                try {
                                    inv.save(file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
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

    public void checkDirectory() {
        File file = new File("plugins//InstantSkillzTV//Backpacks");
        if (!file.exists()) {
            file.mkdir();
        }
    }
}
