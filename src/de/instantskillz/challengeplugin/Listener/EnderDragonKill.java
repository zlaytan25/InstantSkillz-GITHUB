//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EnderDragonKill implements Listener {

    @EventHandler
    public void onPlayerKillEnderDragon(EntityDeathEvent event) {
        Entity dead = event.getEntity();
        if (Main.getPlugin().getEDK() == false) {
            if (dead.getType().equals(EntityType.ENDER_DRAGON)) {
                Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§cDer Ender Drache wurde getötet. Die Challenge wurde beendet und der Timer gestoppt!");
                Main.getPlugin().setTimer(true);
                Player player = (Player) dead.getLastDamageCause();
                player.setGameMode(GameMode.ADVENTURE);

            }
        }

    }

}
