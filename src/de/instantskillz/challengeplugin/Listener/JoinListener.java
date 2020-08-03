//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;

public class JoinListener implements Listener {

    World world = Bukkit.getWorld("world");

    @EventHandler
    public void handlePlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.getWorld() == world) {
            //Spawn-TP
            Location location = new Location(world, 0.5, 75, 0.5);
            player.teleport(location);

            //Player-Attribute
            player.setFoodLevel(20);
            player.setHealth(20);
            player.setTotalExperience(0);
            player.setExp(0);
            player.setLevel(0);
            player.getInventory().clear();
            player.setGameMode(GameMode.ADVENTURE);

            //Navigator
            ItemStack item = new ItemStack(Material.BOOK);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName("§6§lNavigator");
            itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(itemMeta);
            item.setAmount(1);
            player.getInventory().setItem(4, item);

            //Setspawn(HUB)
            FileConfiguration config = Main.getPlugin().getConfig();
            config.set("Spawn.World", player.getWorld().getName());
            config.set("Spawn.X", player.getLocation().getX());
            config.set("Spawn.Y", player.getLocation().getY());
            config.set("Spawn.Z", player.getLocation().getZ());
            config.set("Spawn.Yaw", player.getLocation().getYaw());
            config.set("Spawn.Pitch", player.getLocation().getPitch());
            Main.getPlugin().saveConfig();
        }

        //Join-Message
        event.setJoinMessage("§a§l>> §7" + player.getName());


    }


    @EventHandler
    public void handlePlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        //Quit-Message
        event.setQuitMessage("§4§l<< §7" + player.getName());
    }

    public void updateScoreboard() {
        for (Player online : Bukkit.getOnlinePlayers()) {
            Score score = online.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("§cSpieler: §7" + Bukkit.getOnlinePlayers().size());
            score.setScore(1);
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        Player player = (Player) event.getEntity();
        if (player.getWorld() == Bukkit.getWorld("world")) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.setFoodLevel(20);
            }
            event.setCancelled(true);
        }

    }


    //player.getInventory().addItem(new ItemBuilder(Material.BOOK).setName("§6§lNavigator").setLore("§aBy InstantSkillzTV").build());
    //player.getInventory().addItem(new ItemBuilder(Material.PINK_WOOL).setLore("§6TestLore").setAmount(42).build());

}
