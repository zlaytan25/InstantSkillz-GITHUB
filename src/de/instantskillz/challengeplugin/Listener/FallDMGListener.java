//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class FallDMGListener implements Listener {

    @EventHandler
    private void onEntityDamageEvent(EntityDamageEvent event) {
        Player player = (Player) event.getEntity();
        if (event.getCause() == DamageCause.FALL) {
            if (Main.getPlugin().getFDMG() == false) {
                player.setHealth(0);
                Main.getPlugin().setTimer(true);
                Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§c" + player.getName() + " §ahat Fallschaden bekommen!");
            }
            //if (Main.getPlugin().getFDMG() == true) {
            // event.setCancelled(true);
            //}
        }
    }

}