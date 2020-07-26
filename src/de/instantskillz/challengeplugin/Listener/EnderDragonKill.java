//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import de.instantskillz.challengeplugin.Main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class EnderDragonKill implements Listener {

    @EventHandler
    public void onPlayerKillEnderDragon(EntityDeathEvent event) {
        Entity dead = event.getEntity();
        if (Main.getPlugin().getEDK() == false) {
            if (dead.getType().equals(EntityType.ENDER_DRAGON)) {
                Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§cDer Ender Drache wurde getötet. Die Challenge wurde beendet und der Timer gestoppt!");
                Main.getPlugin().setTimer(true);
                Main.getPlugin().setFDMG(true);
                Main.getPlugin().setSKL(true);
                Main.getPlugin().setUUHC(true);
                Main.getPlugin().setUHC(true);
                Main.getPlugin().setBP(false);
                Main.getPlugin().setEDK(false);
                Main.getPlugin().setKA(false);

                new BukkitRunnable() {

                    @Override
                    public void run() {

                        for (final Player player : Bukkit.getOnlinePlayers()) {
                            if (player.getWorld() == Bukkit.getWorld("world")) {
                                cancel();
                                for (Player all : Bukkit.getServer().getOnlinePlayers())
                                    all.setGameMode(GameMode.ADVENTURE);
                                Main.getPlugin().setTimer(false);
                            }
                            String message = "§cTimer gestoppt!";
                            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                        }


                    }
                }.runTaskTimer(Main.getPlugin(), 0L, 20L);

            }
        }
    }

}
