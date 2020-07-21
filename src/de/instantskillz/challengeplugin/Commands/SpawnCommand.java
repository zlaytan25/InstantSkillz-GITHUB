//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.hub")) {
                if (args.length == 0) {

                    player.getInventory().clear();
                    FileConfiguration config = Main.getPlugin().getConfig();
                    World world = Bukkit.getWorld(config.getString("Spawn.World"));
                    double x = config.getDouble("Spawn.X");
                    double y = config.getDouble("Spawn.Y");
                    double z = config.getDouble("Spawn.Z");
                    float yaw = (float) config.getDouble("Spwan.Yaw");
                    float pitch = (float) config.getDouble("Spawn.Pitch");
                    Location location = new Location(world, x, y, z, yaw, pitch);

                    ItemStack item = new ItemStack(Material.BOOK);
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName("§6§lNavigator");
                    itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    item.setItemMeta(itemMeta);

                    item.setAmount(1);
                    player.getInventory().setItem(4, item);

                    player.teleport(location);
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage("§aServer " + "§8>> " + "§aDu wurdest zur §6Lobby §ateleportiert!");


                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze den §6/hub§c!");

            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Recht! Wie Frauen!!!");

        }


        return false;
    }

}
