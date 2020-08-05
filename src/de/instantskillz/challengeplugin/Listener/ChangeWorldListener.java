//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;


import de.instantskillz.challengeplugin.Main.Main;
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
    public final String STATUS = "§6Die Challenge ist pausiert!";
    String currentWorld;

    public String getCurrentWorld() {
        return currentWorld;
    }

    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent event) {
        challengeWorlds = 0;
        Player player = event.getPlayer();
        String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
        for (World w : Bukkit.getServer().getWorlds()) {
            worldNames[challengeWorlds] = w.getName();
            if (w.getName().contains("Challenge")) {
                challengeWorlds++;
            }
        }

        currentWorld = event.getPlayer().getWorld().getName();

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.getWorld().getName().equals(event.getFrom().getName())) {
                all.sendMessage("§e§l<< §7" + player.getName());
            }
        }
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.getWorld().getName().equals("world")) {
                all.sendMessage("§9§l>> §7" + player.getName());
            }
        }

        if (currentWorld != Bukkit.getWorld("world").getName() && currentWorld.contains("Challenge")) {
            for (int i = 1; i <= challengeWorlds; i++) {
                if (currentWorld.equals("Challenge-" + i)) {

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (all.getWorld().getName().equals(currentWorld)) {
                            all.sendMessage("§9§l>> §7" + player.getName());
                        }
                    }


                    player.getInventory().clear();
                    player.closeInventory();
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt " + i + "§a!");

                    File paused = new File("Challenge-" + i + "//.paused");
                    File running = new File(currentWorld + "//.running");

                    if (!paused.exists() && event.getPlayer().getWorld().getPlayers().size() <= 1) {
                        Main.getPlugin().pausestatus(currentWorld);
                        event.getPlayer().getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
                        event.getPlayer().setGameMode(GameMode.ADVENTURE);
                        try {
                            paused.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (paused.exists() && event.getPlayer().getWorld().getPlayers().size() >= 1) {
                        Main.getPlugin().pausestatus(currentWorld);
                        event.getPlayer().getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
                        event.getPlayer().setGameMode(GameMode.ADVENTURE);
                    } else if (running.exists() && event.getPlayer().getWorld().getPlayers().size() >= 1) {
                        event.getPlayer().setGameMode(GameMode.SURVIVAL);
                    }

                    if (running.exists() && event.getPlayer().getWorld().getPlayers().size() < 1) {
                        running.delete();
                    } else if (running.exists() && paused.exists()) {
                        running.delete();
                    }

                    //Get Inventory
                    File inventory = new File("plugins//InstantSkillzTV//Inventories//CraftWorld{name=Challenge-" + i + "}//" + player.getName() + ".yml");

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
                        Location loc = new Location(world, X, Y + 1, Z);
                        player.teleport(loc);

                        inventory.delete();

                        for (int j = 0; j < player.getInventory().getSize(); j++) {
                            player.getInventory().setItem((Integer) slot.get(j), (ItemStack) list.get(j));
                        }

                    }


                }
            }

        }
    }

    @EventHandler
    public void particles(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        challengeWorlds = 0;
        String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
        for (World w : Bukkit.getServer().getWorlds()) {
            worldNames[challengeWorlds] = w.getName();
            if (w.getName().contains("Challenge")) {
                challengeWorlds++;
            }
        }
        String currentWorld = player.getWorld().getName();
        for (int i = 1; i <= challengeWorlds; i++) {
            if (currentWorld.equals("Challenge-" + i)) {
                File paused = new File("Challenge-" + i + "//.paused");

                if (paused.exists()) {
                    Main.getPlugin().setPup(true);
                    Main.getPlugin().pausestatus(currentWorld);
                    Location loc = player.getLocation();
                    player.getWorld().spawnParticle(Particle.SPELL_WITCH, loc, 2, 0, 0, 0);
                }
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        challengeWorlds = 0;
        String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
        for (World w : Bukkit.getServer().getWorlds()) {
            worldNames[challengeWorlds] = w.getName();
            if (w.getName().contains("Challenge")) {
                challengeWorlds++;
            }
        }
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
        challengeWorlds = 0;
        String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
        for (World w : Bukkit.getServer().getWorlds()) {
            worldNames[challengeWorlds] = w.getName();
            if (w.getName().contains("Challenge")) {
                challengeWorlds++;
            }
        }
        String currentWorld = event.getEntity().getWorld().getName();
        for (int i = 1; i <= challengeWorlds; i++) {
            if (currentWorld.equals("Challenge-" + i)) {
                File paused = new File("Challenge-" + i + "//.paused");

                if (paused.exists()) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.setFoodLevel(20);
                    }
                    event.setCancelled(true);
                }
            }
        }
    }

}