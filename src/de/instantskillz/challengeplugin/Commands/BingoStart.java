//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import de.instantskillz.challengeplugin.Events.BingoEvent;
import de.instantskillz.challengeplugin.Main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class BingoStart implements CommandExecutor, Listener {

    //Inventory
    private final String GUI_NAME = "§6§lBingo-Karte";
    World world;
    Location loc;
    BingoEvent event = new BingoEvent();
    int timer = 5;
    int sec;
    int min;
    int h;
    int d;
    String t1;
    Inventory Binv = Bukkit.createInventory(null, 9 * 5, GUI_NAME);


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (Main.getPlugin().getBINGO() == false) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("schnellerHase.bingo")) {
                    if (args.length == 1) {

                        if (args[0].equalsIgnoreCase("s")) {
                            timer = 5;
                            world = player.getWorld();
                            loc = world.getSpawnLocation();
                            loc.setY(world.getHighestBlockYAt(loc) + 1);
                            Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§aBingo wurde gestartet. Mit §c/bingo j §akannst du dem Spiel beitreten!");
                        }

                        if (args[0].equalsIgnoreCase("j")) {
                            event.setSpieler(1);
                            player.sendMessage(Main.getPlugin().PREFIX + "§aDu bist dem Bingo beigereten!");
                            Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§aEs sind nun §c" + event.getSpieler() + " Spieler §avon §c" + event.getMaxSpieler() + " Spieler §abeigetreten!");
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
                                            if (all.getWorld() == world) {
                                                all.getInventory().clear();
                                                all.teleport(loc);
                                                ItemStack item = new ItemStack(Material.PAPER);
                                                ItemMeta itemMeta = item.getItemMeta();
                                                itemMeta.setDisplayName("§6§lBingo-Karte");
                                                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                                                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                                item.setItemMeta(itemMeta);
                                                item.setAmount(1);
                                                all.getInventory().setItem(8, item);
                                            }
                                        }
                                        Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§cDas Spiel beginnt. Viel Glück!!!");
                                        Bukkit.broadcastMessage(Main.getPlugin().PREFIX + "§aSammle die Gegenstände die du mit §cBingo-Karte einsehen kannst!");


                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                if (sec == -1) {
                                                    cancel();
                                                    return;
                                                }
                                                for (final Player player : Bukkit.getOnlinePlayers()) {
                                                    if (sec == 60) {
                                                        min++;
                                                        sec = 0;
                                                    }
                                                    if (min == 60) {
                                                        h++;
                                                        min = 0;
                                                    }
                                                    if (h == 24) {
                                                        d++;
                                                        h = 0;
                                                    }
                                                    if (h == 24) {
                                                        d++;
                                                        h = 0;
                                                    }

                                                    t1 = String.format("§6§l" + d + "d:" + h + "h:" + min + "min:" + sec + "sec");
                                                    String message = t1;
                                                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                                                }
                                                sec++;
                                            }
                                        }.runTaskTimer(Main.getPlugin(), 0L, 20L);
                                    }
                                }
                            }.runTaskTimer(Main.getPlugin(), 0L, 20L);

                        }


                        //ENDE
                        //
                        //sec = -1
                        //Bukkit.broadcastMessage("§aServer " + "§8>> " + "§aDas Bingo hat §9§l" + t1 + " gedauert!");
                        //for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                        //if(all.getWorld() == world) {
                        //	all.teleport(loc);
                        //	all.getInventory().clear();
                        //}
                        //}
                        //ENDE


                    } else
                        player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/bingo start§c!");
                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte!");
            }
        }
        if (Main.getPlugin().getBINGO() == true) {
            return false;
        }

        return false;
    }


    public void openGUI(Player player) {


    }


    @EventHandler
    public void handleNavigatorOpener(PlayerInteractEvent event) {
        if (event.getItem().getItemMeta().getDisplayName() != "§6§lBingo-Karte" && event.getItem().getType() != Material.PAPER) return;
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            Player player = (Player) event.getPlayer();
            openGUI(player.getPlayer());
            player.sendMessage("§aServer " + "§8>> " + "§aDir wurde die Bingo-Karte geöffnet!");
        }

    }


}
