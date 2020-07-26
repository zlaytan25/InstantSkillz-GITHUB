//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import de.instantskillz.challengeplugin.Main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerCommand implements CommandExecutor {

    int sec;
    int min;
    int h;
    int d;
    String t1;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.timer")) {
                if (args.length == 1) {

                    switch (args[0]) {
                        case "start":
                            if (Main.getPlugin().getTimer() == false) {
                                Bukkit.broadcastMessage("§aServer " + "§8>> " + "§aTimer wurde gestartet!");
                                sec = 0;
                                break;
                            }
                            if (Main.getPlugin().getTimer() == true) {
                                player.sendMessage(Main.getPlugin().PREFIX + "§cTimer nicht aktiv!");
                                break;
                            }

                            break;
                        case "stop":
                            if (Main.getPlugin().getTimer() == false) {
                                sec = -1;
                                min = 0;
                                h = 0;
                                d = 0;
                                Bukkit.broadcastMessage("§aServer " + "§8>> " + "§aDie Challenge hat §9§l" + t1 + " gedauert!");
                                break;
                            }
                            if (Main.getPlugin().getTimer() == true) {
                                player.sendMessage(Main.getPlugin().PREFIX + "§cTimer nicht aktiv!");
                                break;
                            }
                            break;
                        default:
                            player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/timer §c<start/stop>§c!");
                    }


                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            if (sec == -1) {
                                cancel();
                                min = 0;
                                h = 0;
                                d = 0;
                                return;
                            }
                            if (Main.getPlugin().getTimer() == true) {
                                if (sec > 0) {
                                    Bukkit.broadcastMessage("§aServer " + "§8>> " + "§aDie Challenge hat §9§l" + t1 + " gedauert!");
                                    sec = 0;
                                    min = 0;
                                    h = 0;
                                    d = 0;
                                    cancel();
                                    return;
                                }
                                sec = 0;
                                min = 0;
                                h = 0;
                                d = 0;
                                cancel();
                                return;
                            }
                            for (final Player player : Bukkit.getOnlinePlayers()) {
                                if (sec == 60) {
                                    min++;
                                    sec = 0;
                                }
                                if (min == 60) {
                                    h++;
                                    min = 0;
                                }
                                if (h == 24) {
                                    d++;
                                    h = 0;
                                }
                                if (h == 24) {
                                    d++;
                                    h = 0;
                                }

                                t1 = String.format("§6§l" + d + "d:" + h + "h:" + min + "min:" + sec + "sec");
                                String message = t1;
                                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                            }

                            sec++;

                        }
                    }.runTaskTimer(Main.getPlugin(), 0L, 20L);


                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/timer §c<start/stop>§c!");
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte!");
        }

        return false;
    }

}
