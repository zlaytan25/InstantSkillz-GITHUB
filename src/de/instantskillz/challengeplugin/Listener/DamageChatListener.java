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

import java.io.File;
import java.text.DecimalFormat;

public class DamageChatListener implements Listener {

    World world = Bukkit.getWorld("world");
    private int challengeWorlds = 0;

    @EventHandler
    public void damageChat(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            double damage = event.getDamage();

            challengeWorlds = 0;
            String currentWorld = player.getWorld().getName();
            if (currentWorld != Bukkit.getWorld("world").getName() && currentWorld.contains("Challenge")) {
                String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
                for (World w : Bukkit.getServer().getWorlds()) {
                    worldNames[challengeWorlds] = w.getName();
                    if (w.getName().contains("Challenge")) {
                        challengeWorlds++;

                    }
                }

                for (int i = 1; i <= challengeWorlds; i++) {
                    if (currentWorld.equals("Challenge-" + i)) {

                        File paused = new File("Challenge-" + i + "//.paused");
                        if (paused.exists()) {
                            event.setCancelled(true);
                            return;
                        }
                    }
                }
            }

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
