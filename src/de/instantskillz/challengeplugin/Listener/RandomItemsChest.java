//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class RandomItemsChest implements Listener {

    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent event) {
        if (event.getPlayer() instanceof Player) {
            Player player = (Player) event.getPlayer();
            if (event.getInventory().getHolder() instanceof Chest) {
                Bukkit.broadcastMessage("ahhlskdhnaspi");

                Random ran = new Random();
                int c = ran.nextInt(27);

                Chest chest = (Chest) event.getInventory().getHolder();
                Inventory chestinv = chest.getBlockInventory();

                ItemStack item_1 = new ItemStack(Material.APPLE);               //60%
                ItemStack item_2 = new ItemStack(Material.GOLDEN_APPLE);        //10%
                ItemStack item_3 = new ItemStack(Material.CARROT);                //30%

                chestinv.clear();
                chestinv.setItem(c, item_1);
                chestinv.setItem(c, item_2);
                chestinv.setItem(c, item_3);

            }

        }
    }


}