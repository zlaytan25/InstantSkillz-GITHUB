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

    private final String GUI_NAME = "§6Navigator";
    private final String GUI_NAME2 = "§6Challenge-Welten";
    private final String CW1 = "§6Welt 1";
    private final String CW2 = "§6Welt 2";
    private final String CW3 = "§6Welt 3";
    private final String CW4 = "§6Welt 4";
    private final String OCW1 = "§6Einstellungen Welt 1";

    //Navi
    Inventory inventory = Bukkit.createInventory(null, 9 * 5, GUI_NAME);
    Inventory WeltenOrdner = Bukkit.createInventory(null, 9 * 5, GUI_NAME2);

    Inventory InvCW1 = Bukkit.createInventory(null, 9 * 5, CW1);
    Inventory InvCW2 = Bukkit.createInventory(null, 9 * 5, CW2);
    Inventory InvCW3 = Bukkit.createInventory(null, 9 * 5, CW3);
    Inventory InvCW4 = Bukkit.createInventory(null, 9 * 5, CW4);

    Inventory OptionsCW1 = Bukkit.createInventory(null, 9 * 6, OCW1);


    private GameModeListener gl = new GameModeListener();

    public void openGUI(Player player) {

        //Item im Navi

        inventory.setItem(28, Main.getBingoHead("BINGO"));

        ItemStack PlatzHalter = new ItemStack(Material.BEDROCK);
        ItemMeta imp = PlatzHalter.getItemMeta();
        imp.setDisplayName("§cPlatzhalter");
        imp.setLore(Arrays.asList(" ", "§7§oPlatz für Zukünftige Mini-Games!", " "));
        PlatzHalter.setItemMeta(imp);
        PlatzHalter.setAmount(1);
        inventory.setItem(30, PlatzHalter);
        ItemStack PlatzHalter2 = new ItemStack(Material.BEDROCK);
        PlatzHalter2.setItemMeta(imp);
        PlatzHalter2.setAmount(1);
        inventory.setItem(32, PlatzHalter2);
        ItemStack PlatzHalter3 = new ItemStack(Material.BEDROCK);
        PlatzHalter3.setItemMeta(imp);
        PlatzHalter3.setAmount(1);
        inventory.setItem(34, PlatzHalter3);

        ItemStack ChallengeAuswahl = new ItemStack(Material.NETHER_STAR);
        ItemMeta imca = ChallengeAuswahl.getItemMeta();
        imca.setDisplayName("§cChallenges");
        imca.setLore(Arrays.asList(" ", "§7§oEine Übersicht mit allen Challenge-Welten!", " "));
        ChallengeAuswahl.setItemMeta(imca);
        ChallengeAuswahl.setAmount(1);
        inventory.setItem(13, ChallengeAuswahl);

        ItemStack Welten = new ItemStack(Material.END_PORTAL_FRAME);
        ItemMeta itemMeta2 = Welten.getItemMeta();
        itemMeta2.setDisplayName("§cChallenge-Welten");
        itemMeta2.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        itemMeta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta2.setLore(Arrays.asList(" ", "§7§oEine Übersicht mit allen Challenge-Welten!", " "));
        Welten.setItemMeta(itemMeta2);
        Welten.setAmount(1);


        ItemStack Modes = new ItemStack(Material.PAPER);
        ItemMeta itemMetaM = Modes.getItemMeta();
        itemMetaM.setDisplayName("§6§lSpiel-Modi-Auswahl!");
        itemMetaM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        itemMetaM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMetaM.setLore(Arrays.asList(" ", "§7Zeigt die Spiel-Modi-Auswahl!", " "));
        Modes.setItemMeta(itemMetaM);
        Modes.setAmount(1);
        inventory.setItem(2, Modes);

        inventory.setItem(1, Welten);
        player.openInventory(inventory);

    }

    public void openGUI2(Player player) {

        ItemStack deko = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta d = deko.getItemMeta();
        d.setDisplayName(" ");
        deko.setItemMeta(d);
        deko.setAmount(1);
        WeltenOrdner.setItem(0, deko);
        ItemStack deko2 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko2.setItemMeta(d);
        deko2.setAmount(1);
        WeltenOrdner.setItem(1, deko2);
        ItemStack deko3 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko3.setItemMeta(d);
        deko3.setAmount(1);
        WeltenOrdner.setItem(2, deko3);
        ItemStack deko4 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko4.setItemMeta(d);
        deko4.setAmount(1);
        WeltenOrdner.setItem(3, deko4);
        ItemStack deko5 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko5.setItemMeta(d);
        deko5.setAmount(1);
        WeltenOrdner.setItem(5, deko5);
        ItemStack deko6 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko6.setItemMeta(d);
        deko6.setAmount(1);
        WeltenOrdner.setItem(6, deko6);
        ItemStack deko7 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko7.setItemMeta(d);
        deko7.setAmount(1);
        WeltenOrdner.setItem(7, deko7);
        ItemStack deko8 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko8.setItemMeta(d);
        deko8.setAmount(1);
        WeltenOrdner.setItem(8, deko8);
        ItemStack deko9 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko9.setItemMeta(d);
        deko9.setAmount(1);
        WeltenOrdner.setItem(9, deko9);
        ItemStack deko10 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko10.setItemMeta(d);
        deko10.setAmount(1);
        WeltenOrdner.setItem(11, deko10);
        ItemStack deko11 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko11.setItemMeta(d);
        deko11.setAmount(1);
        WeltenOrdner.setItem(13, deko11);
        ItemStack deko12 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko12.setItemMeta(d);
        deko12.setAmount(1);
        WeltenOrdner.setItem(15, deko12);
        ItemStack deko13 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko13.setItemMeta(d);
        deko13.setAmount(1);
        WeltenOrdner.setItem(17, deko13);

        for (int k = 37; k < 45; k++) {
            ItemStack deko14 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            deko14.setItemMeta(d);
            deko14.setAmount(1);
            WeltenOrdner.setItem(k, deko14);
        }

        if (Bukkit.getWorld("Challenge-1") != null) {
            ItemStack wa = new ItemStack(Material.GREEN_DYE);
            ItemMeta imwa = wa.getItemMeta();
            imwa.setDisplayName("§a\u2714 §2§lWelt aktiv! §a\u2714");
            wa.setItemMeta(imwa);
            wa.setAmount(1);
            WeltenOrdner.setItem(19, wa);
        } else {
            ItemStack wa = new ItemStack(Material.GRAY_DYE);
            ItemMeta imwa = wa.getItemMeta();
            imwa.setDisplayName("§4\u2715 §c§lWelt inaktiv! §4\u2715");
            wa.setItemMeta(imwa);
            wa.setAmount(1);
            WeltenOrdner.setItem(19, wa);
        }


        ItemStack ChallengeAuswahl = new ItemStack(Material.NETHER_STAR);
        ItemMeta imca = ChallengeAuswahl.getItemMeta();
        imca.setDisplayName("§cChallenges");
        ChallengeAuswahl.setItemMeta(imca);
        ChallengeAuswahl.setAmount(1);
        WeltenOrdner.setItem(4, ChallengeAuswahl);


        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7Letzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        WeltenOrdner.setItem(36, Zurück);

        WeltenOrdner.setItem(10, Main.getGlobeSkull1("GLOBE1"));
        WeltenOrdner.setItem(12, Main.getGlobeSkull1("GLOBE1"));
        WeltenOrdner.setItem(14, Main.getGlobeSkull1("GLOBE1"));
        WeltenOrdner.setItem(16, Main.getGlobeSkull1("GLOBE1"));
        player.openInventory(WeltenOrdner);

    }

    public void openCW1(Player player) {

        InvCW1.setItem(4, Main.getGlobeSkull1("GLOBE1"));

        ItemStack deko = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta d = deko.getItemMeta();
        d.setDisplayName(" ");
        deko.setItemMeta(d);
        deko.setAmount(1);
        InvCW1.setItem(0, deko);
        ItemStack deko2 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko2.setItemMeta(d);
        deko2.setAmount(1);
        InvCW1.setItem(1, deko2);
        ItemStack deko3 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko3.setItemMeta(d);
        deko3.setAmount(1);
        InvCW1.setItem(2, deko3);
        ItemStack deko4 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko4.setItemMeta(d);
        deko4.setAmount(1);
        InvCW1.setItem(3, deko4);
        ItemStack deko5 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko5.setItemMeta(d);
        deko5.setAmount(1);
        InvCW1.setItem(5, deko5);
        ItemStack deko6 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko6.setItemMeta(d);
        deko6.setAmount(1);
        InvCW1.setItem(6, deko6);
        ItemStack deko7 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko7.setItemMeta(d);
        deko7.setAmount(1);
        InvCW1.setItem(7, deko7);
        ItemStack deko8 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        deko8.setItemMeta(d);
        deko8.setAmount(1);
        InvCW1.setItem(8, deko8);
        ItemStack deko9 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko9.setItemMeta(d);
        deko9.setAmount(1);
        InvCW1.setItem(10, deko9);
        ItemStack deko10 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko10.setItemMeta(d);
        deko10.setAmount(1);
        InvCW1.setItem(11, deko10);
        ItemStack deko11 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko11.setItemMeta(d);
        deko11.setAmount(1);
        InvCW1.setItem(16, deko11);

        for (int k = 37; k < 45; k++) {
            ItemStack deko14 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            deko14.setItemMeta(d);
            deko14.setAmount(1);
            InvCW1.setItem(k, deko14);
        }

        ItemStack wl = new ItemStack(Material.BARRIER);
        ItemMeta imwl = wl.getItemMeta();
        imwl.setDisplayName("§cWelt 1 löschen!");
        imwl.setLore(Arrays.asList(" ", "§7Diese Aktion kann nicht rückgängig gemacht werden!", " "));
        wl.setItemMeta(imwl);
        wl.setAmount(1);
        InvCW1.setItem(19, wl);

        ItemStack wo = new ItemStack(Material.REPEATER);
        ItemMeta imwo = wo.getItemMeta();
        imwo.setDisplayName("§6Challenge Einstellungen");
        imwo.setLore(Arrays.asList(" ", "§7Konfiguriere die Challenge nach deinem Willen!", " "));
        wo.setItemMeta(imwo);
        wo.setAmount(1);
        InvCW1.setItem(20, wo);

        ItemStack wt = new ItemStack(Material.ENDER_PEARL);
        ItemMeta imwt = wt.getItemMeta();
        imwt.setDisplayName("§aTeleport Welt 1");
        imwt.setLore(Arrays.asList(" ", "§7Teleportiert dich in Welt 1!", " "));
        wt.setItemMeta(imwt);
        wt.setAmount(1);
        InvCW1.setItem(25, wt);

        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7Letzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW1.setItem(36, Zurück);

        player.openInventory(InvCW1);
    }

    public void openCW2(Player player) {

        if (Bukkit.getWorld("Challenge-2") != null) {
            ItemStack Create = new ItemStack(Material.GREEN_CONCRETE);
            ItemMeta IMC = Create.getItemMeta();
            IMC.setDisplayName("§6§lChallenge-Welt-2 -> Online §a\u2714");
            IMC.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            IMC.addItemFlags(ItemFlag.HIDE_ENCHANTS);
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
        IMO.setLore(Arrays.asList("§7§oDurch Klick -> ", "§7§oTeleportiert dich in die Challenge-Welt-2", " "));
        TP.setItemMeta(IMO);
        TP.setAmount(1);
        InvCW2.setItem(13, TP);

        ItemStack Delete = new ItemStack(Material.RED_CONCRETE);
        ItemMeta IMD = Delete.getItemMeta();
        IMD.setDisplayName("§6§lDelete Challenge-Welt-2");
        IMD.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oLöscht die Challenge-Welt-2", " "));
        Delete.setItemMeta(IMD);
        Delete.setAmount(1);
        InvCW2.setItem(14, Delete);

        ItemStack Zurück = new ItemStack(Material.BARRIER);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7Letzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW2.setItem(26, Zurück);

        player.openInventory(InvCW2);

    }

    public void openCW3(Player player) {

        if (Bukkit.getWorld("Challenge-3") != null) {
            ItemStack Create = new ItemStack(Material.GREEN_CONCRETE);
            ItemMeta IMC = Create.getItemMeta();
            IMC.setDisplayName("§6§lChallenge-Welt-3 -> Online §a\u2714");
            IMC.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            IMC.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            IMC.setLore(Arrays.asList(" ", "§7§oTeleportiere dich ->", "§7§oLösche die Welt -->", " "));
            Create.setItemMeta(IMC);
            Create.setAmount(1);
            InvCW3.setItem(12, Create);
        } else if (Bukkit.getWorld("Challenge-3") == null) {
            ItemStack Create = new ItemStack(Material.GREEN_CONCRETE);
            ItemMeta IMC = Create.getItemMeta();
            IMC.setDisplayName("§6§lCreate Challenge-Welt-3");
            IMC.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oErstellt die Challenge-Welt-3", " "));
            Create.setItemMeta(IMC);
            Create.setAmount(1);
            InvCW3.setItem(12, Create);
        }

        ItemStack TP = new ItemStack(Material.WHITE_CONCRETE);
        ItemMeta IMO = TP.getItemMeta();
        IMO.setDisplayName("§6§lTeleport Challenge-Welt-3");
        IMO.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oTeleportiert dich in die Challenge-Welt-3", " "));
        TP.setItemMeta(IMO);
        TP.setAmount(1);
        InvCW3.setItem(13, TP);

        ItemStack Delete = new ItemStack(Material.RED_CONCRETE);
        ItemMeta IMD = Delete.getItemMeta();
        IMD.setDisplayName("§6§lDelete Challenge-Welt-3");
        IMD.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oLöscht die Challenge-Welt-3", " "));
        Delete.setItemMeta(IMD);
        Delete.setAmount(1);
        InvCW3.setItem(14, Delete);

        ItemStack Zurück = new ItemStack(Material.BARRIER);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7Letzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW3.setItem(26, Zurück);

        player.openInventory(InvCW3);

    }

    public void openCW4(Player player) {

        if (Bukkit.getWorld("Challenge-4") != null) {
            ItemStack Create = new ItemStack(Material.GREEN_CONCRETE);
            ItemMeta IMC = Create.getItemMeta();
            IMC.setDisplayName("§6§lChallenge-Welt-4 -> Online §a\u2714");
            IMC.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            IMC.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            IMC.setLore(Arrays.asList(" ", "§7§oTeleportiere dich ->", "§7§oLösche die Welt -->", " "));
            Create.setItemMeta(IMC);
            Create.setAmount(1);
            InvCW4.setItem(12, Create);
        } else if (Bukkit.getWorld("Challenge-3") == null) {
            ItemStack Create = new ItemStack(Material.GREEN_CONCRETE);
            ItemMeta IMC = Create.getItemMeta();
            IMC.setDisplayName("§6§lCreate Challenge-Welt-4");
            IMC.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oErstellt die Challenge-Welt-4", " "));
            Create.setItemMeta(IMC);
            Create.setAmount(1);
            InvCW4.setItem(12, Create);
        }

        ItemStack TP = new ItemStack(Material.WHITE_CONCRETE);
        ItemMeta IMO = TP.getItemMeta();
        IMO.setDisplayName("§6§lTeleport Challenge-Welt-4");
        IMO.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oTeleportiert dich in die Challenge-Welt-4", " "));
        TP.setItemMeta(IMO);
        TP.setAmount(1);
        InvCW4.setItem(13, TP);

        ItemStack Delete = new ItemStack(Material.RED_CONCRETE);
        ItemMeta IMD = Delete.getItemMeta();
        IMD.setDisplayName("§6§lDelete Challenge-Welt-4");
        IMD.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oLöscht die Challenge-Welt-4", " "));
        Delete.setItemMeta(IMD);
        Delete.setAmount(1);
        InvCW4.setItem(14, Delete);

        ItemStack Zurück = new ItemStack(Material.BARRIER);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7Letzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW4.setItem(26, Zurück);

        player.openInventory(InvCW4);

    }

    public void openOWC1(Player player) {

        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7Letzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        OptionsCW1.setItem(45, Zurück);

        player.openInventory(OptionsCW1);
    }


    //RightClick on Book(Navi)
    @EventHandler
    public void handleNavigatorOpener(PlayerInteractEvent event) {
        if (event.getItem().getItemMeta().getDisplayName() != "§6§lNavigator" && event.getItem().getType() != Material.BOOK) return;
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
            openGUI(event.getPlayer());
        }

    }

    //Was tun wenn Click im Navi
    @EventHandler
    public void openGUIinv(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(GUI_NAME)) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case PLAYER_HEAD:
                    Bukkit.dispatchCommand(player, "startbingo");
                    player.closeInventory();
                    break;
                case NETHER_STAR:
                    openGUI2(player.getPlayer());
                    break;
                case PAPER:
                    gl.openGUI(player.getPlayer());
                    break;
                default:
                    break;
            }
        }

    }

    @EventHandler
    public void openGUI2inv(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();

        World world1 = Bukkit.getWorld("Challenge-1");

        if (event.getClick().isLeftClick()) {
            if (event.getView().getTitle().equals(GUI_NAME2)) {
                event.setCancelled(true);

                if (event.getSlot() == 10 && Bukkit.getWorld("Challenge-1") != null) {
                    player.closeInventory();
                    Location location1 = world1.getSpawnLocation();
                    location1.setY(world1.getHighestBlockYAt(location1) + 1);
                    player.teleport(location1);
                    player.getInventory().clear();
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt 1§a!");
                } else if (Bukkit.getWorld("Challenge-1") == null) {
                    player.closeInventory();
                    player.sendMessage("§aServer " + "§8>> " + "§cWelt 1 wird erstellt!");
                    WorldCreator c1 = new WorldCreator("Challenge-1");
                    c1.type(WorldType.NORMAL);
                    c1.generateStructures(true);
                    World w1 = c1.createWorld();
                    player.updateInventory();
                    player.sendMessage(Main.getPlugin().PREFIX + "§cWelt 1 wurde erstellt!");
                    openGUI2(player.getPlayer());
                    openCW1(player.getPlayer());
                }

                if (event.getSlot() == 36) {
                    player.openInventory(inventory);
                }

            }
        }
        if (event.getClick().isRightClick()) {
            if (event.getView().getTitle().equals(GUI_NAME2)) {
                event.setCancelled(true);

                if (event.getSlot() == 10 && Bukkit.getWorld("Challenge-1") != null) {
                    openCW1(player.getPlayer());
                } else if (Bukkit.getWorld("Challenge-1") == null) {
                    player.closeInventory();
                    player.sendMessage("§aServer " + "§8>> " + "§cWelt 1 wird erstellt!");
                    WorldCreator c1 = new WorldCreator("Challenge-1");
                    c1.type(WorldType.NORMAL);
                    c1.generateStructures(true);
                    World w1 = c1.createWorld();
                    player.updateInventory();
                    player.sendMessage(Main.getPlugin().PREFIX + "§cWelt 1 wurde erstellt!");
                    openCW1(player.getPlayer());
                }

                if (event.getSlot() == 36) {
                    player.openInventory(inventory);
                }
            }
        }
    }

    @EventHandler
    public void CW1Inv(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        World world1 = Bukkit.getWorld("Challenge-1");
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
                case REPEATER:

                    openOWC1(player.getPlayer());
                    break;

                case ENDER_PEARL:

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

                case BARRIER:

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
                        openGUI2(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-1") == null) {
                        player.sendMessage(Main.getPlugin().PREFIX + "§cEs existiert keine Challenge-Welt-1!");
                        break;
                    }
                    break;

                case RED_DYE:

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

        World world12 = Bukkit.getWorld("Challenge-2");
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
                        Location location1 = world12.getSpawnLocation();
                        location1.setY(world12.getHighestBlockYAt(location1) + 1);
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
                    } else if (Bukkit.getWorld("Challenge-2") == null) {
                        player.sendMessage(Main.getPlugin().PREFIX + "§cEs existiert keine Challenge-Welt-2!");
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

        World world1 = Bukkit.getWorld("Challenge-3");
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
        if (event.getView().getTitle().equals(CW3)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case GREEN_CONCRETE:

                    if (Bukkit.getWorld("Challenge-3") == null) {
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§cChallenge-Welt-3 wird erstellt!");
                        WorldCreator c1 = new WorldCreator("Challenge-3");
                        c1.type(WorldType.NORMAL);
                        c1.generateStructures(true);
                        world = c1.createWorld();
                        player.sendMessage(Main.getPlugin().PREFIX + "§cChallenge-Welt-3 wurde erstellt!");
                        openCW3(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-3") != null) {
                        break;
                    }
                    break;

                case WHITE_CONCRETE:

                    if (Bukkit.getWorld("Challenge-3") != null) {
                        Location location1 = world1.getSpawnLocation();
                        location1.setY(world1.getHighestBlockYAt(location1) + 1);
                        player.teleport(location1);
                        player.getInventory().clear();
                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Challenge-Welt-3!");
                    } else {
                        player.sendMessage("§aServer " + "§8>> " + "§cEs existiert keine Challenge-Welt-3!");
                        break;
                    }
                    break;

                case RED_CONCRETE:

                    if (Bukkit.getWorld("Challenge-3") != null) {
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
                        File challenge3 = new File("Challenge-3");
                        if (challenge3.exists()) {

                            Bukkit.unloadWorld("Challenge-3", true);

                            File data3 = new File("Challenge-3\\data");
                            if (data3.exists()) {
                                for (File files1 : data3.listFiles()) {
                                    files1.delete();
                                }
                                data3.delete();
                            }

                            File playerdata3 = new File("Challenge-3\\playerdata");
                            if (playerdata3.exists()) {
                                for (File files2 : playerdata3.listFiles()) {
                                    files2.delete();
                                }
                                playerdata3.delete();
                            }

                            File poi3 = new File("Challenge-3\\poi");
                            if (poi3.exists()) {
                                for (File files3 : poi3.listFiles()) {
                                    files3.delete();
                                }
                                poi3.delete();
                            }

                            File region3 = new File("Challenge-3\\region");
                            if (region3.exists()) {
                                for (File files4 : region3.listFiles()) {
                                    files4.delete();
                                }
                                region3.delete();
                            }

                            for (File files5 : challenge3.listFiles()) {
                                files5.delete();
                            }
                            challenge3.delete();
                        }
                        player.sendMessage("§aServer " + "§8>> " + "§cChallenge-Welt-3 wurde gelöscht!");
                        openCW3(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-3") == null) {
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


