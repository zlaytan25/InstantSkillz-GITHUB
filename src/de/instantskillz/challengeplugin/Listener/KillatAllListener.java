//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;


public class KillatAllListener implements Listener {


    @EventHandler
    public void playerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (Main.getPlugin().getKA() == false) {

            FileConfiguration config = Main.getPlugin().getConfig();
            config.set("Death.World", player.getWorld().getName());
            config.set("Death.X", player.getLocation().getX());
            config.set("Death.Y", player.getLocation().getY());
            config.set("Death.Z", player.getLocation().getZ());
            Main.getPlugin().saveConfig();

            event.setDeathMessage(null);
            Bukkit.broadcastMessage("§aServer " + "§8>> " + "§cDer Spieler §6" + player.getName() + "§c ist gestorben. Die Challenge wurde beendet und der Timer gestoppt!");

            if (player.getGameMode() == GameMode.SPECTATOR) {
                return;
            } else if (player.getGameMode() == GameMode.ADVENTURE) {
                return;
            } else if (player.getGameMode() == GameMode.CREATIVE) {
                return;
            } else
                Main.getPlugin().setKA(false);
            player.setMaxHealth(20.0);
            Main.getPlugin().setTimer(true);
            Main.getPlugin().setFDMG(true);
            Main.getPlugin().setSKL(true);
            Main.getPlugin().setUUHC(true);
            Main.getPlugin().setBP(false);
            Main.getPlugin().setEDK(false);
            Main.getPlugin().setKA(false);
            Main.getPlugin().setSH(true);
            for (Player all : Bukkit.getServer().getOnlinePlayers())
                all.setGameMode(GameMode.SPECTATOR);
        }

        if (Main.getPlugin().getKA() == true) {
            return;
        }
    }

    @EventHandler
    public void onRespawnEVENT(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

        if (player.getWorld() != Bukkit.getWorld("world")) {

            FileConfiguration config = Main.getPlugin().getConfig();
            World world = Bukkit.getWorld(config.getString("Death.World"));
            double x = config.getDouble("Death.X");
            double y = config.getDouble("Death.Y");
            double z = config.getDouble("Death.Z");
            Location location = new Location(world, x, y, z);

            event.setRespawnLocation(location);
        }

    }

}
