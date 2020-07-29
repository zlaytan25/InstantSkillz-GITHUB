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
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BackPackCommand implements CommandExecutor, Listener {

    private Inventory backpack = Bukkit.createInventory(null, 9 * 3, "§6Backpack");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (Main.getPlugin().getBP() == false) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("schnellerHase.bp")) {
                    if (args.length == 0) {
                        String world = player.getWorld().getName();
                        if (world.contains("Challenge")) {

                            //Get Backpack
                            backpack.clear();
                            File file = new File("plugins//InstantSkillzTV//Backpacks//" + world + ".yml");

                            if (file.exists()) {
                                YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
                                List<?> list = inv.getList("Backpack");
                                List<?> slot = inv.getList("Slot");

                                for (int i = 0; i < list.size(); i++) {
                                    backpack.setItem((Integer) slot.get(i), (ItemStack) list.get(i));
                                }
                            }

                            player.openInventory(backpack);
                            player.sendMessage("§aServer " + "§8>> " + "§aDu hast das Backpack geöffnet!");
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


    @EventHandler
    public void checkBackpack(InventoryCloseEvent event) {
        if (event.getView().getTitle().equals("§6Backpack")) {
            String world = event.getPlayer().getWorld().getName();
            this.checkDirectory();
            ArrayList<ItemStack> list = new ArrayList<>();
            File file = new File("plugins//InstantSkillzTV//Backpacks//" + world + ".yml");

            if (!file.exists()) {
                file.delete();
            }

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);

            ArrayList<Integer> slot = new ArrayList<>();
            for (int i = 0; i < event.getInventory().getSize(); i++) {
                if (event.getInventory().getItem(i) != null) {
                    slot.add(i);
                } else if (i == event.getInventory().getSize()) {
                    break;
                }
            }

            ItemStack[] contents = event.getInventory().getStorageContents();
            for (int i = 0; i < contents.length; i++) {
                ItemStack item = contents[i];

                if (!(item == null)) {
                    list.add(item);
                }
            }

            inv.set("Slot", slot);
            inv.set("Backpack", list);

            try {
                inv.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkDirectory() {
        File file = new File("plugins//InstantSkillzTV//Backpacks");
        if (!file.exists()) {
            file.mkdir();
        }
    }
}
