//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class SneakKillListener implements Listener {

    @EventHandler
    public void playerSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (Main.getPlugin().getSKL() == true) {
            event.setCancelled(true);
        }
        if (Main.getPlugin().getSKL() == false) {
            if (player.getWorld() != Bukkit.getWorld("world")) {
                if (player.getGameMode() == GameMode.SPECTATOR) {
                    event.setCancelled(true);
                } else if (player.getGameMode() == GameMode.CREATIVE) {
                    event.setCancelled(true);
                } else if (player.getGameMode() == GameMode.ADVENTURE) {
                    event.setCancelled(true);
                } else if (player instanceof Player) {
                    player.setHealth(0);
                    player.setGameMode(GameMode.SPECTATOR);
                    Main.getPlugin().setTimer(true);
                    Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§c" + player.getName() + " §ahat gesneaked!");

                }
            }
        }

    }


}
