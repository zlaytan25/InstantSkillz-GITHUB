//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class UnpauseChallengeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.unpause")) {
                if (args.length == 0) {

                    String currentWorld = player.getWorld().getName();
                    File paused = new File(currentWorld + "//.paused");
                    File running = new File(currentWorld + "//.running");

                    if (paused.exists()) {
                        paused.delete();
                        try {
                            running.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        player.getPlayer().getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, true);
                        Bukkit.broadcastMessage("Die Challenge läuft wieder!");

                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (all.getWorld().getName().equals(currentWorld)) {
                                all.setGameMode(GameMode.SURVIVAL);
                            }
                        }
                    }

                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/unpause§c!");
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte!");
        }
        return false;
    }

}