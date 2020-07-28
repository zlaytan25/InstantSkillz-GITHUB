//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Util;

import de.instantskillz.challengeplugin.Listener.GameModeListener;
import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;
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
import java.util.List;

public class Navigator implements Listener {

    private final String GUI_NAME = "§6Navigator";
    private final String GUI_NAME2 = "§6Challenge-Welten";
    private final String CW1 = "§6Welt 1";
    private final String CW2 = "§6Welt 2";
    private final String CW3 = "§6Welt 3";
    private final String CW4 = "§6Welt 4";
    private final String OCW1 = "§6Einstellungen Welt 1";
    private final String OCW2 = "§6Einstellungen Welt 2";
    private final String OCW3 = "§6Einstellungen Welt 3";
    private final String OCW4 = "§6Einstellungen Welt 2";

    //Navi
    Inventory inventory = Bukkit.createInventory(null, 9 * 5, GUI_NAME);
    Inventory WeltenOrdner = Bukkit.createInventory(null, 9 * 5, GUI_NAME2);

    Inventory InvCW1 = Bukkit.createInventory(null, 9 * 5, CW1);
    Inventory InvCW2 = Bukkit.createInventory(null, 9 * 5, CW2);
    Inventory InvCW3 = Bukkit.createInventory(null, 9 * 5, CW3);
    Inventory InvCW4 = Bukkit.createInventory(null, 9 * 5, CW4);

    Inventory OptionsCW1 = Bukkit.createInventory(null, 9 * 6, OCW1);
    Inventory OptionsCW2 = Bukkit.createInventory(null, 9 * 6, OCW2);
    Inventory OptionsCW3 = Bukkit.createInventory(null, 9 * 6, OCW3);
    Inventory OptionsCW4 = Bukkit.createInventory(null, 9 * 6, OCW4);


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
        itemMetaM.setLore(Arrays.asList(" ", "§7§oZeigt die Spiel-Modi-Auswahl!", " "));
        Modes.setItemMeta(itemMetaM);
        Modes.setAmount(1);
        inventory.setItem(2, Modes);

        inventory.setItem(1, Welten);
        player.openInventory(inventory);

    }

    public void openGUI2(Player player) {

        for (int k = 0; k < 9; k++) {
            ItemStack deko1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta d = deko1.getItemMeta();
            d.setDisplayName(" ");
            deko1.setItemMeta(d);
            deko1.setAmount(1);
            WeltenOrdner.setItem(k, deko1);
        }

        for (int k = 9; k < 18; k++) {
            ItemStack deko1 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            ItemMeta d = deko1.getItemMeta();
            d.setDisplayName(" ");
            deko1.setItemMeta(d);
            deko1.setAmount(1);
            WeltenOrdner.setItem(k, deko1);
        }

        for (int k = 37; k < 45; k++) {
            ItemStack deko14 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            ItemMeta d = deko14.getItemMeta();
            d.setDisplayName(" ");
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

        if (Bukkit.getWorld("Challenge-2") != null) {
            ItemStack wa2 = new ItemStack(Material.GREEN_DYE);
            ItemMeta imwa2 = wa2.getItemMeta();
            imwa2.setDisplayName("§a\u2714 §2§lWelt aktiv! §a\u2714");
            wa2.setItemMeta(imwa2);
            wa2.setAmount(1);
            WeltenOrdner.setItem(21, wa2);
        } else {
            ItemStack wa2 = new ItemStack(Material.GRAY_DYE);
            ItemMeta imwa2 = wa2.getItemMeta();
            imwa2.setDisplayName("§4\u2715 §c§lWelt inaktiv! §4\u2715");
            wa2.setItemMeta(imwa2);
            wa2.setAmount(1);
            WeltenOrdner.setItem(21, wa2);
        }

        if (Bukkit.getWorld("Challenge-3") != null) {
            ItemStack wa3 = new ItemStack(Material.GREEN_DYE);
            ItemMeta imwa3 = wa3.getItemMeta();
            imwa3.setDisplayName("§a\u2714 §2§lWelt aktiv! §a\u2714");
            wa3.setItemMeta(imwa3);
            wa3.setAmount(1);
            WeltenOrdner.setItem(23, wa3);
        } else {
            ItemStack wa3 = new ItemStack(Material.GRAY_DYE);
            ItemMeta imwa3 = wa3.getItemMeta();
            imwa3.setDisplayName("§4\u2715 §c§lWelt inaktiv! §4\u2715");
            wa3.setItemMeta(imwa3);
            wa3.setAmount(1);
            WeltenOrdner.setItem(23, wa3);
        }

        if (Bukkit.getWorld("Challenge-4") != null) {
            ItemStack wa4 = new ItemStack(Material.GREEN_DYE);
            ItemMeta imwa4 = wa4.getItemMeta();
            imwa4.setDisplayName("§a\u2714 §2§lWelt aktiv! §a\u2714");
            wa4.setItemMeta(imwa4);
            wa4.setAmount(1);
            WeltenOrdner.setItem(25, wa4);
        } else {
            ItemStack wa4 = new ItemStack(Material.GRAY_DYE);
            ItemMeta imwa4 = wa4.getItemMeta();
            imwa4.setDisplayName("§4\u2715 §c§lWelt inaktiv! §4\u2715");
            wa4.setItemMeta(imwa4);
            wa4.setAmount(1);
            WeltenOrdner.setItem(25, wa4);
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
        itemMetaZ.setLore(Arrays.asList(" ", "§7§oLetzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        WeltenOrdner.setItem(36, Zurück);

        WeltenOrdner.setItem(10, Main.getGlobeSkull1("GLOBE1"));
        WeltenOrdner.setItem(12, Main.getGlobeSkull2("GLOBE2"));
        WeltenOrdner.setItem(14, Main.getGlobeSkull3("GLOBE3"));
        WeltenOrdner.setItem(16, Main.getGlobeSkull4("GLOBE4"));
        player.openInventory(WeltenOrdner);

    }

    public void openCW1(Player player) {

        for (int k = 0; k < 9; k++) {
            ItemStack deko1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta d = deko1.getItemMeta();
            d.setDisplayName(" ");
            deko1.setItemMeta(d);
            deko1.setAmount(1);
            InvCW1.setItem(k, deko1);
        }

        InvCW1.setItem(4, Main.getDeko1("GLOBED1"));

        ItemStack deko9 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta d = deko9.getItemMeta();
        d.setDisplayName(" ");
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
        imwl.setLore(Arrays.asList(" ", "§7§oDiese Aktion kann nicht rückgängig gemacht werden!", " "));
        wl.setItemMeta(imwl);
        wl.setAmount(1);
        InvCW1.setItem(19, wl);

        ItemStack wo = new ItemStack(Material.REPEATER);
        ItemMeta imwo = wo.getItemMeta();
        imwo.setDisplayName("§6Challenge Einstellungen");
        imwo.setLore(Arrays.asList(" ", "§7§oKonfiguriere die Challenge nach deinem Willen!", " "));
        wo.setItemMeta(imwo);
        wo.setAmount(1);
        InvCW1.setItem(20, wo);

        ItemStack wt = new ItemStack(Material.ENDER_PEARL);
        ItemMeta imwt = wt.getItemMeta();
        imwt.setDisplayName("§aTeleport Welt 1");
        imwt.setLore(Arrays.asList(" ", "§7§oTeleportiert dich in Welt 1!", " "));
        wt.setItemMeta(imwt);
        wt.setAmount(1);
        InvCW1.setItem(25, wt);

        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7§oLetzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW1.setItem(36, Zurück);

        player.openInventory(InvCW1);
    }

    public void openCW2(Player player) {

        for (int k = 0; k < 9; k++) {
            ItemStack deko1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta d = deko1.getItemMeta();
            d.setDisplayName(" ");
            deko1.setItemMeta(d);
            deko1.setAmount(1);
            InvCW2.setItem(k, deko1);
        }

        InvCW2.setItem(4, Main.getDeko2("GLOBED2"));


        ItemStack deko9 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta d = deko9.getItemMeta();
        d.setDisplayName(" ");
        deko9.setItemMeta(d);
        deko9.setAmount(1);
        InvCW2.setItem(10, deko9);
        ItemStack deko10 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko10.setItemMeta(d);
        deko10.setAmount(1);
        InvCW2.setItem(11, deko10);
        ItemStack deko11 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko11.setItemMeta(d);
        deko11.setAmount(1);
        InvCW2.setItem(16, deko11);

        for (int k = 37; k < 45; k++) {
            ItemStack deko14 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            deko14.setItemMeta(d);
            deko14.setAmount(1);
            InvCW2.setItem(k, deko14);
        }

        ItemStack wl = new ItemStack(Material.BARRIER);
        ItemMeta imwl = wl.getItemMeta();
        imwl.setDisplayName("§cWelt 2 löschen!");
        imwl.setLore(Arrays.asList(" ", "§7§oDiese Aktion kann nicht rückgängig gemacht werden!", " "));
        wl.setItemMeta(imwl);
        wl.setAmount(1);
        InvCW2.setItem(19, wl);

        ItemStack wo = new ItemStack(Material.REPEATER);
        ItemMeta imwo = wo.getItemMeta();
        imwo.setDisplayName("§6Challenge Einstellungen");
        imwo.setLore(Arrays.asList(" ", "§7§oKonfiguriere die Challenge nach deinem Willen!", " "));
        wo.setItemMeta(imwo);
        wo.setAmount(1);
        InvCW2.setItem(20, wo);

        ItemStack wt = new ItemStack(Material.ENDER_PEARL);
        ItemMeta imwt = wt.getItemMeta();
        imwt.setDisplayName("§aTeleport Welt 2");
        imwt.setLore(Arrays.asList(" ", "§7§oTeleportiert dich in Welt 2!", " "));
        wt.setItemMeta(imwt);
        wt.setAmount(1);
        InvCW2.setItem(25, wt);

        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7§oLetzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW2.setItem(36, Zurück);

        player.openInventory(InvCW2);
    }

    public void openCW3(Player player) {

        for (int k = 0; k < 9; k++) {
            ItemStack deko1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta d = deko1.getItemMeta();
            d.setDisplayName(" ");
            deko1.setItemMeta(d);
            deko1.setAmount(1);
            InvCW3.setItem(k, deko1);
        }

        InvCW3.setItem(4, Main.getDeko3("GLOBED3"));

        ItemStack deko9 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta d = deko9.getItemMeta();
        d.setDisplayName(" ");
        deko9.setItemMeta(d);
        deko9.setAmount(1);
        InvCW3.setItem(10, deko9);
        ItemStack deko10 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko10.setItemMeta(d);
        deko10.setAmount(1);
        InvCW3.setItem(11, deko10);
        ItemStack deko11 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko11.setItemMeta(d);
        deko11.setAmount(1);
        InvCW3.setItem(16, deko11);

        for (int k = 37; k < 45; k++) {
            ItemStack deko14 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            deko14.setItemMeta(d);
            deko14.setAmount(1);
            InvCW3.setItem(k, deko14);
        }

        ItemStack wl = new ItemStack(Material.BARRIER);
        ItemMeta imwl = wl.getItemMeta();
        imwl.setDisplayName("§cWelt 3 löschen!");
        imwl.setLore(Arrays.asList(" ", "§7§oDiese Aktion kann nicht rückgängig gemacht werden!", " "));
        wl.setItemMeta(imwl);
        wl.setAmount(1);
        InvCW3.setItem(19, wl);

        ItemStack wo = new ItemStack(Material.REPEATER);
        ItemMeta imwo = wo.getItemMeta();
        imwo.setDisplayName("§6Challenge Einstellungen");
        imwo.setLore(Arrays.asList(" ", "§7§oKonfiguriere die Challenge nach deinem Willen!", " "));
        wo.setItemMeta(imwo);
        wo.setAmount(1);
        InvCW3.setItem(20, wo);

        ItemStack wt = new ItemStack(Material.ENDER_PEARL);
        ItemMeta imwt = wt.getItemMeta();
        imwt.setDisplayName("§aTeleport Welt 3");
        imwt.setLore(Arrays.asList(" ", "§7§oTeleportiert dich in Welt 3!", " "));
        wt.setItemMeta(imwt);
        wt.setAmount(1);
        InvCW3.setItem(25, wt);

        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7§oLetzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW3.setItem(36, Zurück);


        player.openInventory(InvCW3);
    }

    public void openCW4(Player player) {

        for (int k = 0; k < 9; k++) {
            ItemStack deko1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta d = deko1.getItemMeta();
            d.setDisplayName(" ");
            deko1.setItemMeta(d);
            deko1.setAmount(1);
            InvCW1.setItem(k, deko1);
        }

        InvCW4.setItem(4, Main.getDeko4("GLOBED4"));

        ItemStack deko9 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta d = deko9.getItemMeta();
        d.setDisplayName(" ");
        deko9.setItemMeta(d);
        deko9.setAmount(1);
        InvCW4.setItem(10, deko9);
        ItemStack deko10 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko10.setItemMeta(d);
        deko10.setAmount(1);
        InvCW4.setItem(11, deko10);
        ItemStack deko11 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        deko11.setItemMeta(d);
        deko11.setAmount(1);
        InvCW4.setItem(16, deko11);

        for (int k = 37; k < 45; k++) {
            ItemStack deko14 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            deko14.setItemMeta(d);
            deko14.setAmount(1);
            InvCW4.setItem(k, deko14);
        }

        ItemStack wl = new ItemStack(Material.BARRIER);
        ItemMeta imwl = wl.getItemMeta();
        imwl.setDisplayName("§cWelt 4 löschen!");
        imwl.setLore(Arrays.asList(" ", "§7§oDiese Aktion kann nicht rückgängig gemacht werden!", " "));
        wl.setItemMeta(imwl);
        wl.setAmount(1);
        InvCW4.setItem(19, wl);

        ItemStack wo = new ItemStack(Material.REPEATER);
        ItemMeta imwo = wo.getItemMeta();
        imwo.setDisplayName("§6Challenge Einstellungen");
        imwo.setLore(Arrays.asList(" ", "§7§oKonfiguriere die Challenge nach deinem Willen!", " "));
        wo.setItemMeta(imwo);
        wo.setAmount(1);
        InvCW4.setItem(20, wo);

        ItemStack wt = new ItemStack(Material.ENDER_PEARL);
        ItemMeta imwt = wt.getItemMeta();
        imwt.setDisplayName("§aTeleport Welt 4");
        imwt.setLore(Arrays.asList(" ", "§7§oTeleportiert dich in Welt 4!", " "));
        wt.setItemMeta(imwt);
        wt.setAmount(1);
        InvCW4.setItem(25, wt);

        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7§oLetzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        InvCW4.setItem(36, Zurück);

        player.openInventory(InvCW4);

    }

    public void openOWC1(Player player) {

        for (int k = 0; k < 9; k++) {
            ItemStack deko14 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta d = deko14.getItemMeta();
            d.setDisplayName(" ");
            deko14.setItemMeta(d);
            deko14.setAmount(1);
            OptionsCW1.setItem(k, deko14);

        }

        ItemStack wo = new ItemStack(Material.REPEATER);
        ItemMeta imwo = wo.getItemMeta();
        imwo.setDisplayName("§6Challenge Einstellungen");
        wo.setItemMeta(imwo);
        wo.setAmount(1);
        OptionsCW1.setItem(4, wo);

        for (int k = 9; k < 18; k++) {
            ItemStack deko1 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            ItemMeta d = deko1.getItemMeta();
            d.setDisplayName(" ");
            deko1.setItemMeta(d);
            deko1.setAmount(1);
            OptionsCW1.setItem(k, deko1);
        }

        ItemStack timer = new ItemStack(Material.CLOCK, 1);
        ItemMeta imt = timer.getItemMeta();
        imt.setDisplayName("§6Timer");
        imt.setLore(Arrays.asList(" ", "§7§oEine ingame Stoppuhr zum stoppen der Challenge Zeit!", " "));
        timer.setItemMeta(imt);
        OptionsCW1.setItem(10, timer);

        if (Main.getPlugin().getTimer() == false) {
            ItemStack Timer1 = new ItemStack(Material.GREEN_DYE, 1);
            ItemMeta itemMeta22 = Timer1.getItemMeta();
            itemMeta22.setDisplayName("§cTimer -> AN §a\u2714");
            itemMeta22.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet den Timer aus!", " "));
            Timer1.setItemMeta(itemMeta22);
            OptionsCW1.setItem(19, Timer1);
        } else if (Main.getPlugin().getTimer() == true) {
            ItemStack Timer2 = new ItemStack(Material.GRAY_DYE, 1);
            ItemMeta itemMeta2 = Timer2.getItemMeta();
            itemMeta2.setDisplayName("§cTimer -> AUS §4\u2715");
            itemMeta2.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet den Timer aus!", " "));
            Timer2.setItemMeta(itemMeta2);
            OptionsCW1.setItem(19, Timer2);
        }

        ItemStack ED = new ItemStack(Material.DRAGON_HEAD, 1);
        ItemMeta imed = ED.getItemMeta();
        imed.setDisplayName("§6Ziel: Ender Drache");
        imed.setLore(Arrays.asList(" ", "§7§oSetzt das Challenge Ziel: ", "§7Töte den Ender Drachen!", " "));
        ED.setItemMeta(imed);
        OptionsCW1.setItem(12, ED);

        if (Main.getPlugin().getEDK() == false) {
            ItemStack EDK1 = new ItemStack(Material.GREEN_DYE, 1);
            ItemMeta itemMeta7 = EDK1.getItemMeta();
            itemMeta7.setDisplayName("§cZiel: Ender Drache -> AN §a\u2714");
            itemMeta7.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oSchaltet das Ziel des Ender Drachens aus!", " "));
            EDK1.setItemMeta(itemMeta7);
            OptionsCW1.setItem(21, EDK1);
        } else if (Main.getPlugin().getEDK() == true) {
            ItemStack EDK2 = new ItemStack(Material.GRAY_DYE, 1);
            ItemMeta itemMeta77 = EDK2.getItemMeta();
            itemMeta77.setDisplayName("§cZiel: Ender Drache -> AUS §4\u2715");
            itemMeta77.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oSchaltet das Ziel des Ender Drachens an!", " "));
            EDK2.setItemMeta(itemMeta77);
            OptionsCW1.setItem(21, EDK2);
        }

        ItemStack hp = new ItemStack(Material.POTION, 1, (short) 8197);
        ItemMeta imhp = hp.getItemMeta();
        imhp.setDisplayName("§6Anzahl der Herzen");
        imhp.setLore(Arrays.asList(" ", "§7§oStandard: 10 Herzen", " "));
        imhp.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        hp.setItemMeta(imhp);
        OptionsCW1.setItem(14, hp);

        ItemStack hp1 = new ItemStack(Material.LIGHT_BLUE_DYE, 1);
        ItemMeta itemMeta8 = hp1.getItemMeta();
        itemMeta8.setDisplayName("§cHalbes Herz: \u002B");
        itemMeta8.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oErhöht das Leben um ein halbes Herz!", " "));
        hp1.setItemMeta(itemMeta8);
        OptionsCW1.setItem(23, hp1);

        ItemStack hp2 = new ItemStack(Material.MAGENTA_DYE, 1);
        ItemMeta itemMeta88 = hp2.getItemMeta();
        itemMeta88.setDisplayName("§cHalbes Herz: \u002D");
        itemMeta88.setLore(Arrays.asList(" ", "§7§oDurch Klick ->", "§7§oVerringert das Leben um ein halbes Herz!", " "));
        hp2.setItemMeta(itemMeta88);
        OptionsCW1.setItem(32, hp2);

        ItemStack food = new ItemStack(Material.COOKED_CHICKEN, 1);
        ItemMeta imf = food.getItemMeta();
        imf.setDisplayName("§6Hunger");
        imf.setLore(Arrays.asList(" ", "§7§oSchaltet den Hunger ein oder aus!", " "));
        food.setItemMeta(imf);
        OptionsCW1.setItem(16, food);

        ItemStack fl = new ItemStack(Material.GREEN_DYE, 1);
        ItemMeta imfl = fl.getItemMeta();
        imfl.setDisplayName("§cHunger -> AN §a\u2714");
        imfl.setLore(Arrays.asList(" ", "§7§oDurch Klick -> ", "§7§oSchaltet den Hunger aus!", " "));
        fl.setItemMeta(imfl);
        OptionsCW1.setItem(25, fl);

        for (int k = 45; k < 54; k++) {
            ItemStack deko14 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            ItemMeta d = deko14.getItemMeta();
            d.setDisplayName(" ");
            deko14.setItemMeta(d);
            deko14.setAmount(1);
            OptionsCW1.setItem(k, deko14);
        }

        ItemStack bq = new ItemStack(Material.WRITABLE_BOOK, 1);
        ItemMeta imbq = bq.getItemMeta();
        imbq.setDisplayName("§6Save & Quit");
        imbq.setLore(Arrays.asList(" ", "§7§oSpeichert die Einstellungen und schließt das Inventar!", " "));
        bq.setItemMeta(imbq);
        OptionsCW1.setItem(48, bq);

        ItemStack emer = new ItemStack(Material.EMERALD, 1);
        ItemMeta ime = emer.getItemMeta();
        ime.setDisplayName("§6Save & Teleport");
        ime.setLore(Arrays.asList(" ", "§7§oSpeichert die Einstellungen und Teleportiert dich!", " "));
        emer.setItemMeta(ime);
        OptionsCW1.setItem(50, emer);

        ItemStack map = new ItemStack(Material.MAP, 1);
        ItemMeta imm = map.getItemMeta();
        imm.setDisplayName("§6§lWeiter");
        imm.setLore(Arrays.asList(" ", "§7§oNächste Menü-Seite", " "));
        map.setItemMeta(imm);
        OptionsCW1.setItem(53, map);

        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7§oLetzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        OptionsCW1.setItem(45, Zurück);

        player.openInventory(OptionsCW1);
    }

    public void openOWC2(Player player) {

        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7Letzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        OptionsCW2.setItem(45, Zurück);

        player.openInventory(OptionsCW2);
    }

    public void openOWC3(Player player) {

        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7§oLetzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        OptionsCW3.setItem(45, Zurück);

        player.openInventory(OptionsCW3);
    }

    public void openOWC4(Player player) {

        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7§oLetzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        OptionsCW4.setItem(45, Zurück);

        player.openInventory(OptionsCW4);
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
        World world2 = Bukkit.getWorld("Challenge-2");
        World world3 = Bukkit.getWorld("Challenge-3");
        World world4 = Bukkit.getWorld("Challenge-4");

        if (event.getClick().isLeftClick()) {
            if (event.getView().getTitle().equals(GUI_NAME2)) {
                event.setCancelled(true);

                if (event.getSlot() == 10 && Bukkit.getWorld("Challenge-1") != null) {
                    player.closeInventory();
                    Location location1 = world1.getSpawnLocation();
                    location1.setY(world1.getHighestBlockYAt(location1) + 1);
                    player.teleport(location1);
                    player.getInventory().clear();

                    String playername = player.getName();
                    File file = new File("plugins//InstantSkillzTV//Inventories//" + world1 + "//" + playername + ".yml");

                    if (file.exists()) {
                        YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
                        player.getInventory().clear();
                        List<?> list = inv.getList("Inventory");
                        List<?> slot = inv.getList("Slot");

                        double health = inv.getDouble("Health");
                        player.setHealth(health);
                        double exp = inv.getDouble("Exp");
                        player.setExp((float) exp);
                        int level = inv.getInt("Level");
                        player.setLevel(level);
                        int hunger = inv.getInt("Hunger");
                        player.setFoodLevel(hunger);

                        for (int i = 0; i < player.getInventory().getSize(); i++) {
                            player.getInventory().setItem((Integer) slot.get(i), (ItemStack) list.get(i));
                        }

                        file.delete();

                        return;
                    }

                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt 1§a!");
                } else if (event.getSlot() == 10 && Bukkit.getWorld("Challenge-1") == null) {
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

                if (event.getSlot() == 12 && Bukkit.getWorld("Challenge-2") != null) {
                    player.closeInventory();
                    Location location2 = world2.getSpawnLocation();
                    location2.setY(world2.getHighestBlockYAt(location2) + 1);
                    player.teleport(location2);

                    String playername = player.getName();
                    File file = new File("plugins//InstantSkillzTV//Inventories//" + world2 + "//" + playername + ".yml");

                    if (file.exists()) {
                        YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
                        player.getInventory().clear();
                        List<?> list = inv.getList("Inventory");
                        List<?> slot = inv.getList("Slot");

                        double health = inv.getDouble("Health");
                        player.setHealth(health);
                        double exp = inv.getDouble("Exp");
                        player.setExp((float) exp);
                        int level = inv.getInt("Level");
                        player.setLevel(level);
                        int hunger = inv.getInt("Hunger");
                        player.setFoodLevel(hunger);

                        for (int i = 0; i < player.getInventory().getSize(); i++) {
                            player.getInventory().setItem((Integer) slot.get(i), (ItemStack) list.get(i));
                        }

                        file.delete();

                        return;
                    }

                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt 2§a!");
                } else if (event.getSlot() == 12 && Bukkit.getWorld("Challenge-2") == null) {
                    player.closeInventory();
                    player.sendMessage("§aServer " + "§8>> " + "§cWelt 2 wird erstellt!");
                    WorldCreator c2 = new WorldCreator("Challenge-2");
                    c2.type(WorldType.NORMAL);
                    c2.generateStructures(true);
                    World w2 = c2.createWorld();
                    player.updateInventory();
                    player.sendMessage(Main.getPlugin().PREFIX + "§cWelt 2 wurde erstellt!");
                    openGUI2(player.getPlayer());
                    openCW2(player.getPlayer());
                }

                if (event.getSlot() == 14 && Bukkit.getWorld("Challenge-3") != null) {
                    player.closeInventory();
                    Location location3 = world3.getSpawnLocation();
                    location3.setY(world3.getHighestBlockYAt(location3) + 1);
                    player.teleport(location3);

                    String playername = player.getName();
                    File file = new File("plugins//InstantSkillzTV//Inventories//" + world3 + "//" + playername + ".yml");

                    if (file.exists()) {
                        YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
                        player.getInventory().clear();
                        List<?> list = inv.getList("Inventory");
                        List<?> slot = inv.getList("Slot");

                        double health = inv.getDouble("Health");
                        player.setHealth(health);
                        double exp = inv.getDouble("Exp");
                        player.setExp((float) exp);
                        int level = inv.getInt("Level");
                        player.setLevel(level);
                        int hunger = inv.getInt("Hunger");
                        player.setFoodLevel(hunger);

                        for (int i = 0; i < player.getInventory().getSize(); i++) {
                            player.getInventory().setItem((Integer) slot.get(i), (ItemStack) list.get(i));
                        }

                        file.delete();

                        return;
                    }

                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt 3§a!");
                } else if (event.getSlot() == 14 && Bukkit.getWorld("Challenge-3") == null) {
                    player.closeInventory();
                    player.sendMessage("§aServer " + "§8>> " + "§cWelt 3 wird erstellt!");
                    WorldCreator c3 = new WorldCreator("Challenge-3");
                    c3.type(WorldType.NORMAL);
                    c3.generateStructures(true);
                    World w3 = c3.createWorld();
                    player.updateInventory();
                    player.sendMessage(Main.getPlugin().PREFIX + "§cWelt 3 wurde erstellt!");
                    openGUI2(player.getPlayer());
                    openCW3(player.getPlayer());
                }

                if (event.getSlot() == 16 && Bukkit.getWorld("Challenge-4") != null) {
                    player.closeInventory();
                    Location location4 = world4.getSpawnLocation();
                    location4.setY(world4.getHighestBlockYAt(location4) + 1);
                    player.teleport(location4);

                    String playername = player.getName();
                    File file = new File("plugins//InstantSkillzTV//Inventories//" + world4 + "//" + playername + ".yml");

                    if (file.exists()) {
                        YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
                        player.getInventory().clear();
                        List<?> list = inv.getList("Inventory");
                        List<?> slot = inv.getList("Slot");

                        double health = inv.getDouble("Health");
                        player.setHealth(health);
                        double exp = inv.getDouble("Exp");
                        player.setExp((float) exp);
                        int level = inv.getInt("Level");
                        player.setLevel(level);
                        int hunger = inv.getInt("Hunger");
                        player.setFoodLevel(hunger);

                        for (int i = 0; i < player.getInventory().getSize(); i++) {
                            player.getInventory().setItem((Integer) slot.get(i), (ItemStack) list.get(i));
                        }

                        file.delete();

                        return;
                    }

                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt 4§a!");
                } else if (event.getSlot() == 16 && Bukkit.getWorld("Challenge-4") == null) {
                    player.closeInventory();
                    player.sendMessage("§aServer " + "§8>> " + "§cWelt 4 wird erstellt!");
                    WorldCreator c4 = new WorldCreator("Challenge-4");
                    c4.type(WorldType.NORMAL);
                    c4.generateStructures(true);
                    World w4 = c4.createWorld();
                    player.updateInventory();
                    player.sendMessage(Main.getPlugin().PREFIX + "§cWelt 4 wurde erstellt!");
                    openGUI2(player.getPlayer());
                    openCW4(player.getPlayer());
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
                } else if (event.getSlot() == 10 && Bukkit.getWorld("Challenge-1") == null) {
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

                if (event.getSlot() == 12 && Bukkit.getWorld("Challenge-2") != null) {
                    openCW2(player.getPlayer());
                } else if (event.getSlot() == 12 && Bukkit.getWorld("Challenge-2") == null) {
                    player.closeInventory();
                    player.sendMessage(Main.getPlugin().PREFIX + "§cWelt 2 wird erstellt!");
                    WorldCreator c2 = new WorldCreator("Challenge-2");
                    c2.type(WorldType.NORMAL);
                    c2.generateStructures(true);
                    World w2 = c2.createWorld();
                    player.updateInventory();
                    player.sendMessage(Main.getPlugin().PREFIX + "§cWelt 2 wurde erstellt!");
                    openGUI2(player.getPlayer());
                    openCW2(player.getPlayer());
                }

                if (event.getSlot() == 14 && Bukkit.getWorld("Challenge-3") != null) {
                    openCW3(player.getPlayer());
                } else if (event.getSlot() == 14 && Bukkit.getWorld("Challenge-3") == null) {
                    player.closeInventory();
                    player.sendMessage(Main.getPlugin().PREFIX + "§cWelt 3 wird erstellt!");
                    WorldCreator c3 = new WorldCreator("Challenge-3");
                    c3.type(WorldType.NORMAL);
                    c3.generateStructures(true);
                    World w3 = c3.createWorld();
                    player.updateInventory();
                    player.sendMessage(Main.getPlugin().PREFIX + "§cWelt 3 wurde erstellt!");
                    openGUI2(player.getPlayer());
                    openCW3(player.getPlayer());
                }

                if (event.getSlot() == 16 && Bukkit.getWorld("Challenge-4") != null) {
                    openCW4(player.getPlayer());
                } else if (event.getSlot() == 16 && Bukkit.getWorld("Challenge-4") == null) {
                    player.closeInventory();
                    player.sendMessage(Main.getPlugin().PREFIX + "§cWelt 4 wird erstellt!");
                    WorldCreator c4 = new WorldCreator("Challenge-4");
                    c4.type(WorldType.NORMAL);
                    c4.generateStructures(true);
                    World w4 = c4.createWorld();
                    player.updateInventory();
                    player.sendMessage(Main.getPlugin().PREFIX + "§cWelt 4 wurde erstellt!");
                    openGUI2(player.getPlayer());
                    openCW4(player.getPlayer());
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

                        String playername = player.getName();
                        File file = new File("plugins//InstantSkillzTV//Inventories//" + world1 + "//" + playername + ".yml");

                        if (file.exists()) {
                            YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
                            player.getInventory().clear();
                            List<?> list = inv.getList("Inventory");
                            List<?> slot = inv.getList("Slot");

                            double health = inv.getDouble("Health");
                            player.setHealth(health);
                            double exp = inv.getDouble("Exp");
                            player.setExp((float) exp);
                            int level = inv.getInt("Level");
                            player.setLevel(level);
                            int hunger = inv.getInt("Hunger");
                            player.setFoodLevel(hunger);

                            for (int i = 0; i < player.getInventory().getSize(); i++) {
                                player.getInventory().setItem((Integer) slot.get(i), (ItemStack) list.get(i));
                            }

                            file.delete();

                            return;
                        }

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

                        //Inventar löschen
                        String playername = player.getName();
                        File inventory = new File("plugins//InstantSkillzTV//Inventories//" + world1);
                        FileUtils.deleteQuietly(inventory);

                        //Backpack löschen
                        File backpack = new File("plugins//InstantSkillzTV//Backpacks//" + world1);
                        backpack.delete();

                        //Welt-Löschen
                        File challenge1 = new File("Challenge-1");
                        if (challenge1.exists()) {
                            Bukkit.unloadWorld("Challenge-1", true);
                            FileUtils.deleteQuietly(challenge1);
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
    public void CW2Inv(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        World world1 = Bukkit.getWorld("Challenge-2");
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
                case REPEATER:

                    openOWC2(player.getPlayer());
                    break;

                case ENDER_PEARL:

                    if (Bukkit.getWorld("Challenge-2") != null) {
                        Location location1 = world1.getSpawnLocation();
                        location1.setY(world1.getHighestBlockYAt(location1) + 1);
                        player.teleport(location1);
                        player.getInventory().clear();

                        String playername = player.getName();
                        File file = new File("plugins//InstantSkillzTV//Inventories//" + world1);

                        if (file.exists()) {
                            YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
                            player.getInventory().clear();
                            List<?> list = inv.getList("Inventory");
                            List<?> slot = inv.getList("Slot");

                            double health = inv.getDouble("Health");
                            player.setHealth(health);
                            double exp = inv.getDouble("Exp");
                            player.setExp((float) exp);
                            int level = inv.getInt("Level");
                            player.setLevel(level);
                            int hunger = inv.getInt("Hunger");
                            player.setFoodLevel(hunger);

                            for (int i = 0; i < player.getInventory().getSize(); i++) {
                                player.getInventory().setItem((Integer) slot.get(i), (ItemStack) list.get(i));
                            }

                            file.delete();

                            return;
                        }

                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt 2!");
                    } else {
                        player.sendMessage("§aServer " + "§8>> " + "§cEs existiert keine Welt 2!");
                        break;
                    }
                    break;

                case BARRIER:

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

                        //Inventar löschen
                        String playername = player.getName();
                        File inventory = new File("plugins//InstantSkillzTV//Inventories//" + world1);
                        FileUtils.deleteQuietly(inventory);

                        //Backpack löschen
                        File backpack = new File("plugins//InstantSkillzTV//Backpacks//" + world1);
                        backpack.delete();

                        //Welt-Löschen
                        File challenge2 = new File("Challenge-2");
                        if (challenge2.exists()) {
                            Bukkit.unloadWorld("Challenge-2", true);
                            FileUtils.deleteQuietly(challenge2);
                        }

                        player.sendMessage("§aServer " + "§8>> " + "§cWelt 2 wurde gelöscht!");
                        openGUI2(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-2") == null) {
                        player.sendMessage(Main.getPlugin().PREFIX + "§cEs existiert keine Welt 2!");
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
    public void CW3Inv(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        World world1 = Bukkit.getWorld("Challenge-3");
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
                case REPEATER:

                    openOWC3(player.getPlayer());
                    break;

                case ENDER_PEARL:

                    if (Bukkit.getWorld("Challenge-3") != null) {
                        Location location1 = world1.getSpawnLocation();
                        location1.setY(world1.getHighestBlockYAt(location1) + 1);
                        player.teleport(location1);
                        player.getInventory().clear();

                        String playername = player.getName();
                        File file = new File("plugins//InstantSkillzTV//Inventories//" + world1 + "//" + playername + ".yml");

                        if (file.exists()) {
                            YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
                            player.getInventory().clear();
                            List<?> list = inv.getList("Inventory");
                            List<?> slot = inv.getList("Slot");

                            double health = inv.getDouble("Health");
                            player.setHealth(health);
                            double exp = inv.getDouble("Exp");
                            player.setExp((float) exp);
                            int level = inv.getInt("Level");
                            player.setLevel(level);
                            int hunger = inv.getInt("Hunger");
                            player.setFoodLevel(hunger);

                            for (int i = 0; i < player.getInventory().getSize(); i++) {
                                player.getInventory().setItem((Integer) slot.get(i), (ItemStack) list.get(i));
                            }

                            file.delete();

                            return;
                        }

                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt 3!");
                    } else {
                        player.sendMessage("§aServer " + "§8>> " + "§cEs existiert keine Welt 3!");
                        break;
                    }
                    break;

                case BARRIER:

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

                        //Inventar löschen
                        String playername = player.getName();
                        File inventory = new File("plugins//InstantSkillzTV//Inventories//" + world1);
                        FileUtils.deleteQuietly(inventory);

                        //Backpack löschen
                        File backpack = new File("plugins//InstantSkillzTV//Backpacks//" + world1);
                        backpack.delete();

                        //Welt-Löschen
                        File challenge3 = new File("Challenge-3");
                        if (challenge3.exists()) {
                            Bukkit.unloadWorld("Challenge-3", true);
                            FileUtils.deleteQuietly(challenge3);
                        }

                        player.sendMessage("§aServer " + "§8>> " + "§cWelt 3 wurde gelöscht!");
                        openGUI2(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-3") == null) {
                        player.sendMessage(Main.getPlugin().PREFIX + "§cEs existiert keine Welt 3!");
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
    public void CW4Inv(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        World world1 = Bukkit.getWorld("Challenge-4");
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
        if (event.getView().getTitle().equals(CW4)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {
                case REPEATER:

                    openOWC4(player.getPlayer());
                    break;

                case ENDER_PEARL:

                    if (Bukkit.getWorld("Challenge-4") != null) {
                        Location location1 = world1.getSpawnLocation();
                        location1.setY(world1.getHighestBlockYAt(location1) + 1);
                        player.teleport(location1);
                        player.getInventory().clear();

                        String playername = player.getName();
                        File file = new File("plugins//InstantSkillzTV//Inventories//" + world1 + "//" + playername + ".yml");

                        if (file.exists()) {
                            YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
                            player.getInventory().clear();
                            List<?> list = inv.getList("Inventory");
                            List<?> slot = inv.getList("Slot");

                            double health = inv.getDouble("Health");
                            player.setHealth(health);
                            double exp = inv.getDouble("Exp");
                            player.setExp((float) exp);
                            int level = inv.getInt("Level");
                            player.setLevel(level);
                            int hunger = inv.getInt("Hunger");
                            player.setFoodLevel(hunger);

                            for (int i = 0; i < player.getInventory().getSize(); i++) {
                                player.getInventory().setItem((Integer) slot.get(i), (ItemStack) list.get(i));
                            }

                            file.delete();

                            return;
                        }

                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt 4!");
                    } else {
                        player.sendMessage("§aServer " + "§8>> " + "§cEs existiert keine Welt 4!");
                        break;
                    }
                    break;

                case BARRIER:

                    if (Bukkit.getWorld("Challenge-4") != null) {
                        player.closeInventory();
                        //HUB-Teleport
                        if (player.getWorld() != hub) {
                            player.teleport(lochub);
                            //Navigator
                            player.getInventory().setItem(4, item);
                            //Gamemode
                            player.setGameMode(GameMode.ADVENTURE);
                        }

                        //Inventar löschen
                        String playername = player.getName();
                        File inventory = new File("plugins//InstantSkillzTV//Inventories//" + world1);
                        FileUtils.deleteQuietly(inventory);

                        //Backpack löschen
                        File backpack = new File("plugins//InstantSkillzTV//Backpacks//" + world1);
                        backpack.delete();

                        //Welt-Löschen
                        File challenge4 = new File("Challenge-4");
                        if (challenge4.exists()) {
                            Bukkit.unloadWorld("Challenge-4", true);
                            FileUtils.deleteQuietly(challenge4);
                        }

                        player.sendMessage("§aServer " + "§8>> " + "§cWelt 4 wurde gelöscht!");
                        openGUI2(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-4") == null) {
                        player.sendMessage(Main.getPlugin().PREFIX + "§cEs existiert keine Welt 4!");
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


