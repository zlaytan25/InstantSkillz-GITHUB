//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

public class UUHC implements Listener {

    @EventHandler
    public void onPlayerRegainHealth(EntityRegainHealthEvent event) {
        if (Main.getPlugin().getUUHC() == true) {

        } else if (Main.getPlugin().getUUHC() == false) {
            if (event.getRegainReason() == RegainReason.EATING || event.getRegainReason() == RegainReason.MAGIC || event.getRegainReason() == RegainReason.MAGIC_REGEN)
                event.setCancelled(true);
        }
    }


}
