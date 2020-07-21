//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import java.text.DecimalFormat;

public class DamageChatListener implements Listener {

    World world = Bukkit.getWorld("world");

    @EventHandler
    public void damageChat(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            double damage = event.getDamage();

            if (player.getWorld() == world) {
                event.setCancelled(true);
            } else if (event.getCause() == DamageCause.VOID) {
                player.setHealth(0);
                event.setCancelled(true);
            } else {

                //player.setFoodLevel(2000);
                //player.setHealth(20);

                DecimalFormat format = new DecimalFormat("0.00");
                Bukkit.broadcastMessage("§aServer " + "§8>> " + "§6" + player.getName() + " §chat §6" + format.format(damage / 2) + " §cSchaden erlitten!");
            }


        }
    }

}
