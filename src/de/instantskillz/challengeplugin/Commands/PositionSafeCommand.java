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

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class PositionSafeCommand implements CommandExecutor {

    String pos;
    double pX;
    double pY;
    double pZ;
    private int challengeWorlds = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
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
                                File file = new File("Challenge-" + i + "//public//pos-marker//" + args[0] + ".yml");
                                YamlConfiguration posi = YamlConfiguration.loadConfiguration(file);
                                DecimalFormat format = new DecimalFormat("0.00");

                                if (file.exists()) {

                                    pos = posi.getString("Name");
                                    pX = posi.getDouble("X");
                                    pY = posi.getDouble("Y");
                                    pZ = posi.getDouble("Z");

                                    player.sendMessage(Main.getPlugin().PREFIX + "§6" + pos + " §aist bei §c<§6" + format.format(pX) + "§c, §6" + format.format(pY) + "§c, §6" + format.format(pZ) + "§c>§a!");

                                } else {

                                    try {
                                        file.createNewFile();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    pos = args[0];
                                    pX = player.getLocation().getX();
                                    pY = player.getLocation().getY();
                                    pZ = player.getLocation().getZ();

                                    player.sendMessage(Main.getPlugin().PREFIX + "§aDie Position §6" + pos + " §abei §c<§6" + format.format(pX) + "§c, §6" + format.format(pY) + "§c, §6" + format.format(pZ) + "§c> §awurde gespeichert!");

                                    posi.set("Name", pos);
                                    posi.set("X", pX);
                                    posi.set("Y", pY);
                                    posi.set("Z", pZ);

                                    try {
                                        posi.save(file);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }

                            }
                        }
                    }

                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/pos <NAME-POSITION>§c!");
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte");
        }
        return false;
    }




    /*





    DecimalFormat format = new DecimalFormat("0.00");
    if (pos != null) {

        if (!positions.contains(pos)) {
            positions.add(pos);
            X.add(pX);
            Y.add(pY);
            Z.add(pZ);
            player.sendMessage(Main.getPlugin().PREFIX + "§aDie Position §6" + pos + " §abei §c<§6" + format.format(pX) + "§c, §6" + format.format(pY) + "§c, §6" + format.format(pZ)  + "§c> §awurde gespeichert!");
        } else {
            player.sendMessage(Main.getPlugin().PREFIX + "§6" + pos + " §aist bei §c<§6" + format.format(pX) + "§c, §6" + format.format(pY) + "§c, §6" + format.format(pZ)  + "§c>§a!");
        }

    }else
        player.sendMessage(Main.getPlugin().PREFIX + "§aDie Position §c" + pos + " §aexistiert nicht!");
     */
}


