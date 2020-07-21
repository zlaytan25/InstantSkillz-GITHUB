//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

public class UHC implements Listener {


    @EventHandler
    public void onPlayerRegainHealth(EntityRegainHealthEvent event) {
        if (Main.getPlugin().getUHC() == true) {

        } else if (Main.getPlugin().getUHC() == false) {
            if (event.getRegainReason() == RegainReason.SATIATED || event.getRegainReason() == RegainReason.REGEN)
                event.setCancelled(true);
        }
    }
}