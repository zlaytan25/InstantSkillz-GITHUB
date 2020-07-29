//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class SplitHerzen implements Listener {

    @EventHandler
    public void onDmg(EntityDamageEvent event) {
        Player player = (Player) event.getEntity();
        if (player.getWorld().getName().contains("Challenge")) {
            if (Main.getPlugin().getSH() == true) {

            } else if (Main.getPlugin().getSH() == false) {
                if (event.getDamage() > 0) {
                    double lastdmg = event.getDamage();
                    double health = player.getHealth();
                    double newhealth = health - lastdmg;
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.setMaxHealth(newhealth);
                        all.setHealth(newhealth);
                    }
                }
            }
        }
    }


}
