//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Util;

import de.instantskillz.challengeplugin.Listener.GameModeListener;
import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
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
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

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
    private final String OCW1 = "§6Einstellungen Welt 1.1";
    private final String OCW2 = "§6Einstellungen Welt 2.1";
    private final String OCW3 = "§6Einstellungen Welt 3.1";
    private final String OCW4 = "§6Einstellungen Welt 4.1";
    private final String OCW11 = "§6Einstellungen Welt 1.2";
    private final String OCW21 = "§6Einstellungen Welt 2.2";
    private final String OCW31 = "§6Einstellungen Welt 3.2";
    private final String OCW41 = "§6Einstellungen Welt 4.2";
    private final String OCW12 = "§6Einstellungen Welt 1.3";
    private final String OCW22 = "§6Einstellungen Welt 2.3";
    private final String OCW32 = "§6Einstellungen Welt 3.3";
    private final String OCW42 = "§6Einstellungen Welt 4.3";


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

    Inventory OptionsCW11 = Bukkit.createInventory(null, 9 * 6, OCW11);
    Inventory OptionsCW21 = Bukkit.createInventory(null, 9 * 6, OCW21);
    Inventory OptionsCW31 = Bukkit.createInventory(null, 9 * 6, OCW31);
    Inventory OptionsCW41 = Bukkit.createInventory(null, 9 * 6, OCW41);

    Inventory OptionsCW12 = Bukkit.createInventory(null, 9 * 6, OCW12);
    Inventory OptionsCW22 = Bukkit.createInventory(null, 9 * 6, OCW22);
    Inventory OptionsCW32 = Bukkit.createInventory(null, 9 * 6, OCW32);
    Inventory OptionsCW42 = Bukkit.createInventory(null, 9 * 6, OCW42);

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
            itemMeta22.setLore(Arrays.asList(" ", "§7§oSchaltet den Timer aus!", " "));
            Timer1.setItemMeta(itemMeta22);
            OptionsCW1.setItem(19, Timer1);
        } else if (Main.getPlugin().getTimer() == true) {
            ItemStack Timer2 = new ItemStack(Material.GRAY_DYE, 1);
            ItemMeta itemMeta2 = Timer2.getItemMeta();
            itemMeta2.setDisplayName("§cTimer -> AUS §4\u2715");
            itemMeta2.setLore(Arrays.asList(" ", "§7§oSchaltet den Timer an!", " "));
            Timer2.setItemMeta(itemMeta2);
            OptionsCW1.setItem(19, Timer2);
        }

        ItemStack sh = new ItemStack(Material.POTION, 1);
        PotionMeta meta = (PotionMeta) sh.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.INSTANT_DAMAGE, false, true));
        meta.setDisplayName("§6Split-Herzen");
        meta.setLore(Arrays.asList(" ", "§7§oAlle Spieler haben §7§o§lEIN §7§oeinheitliches Leben", " "));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        sh.setItemMeta(meta);
        OptionsCW1.setItem(12, sh);

        ItemStack KA1 = new ItemStack(Material.GREEN_DYE, 1);
        ItemMeta itemMeta7 = KA1.getItemMeta();
        itemMeta7.setDisplayName("§cSplit-Herzen -> AN §a\u2714");
        itemMeta7.setLore(Arrays.asList(" ", "§7§oSchaltet das einheitliche Leben aus!", " "));
        KA1.setItemMeta(itemMeta7);
        OptionsCW1.setItem(21, KA1);

        ItemStack KA2 = new ItemStack(Material.GRAY_DYE, 1);
        ItemMeta itemMeta77 = KA2.getItemMeta();
        itemMeta77.setDisplayName("§cSplit-Herzen -> AUS §4\u2715");
        itemMeta77.setLore(Arrays.asList(" ", "§7§oSchaltet das einheitliche Leben an!", " "));
        KA2.setItemMeta(itemMeta77);
        OptionsCW1.setItem(21, KA2);


        ItemStack hp = new ItemStack(Material.POTION, 1);
        PotionMeta meta1 = (PotionMeta) sh.getItemMeta();
        meta1.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL, false, true));
        meta1.setDisplayName("§6Anzahl der Herzen");
        meta1.setLore(Arrays.asList(" ", "§7§oStandard: §7§o§l10 §7§oHerzen", " "));
        meta1.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        hp.setItemMeta(meta1);
        OptionsCW1.setItem(14, hp);

        //GETTERS UND SETTERS MACHEN
        ItemStack hp1 = new ItemStack(Material.LIGHT_BLUE_DYE, 1);
        ItemMeta itemMeta8 = hp1.getItemMeta();
        itemMeta8.setDisplayName("§cHalbes Herz: \u002B");
        itemMeta8.setLore(Arrays.asList(" ", "§7§oErhöht das Leben um ein halbes Herz!", " "));
        hp1.setItemMeta(itemMeta8);
        OptionsCW1.setItem(23, hp1);

        ItemStack hp2 = new ItemStack(Material.MAGENTA_DYE, 1);
        ItemMeta itemMeta88 = hp2.getItemMeta();
        itemMeta88.setDisplayName("§cHalbes Herz: \u002D");
        itemMeta88.setLore(Arrays.asList(" ", "§7§oVerringert das Leben um ein halbes Herz!", " "));
        hp2.setItemMeta(itemMeta88);
        OptionsCW1.setItem(32, hp2);

        ItemStack food = new ItemStack(Material.COOKED_CHICKEN, 1);
        ItemMeta imf = food.getItemMeta();
        imf.setDisplayName("§6Hunger");
        imf.setLore(Arrays.asList(" ", "§7§oSchaltet den Hunger ein oder aus!", " "));
        food.setItemMeta(imf);
        OptionsCW1.setItem(16, food);

        //GETTER UND SETTER MACHEN
        ItemStack fl = new ItemStack(Material.GREEN_DYE, 1);
        ItemMeta imfl = fl.getItemMeta();
        imfl.setDisplayName("§cHunger -> AN §a\u2714");
        imfl.setLore(Arrays.asList(" ", "§7§oSchaltet den Hunger aus!", " "));
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

    public void openOCW11(Player player) {

        for (int k = 0; k < 9; k++) {
            ItemStack deko14 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta d = deko14.getItemMeta();
            d.setDisplayName(" ");
            deko14.setItemMeta(d);
            deko14.setAmount(1);
            OptionsCW11.setItem(k, deko14);

        }

        ItemStack wo = new ItemStack(Material.REPEATER);
        ItemMeta imwo = wo.getItemMeta();
        imwo.setDisplayName("§6Challenge Einstellungen");
        wo.setItemMeta(imwo);
        wo.setAmount(1);
        OptionsCW11.setItem(4, wo);

        for (int k = 9; k < 18; k++) {
            ItemStack deko1 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            ItemMeta d = deko1.getItemMeta();
            d.setDisplayName(" ");
            deko1.setItemMeta(d);
            deko1.setAmount(1);
            OptionsCW11.setItem(k, deko1);
        }

        ItemStack bp = new ItemStack(Material.CHEST, 1);
        ItemMeta imbp = bp.getItemMeta();
        imbp.setDisplayName("§6Backpack");
        imbp.setLore(Arrays.asList(" ", "§7§oEin integriertes Backpack mit §7§o§l/bp§7§o!", " "));
        bp.setItemMeta(imbp);
        OptionsCW11.setItem(10, bp);

        if (Main.getPlugin().getBP() == false) {
            ItemStack Timer1 = new ItemStack(Material.GREEN_DYE, 1);
            ItemMeta itemMeta22 = Timer1.getItemMeta();
            itemMeta22.setDisplayName("§cBackpack -> AN §a\u2714");
            itemMeta22.setLore(Arrays.asList(" ", "§7§oSchaltet das Backpack aus!", " "));
            Timer1.setItemMeta(itemMeta22);
            OptionsCW11.setItem(19, Timer1);
        } else if (Main.getPlugin().getBP() == true) {
            ItemStack Timer2 = new ItemStack(Material.GRAY_DYE, 1);
            ItemMeta itemMeta2 = Timer2.getItemMeta();
            itemMeta2.setDisplayName("§cBackpack -> AUS §4\u2715");
            itemMeta2.setLore(Arrays.asList(" ", "§7§oSchaltet das Backpack aus!", " "));
            Timer2.setItemMeta(itemMeta2);
            OptionsCW11.setItem(19, Timer2);
        }

        ItemStack ED = new ItemStack(Material.BRICK_STAIRS, 1);
        ItemMeta imed = ED.getItemMeta();
        imed.setDisplayName("§6Sneak = Kill");
        imed.setLore(Arrays.asList(" ", "§7§oDirekte tötung durch Schleichen!", " "));
        ED.setItemMeta(imed);
        OptionsCW11.setItem(12, ED);

        if (Main.getPlugin().getSKL() == false) {
            ItemStack EDK1 = new ItemStack(Material.GREEN_DYE, 1);
            ItemMeta itemMeta7 = EDK1.getItemMeta();
            itemMeta7.setDisplayName("§cSneak = Kill -> AN §a\u2714");
            itemMeta7.setLore(Arrays.asList(" ", "§7§oSchaltet Sneak = Kill aus!", " "));
            EDK1.setItemMeta(itemMeta7);
            OptionsCW11.setItem(21, EDK1);
        } else if (Main.getPlugin().getSKL() == true) {
            ItemStack EDK2 = new ItemStack(Material.GRAY_DYE, 1);
            ItemMeta itemMeta77 = EDK2.getItemMeta();
            itemMeta77.setDisplayName("§cSneak = Kill -> AUS §4\u2715");
            itemMeta77.setLore(Arrays.asList(" ", "§7§oSchaltet Sneak = Kill an!", " "));
            EDK2.setItemMeta(itemMeta77);
            OptionsCW11.setItem(21, EDK2);
        }

        ItemStack hp = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta imhp = hp.getItemMeta();
        imhp.setDisplayName("§6UHC");
        imhp.setLore(Arrays.asList(" ", "§7§oKeine natürliche Regeneration!", " "));
        hp.setItemMeta(imhp);
        OptionsCW11.setItem(14, hp);

        if (Main.getPlugin().getUHC() == false) {
            ItemStack hp1 = new ItemStack(Material.GREEN_DYE, 1);
            ItemMeta itemMeta8 = hp1.getItemMeta();
            itemMeta8.setDisplayName("§cUHC -> AN §4\u2715");
            itemMeta8.setLore(Arrays.asList(" ", "§7§oSchaltet UHC aus!", " "));
            hp1.setItemMeta(itemMeta8);
            OptionsCW11.setItem(23, hp1);
        } else if (Main.getPlugin().getUHC() == true) {
            ItemStack hp2 = new ItemStack(Material.GRAY_DYE, 1);
            ItemMeta itemMeta88 = hp2.getItemMeta();
            itemMeta88.setDisplayName("§cUHC -> AUS §4\u2715");
            itemMeta88.setLore(Arrays.asList(" ", "§7§oSchaltet UHC an!", " "));
            hp2.setItemMeta(itemMeta88);
            OptionsCW11.setItem(23, hp2);
        }

        ItemStack food = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
        ItemMeta imf = food.getItemMeta();
        imf.setDisplayName("§6UUHC");
        imf.setLore(Arrays.asList(" ", "§7§oKeine Regeneration!", "§7§o§lWirklich keine *_*!", " "));
        food.setItemMeta(imf);
        OptionsCW11.setItem(16, food);

        if (Main.getPlugin().getUUHC() == false) {
            ItemStack hp1 = new ItemStack(Material.GREEN_DYE, 1);
            ItemMeta itemMeta8 = hp1.getItemMeta();
            itemMeta8.setDisplayName("§cUUHC -> AN §4\u2715");
            itemMeta8.setLore(Arrays.asList(" ", "§7§oSchaltet UUHC aus!", " "));
            hp1.setItemMeta(itemMeta8);
            OptionsCW11.setItem(25, hp1);
        } else if (Main.getPlugin().getUUHC() == true) {
            ItemStack hp2 = new ItemStack(Material.GRAY_DYE, 1);
            ItemMeta itemMeta88 = hp2.getItemMeta();
            itemMeta88.setDisplayName("§cUUHC -> AUS §4\u2715");
            itemMeta88.setLore(Arrays.asList(" ", "§7§oSchaltet UUHC an!", " "));
            hp2.setItemMeta(itemMeta88);
            OptionsCW11.setItem(25, hp2);
        }


        for (int k = 45; k < 54; k++) {
            ItemStack deko14 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            ItemMeta d = deko14.getItemMeta();
            d.setDisplayName(" ");
            deko14.setItemMeta(d);
            deko14.setAmount(1);
            OptionsCW11.setItem(k, deko14);
        }

        ItemStack bq = new ItemStack(Material.WRITABLE_BOOK, 1);
        ItemMeta imbq = bq.getItemMeta();
        imbq.setDisplayName("§6Save & Quit");
        imbq.setLore(Arrays.asList(" ", "§7§oSpeichert die Einstellungen und schließt das Inventar!", " "));
        bq.setItemMeta(imbq);
        OptionsCW11.setItem(48, bq);

        ItemStack emer = new ItemStack(Material.EMERALD, 1);
        ItemMeta ime = emer.getItemMeta();
        ime.setDisplayName("§6Save & Teleport");
        ime.setLore(Arrays.asList(" ", "§7§oSpeichert die Einstellungen und Teleportiert dich!", " "));
        emer.setItemMeta(ime);
        OptionsCW11.setItem(50, emer);

        ItemStack map = new ItemStack(Material.MAP, 1);
        ItemMeta imm = map.getItemMeta();
        imm.setDisplayName("§6§lWeiter");
        imm.setLore(Arrays.asList(" ", "§7§oNächste Menü-Seite", " "));
        map.setItemMeta(imm);
        OptionsCW11.setItem(53, map);

        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7§oLetzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        OptionsCW11.setItem(45, Zurück);

        player.openInventory(OptionsCW11);
    }

    public void openOCW12(Player player) {

        for (int k = 0; k < 9; k++) {
            ItemStack deko14 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta d = deko14.getItemMeta();
            d.setDisplayName(" ");
            deko14.setItemMeta(d);
            deko14.setAmount(1);
            OptionsCW12.setItem(k, deko14);

        }

        ItemStack wo = new ItemStack(Material.REPEATER);
        ItemMeta imwo = wo.getItemMeta();
        imwo.setDisplayName("§6Challenge Einstellungen");
        wo.setItemMeta(imwo);
        wo.setAmount(1);
        OptionsCW12.setItem(4, wo);

        for (int k = 9; k < 18; k++) {
            ItemStack deko1 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            ItemMeta d = deko1.getItemMeta();
            d.setDisplayName(" ");
            deko1.setItemMeta(d);
            deko1.setAmount(1);
            OptionsCW12.setItem(k, deko1);
        }
        //FDMG,KIllall,EnderDragon
        ItemStack bp = new ItemStack(Material.GOLDEN_BOOTS, 1);
        ItemMeta imbp = bp.getItemMeta();
        imbp.setDisplayName("§6Fallschaden");
        imbp.setLore(Arrays.asList(" ", "§7§oNormaler Fallschaden oder instant Kill?", " "));
        bp.setItemMeta(imbp);
        OptionsCW12.setItem(10, bp);

        if (Main.getPlugin().getFDMG() == false) {
            ItemStack Timer1 = new ItemStack(Material.GREEN_DYE, 1);
            ItemMeta itemMeta22 = Timer1.getItemMeta();
            itemMeta22.setDisplayName("§cFallschaden = Kill -> AN §a\u2714");
            itemMeta22.setLore(Arrays.asList(" ", "§7§oSchaltet Fallschaden = Kill aus!", " "));
            Timer1.setItemMeta(itemMeta22);
            OptionsCW12.setItem(19, Timer1);
        } else if (Main.getPlugin().getFDMG() == true) {
            ItemStack Timer2 = new ItemStack(Material.GRAY_DYE, 1);
            ItemMeta itemMeta2 = Timer2.getItemMeta();
            itemMeta2.setDisplayName("§cFallschaden = Kill -> AUS §4\u2715");
            itemMeta2.setLore(Arrays.asList(" ", "§7§oSchaltet Fallschaden = Kill aus!", " "));
            Timer2.setItemMeta(itemMeta2);
            OptionsCW12.setItem(19, Timer2);
        }

        ItemStack ED = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
        ItemMeta imed = ED.getItemMeta();
        imed.setDisplayName("§6Player Death = Kill all");
        imed.setLore(Arrays.asList(" ", "§7§oChallenge ist beendet, wenn ein Spieler stirbt!", " "));
        ED.setItemMeta(imed);
        OptionsCW12.setItem(12, ED);

        if (Main.getPlugin().getKA() == false) {
            ItemStack EDK1 = new ItemStack(Material.GREEN_DYE, 1);
            ItemMeta itemMeta7 = EDK1.getItemMeta();
            itemMeta7.setDisplayName("§cPlayer Death = Kill -> AN §a\u2714");
            itemMeta7.setLore(Arrays.asList(" ", "§7§oSchaltet Player Death = Kill aus!", " "));
            EDK1.setItemMeta(itemMeta7);
            OptionsCW12.setItem(21, EDK1);
        } else if (Main.getPlugin().getKA() == true) {
            ItemStack EDK2 = new ItemStack(Material.GRAY_DYE, 1);
            ItemMeta itemMeta77 = EDK2.getItemMeta();
            itemMeta77.setDisplayName("§cPlayer Death = Kill -> AUS §4\u2715");
            itemMeta77.setLore(Arrays.asList(" ", "§7§oSchaltet Player Death = Kill an!", " "));
            EDK2.setItemMeta(itemMeta77);
            OptionsCW12.setItem(21, EDK2);
        }

        ItemStack hp = new ItemStack(Material.DRAGON_HEAD, 1);
        ItemMeta imhp = hp.getItemMeta();
        imhp.setDisplayName("§6Ziel: Ender Drache");
        imhp.setLore(Arrays.asList(" ", "§7§oSetzt das Challenge Ziel auf:", "§7§o§lTöte den Ender Drachen", " "));
        hp.setItemMeta(imhp);
        OptionsCW12.setItem(14, hp);

        if (Main.getPlugin().getEDK() == false) {
            ItemStack hp1 = new ItemStack(Material.GREEN_DYE, 1);
            ItemMeta itemMeta8 = hp1.getItemMeta();
            itemMeta8.setDisplayName("§cZiel: Ender Drache -> AN §4\u2715");
            itemMeta8.setLore(Arrays.asList(" ", "§7§oChallenge Ziel: §7§o§lEnder Drache§7§o!", " "));
            hp1.setItemMeta(itemMeta8);
            OptionsCW12.setItem(23, hp1);
        } else if (Main.getPlugin().getEDK() == true) {
            ItemStack hp2 = new ItemStack(Material.GRAY_DYE, 1);
            ItemMeta itemMeta88 = hp2.getItemMeta();
            itemMeta88.setDisplayName("§cZiel: Ender Drache -> AUS §4\u2715");
            itemMeta88.setLore(Arrays.asList(" ", "§7§oChallenge Ziel: §7§o§lUnbekannt§7§o!", " "));
            hp2.setItemMeta(itemMeta88);
            OptionsCW12.setItem(23, hp2);
        }

        ItemStack food = new ItemStack(Material.BEDROCK, 1);
        ItemMeta imf = food.getItemMeta();
        imf.setDisplayName("§6Platzhalter");
        imf.setLore(Arrays.asList(" ", "§7§oPlatz für Zuküntige Challenges!", " "));
        food.setItemMeta(imf);
        OptionsCW12.setItem(16, food);

        /*if(Main.getPlugin().getUUHC() == false) {
            ItemStack hp1 = new ItemStack(Material.GREEN_DYE, 1);
            ItemMeta itemMeta8 = hp1.getItemMeta();
            itemMeta8.setDisplayName("§cUUHC -> AUS §4\u2715");
            itemMeta8.setLore(Arrays.asList(" ", "§7§oSchaltet UUHC aus!", " "));
            hp1.setItemMeta(itemMeta8);
            OptionsCW12.setItem(25, hp1);
        }else if(Main.getPlugin().getUUHC() == true) {
            ItemStack hp2 = new ItemStack(Material.GRAY_DYE, 1);
            ItemMeta itemMeta88 = hp2.getItemMeta();
            itemMeta88.setDisplayName("§cUUHC -> AUS §4\u2715");
            itemMeta88.setLore(Arrays.asList(" ", "§7§oSchaltet UUHC an!", " "));
            hp2.setItemMeta(itemMeta88);
            OptionsCW12.setItem(25, hp2);
        }*/


        for (int k = 45; k < 54; k++) {
            ItemStack deko14 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            ItemMeta d = deko14.getItemMeta();
            d.setDisplayName(" ");
            deko14.setItemMeta(d);
            deko14.setAmount(1);
            OptionsCW12.setItem(k, deko14);
        }

        ItemStack bq = new ItemStack(Material.WRITABLE_BOOK, 1);
        ItemMeta imbq = bq.getItemMeta();
        imbq.setDisplayName("§6Save & Quit");
        imbq.setLore(Arrays.asList(" ", "§7§oSpeichert die Einstellungen und schließt das Inventar!", " "));
        bq.setItemMeta(imbq);
        OptionsCW12.setItem(48, bq);

        ItemStack emer = new ItemStack(Material.EMERALD, 1);
        ItemMeta ime = emer.getItemMeta();
        ime.setDisplayName("§6Save & Teleport");
        ime.setLore(Arrays.asList(" ", "§7§oSpeichert die Einstellungen und Teleportiert dich!", " "));
        emer.setItemMeta(ime);
        OptionsCW12.setItem(50, emer);

        ItemStack map = new ItemStack(Material.MAP, 1);
        ItemMeta imm = map.getItemMeta();
        imm.setDisplayName("§6§lWeiter");
        imm.setLore(Arrays.asList(" ", "§7§oNächste Menü-Seite", " "));
        map.setItemMeta(imm);
        OptionsCW12.setItem(53, map);

        ItemStack Zurück = new ItemStack(Material.RED_DYE);
        ItemMeta itemMetaZ = Zurück.getItemMeta();
        itemMetaZ.setDisplayName("§6§lZurück!");
        itemMetaZ.setLore(Arrays.asList(" ", "§7§oLetzte Menü-Seite", " "));
        Zurück.setItemMeta(itemMetaZ);
        Zurück.setAmount(1);
        OptionsCW12.setItem(45, Zurück);

        player.openInventory(OptionsCW12);
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

                        World world = Bukkit.getWorld(inv.getString("World"));
                        Double X = inv.getDouble("X");
                        Double Y = inv.getDouble("Y");
                        Double Z = inv.getDouble("Z");
                        Location loc = new Location(world, X, Y, Z);
                        player.teleport(loc);

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

                        World world = Bukkit.getWorld(inv.getString("World"));
                        Double X = inv.getDouble("X");
                        Double Y = inv.getDouble("Y");
                        Double Z = inv.getDouble("Z");
                        Location loc = new Location(world, X, Y, Z);
                        player.teleport(loc);

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

                        World world = Bukkit.getWorld(inv.getString("World"));
                        Double X = inv.getDouble("X");
                        Double Y = inv.getDouble("Y");
                        Double Z = inv.getDouble("Z");
                        Location loc = new Location(world, X, Y, Z);
                        player.teleport(loc);

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

                        World world = Bukkit.getWorld(inv.getString("World"));
                        Double X = inv.getDouble("X");
                        Double Y = inv.getDouble("Y");
                        Double Z = inv.getDouble("Z");
                        Location loc = new Location(world, X, Y, Z);
                        player.teleport(loc);

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

                            World world = Bukkit.getWorld(inv.getString("World"));
                            Double X = inv.getDouble("X");
                            Double Y = inv.getDouble("Y");
                            Double Z = inv.getDouble("Z");
                            Location loc = new Location(world, X, Y, Z);
                            player.teleport(loc);

                            for (int i = 0; i < player.getInventory().getSize(); i++) {
                                player.getInventory().setItem((Integer) slot.get(i), (ItemStack) list.get(i));
                            }

                            file.delete();

                            return;
                        }

                        player.setGameMode(GameMode.SURVIVAL);
                        player.closeInventory();
                        player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt 1!");
                    } else {
                        player.sendMessage("§aServer " + "§8>> " + "§cEs existiert keine Welt 1!");
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

                        //Inventar löschen
                        String playername = player.getName();
                        File file = new File("plugins//InstantSkillzTV//Inventories//" + world1 + "//" + playername + ".yml");
                        file.delete();

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
                        player.sendMessage("§aServer " + "§8>> " + "§cWelt 1 wurde gelöscht!");
                        openGUI2(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-1") == null) {
                        player.sendMessage(Main.getPlugin().PREFIX + "§cEs existiert keine Welt 1!");
                        break;
                    }
                    break;

                case RED_DYE:

                    openGUI2(player.getPlayer());
                    break;

                default:
                    break;
            }
        }

    }

    @EventHandler
    public void CW1InvEinstellungen1(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals(OCW1)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {

                case WRITABLE_BOOK:
                    player.closeInventory();
                    break;
                case EMERALD:
                    World world1 = Bukkit.getWorld("Challenge-1");
                    Location location1 = world1.getSpawnLocation();
                    location1.setY(world1.getHighestBlockYAt(location1) + 1);
                    player.teleport(location1);
                    player.getInventory().clear();
                    player.setGameMode(GameMode.SURVIVAL);
                    player.closeInventory();
                    player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt 1!");
                    break;
                case RED_DYE:
                    openCW1(player.getPlayer());
                    break;
                case MAP:
                    openOCW11(player.getPlayer());
                    break;
                default:
                    break;
            }

            if (event.getSlot() == 19) {
                if (event.getCurrentItem().getType() == Material.GREEN_DYE) {
                    Main.getPlugin().setTimer(true);
                    openOWC1(player.getPlayer());
                } else if (event.getCurrentItem().getType() == Material.GRAY_DYE) {
                    Main.getPlugin().setTimer(false);
                    openOWC1(player.getPlayer());
                }
            }
            if (event.getSlot() == 21) {
                if (event.getCurrentItem().getType() == Material.GREEN_DYE) {

                } else if (event.getCurrentItem().getType() == Material.GRAY_DYE) {

                }
            }
            if (event.getSlot() == 23) {

            }
            if (event.getSlot() == 32) {

            }
            if (event.getSlot() == 25) {
                if (event.getCurrentItem().getType() == Material.GREEN_DYE) {

                } else if (event.getCurrentItem().getType() == Material.GRAY_DYE) {

                }
            }

        }

    }

    @EventHandler
    public void CW1InvEinstellungen2(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(OCW11)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {

                case WRITABLE_BOOK:
                    player.closeInventory();
                    break;
                case EMERALD:
                    World world1 = Bukkit.getWorld("Challenge-1");
                    Location location1 = world1.getSpawnLocation();
                    location1.setY(world1.getHighestBlockYAt(location1) + 1);
                    player.teleport(location1);
                    player.getInventory().clear();
                    player.setGameMode(GameMode.SURVIVAL);
                    player.closeInventory();
                    player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt 1!");
                    break;
                case RED_DYE:
                    openOWC1(player.getPlayer());
                    break;
                case MAP:
                    openOCW12(player.getPlayer());
                    break;

                default:
                    break;
            }

            if (event.getSlot() == 19) {
                if (event.getCurrentItem().getType() == Material.GREEN_DYE) {
                    Main.getPlugin().setBP(true);
                    openOCW11(player.getPlayer());
                } else if (event.getCurrentItem().getType() == Material.GRAY_DYE) {
                    Main.getPlugin().setBP(false);
                    openOCW11(player.getPlayer());
                }
            }
            if (event.getSlot() == 21) {
                if (event.getCurrentItem().getType() == Material.GREEN_DYE) {
                    Main.getPlugin().setSKL(true);
                    openOCW11(player.getPlayer());
                } else if (event.getCurrentItem().getType() == Material.GRAY_DYE) {
                    Main.getPlugin().setSKL(false);
                    openOCW11(player.getPlayer());
                }
            }
            if (event.getSlot() == 23) {
                if (event.getCurrentItem().getType() == Material.GREEN_DYE) {
                    Main.getPlugin().setUHC(true);
                    openOCW11(player.getPlayer());
                } else if (event.getCurrentItem().getType() == Material.GRAY_DYE) {
                    Main.getPlugin().setUHC(false);
                    openOCW11(player.getPlayer());
                }
            }
            if (event.getSlot() == 25) {
                if (event.getCurrentItem().getType() == Material.GREEN_DYE) {
                    Main.getPlugin().setUUHC(true);
                    openOCW11(player.getPlayer());
                } else if (event.getCurrentItem().getType() == Material.GRAY_DYE) {
                    Main.getPlugin().setUUHC(false);
                    openOCW11(player.getPlayer());
                }
            }
        }

    }

    @EventHandler
    public void CW1InvEinstellungen3(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(OCW12)) {
            event.setCancelled(true);

            switch (event.getCurrentItem().getType()) {

                case WRITABLE_BOOK:
                    player.closeInventory();
                    break;
                case EMERALD:
                    World world1 = Bukkit.getWorld("Challenge-1");
                    Location location1 = world1.getSpawnLocation();
                    location1.setY(world1.getHighestBlockYAt(location1) + 1);
                    player.teleport(location1);
                    player.getInventory().clear();
                    player.setGameMode(GameMode.SURVIVAL);
                    player.closeInventory();
                    player.sendMessage("§aServer " + "§8>> " + "§aTeleportiert in: §6Welt 1!");
                    break;
                case RED_DYE:
                    openOCW11(player.getPlayer());
                    break;
                case MAP:
                    player.sendMessage(Main.getPlugin().PREFIX + "§aSeiten werden folgen!");
                    break;

                default:
                    break;
            }

            if (event.getSlot() == 19) {
                if (event.getCurrentItem().getType() == Material.GREEN_DYE) {
                    Main.getPlugin().setFDMG(true);
                    openOCW12(player.getPlayer());
                } else if (event.getCurrentItem().getType() == Material.GRAY_DYE) {
                    Main.getPlugin().setFDMG(false);
                    openOCW12(player.getPlayer());
                }
            }
            if (event.getSlot() == 21) {
                if (event.getCurrentItem().getType() == Material.GREEN_DYE) {
                    Main.getPlugin().setKA(true);
                    openOCW12(player.getPlayer());
                } else if (event.getCurrentItem().getType() == Material.GRAY_DYE) {
                    Main.getPlugin().setKA(false);
                    openOCW12(player.getPlayer());
                }
            }
            if (event.getSlot() == 23) {
                if (event.getCurrentItem().getType() == Material.GREEN_DYE) {
                    Main.getPlugin().setEDK(true);
                    openOCW12(player.getPlayer());
                } else if (event.getCurrentItem().getType() == Material.GRAY_DYE) {
                    Main.getPlugin().setEDK(false);
                    openOCW12(player.getPlayer());
                }
            }
            /*if(event.getSlot()  == 25){
                if(event.getCurrentItem().getType() == Material.GREEN_DYE){
                    Main.getPlugin().setUUHC(true);
                    openOCW11(player.getPlayer());
                }else if(event.getCurrentItem().getType() == Material.GRAY_DYE){
                    Main.getPlugin().setUUHC(false);
                    openOCW11(player.getPlayer());
                }
            }*/
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
                            World world = Bukkit.getWorld(inv.getString("World"));
                            Double X = inv.getDouble("X");
                            Double Y = inv.getDouble("Y");
                            Double Z = inv.getDouble("Z");
                            Location loc = new Location(world, X, Y, Z);
                            player.teleport(loc);

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
                        //Welt-Löschen
                        File challenge2 = new File("Challenge-2");

                        //Inventar löschen
                        String playername = player.getName();
                        File file = new File("plugins//InstantSkillzTV//Inventories//" + world1 + "//" + playername + ".yml");
                        file.delete();

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
                        player.sendMessage("§aServer " + "§8>> " + "§cWelt 2 wurde gelöscht!");
                        openGUI2(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-2") == null) {
                        player.sendMessage(Main.getPlugin().PREFIX + "§cEs existiert keine Welt 2!");
                        break;
                    }
                    break;

                case RED_DYE:

                    openGUI2(player.getPlayer());
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

                            World world = Bukkit.getWorld(inv.getString("World"));
                            Double X = inv.getDouble("X");
                            Double Y = inv.getDouble("Y");
                            Double Z = inv.getDouble("Z");
                            Location loc = new Location(world, X, Y, Z);
                            player.teleport(loc);

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
                        //Welt-Löschen
                        File challenge3 = new File("Challenge-3");

                        //Inventar löschen
                        String playername = player.getName();
                        File file = new File("plugins//InstantSkillzTV//Inventories//" + world1 + "//" + playername + ".yml");
                        file.delete();

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
                        player.sendMessage("§aServer " + "§8>> " + "§cWelt 3 wurde gelöscht!");
                        openGUI2(player.getPlayer());
                        break;
                    } else if (Bukkit.getWorld("Challenge-3") == null) {
                        player.sendMessage(Main.getPlugin().PREFIX + "§cEs existiert keine Welt 3!");
                        break;
                    }
                    break;

                case RED_DYE:

                    openGUI2(player.getPlayer());
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
                            World world = Bukkit.getWorld(inv.getString("World"));
                            Double X = inv.getDouble("X");
                            Double Y = inv.getDouble("Y");
                            Double Z = inv.getDouble("Z");
                            Location loc = new Location(world, X, Y, Z);
                            player.teleport(loc);

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
                        //Welt-Löschen
                        File challenge4 = new File("Challenge-4");

                        //Inventar löschen
                        String playername = player.getName();
                        File file = new File("plugins//InstantSkillzTV//Inventories//" + world1 + "//" + playername + ".yml");
                        file.delete();

                        if (challenge4.exists()) {

                            Bukkit.unloadWorld("Challenge-4", true);

                            File data4 = new File("Challenge-4\\data");
                            if (data4.exists()) {
                                for (File files1 : data4.listFiles()) {
                                    files1.delete();
                                }
                                data4.delete();
                            }

                            File playerdata4 = new File("Challenge-4\\playerdata");
                            if (playerdata4.exists()) {
                                for (File files2 : playerdata4.listFiles()) {
                                    files2.delete();
                                }
                                playerdata4.delete();
                            }

                            File poi4 = new File("Challenge-4\\poi");
                            if (poi4.exists()) {
                                for (File files3 : poi4.listFiles()) {
                                    files3.delete();
                                }
                                poi4.delete();
                            }

                            File region4 = new File("Challenge-4\\region");
                            if (region4.exists()) {
                                for (File files4 : region4.listFiles()) {
                                    files4.delete();
                                }
                                region4.delete();
                            }

                            for (File files5 : challenge4.listFiles()) {
                                files5.delete();
                            }
                            challenge4.delete();
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

                    openGUI2(player.getPlayer());
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


