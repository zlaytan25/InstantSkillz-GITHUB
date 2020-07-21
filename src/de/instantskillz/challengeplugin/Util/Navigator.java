//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Util;

import de.instantskillz.challengeplugin.Listener.GameModeListener;
import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.Arrays;

public class Navigator implements Listener {

    private final String GUI_NAME = "§6§lNavigator";
    private final String GUI_NAME2 = "§6§lChallenge-Welten";
    private final String CW1 = "§6§lChallenge-Welt-1";
    private final String CW2 = "§6§lChallenge-Welt-2";
    private final String CW3 = "§6§lChallenge-Welt-3";
    private final String CW4 = "§6§lChallenge-Welt-4";
    private final String CW5 = "§6§lChallenge-Welt-5";


    //Navi
    Inventory inventory = Bukkit.createInventory(null, 9 * 3, GUI_NAME);
    Inventory WeltenOrdner = Bukkit.createInventory(null, 9 * 3, GUI_NAME2);

    Inventory InvCW1 = Bukkit.createInventory(null, 9 * 3, CW1);
    Inventory InvCW2 = Bukkit.createInventory(null, 9 * 3, CW2);
    Inventory InvCW3 = Bukkit.createInventory(null, 9 * 3, CW3);
    Inventory InvCW4 = Bukkit.createInventory(null, 9 * 3, CW4);
    Inventory InvCW5 = Bukkit.createInventory(null, 9 * 3, CW5);


    private GameModeListener gl = new GameModeListener();

    public void openGUI(Player player) {

        //Item im Navi
        ItemStack Bingo = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ItemMeta itemMeta = Bingo.getItemMeta();
        itemMeta.setDisplayName("§cStarte BINGO");
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.setLore(Arrays.asList(" ", "§7§oErstellt eine Bingo Welt!", " "));
        Bingo.setItemMeta(itemMeta);
        Bingo.setAmount(1);

        ItemStack Welten = new ItemStack(Material.END_PORTAL_FRAME);
        ItemMeta itemMeta2 = Welten.getItemMeta();
        itemMeta2.setDisplayName("§cChallenge-Welten");
        itemMeta2.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        itemMeta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta2.setLore(Arrays.asList(" ", "§7§oEine Übersicht mit allen Challenge-Welten!", " "));
        Welten.setItemMeta(itemMeta2);
        Welten.setAmount(1);

        if (Bukkit.getWorld("Challenge-1") == null) {
            ItemStack Welt1 = new ItemStack(Material.WHITE_CONCRETE);
            ItemMeta itemMeta3 = Welt1.getItemMeta();
            itemMeta3.setDisplayName("§6§lChallenge-Welt-1");
            itemMeta3.setLore(Arrays.asList(" ", "§4\u2715 §c§lWelt inaktiv! §4\u2715", " "));
            Welt1.setItemMeta(itemMeta3);
            Welt1.setAmount(1);
            WeltenOrdner.setItem(11, Welt1);
        } else if (Bukkit.getWorld("Challenge-1") != null) {
            ItemStack Welt1 = new ItemStack(Material.WHITE_CONCRETE);
            ItemMeta itemMeta3 = Welt1.getItemMeta();
            itemMeta3.setDisplayName("§6§lChallenge-Welt-1");
            itemMeta3.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta3.setLore(Arrays.asList(" ", "§a\u2714 §c§lWelt aktiv! §a\u2714", " "));
            Welt1.setItemMeta(itemMeta3);
            Welt1.setAmount(1);
            WeltenOrdner.setItem(11, Welt1);
        }

        if (Bukkit.getWorld("Challenge-2") == null) {
            ItemStack Welt2 = new ItemStack(Material.RED_CONCRETE);
            ItemMeta itemMeta4 = Welt2.getItemMeta();
            itemMeta4.setDisplayName("§6§lChallenge-Welt-2");
            itemMeta4.setLore(Arrays.asList(" ", "§4\u2715 §c§lWelt inaktiv! §4\u2715", " "));
            Welt2.setItemMeta(itemMeta4);
            Welt2.setAmount(1);
            WeltenOrdner.setItem(12, Welt2);
        } else if (Bukkit.getWorld("Challenge-2") != null) {
            ItemStack Welt2 = new ItemStack(Material.RED_CONCRETE);
            ItemMeta itemMeta4 = Welt2.getItemMeta();
            itemMeta4.setDisplayName("§6§lChallenge-Welt-2");
            itemMeta4.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta4.setLore(Arrays.asList(" ", "§a\u2714 §c§lWelt aktiv! §a\u2714", " "));
            Welt2.setItemMeta(itemMeta4);
            Welt2.setAmount(1);
            WeltenOrdner.setItem(12, Welt2);
        }

        if (Bukkit.getWorld("Challenge-3") == null) {
            ItemStack Welt3 = new ItemStack(Material.BLUE_CONCRETE);
            ItemMeta itemMeta5 = Welt3.getItemMeta();
            itemMeta5.setDisplayName("§6§lChallenge-Welt-3");
            itemMeta5.setLore(Arrays.asList(" ", "§4\u2715 §c§lWelt inaktiv! §4\u2715", " "));
            Welt3.setItemMeta(itemMeta5);
            Welt3.setAmount(1);
            WeltenOrdner.setItem(13, Welt3);
        } else if (Bukkit.getWorld("Challenge-3") != null) {
            ItemStack Welt3 = new ItemStack(Material.BLUE_CONCRETE);
            ItemMeta itemMeta5 = Welt3.getItemMeta();
            itemMeta5.setDisplayName("§6§lChallenge-Welt-3");
            itemMeta5.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta5.setLore(Arrays.asList(" ", "§a\u2714 §c§lWelt aktiv! §a\u2714", " "));
            Welt3.setItemMeta(itemMeta5);
            Welt3.setAmount(1);
            WeltenOrdner.setItem(13, Welt3);
        }

        if (Bukkit.getWorld("Challenge-4") == null) {
            ItemStack Welt4 = new ItemStack(Material.GREEN_CONCRETE);
            ItemMeta itemMeta6 = Welt4.getItemMeta();
            itemMeta6.setDisplayName("§6§lChallenge-Welt-4");
            itemMeta6.setLore(Arrays.asList(" ", "§4\u2715 §c§lWelt inaktiv! §4\u2715", " "));
            Welt4.setItemMeta(itemMeta6);
            Welt4.setAmount(1);
            WeltenOrdner.setItem(14, Welt4);
        } else if (Bukkit.getWorld("Challenge-4") != null) {
            ItemStack Welt4 = new ItemStack(Material.GREEN_CONCRETE);
            ItemMeta itemMeta6 = Welt4.getItemMeta();
            itemMeta6.setDisplayName("§6§lChallenge-Welt-4");
            itemMeta6.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta6.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta6.setLore(Arrays.asList(" ", "§a\u2714 §c§lWelt aktiv! §a\u2714", " "));
            Welt4.setItemMeta(itemMeta6);
            Welt4.setAmount(1);
            WeltenOrdner.setItem(14, Welt4);
        }

        if (Bukkit.getWorld("Challenge-5") == null) {
            ItemStack Welt5 = new ItemStack(Material.BLACK_CONCRETE);
            ItemMeta itemMeta7 = Welt5.getItemMeta();
            itemMeta7.setDisplayName("§6§lChallenge-Welt-5");
            itemMeta7.setLore(Arrays.asList(" ", "§4\u2715 §c§lWelt inaktiv! §4\u2715", " "));
            Welt5.setItemMeta(itemMeta7);
            Welt5.setAmount(1);
            WeltenOrdner.setItem(15, Welt5);
        } else if (Bukkit.getWorld("Challenge-5") != null) {
            ItemStack Welt5 = new ItemStack(Material.BLACK_CONCRETE);
            ItemMeta itemMeta7 = Welt5.getItemMeta();
            itemMeta7.setDisplayName("§6§lChallenge-Welt-5");
            itemMeta7.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            itemMeta7.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta7.setLore(Arrays.asList(" ", "§a\u2714 §c§lWelt aktiv! §a\u2714", " "));
            Welt5.setItemMeta(itemMeta7);
            Welt5.setAmount(1);
            WeltenOrdner.setItem(15, Welt5);
        }
        ItemStack Zurück = new ItemStack(Material.BARRIER);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7Letzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        WeltenOrdner.setItem(26, Zurück);

        ItemStack Modes = new ItemStack(Material.PAPER);
        ItemMeta itemMetaM = Modes.getItemMeta();
        itemMetaM.setDisplayName("§6§lSpiel-Modi-Auswahl!");
        itemMetaM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        itemMetaM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMetaM.setLore(Arrays.asList(" ", "§7Zeigt die Spiel-Modi-Auswahl!", " "));
        Modes.setItemMeta(itemMetaM);
        Modes.setAmount(1);
        inventory.setItem(15, Modes);


        inventory.setItem(11, Bingo);
        inventory.setItem(13, Welten);
        player.openInventory(inventory);

    }

    public void openCW1(Player player) {

        if (Bukkit.getWorld("Challenge-1") != null) {
            ItemStack CreateCW1 = new ItemStack(Material.GREEN_CONCRETE);
            ItemMeta IMCCW1 = CreateCW1.getItemMeta();
            IMCCW1.setDisplayName("§6§lChallenge-Welt-1 -> Online §a\u2714");
            IMCCW1.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            IMCCW1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            IMCCW1.setLore(Arrays.asList(" ", "§7§oTeleportiere dich ->", "§7§oLösche die Welt -->", " "));
            CreateCW1.setItemMeta(IMCCW1);
            CreateCW1.setAmount(1);
            InvCW1.setItem(12, CreateCW1);
        } else if (Bukkit.getWorld("Challenge-1") == null) {
            ItemStack CreateCW1 = new ItemStack(Material.GREEN_CONCRETE);
            ItemMeta IMCCW1 = CreateCW1.getItemMeta();
            IMCCW1.setDisplayName("§6§lCreate Challenge-Welt-1");
            IMCCW1.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oErstellt die Challenge-Welt-1", " "));
            CreateCW1.setItemMeta(IMCCW1);
            CreateCW1.setAmount(1);
            InvCW1.setItem(12, CreateCW1);
        }

        ItemStack TPCW1 = new ItemStack(Material.WHITE_CONCRETE);
        ItemMeta IMOCW1 = TPCW1.getItemMeta();
        IMOCW1.setDisplayName("§6§lTeleport Challenge-Welt-1");
        IMOCW1.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oTeleportiert dich in die Challenge-Welt-1", " "));
        TPCW1.setItemMeta(IMOCW1);
        TPCW1.setAmount(1);
        InvCW1.setItem(13, TPCW1);

        ItemStack DeleteCW1 = new ItemStack(Material.RED_CONCRETE);
        ItemMeta IMDCW1 = DeleteCW1.getItemMeta();
        IMDCW1.setDisplayName("§6§lDelete Challenge-Welt-1");
        IMDCW1.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oLöscht die Challenge-Welt-1", " "));
        DeleteCW1.setItemMeta(IMDCW1);
        DeleteCW1.setAmount(1);
        InvCW1.setItem(14, DeleteCW1);

        ItemStack Zurück = new ItemStack(Material.BARRIER);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7Letzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW1.setItem(26, Zurück);

        player.openInventory(InvCW1);
    }

    public void openCW2(Player player) {

        if (Bukkit.getWorld("Challenge-2") != null) {
            ItemStack Create = new ItemStack(Material.GREEN_CONCRETE);
            ItemMeta IMC = Create.getItemMeta();
            IMC.setDisplayName("§6§lChallenge-Welt-2 -> Online §a\u2714");
            IMC.setLore(Arrays.asList(" ", "§7§oTeleportiere dich ->", "§7§oLösche die Welt -->", " "));
            Create.setItemMeta(IMC);
            Create.setAmount(1);
            InvCW2.setItem(12, Create);
        } else if (Bukkit.getWorld("Challenge-2") == null) {
            ItemStack Create = new ItemStack(Material.GREEN_CONCRETE);
            ItemMeta IMC = Create.getItemMeta();
            IMC.setDisplayName("§6§lCreate Challenge-Welt-2");
            IMC.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oErstellt die Challenge-Welt-2", " "));
            Create.setItemMeta(IMC);
            Create.setAmount(1);
            InvCW2.setItem(12, Create);
        }
        ItemStack TP = new ItemStack(Material.WHITE_CONCRETE);
        ItemMeta IMO = TP.getItemMeta();
        IMO.setDisplayName("§6§lTeleport Challenge-Welt-2");
        IMO.setLore(Arrays.asList("§7§oDurch Klick -> ", "§7§oTeleportiert dich in die Challenge-Welt-2"));
        TP.setItemMeta(IMO);
        TP.setAmount(1);
        InvCW2.setItem(13, TP);

        ItemStack Delete = new ItemStack(Material.RED_CONCRETE);
        ItemMeta IMD = Delete.getItemMeta();
        IMD.setDisplayName("§6§lDelete Challenge-Welt-2");
        IMD.setLore(Arrays.asList("§7§oDurch Klick -> ", "§7§oLöscht die Challenge-Welt-2"));
        Delete.setItemMeta(IMD);
        Delete.setAmount(1);
        InvCW2.setItem(14, Delete);

        ItemStack Zurück = new ItemStack(Material.BARRIER);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList("§7Letzte Menü-Seite"));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW2.setItem(26, Zurück);

        player.openInventory(InvCW2);

    }

    public void openCW3(Player player) {

        ItemStack Create = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta IMC = Create.getItemMeta();
        IMC.setDisplayName("§6§lCreate Challenge-Welt-3");
        IMC.setLore(Arrays.asList("§7§oDurch Klick -> ", "§7§oErstellt die Challenge-Welt-3"));
        Create.setItemMeta(IMC);
        Create.setAmount(1);
        InvCW3.setItem(12, Create);

        ItemStack TP = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta IMO = TP.getItemMeta();
        IMO.setDisplayName("§6§lTeleport Challenge-Welt-3");
        IMO.setLore(Arrays.asList("§7§oDurch Klick -> ", "§7§oTeleportiert dich in die Challenge-Welt-3"));
        TP.setItemMeta(IMO);
        TP.setAmount(1);
        InvCW3.setItem(13, TP);

        ItemStack Delete = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta IMD = Delete.getItemMeta();
        IMD.setDisplayName("§6§lDelete Challenge-Welt-3");
        IMD.setLore(Arrays.asList("§7§oDurch Klick -> ", "§7§oLöscht die Challenge-Welt-3"));
        Delete.setItemMeta(IMD);
        Delete.setAmount(1);
        InvCW3.setItem(14, Delete);

        ItemStack Zurück = new ItemStack(Material.BARRIER);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList("§7Letzte Menü-Seite"));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW3.setItem(26, Zurück);

        player.openInventory(InvCW3);

    }

    public void openCW4(Player player) {

        ItemStack Create = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta IMC = Create.getItemMeta();
        IMC.setDisplayName("§6§lCreate Challenge-Welt-4");
        IMC.setLore(Arrays.asList("§7§oDurch Klick -> ", "§7§oErstellt die Challenge-Welt-4"));
        Create.setItemMeta(IMC);
        Create.setAmount(1);
        InvCW4.setItem(12, Create);

        ItemStack TP = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta IMO = TP.getItemMeta();
        IMO.setDisplayName("§6§lTeleport Challenge-Welt-4");
        IMO.setLore(Arrays.asList("§7§oDurch Klick -> ", "§7§oTeleportiert dich in die Challenge-Welt-4"));
        TP.setItemMeta(IMO);
        TP.setAmount(1);
        InvCW4.setItem(13, TP);

        ItemStack Delete = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta IMD = Delete.getItemMeta();
        IMD.setDisplayName("§6§lDelete Challenge-Welt-4");
        IMD.setLore(Arrays.asList("§7§oDurch Klick -> ", "§7§oLöscht die Challenge-Welt-4"));
        Delete.setItemMeta(IMD);
        Delete.setAmount(1);
        InvCW4.setItem(14, Delete);

        ItemStack Zurück = new ItemStack(Material.BARRIER);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList("§7Letzte Menü-Seite"));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW4.setItem(26, Zurück);

        player.openInventory(InvCW4);

    }

    public void openCW5(Player player) {

        ItemStack Create = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta IMC = Create.getItemMeta();
        IMC.setDisplayName("§6§lCreate Challenge-Welt-5");
        IMC.setLore(Arrays.asList("§7§oDurch Klick -> ", "§7§oErstellt die Challenge-Welt-5"));
        Create.setItemMeta(IMC);
        Create.setAmount(1);
        InvCW5.setItem(12, Create);

        ItemStack TP = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta IMO = TP.getItemMeta();
        IMO.setDisplayName("§6§lTeleport Challenge-Welt-5");
        IMO.setLore(Arrays.asList("§7§oDurch Klick -> ", "§7§oTeleportiert dich in die Challenge-Welt-5"));
        TP.setItemMeta(IMO);
        TP.setAmount(1);
        InvCW5.setItem(13, TP);

        ItemStack Delete = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta IMD = Delete.getItemMeta();
        IMD.setDisplayName("§6§lDelete Challenge-Welt-5");
        IMD.setLore(Arrays.asList("§7§oDurch Klick -> ", "§7§oLöscht die Challenge-Welt-5"));
        Delete.setItemMeta(IMD);
        Delete.setAmount(1);
        InvCW5.setItem(14, Delete);

        ItemStack Zurück = new ItemStack(Material.BARRIER);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList("§7Letzte Menü-Seite"));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW5.setItem(26, Zurück);

        player.openInventory(InvCW5);

    }


    //RightClick on Book(Navi)
    @EventHandler
    public void handleNavigatorOpener(PlayerInteractEvent event) {
        if (event.getItem().getItemMeta().getDisplayName() != "§6§lNavigator" && event.getItem().getType() != Material.BOOK) return;
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            openGUI(event.getPlayer());
            Player player = (Player) event.getPlayer();
            player.sendMessage("§aServer " + "§8>> " + "§aDir wurde der Navigator geöffnet!");
        }

    }

    //Was tun wenn Click im Navi
    @EventHandler
    public void handleNavigatorGUIClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(GUI_NAME)) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case ENCHANTED_GOLDEN_APPLE:
                    Bukkit.dispatchCommand(player, "startbingo");
                    player.closeInventory();
                    break;
                case END_PORTAL_FRAME:
                    player.openInventory(WeltenOrdner);
                    //player.sendMessage("§aServer " + "§8>> " + "§aDir wurde die Welten-Auswahl geöffnet!");
                    break;
                case PAPER:
                    gl.openGUI(player.getPlayer());
                    //player.sendMessage(Main.getPlugin().PREFIX + "§aDir wurde die Spiel-Modi-Auswahl geöffnet!");
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


        World world2 = Bukkit.getWorld("Challenge-2");
        World world3 = Bukkit.getWorld("Challenge-3");
        World world4 = Bukkit.getWorld("Challenge-4");
        World world5 = Bukkit.getWorld("Challenge-5");

        if (event.getView().getTitle().equals(GUI_NAME2)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case WHITE_CONCRETE:

                    openCW1(player.getPlayer());
                    break;

                case RED_CONCRETE:

                    openCW2(player.getPlayer());
                    break;

                case BLUE_CONCRETE:

                    if (Bukkit.getWorld("Challenge-3") != null) {
                        Location location3 = world3.getSpawnLocation();
                        location3.setY(world3.getHighestBlockYAt(location3) + 1);
                        player.teleport(location3);
                        player.getInventory().clear();
                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: Challenge-Welt-3!");
                    } else {
                        player.sendMessage("§aServer " + "§8>> " + "§cEs existiert keine Challenge-Welt-3!");
                        player.closeInventory();
                        break;
                    }
                    break;

                case GREEN_CONCRETE:

                    if (Bukkit.getWorld("Challenge-4") != null) {
                        Location location4 = world4.getSpawnLocation();
                        location4.setY(world4.getHighestBlockYAt(location4) + 1);
                        player.teleport(location4);
                        player.getInventory().clear();
                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: Challenge-Welt-4!");
                    } else {
                        player.sendMessage("§aServer " + "§8>> " + "§cEs existiert keine Challenge-Welt-4!");
                        player.closeInventory();
                        break;
                    }
                    break;

                case BLACK_CONCRETE:

                    if (Bukkit.getWorld("Challenge-5") != null) {
                        Location location5 = world5.getSpawnLocation();
                        location5.setY(world5.getHighestBlockYAt(location5) + 1);
                        player.teleport(location5);
                        player.getInventory().clear();
                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: Challenge-Welt-5!");
                    } else {
                        player.sendMessage("§aServer " + "§8>> " + "§cEs existiert keine Challenge-Welt-5!");
                        player.closeInventory();
                        break;
                    }
                    break;
                case BARRIER:

                    player.openInventory(inventory);
                    break;

                default:
                    break;
            }
        }
    }

    @EventHandler
    public void handleNavigatorGUIClick3(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        World world1 = Bukkit.getWorld("Challenge-1");
        World world;
        World hub = Bukkit.getWorld("world");
        Location lochub = new Location(hub, 0.5, 75, 0.5);
        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§6§lNavigator");
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(itemMeta);
        item.setAmount(1);

        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(CW1)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case GREEN_CONCRETE:

                    if (Bukkit.getWorld("Challenge-1") == null) {
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§cChallenge-Welt-1 wird erstellt!");
                        WorldCreator c1 = new WorldCreator("Challenge-1");
                        c1.type(WorldType.NORMAL);
                        c1.generateStructures(true);
                        world = c1.createWorld();
                        player.sendMessage(Main.getPlugin().PREFIX + "§cChallenge-Welt-1 wurde erstellt!");
                        openCW1(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-1") != null) {
                        break;
                    }
                    break;

                case WHITE_CONCRETE:

                    if (Bukkit.getWorld("Challenge-1") != null) {
                        Location location1 = world1.getSpawnLocation();
                        location1.setY(world1.getHighestBlockYAt(location1) + 1);
                        player.teleport(location1);
                        player.getInventory().clear();
                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Challenge-Welt-1!");
                    } else {
                        player.sendMessage("§aServer " + "§8>> " + "§cEs existiert keine Challenge-Welt-1!");
                        break;
                    }
                    break;

                case RED_CONCRETE:

                    if (Bukkit.getWorld("Challenge-1") != null) {
                        player.closeInventory();
                        //HUB-Teleport
                        if (player.getWorld() != hub) {
                            player.teleport(lochub);
                            //Navigator
                            player.getInventory().setItem(4, item);
                            //Gamemode
                            player.setGameMode(GameMode.ADVENTURE);
                        }
                        //Welt-Löschen
                        File challenge = new File("Challenge-1");
                        if (challenge.exists()) {

                            Bukkit.unloadWorld("Challenge-1", true);

                            File data = new File("Challenge-1\\data");
                            if (data.exists()) {
                                for (File files1 : data.listFiles()) {
                                    files1.delete();
                                }
                                data.delete();
                            }

                            File playerdata = new File("Challenge-1\\playerdata");
                            if (playerdata.exists()) {
                                for (File files2 : playerdata.listFiles()) {
                                    files2.delete();
                                }
                                playerdata.delete();
                            }

                            File poi = new File("Challenge-1\\poi");
                            if (poi.exists()) {
                                for (File files3 : poi.listFiles()) {
                                    files3.delete();
                                }
                                poi.delete();
                            }

                            File region = new File("Challenge-1\\region");
                            if (region.exists()) {
                                for (File files4 : region.listFiles()) {
                                    files4.delete();
                                }
                                region.delete();
                            }

                            for (File files5 : challenge.listFiles()) {
                                files5.delete();
                            }
                            challenge.delete();
                        }
                        player.sendMessage("§aServer " + "§8>> " + "§cChallenge-Welt-1 wurde gelöscht!");
                        openCW1(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-1") == null) {
                        player.sendMessage(Main.getPlugin().PREFIX + "§cEs existiert keine Challenge-Welt-1!");
                        break;
                    }
                    break;

                case BARRIER:

                    player.openInventory(WeltenOrdner);
                    break;

                default:
                    break;
            }
        }

    }

    @EventHandler
    public void handleNavigatorGUIClick4(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        World world1 = Bukkit.getWorld("Challenge-2");
        World world;

        World hub = Bukkit.getWorld("world");
        Location lochub = new Location(hub, 0.5, 75, 0.5);

        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§6§lNavigator");
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(itemMeta);
        item.setAmount(1);

        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(CW2)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case GREEN_CONCRETE:

                    if (Bukkit.getWorld("Challenge-2") == null) {
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§cChallenge-Welt-2 wird erstellt!");
                        WorldCreator c1 = new WorldCreator("Challenge-2");
                        c1.type(WorldType.NORMAL);
                        c1.generateStructures(true);
                        world = c1.createWorld();
                        player.sendMessage(Main.getPlugin().PREFIX + "§cChallenge-Welt-2 wurde erstellt!");
                        openCW2(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-2") != null) {
                        break;
                    }
                    break;

                case WHITE_CONCRETE:

                    if (Bukkit.getWorld("Challenge-2") != null) {
                        Location location1 = world1.getSpawnLocation();
                        location1.setY(world1.getHighestBlockYAt(location1) + 1);
                        player.teleport(location1);
                        player.getInventory().clear();
                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: Challenge-Welt-2!");
                    } else {
                        player.sendMessage("§aServer " + "§8>> " + "§cEs existiert keine Challenge-Welt-2!");
                        break;
                    }
                    break;

                case RED_CONCRETE:
                    if (Bukkit.getWorld("Challenge-2") != null) {
                        player.closeInventory();
                        //HUB-Teleport
                        if (player.getWorld() != hub) {
                            player.teleport(lochub);
                            //Navigator
                            player.getInventory().setItem(4, item);
                            //Gamemode
                            player.setGameMode(GameMode.ADVENTURE);
                        }
                        //Welt-Löschen
                        File challenge2 = new File("Challenge-2");
                        if (challenge2.exists()) {

                            Bukkit.unloadWorld("Challenge-2", true);

                            File data2 = new File("Challenge-2\\data");
                            if (data2.exists()) {
                                for (File files1 : data2.listFiles()) {
                                    files1.delete();
                                }
                                data2.delete();
                            }

                            File playerdata2 = new File("Challenge-2\\playerdata");
                            if (playerdata2.exists()) {
                                for (File files2 : playerdata2.listFiles()) {
                                    files2.delete();
                                }
                                playerdata2.delete();
                            }

                            File poi2 = new File("Challenge-2\\poi");
                            if (poi2.exists()) {
                                for (File files3 : poi2.listFiles()) {
                                    files3.delete();
                                }
                                poi2.delete();
                            }

                            File region2 = new File("Challenge-2\\region");
                            if (region2.exists()) {
                                for (File files4 : region2.listFiles()) {
                                    files4.delete();
                                }
                                region2.delete();
                            }

                            for (File files5 : challenge2.listFiles()) {
                                files5.delete();
                            }
                            challenge2.delete();
                        }
                        player.sendMessage("§aServer " + "§8>> " + "§cChallenge-Welt-2 wurde gelöscht!");
                        openCW2(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-1") == null) {
                        player.sendMessage(Main.getPlugin().PREFIX + "§cEs existiert keine Challenge-Welt-1!");
                        break;
                    }
                    break;

                case BARRIER:

                    player.openInventory(WeltenOrdner);
                    break;

                default:
                    break;
            }
        }

    }

    @EventHandler
    public void handleNavigatorGUIClick5(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(CW3)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case GREEN_STAINED_GLASS_PANE:
                    player.sendMessage("green");
                    break;

                case WHITE_STAINED_GLASS_PANE:
                    player.sendMessage("white");
                    break;

                case RED_STAINED_GLASS_PANE:
                    player.sendMessage("red");
                    break;

                case BARRIER:

                    player.openInventory(WeltenOrdner);
                    break;

                default:
                    break;
            }
        }

    }

    @EventHandler
    public void handleNavigatorGUIClick6(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(CW4)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case GREEN_STAINED_GLASS_PANE:
                    player.sendMessage("green");
                    break;

                case WHITE_STAINED_GLASS_PANE:
                    player.sendMessage("white");
                    break;

                case RED_STAINED_GLASS_PANE:
                    player.sendMessage("red");
                    break;

                case BARRIER:

                    player.openInventory(WeltenOrdner);
                    break;

                default:
                    break;
            }
        }

    }

    @EventHandler
    public void handleNavigatorGUIClick7(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(CW5)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case GREEN_STAINED_GLASS_PANE:
                    player.sendMessage("green");
                    break;

                case WHITE_STAINED_GLASS_PANE:
                    player.sendMessage("white");
                    break;

                case RED_STAINED_GLASS_PANE:
                    player.sendMessage("red");
                    break;

                case BARRIER:

                    player.openInventory(WeltenOrdner);
                    break;

                default:
                    break;
            }
        }

    }

    @EventHandler
    public void handleNavigatorGUIClick8(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (player.getWorld() == Bukkit.getWorld("world")) {
            if (event.getSlotType() == SlotType.QUICKBAR) {
                event.setCancelled(true);
                switch (event.getCurrentItem().getType()) {
                    case BOOK:
                        event.setCancelled(true);
                        break;
                    default:
                        break;
                }

            }
        }

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld() == Bukkit.getWorld("world")) {
            if (event.getItemDrop().getItemStack().getType() == Material.BOOK) {
                event.setCancelled(true);
            }
        }
    }


}
