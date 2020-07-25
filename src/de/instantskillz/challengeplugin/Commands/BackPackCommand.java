//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
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

                        String[] allWorlds = new String[Bukkit.getServer().getWorlds().size()];
                        int count = 0;
                        int challenge = 0;
                        for (World w : Bukkit.getServer().getWorlds()) {
                            allWorlds[count] = w.getName();
                            if (w.getName().contains("Challenge")) {
                                for (int i = 0; i < challenge; i++) {
                                    if (player.getWorld() == Bukkit.getWorld("challenge-" + challenge)) {

                                        player.openInventory(backpack);

                                        this.checkDirectory();
                                        ArrayList<ItemStack> list = new ArrayList<>();
                                        World world = player.getWorld();
                                        File file = new File("plugins//InstantSkillzTV//Backpacks//" + world + ".yml");

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

                                        inv.set("Inventory", list);

                                        try {
                                            inv.save(file);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }

                                        player.sendMessage("§aServer " + "§8>> " + "§aDu hast das Backpack geöffnet!");
                                    }
                                }
                                challenge++;
                            }
                            count++;
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
