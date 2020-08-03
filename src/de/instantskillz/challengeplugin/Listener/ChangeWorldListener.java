//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;


import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ChangeWorldListener implements Listener {

    public int challengeWorlds = 0;

    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent event) {
        String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
        for (World w : Bukkit.getServer().getWorlds()) {
            worldNames[challengeWorlds] = w.getName();
            if (w.getName().contains("Challenge")) {
                challengeWorlds++;
            }
        }
        String currentWorld = event.getPlayer().getWorld().getName();
        if (currentWorld != Bukkit.getWorld("world").getName() && currentWorld.contains("Challenge")) {

            for (int i = 1; i <= challengeWorlds; i++) {
                if (currentWorld.equals("Challenge-" + i)) {

                    //Get Inventory
                    Player player = event.getPlayer();
                    File inventory = new File("plugins//InstantSkillzTV//Inventories//CraftWorld{name=Challenge-}" + i + "}//" + player.getName() + ".yml");

                    player.getInventory().clear();
                    player.closeInventory();
                    player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Challenge-Welt-" + i + "!");

                    if (inventory.exists()) {
                        YamlConfiguration inv = YamlConfiguration.loadConfiguration(inventory);
                        player.getInventory().clear();
                        List<?> list = inv.getList("Inventory");
                        List<?> slot = inv.getList("Slot");

                        double health = inv.getDouble("Health");
                        player.setHealth(health);
                        double exp = inv.getDouble("Exp");
                        player.setExp((float) exp);
                        int level = inv.getInt("Level");
                        player.setLevel(level);
                        int hunger = inv.getInt("Hunger");
                        player.setFoodLevel(hunger);

                        World world = Bukkit.getWorld(inv.getString("World"));
                        Double X = inv.getDouble("X");
                        Double Y = inv.getDouble("Y");
                        Double Z = inv.getDouble("Z");
                        Location loc = new Location(world, X, Y, Z);
                        player.teleport(loc);

                        inventory.delete();

                        for (int j = 0; j < player.getInventory().getSize(); j++) {
                            player.getInventory().setItem((Integer) slot.get(j), (ItemStack) list.get(j));
                        }
                    } else {
                        Location location1 = event.getPlayer().getWorld().getSpawnLocation();
                        location1.setY(event.getPlayer().getWorld().getHighestBlockYAt(location1) + 1);
                        player.teleport(location1);
                    }

                    File paused = new File("Challenge-" + i + "//.paused");

                    if (!paused.exists() && event.getPlayer().getWorld().getPlayers().size() < 1) {
                        Bukkit.broadcastMessage("Die Challenge wurde pausiert!");
                        event.getPlayer().getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
                        event.getPlayer().setGameMode(GameMode.ADVENTURE);
                    } else if (!paused.exists()) {
                        Bukkit.broadcastMessage("Die Challenge wurde pausiert!");
                        event.getPlayer().getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
                        event.getPlayer().setGameMode(GameMode.ADVENTURE);

                        try {
                            paused.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            File running = new File(currentWorld + "//.running");
            if (running.exists()) {
                running.delete();
            }
        }
    }

    @EventHandler
    public void particles(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        String currentWorld = player.getWorld().getName();
        for (int i = 1; i <= challengeWorlds; i++) {
            if (currentWorld.equals("Challenge-" + i)) {
                File paused = new File("Challenge-" + i + "//.paused");

                if (paused.exists()) {
                    Location loc = player.getLocation();
                    player.getWorld().spawnParticle(Particle.SPELL_WITCH, loc, 2, 0, 0, 0);
                }
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        String currentWorld = event.getEntity().getWorld().getName();
        for (int i = 1; i <= challengeWorlds; i++) {
            if (currentWorld.equals("Challenge-" + i)) {
                File paused = new File("Challenge-" + i + "//.paused");

                if (paused.exists()) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        String currentWorld = event.getEntity().getWorld().getName();
        for (int i = 1; i <= challengeWorlds; i++) {
            if (currentWorld.equals("Challenge-" + i)) {
                File paused = new File("Challenge-" + i + "//.paused");

                if (paused.exists()) {
                    event.setCancelled(true);
                }
            }
        }
    }
}