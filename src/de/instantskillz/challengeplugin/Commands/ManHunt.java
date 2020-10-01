//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import de.instantskillz.challengeplugin.Events.ManHuntEvent;
import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ManHunt implements CommandExecutor, Listener {

    ManHuntEvent event = new ManHuntEvent();
    int timer = 5;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.manhunt")) {
                if (args.length == 1) {

                    if (args[0].equalsIgnoreCase("start")) {
                        if (Main.getPlugin().getStart() == true) {
                            Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§aManHunt wurde schon gestartet! Bitte geht in eine Welt und entscheidet euch für ein Team.");
                        } else if (Main.getPlugin().getStart() == false) {
                            Main.getPlugin().setStart(true);
                            Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§aManHunt wurde gestartet! Bitte geht in eine Welt und entscheidet euch für ein Team." + " §1Hunter: §7§o/manhunt join§1hunter§0; §4Player: §7§o/manhunt join§4player");
                        } else if (event.getSpieler() == event.getMaxSpieler()) {
                            player.sendMessage(Main.getPlugin().PREFIX + "§4Die Runde startet bereits!");
                        }
                    }

                    if (args[0].equalsIgnoreCase("joinhunter")) {

                        if (event.getHunter() != (event.getMaxSpieler() - 1)) {
                            timer = 5;
                            event.setSpieler(1);
                            event.setHunter(1);

                            ItemStack item = new ItemStack(Material.COMPASS, 1);
                            ItemMeta im = item.getItemMeta();
                            im.setDisplayName("§6Tracker");
                            im.setLore(Arrays.asList(" ", "§7§oTrackt den Player!", " "));
                            im.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                            item.setItemMeta(im);
                            player.getInventory().setItem(8, item);

                            player.sendMessage(Main.getPlugin().PREFIX + "§aDu bist den Huntern beigetreten!");
                            Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§aEs sind §c" + event.getSpieler() + "/" + event.getMaxSpieler() + " §aSpieler beigetreten!");
                            Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§1Hunter: §1" + event.getHunter() + "/1§0; §4Player: §4" + event.getPlayer() + "§4/1");
                        } else if (event.getHunter() == (event.getMaxSpieler() - 1)) {
                            player.sendMessage(Main.getPlugin().PREFIX + "§4Die Hunter sind voll. Trete dem Player bei, falls es noch keinen gibt!");
                        } else if (event.getSpieler() == event.getMaxSpieler()) {
                            player.sendMessage(Main.getPlugin().PREFIX + "§4Die Runde startet bereits!");
                        }
                    }

                    if (args[0].equalsIgnoreCase("joinplayer")) {
                        if (event.getPlayer() == 1) {
                            player.sendMessage(Main.getPlugin().PREFIX + "§4Es kann nur einen Player gleichzeitig geben! Trete den Huntern bei!");
                        } else if (event.getPlayer() != 1) {

                            this.checkDirectory();
                            File file = new File("plugins//InstantSkillzTV//ManHunt//player.yml");
                            YamlConfiguration playername = YamlConfiguration.loadConfiguration(file);
                            String pname = player.getName();
                            playername.set("Player", pname);

                            try {
                                playername.save(file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                            event.setSpieler(1);
                            event.setPlayer(1);
                            player.sendMessage(Main.getPlugin().PREFIX + "§aDu bist den Playern beigetreten!");
                            Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§aEs sind §c" + event.getSpieler() + "/" + event.getMaxSpieler() + " §aSpieler beigetreten!");
                            Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§1Hunter: §1" + event.getHunter() + "/1§0; §4Player: §4" + event.getPlayer() + "§4/1");
                        } else if (event.getSpieler() == event.getMaxSpieler()) {
                            player.sendMessage(Main.getPlugin().PREFIX + "§4Die Runde startet bereits!");
                        }
                    }

                    if (event.getSpieler() == event.getMaxSpieler()) {
                        Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§aAlle Spieler sind beigetreten!");

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§aDas Spiel beginnt in: §c" + timer);
                                timer--;
                                if (timer == -1) {
                                    cancel();
                                    timer = 0;
                                    for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                                        all.setGameMode(GameMode.CREATIVE);

                                    }
                                    Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§cDas Spiel beginnt. Viel Glück!!!");

                                }
                            }
                        }.runTaskTimer(Main.getPlugin(), 0L, 20L);
                    }
                }
            }
        }

        return false;
    }

    @EventHandler
    public void checkDirectory() {
        File file = new File("plugins//InstantSkillzTV//Manhunt//player");
        if (!file.exists()) {
            file.mkdir();
        }
    }

    @EventHandler
    public void handleNavigatorGUIClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (player.getGameMode() == GameMode.CREATIVE) {
            return;
        }
        if (event.getSlotType() == InventoryType.SlotType.QUICKBAR) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case COMPASS:
                    event.setCancelled(true);
                    break;
                default:
                    break;
            }
        }
    }


    @EventHandler
    public void tracker(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (event.getSpieler() == event.getMaxSpieler()) {
            File file = new File("plugins//InstantSkillzTV//ManHunt//player.yml");
            YamlConfiguration pname = YamlConfiguration.loadConfiguration(file);
            if (file.exists()) {
                String playername = pname.getString("Player");
                Bukkit.broadcastMessage(playername);
                if (e.getPlayer().getName().equalsIgnoreCase(playername)) {
                    player.performCommand("/setworldspawn ~ ~ ~");
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
            } else if {
                return;
            }
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        challengeWorlds = 0;
        String[] worldNames = new String[Bukkit.getServer().getWorlds().size()];
        for (World w : Bukkit.getServer().getWorlds()) {
            worldNames[challengeWorlds] = w.getName();
        }
        String currentWorld = event.getEntity().getWorld().getName();
        for (int i = 1; i <= challengeWorlds; i++) {
            if (currentWorld.equals("Challenge-" + i)) {

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
