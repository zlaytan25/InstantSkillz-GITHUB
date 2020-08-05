//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.hub")) {
                if (args.length == 0) {

                    if (player.getWorld() != Bukkit.getWorld("world")) {
                        Main.getPlugin().setTimer(true);
                        this.checkDirectory();
                        ArrayList<ItemStack> list = new ArrayList<>();
                        String playername = player.getName();
                        World world = player.getWorld();
                        File file = new File("plugins//InstantSkillzTV//Inventories//" + world + "//" + playername + ".yml");

                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);

                        ArrayList<Integer> slot = new ArrayList<>();

                        for (int i = 0; i <= player.getInventory().getSize(); i++) {
                            if (player.getInventory().getItem(i) != null) {
                                slot.add(i);
                            }
                        }

                        ItemStack[] contents = player.getInventory().getContents();
                        double health = player.getHealth();
                        int level = player.getLevel();
                        double exp = player.getExp();
                        int hunger = player.getFoodLevel();

                        for (int i = 0; i < contents.length; i++) {
                            ItemStack item = contents[i];

                            if (!(item == null)) {
                                list.add(item);
                            }
                        }

                        String cw = player.getWorld().getName();
                        double X = player.getLocation().getX();
                        double Y = player.getLocation().getY();
                        double Z = player.getLocation().getZ();

                        inv.set("Slot", slot);
                        inv.set("Inventory", list);
                        inv.set("Health", health);
                        inv.set("Exp", exp);
                        inv.set("Level", level);
                        inv.set("Hunger", hunger);
                        inv.set("World", cw);
                        inv.set("X", X);
                        inv.set("Y", Y);
                        inv.set("Z", Z);

                        try {
                            inv.save(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        player.getInventory().clear();

                        FileConfiguration config = Main.getPlugin().getConfig();
                        World world2 = Bukkit.getWorld(config.getString("Spawn.World"));
                        double x = config.getDouble("Spawn.X");
                        double y = config.getDouble("Spawn.Y");
                        double z = config.getDouble("Spawn.Z");
                        float yaw = (float) config.getDouble("Spwan.Yaw");
                        float pitch = (float) config.getDouble("Spawn.Pitch");
                        Location location = new Location(world2, x, y, z, yaw, pitch);

                        ItemStack item = new ItemStack(Material.BOOK);
                        ItemMeta itemMeta = item.getItemMeta();
                        itemMeta.setDisplayName("§6§lNavigator");
                        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        item.setItemMeta(itemMeta);
                        item.setAmount(1);
                        player.getInventory().setItem(4, item);
                        player.teleport(location);
                        player.setFoodLevel(20);
                        player.setMaxHealth(20.0);
                        player.setHealth(20);
                        player.setExp(0);
                        player.setLevel(0);
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage("§aServer " + "§8>> " + "§aDu wurdest zur §6Lobby §ateleportiert!");
                        Main.getPlugin().setFDMG(true);
                        Main.getPlugin().setSKL(true);
                        Main.getPlugin().setUUHC(true);
                        Main.getPlugin().setBP(false);
                        Main.getPlugin().setEDK(false);
                        Main.getPlugin().setKA(false);
                        Main.getPlugin().setTimer(false);
                        Main.getPlugin().setSH(true);

                        return true;
                    } else {

                        FileConfiguration config = Main.getPlugin().getConfig();
                        World world1 = Bukkit.getWorld(config.getString("Spawn.World"));
                        double x = config.getDouble("Spawn.X");
                        double y = config.getDouble("Spawn.Y");
                        double z = config.getDouble("Spawn.Z");
                        float yaw = (float) config.getDouble("Spwan.Yaw");
                        float pitch = (float) config.getDouble("Spawn.Pitch");
                        Location location = new Location(world1, x, y, z, yaw, pitch);

                        ItemStack item = new ItemStack(Material.BOOK);
                        ItemMeta itemMeta = item.getItemMeta();
                        itemMeta.setDisplayName("§6§lNavigator");
                        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        item.setItemMeta(itemMeta);

                        item.setAmount(1);
                        player.getInventory().clear();
                        player.getInventory().setItem(4, item);

                        player.teleport(location);

                        player.setFoodLevel(20);
                        player.setMaxHealth(20.0);
                        player.setHealth(20);
                        player.setTotalExperience(0);
                        player.setExp(0);
                        player.setLevel(0);

                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage("§aServer " + "§8>> " + "§aDu wurdest zur §6Lobby §ateleportiert!");
                        Main.getPlugin().setFDMG(true);
                        Main.getPlugin().setSKL(true);
                        Main.getPlugin().setUUHC(true);
                        Main.getPlugin().setBP(false);
                        Main.getPlugin().setEDK(false);
                        Main.getPlugin().setKA(false);
                        Main.getPlugin().setTimer(false);
                        Main.getPlugin().setSH(true);
                    }

                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze den §6/hub§c!");

            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Recht! Wie Frauen!!!");

        }


        return false;
    }

    public void checkDirectory() {
        File file = new File("plugins//InstantSkillzTV//Inventories");
        if (!file.exists()) {
            file.mkdir();
        }
    }


}
