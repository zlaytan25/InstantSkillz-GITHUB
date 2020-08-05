//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;


import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PauseChallengeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.pause")) {
                if (args.length == 0) {


                    String currentWorld = player.getWorld().getName();
                    File paused = new File(currentWorld + "//.paused");
                    File running = new File(currentWorld + "//.running");

                    if (running.exists() || !paused.exists()) {
                        running.delete();
                        try {
                            paused.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        player.getPlayer().getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);

                        Main.getPlugin().setPup(true);
                        Main.getPlugin().pausestatus(currentWorld);

                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (all.getWorld().getName().equals(currentWorld)) {
                                all.setGameMode(GameMode.ADVENTURE);
                            }
                        }
                    } else if (paused.exists()) {
                        Bukkit.broadcastMessage("Die Challenge ist bereits pausiert!");
                    }

                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/pause§c!");
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte!");
        }
        return false;
    }
}