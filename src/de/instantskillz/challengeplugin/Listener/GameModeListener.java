//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Listener;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;


public class GameModeListener implements Listener {


    private final String GUI_NAME = "§6§lSpiel-Modi-1";
    private final String GUI_NAME2 = "§6§lSpiel-Modi-2";

    Inventory inv = Bukkit.createInventory(null, 9 * 3, GUI_NAME);
    Inventory inv2 = Bukkit.createInventory(null, 9 * 3, GUI_NAME2);

    public void openGUI(Player player) {

        //Items im inv

        //SneakKill
        if (Main.getPlugin().getSKL() == false) {
            ItemStack nosneak1 = new ItemStack(Material.COBBLESTONE_STAIRS);
            ItemMeta itemMeta1 = nosneak1.getItemMeta();
            itemMeta1.setDisplayName("§cNoSneak -> AN §a\u2714");
            itemMeta1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta1.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet SneakKill aus!", " "));
            nosneak1.setItemMeta(itemMeta1);
            nosneak1.setAmount(1);
            inv.setItem(13, nosneak1);
        } else if (Main.getPlugin().getSKL() == true) {
            ItemStack nosneak2 = new ItemStack(Material.COBBLESTONE_STAIRS);
            ItemMeta itemMeta = nosneak2.getItemMeta();
            itemMeta.setDisplayName("§cNoSneak -> AUS §4\u2715");
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet SneakKill an!", " "));
            nosneak2.setItemMeta(itemMeta);
            nosneak2.setAmount(1);
            inv.setItem(13, nosneak2);
        }

        //Timer
        if (Main.getPlugin().getTimer() == false) {
            ItemStack Timer1 = new ItemStack(Material.CLOCK);
            ItemMeta itemMeta22 = Timer1.getItemMeta();
            itemMeta22.setDisplayName("§cTimer -> AN §a\u2714");
            itemMeta22.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta22.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta22.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet den Timer aus!", " "));
            Timer1.setItemMeta(itemMeta22);
            Timer1.setAmount(1);
            inv.setItem(11, Timer1);
        } else if (Main.getPlugin().getTimer() == true) {
            ItemStack Timer2 = new ItemStack(Material.CLOCK);
            ItemMeta itemMeta2 = Timer2.getItemMeta();
            itemMeta2.setDisplayName("§cTimer -> AUS §4\u2715");
            itemMeta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta2.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet den Timer aus!", " "));
            Timer2.setItemMeta(itemMeta2);
            Timer2.setAmount(1);
            inv.setItem(11, Timer2);
        }

        //KillALL
        if (Main.getPlugin().getKA() == false) {
            ItemStack KA1 = new ItemStack(Material.BEACON);
            ItemMeta itemMeta3 = KA1.getItemMeta();
            itemMeta3.setDisplayName("§cKillAll -> AN §a\u2714");
            itemMeta3.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta3.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet die Tötung von allen aus!", " "));
            KA1.setItemMeta(itemMeta3);
            KA1.setAmount(1);
            inv.setItem(15, KA1);
        } else if (Main.getPlugin().getKA() == true) {
            ItemStack KA2 = new ItemStack(Material.BEACON);
            ItemMeta itemMeta33 = KA2.getItemMeta();
            itemMeta33.setDisplayName("§cKillAll -> AUS §4\u2715");
            itemMeta33.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta33.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet die Tötung von allen an!", " "));
            KA2.setItemMeta(itemMeta33);
            KA2.setAmount(1);
            inv.setItem(15, KA2);
        }

        //FallDMG
        if (Main.getPlugin().getFDMG() == false) {
            ItemStack FDMG1 = new ItemStack(Material.GOLDEN_BOOTS);
            ItemMeta itemMeta4 = FDMG1.getItemMeta();
            itemMeta4.setDisplayName("§cFall-Damage -> AN §a\u2714");
            itemMeta4.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta4.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oSchaltet den Fallschaden aus!", " "));
            FDMG1.setItemMeta(itemMeta4);
            FDMG1.setAmount(1);
            inv.setItem(12, FDMG1);
        } else if (Main.getPlugin().getFDMG() == true) {
            ItemStack FDMG2 = new ItemStack(Material.GOLDEN_BOOTS);
            ItemMeta itemMeta44 = FDMG2.getItemMeta();
            itemMeta44.setDisplayName("§cFall-Damage -> AUS §4\u2715");
            itemMeta44.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta44.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet die direkte Tötung durch Fallschaden an!", " "));
            FDMG2.setItemMeta(itemMeta44);
            FDMG2.setAmount(1);
            inv.setItem(12, FDMG2);
        }

        //Backpack
        if (Main.getPlugin().getBP() == false) {
            ItemStack BP1 = new ItemStack(Material.CHEST);
            ItemMeta itemMeta5 = BP1.getItemMeta();
            itemMeta5.setDisplayName("§cBackpack -> AN §a\u2714");
            itemMeta5.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta5.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oSchaltet das Backpack aus!", " "));
            BP1.setItemMeta(itemMeta5);
            BP1.setAmount(1);
            inv.setItem(14, BP1);
        } else if (Main.getPlugin().getBP() == true) {
            ItemStack BP2 = new ItemStack(Material.CHEST);
            ItemMeta itemMeta55 = BP2.getItemMeta();
            itemMeta55.setDisplayName("§cBackpack -> AUS §4\u2715");
            itemMeta55.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta55.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet das Backpack an!", " "));
            BP2.setItemMeta(itemMeta55);
            BP2.setAmount(1);
            inv.setItem(14, BP2);
        }


        //NächsteSeite
        ItemStack Zurück2 = new ItemStack(Material.HOPPER);
        ItemMeta itemMetaZ2 = Zurück2.getItemMeta();
        itemMetaZ2.setDisplayName("§6§lNächste Seite!");
        itemMetaZ2.setLore(Arrays.asList(" ", "§7Nächste Menü-Seite", " "));
        Zurück2.setItemMeta(itemMetaZ2);
        Zurück2.setAmount(1);
        inv.setItem(26, Zurück2);

        player.openInventory(inv);
    }

    public void openGUI2(Player player) {

        //Bingo
        if (Main.getPlugin().getBINGO() == false) {
            ItemStack Bingo1 = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta itemMeta6 = Bingo1.getItemMeta();
            itemMeta6.setDisplayName("§cBINGO -> AN §a\u2714");
            itemMeta6.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta6.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta6.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oSchaltet das BINGO aus!", " "));
            Bingo1.setItemMeta(itemMeta6);
            Bingo1.setAmount(1);
            inv2.setItem(11, Bingo1);
        } else if (Main.getPlugin().getBINGO() == true) {
            ItemStack Bingo2 = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta itemMeta66 = Bingo2.getItemMeta();
            itemMeta66.setDisplayName("§cBINGO -> AUS §4\u2715");
            itemMeta66.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta66.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet das BINGO an!", " "));
            Bingo2.setItemMeta(itemMeta66);
            Bingo2.setAmount(1);
            inv2.setItem(11, Bingo2);
        }

        //EnderDrachenKill
        if (Main.getPlugin().getEDK() == false) {
            ItemStack EDK1 = new ItemStack(Material.DRAGON_HEAD);
            ItemMeta itemMeta7 = EDK1.getItemMeta();
            itemMeta7.setDisplayName("§cZiel: Ender Drache -> AN §a\u2714");
            itemMeta7.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta7.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta7.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oSchaltet das Ziel des Ender Drachens aus!", " "));
            EDK1.setItemMeta(itemMeta7);
            EDK1.setAmount(1);
            inv2.setItem(12, EDK1);
        } else if (Main.getPlugin().getEDK() == true) {
            ItemStack EDK2 = new ItemStack(Material.DRAGON_HEAD);
            ItemMeta itemMeta77 = EDK2.getItemMeta();
            itemMeta77.setDisplayName("§cZiel: Ender Drache -> AUS §4\u2715");
            itemMeta77.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta77.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet das Ziel des Ender Drachens an!", " "));
            EDK2.setItemMeta(itemMeta77);
            EDK2.setAmount(1);
            inv2.setItem(12, EDK2);
        }

        //UHC
        if (Main.getPlugin().getUHC() == false) {
            ItemStack UHC1 = new ItemStack(Material.CREEPER_HEAD);
            ItemMeta itemMeta8 = UHC1.getItemMeta();
            itemMeta8.setDisplayName("§cUHC -> AN §a\u2714");
            itemMeta8.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta8.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta8.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oSchaltet UHC aus!", " "));
            UHC1.setItemMeta(itemMeta8);
            UHC1.setAmount(1);
            inv2.setItem(13, UHC1);
        } else if (Main.getPlugin().getUHC() == true) {
            ItemStack UHC2 = new ItemStack(Material.CREEPER_HEAD);
            ItemMeta itemMeta88 = UHC2.getItemMeta();
            itemMeta88.setDisplayName("§cUHC -> AUS §4\u2715");
            itemMeta88.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta88.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet UHC an!", " "));
            UHC2.setItemMeta(itemMeta88);
            UHC2.setAmount(1);
            inv2.setItem(13, UHC2);
        }

        //UUHC
        if (Main.getPlugin().getUUHC() == false) {
            ItemStack UUHC1 = new ItemStack(Material.ZOMBIE_HEAD);
            ItemMeta itemMeta9 = UUHC1.getItemMeta();
            itemMeta9.setDisplayName("§cUltra-UHC -> AN §a\u2714");
            itemMeta9.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta9.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oSchaltet Ultra-UHC aus!", " "));
            UUHC1.setItemMeta(itemMeta9);
            UUHC1.setAmount(1);
            inv2.setItem(14, UUHC1);
        } else if (Main.getPlugin().getUUHC() == true) {
            ItemStack UUHC2 = new ItemStack(Material.ZOMBIE_HEAD);
            ItemMeta itemMeta99 = UUHC2.getItemMeta();
            itemMeta99.setDisplayName("§cUltra-UHC -> AUS §4\u2715");
            itemMeta99.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta99.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet Ultra-UHC an!", " "));
            UUHC2.setItemMeta(itemMeta99);
            UUHC2.setAmount(1);
            inv2.setItem(14, UUHC2);
        }


        //Zurück
        ItemStack Zurück = new ItemStack(Material.BARRIER);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7Letzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        inv2.setItem(26, Zurück);

        player.openInventory(inv2);
    }


    @EventHandler
    public void handleNavigatorGUIClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(GUI_NAME)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case COBBLESTONE_STAIRS:

                    if (Main.getPlugin().getSKL() == true) {  //true = aus
                        player.closeInventory();
                        Main.getPlugin().setSKL(false);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cSneakKill wurde aktiviert!");
                        openGUI(player.getPlayer());
                        break;
                    } else if (Main.getPlugin().getSKL() == false) {   //false = an
                        player.closeInventory();
                        Main.getPlugin().setSKL(true);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cSneakKill wurde deaktiviert!");
                        openGUI(player.getPlayer());
                        break;
                    }
                    break;

                case CLOCK:

                    if (Main.getPlugin().getTimer() == true) { //true = aus
                        player.closeInventory();
                        Main.getPlugin().setTimer(false);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cTimer aktiviert!");
                        openGUI(player.getPlayer());
                        break;
                    }
                    if (Main.getPlugin().getTimer() == false) {  //false = an
                        player.closeInventory();
                        Main.getPlugin().setTimer(true);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cTimer deaktiviert!");
                        openGUI(player.getPlayer());
                        break;
                    }
                    break;

                case HOPPER:

                    openGUI2(player.getPlayer());
                    break;

                case BEACON:

                    if (Main.getPlugin().getKA() == true) { //true = aus
                        player.closeInventory();
                        Main.getPlugin().setKA(false);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cKillAll aktiviert!");
                        openGUI(player.getPlayer());
                        break;
                    }
                    if (Main.getPlugin().getKA() == false) {  //false = an
                        player.closeInventory();
                        Main.getPlugin().setKA(true);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cKillAll deaktiviert!");
                        openGUI(player.getPlayer());
                        break;
                    }
                    break;

                case GOLDEN_BOOTS:

                    if (Main.getPlugin().getFDMG() == true) { //true = aus
                        player.closeInventory();
                        Main.getPlugin().setFDMG(false);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cDirekte Tötung durch Fallschaden aktiviert!");
                        openGUI(player.getPlayer());
                        break;
                    }
                    if (Main.getPlugin().getFDMG() == false) {  //false = an
                        player.closeInventory();
                        Main.getPlugin().setFDMG(true);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cDirekte Tötung durch Fallschaden deaktiviert!");
                        openGUI(player.getPlayer());
                        break;
                    }
                    break;

                case CHEST:

                    if (Main.getPlugin().getBP() == true) { //true = aus
                        player.closeInventory();
                        Main.getPlugin().setBP(false);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cBackpack aktiviert");
                        openGUI(player.getPlayer());
                        break;
                    }
                    if (Main.getPlugin().getBP() == false) {  //false = an
                        player.closeInventory();
                        Main.getPlugin().setBP(true);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cBackpack deaktiviert!");
                        openGUI(player.getPlayer());
                        break;
                    }
                    break;

                default:
                    break;
            }
        }

    }

    @EventHandler
    public void handleNavigatorGUIClick2(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(GUI_NAME2)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case GOLDEN_APPLE:

                    if (Main.getPlugin().getBINGO() == true) { //true = aus
                        player.closeInventory();
                        Main.getPlugin().setBINGO(false);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cBINGO aktiviert");
                        openGUI2(player.getPlayer());
                        break;
                    }
                    if (Main.getPlugin().getBINGO() == false) {  //false = an
                        player.closeInventory();
                        Main.getPlugin().setBINGO(true);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cBINGO deaktiviert!");
                        openGUI2(player.getPlayer());
                        break;
                    }
                    break;

                case DRAGON_HEAD:

                    if (Main.getPlugin().getEDK() == true) { //true = aus
                        player.closeInventory();
                        Main.getPlugin().setEDK(false);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cZiel: Ender Drache aktiviert");
                        openGUI2(player.getPlayer());
                        break;
                    }
                    if (Main.getPlugin().getEDK() == false) {  //false = an
                        player.closeInventory();
                        Main.getPlugin().setEDK(true);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cZiel: Ender Drache deaktiviert!");
                        openGUI2(player.getPlayer());
                        break;
                    }
                    break;

                case ZOMBIE_HEAD:

                    if (Main.getPlugin().getUUHC() == true) { //true = aus
                        player.closeInventory();
                        Main.getPlugin().setUUHC(false);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cUltra-UHC aktiviert");
                        openGUI2(player.getPlayer());
                        break;
                    }
                    if (Main.getPlugin().getUUHC() == false) {  //false = an
                        player.closeInventory();
                        Main.getPlugin().setUUHC(true);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cUltra-UHC deaktiviert!");
                        openGUI2(player.getPlayer());
                        break;
                    }
                    break;

                case CREEPER_HEAD:

                    if (Main.getPlugin().getUHC() == true) { //true = aus
                        player.closeInventory();
                        Main.getPlugin().setUHC(false);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cUHC aktiviert");
                        openGUI2(player.getPlayer());
                        break;
                    }
                    if (Main.getPlugin().getUHC() == false) {  //false = an
                        player.closeInventory();
                        Main.getPlugin().setUHC(true);
                        player.sendMessage(Main.getPlugin().PREFIX + "§cUHC deaktiviert!");
                        openGUI2(player.getPlayer());
                        break;
                    }
                    break;

                case BARRIER:

                    openGUI(player.getPlayer());
                    break;

                default:
                    break;
            }
        }
    }

}
