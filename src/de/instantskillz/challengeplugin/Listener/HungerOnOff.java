//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HungerOnOff implements Listener {

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        Player player = (Player) event.getEntity();
        if (player.getWorld() != Bukkit.getWorld("world")) {
            if (Main.getPlugin().getHunger() == true) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.setFoodLevel(20);
                }
                event.setCancelled(true);
            }
        }
    }
}
