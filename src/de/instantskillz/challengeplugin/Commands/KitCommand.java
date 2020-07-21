//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("schnellerHase.kit")) {
                if (args.length == 0) {

                    Inventory inventory = Bukkit.createInventory(null, 9 * 3, "§6§lKit-Inventar");

                    //Bow
                    ItemStack item = new ItemStack(Material.BOW);
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName("§6Epischer-Hasenbogen!");
                    itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
                    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    item.setItemMeta(itemMeta);

                    //Schwert
                    ItemStack item2 = new ItemStack(Material.DIAMOND_SWORD);
                    ItemMeta itemMeta2 = item2.getItemMeta();
                    itemMeta2.setDisplayName("§6Anal-Zerficker!");
                    itemMeta2.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                    itemMeta2.addEnchant(Enchantment.KNOCKBACK, 10, true);
                    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    item2.setItemMeta(itemMeta2);

                    //Bucket
                    ItemStack item3 = new ItemStack(Material.WATER_BUCKET);
                    ItemMeta itemMeta3 = item3.getItemMeta();
                    itemMeta3.setDisplayName("§6Life-Saver!");
                    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    item3.setItemMeta(itemMeta3);

                    //Bow-Position
                    item.setAmount(1);
                    inventory.setItem(12, item);

                    //Bucket-Position
                    item3.setAmount(1);
                    inventory.setItem(13, item3);

                    //Schwert-Position
                    item2.setAmount(1);
                    inventory.setItem(14, item2);

                    player.openInventory(inventory);
                    player.sendMessage("§aServer " + "§8>> " + "§aDir wurde das Kit-Menü geöffnet!");

                } else
                    player.sendMessage("§aServer " + "§8>> " + "§cBitte benutze §6/kit§c!");
            } else
                player.sendMessage("§aServer " + "§8>> " + "§cDazu hast du keine Rechte!");
        }

        return false;
    }


}

