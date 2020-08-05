//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PositionSafeTabComplete implements TabCompleter {

    private int challengeWorlds = 0;

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.pos")) {
                if (args.length == 1) {

                    challengeWorlds = 0;
                    String currentWorld = player.getWorld().getName();
                    if (currentWorld != Bukkit.getWorld("world").getName() && currentWorld.contains("Challenge")) {
                        String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
                        for (World w : Bukkit.getServer().getWorlds()) {
                            worldNames[challengeWorlds] = w.getName();
                            if (w.getName().contains("Challenge")) {
                                challengeWorlds++;

                            }
                        }

                        for (int i = 1; i <= challengeWorlds; i++) {
                            if (currentWorld.equals("Challenge-" + i)) {

                                File[] files = new File("Challenge-" + i + "//public//pos-marker").listFiles();
                                File checkdir = new File("Challenge-" + i + "//public//pos-marker");
                                List<String> positions = new ArrayList<String>();
                                if (checkdir.exists()) {
                                    for (File file : files) {
                                        if (file.isFile()) {
                                            positions.add(file.getName().replace(".yml", ""));
                                        }
                                    }
                                    return positions;
                                } else {
                                    List<String> noPos = new ArrayList<>();
                                    noPos.add("Keine Positionen gespeichert!");
                                    return noPos;
                                }


                            }
                        }
                    }


                }
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte");

        }
        return null;
    }
}


