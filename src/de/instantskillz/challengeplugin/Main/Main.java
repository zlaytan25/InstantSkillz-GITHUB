//Plugin by: InstantskillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Main;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.instantskillz.challengeplugin.Commands.*;
import de.instantskillz.challengeplugin.Listener.*;
import de.instantskillz.challengeplugin.Util.*;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

//import de.instantskillz.challengeplugin.Commands.BingoWorldStart;
//import de.instantskillz.challengeplugin.Commands.BingoWorldStop;
//import de.instantskillz.challengeplugin.Commands.WorldDelete;
//import de.instantskillz.challengeplugin.Commands.WorldGenerator;

public class Main extends JavaPlugin {

    private static Main plugin;
    public final String PREFIX = "§aServer " + "§8>> §r";
    public SneakKillListener skl = new SneakKillListener();
    public GameModeListener gml = new GameModeListener();


    //SneakKillEvent
    private boolean SKL = true;
    //TimerAn/Aus
    private boolean timer = false;
    //KillALL
    private boolean KA = false;
    //FallDMG
    private boolean FDMG = true;
    //Backpack
    private boolean BP = false;
    //BINGO
    private boolean BINGO = true;
    //EnderDragonKill
    private boolean EDK = false;
    //UUHC
    private boolean UUHC = true;
    //UHC
    private boolean UHC = true;
    //SplitHerzen
    private boolean SH = true;
    //Hunger
    private boolean Hunger = false;

    public static Main getPlugin() {
        return plugin;
    }

    public void onEnable() {
        plugin = this;

        for (Player all : Bukkit.getOnlinePlayers()) {
            all.setGameMode(GameMode.ADVENTURE);
            all.sendMessage("§aServer " + "§8>> " + "§aPlugin geladen.");
        }

        MuteCommand muteCommand = new MuteCommand();
        new RecipeLoader().registerRecipes();

        getCommand("heal").setExecutor(new HealCommand());
        getCommand("kit").setExecutor(new KitCommand());
        getCommand("setspawn").setExecutor(new SetspawnCommand());
        getCommand("hub").setExecutor(new SpawnCommand());
        getCommand("chatclear").setExecutor(new ChatclearCommand());
        getCommand("mute").setExecutor(muteCommand);
        getCommand("inv").setExecutor(new InvCommand());
        getCommand("bp").setExecutor(new BackPackCommand());
        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("gm1").setExecutor(new GM1());
        getCommand("gm2").setExecutor(new GM2());
        getCommand("gm3").setExecutor(new GM3());
        getCommand("gm0").setExecutor(new GM0());
        //getCommand("startbingo").setExecutor(new BingoWorldStart());
        //getCommand("stopbingo").setExecutor(new BingoWorldStop());
        //getCommand("start").setExecutor(new WorldGenerator());
        //getCommand("delete").setExecutor(new WorldDelete());
        getCommand("modes").setExecutor(new GameModesStartStop());
        getCommand("bingo").setExecutor(new BingoStart());
        getCommand("pos").setExecutor(new PositionSafeCommand());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(muteCommand, this);
        pluginManager.registerEvents(new KillatAllListener(), this);
        pluginManager.registerEvents(new DamageChatListener(), this);
        pluginManager.registerEvents(new SneakKillListener(), this);
        //pluginManager.registerEvents(new FallDMGListener(), this);
        pluginManager.registerEvents(new Navigator(), this);
        pluginManager.registerEvents(new RandomItemsChest(), this);
        pluginManager.registerEvents(new GameModeListener(), this);
        pluginManager.registerEvents(new BingoStart(), this);
        pluginManager.registerEvents(new EnderDragonKill(), this);
        pluginManager.registerEvents(new UUHC(), this);
        pluginManager.registerEvents(new UHC(), this);
        pluginManager.registerEvents(new SplitHerzen(), this);
        pluginManager.registerEvents(new HungerOnOff(), this);
        pluginManager.registerEvents(new BackPackCommand(),this);


    }

    public boolean getSKL() {
        return SKL;
    }

    public void setSKL(boolean start) {
        this.SKL = start;
    }

    public boolean getTimer() {
        return timer;
    }

    public void setTimer(boolean start) {
        this.timer = start;
    }

    public boolean getKA() {
        return KA;
    }

    public void setKA(boolean start) {
        this.KA = start;
    }

    public boolean getFDMG() {
        return FDMG;
    }

    public void setFDMG(boolean start) {
        this.FDMG = start;
    }

    public boolean getBP() {
        return BP;
    }

    public void setBP(boolean start) {
        this.BP = start;
    }

    public boolean getBINGO() {
        return BINGO;
    }

    public void setBINGO(boolean start) {
        this.BINGO = start;
    }

    public boolean getEDK() {
        return EDK;
    }

    public void setEDK(boolean start) {
        this.EDK = start;
    }

    public boolean getUUHC() {
        return UUHC;
    }

    public void setUUHC(boolean start) {
        this.UUHC = start;
    }

    public boolean getUHC() {
        return UHC;
    }

    public void setUHC(boolean start) {
        this.UHC = start;
    }

    public boolean getSH() {
        return SH;
    }

    public void setSH(boolean start) {
        this.SH = start;
    }

    public boolean getHunger() {
        return Hunger;
    }

    public void setHunger(boolean start) {
        this.Hunger = start;
    }

    public static ItemStack getBingoHead(String name) {
        for (BingoSkull head : BingoSkull.values()) {
            if (head.getIdTag().equalsIgnoreCase(name)) {
                return head.getItemStack();
            }
        }
        return null;
    }

    public static ItemStack createBingoSkull(String url, String name) {

        ItemStack skullBingo = new ItemStack(Material.PLAYER_HEAD, 1);
        if (url.isEmpty()) return skullBingo;
        SkullMeta smeta = (SkullMeta) skullBingo.getItemMeta();
        smeta.setDisplayName("§cStarte BINGO");
        smeta.setLore(Arrays.asList(" ", "§7§oErstellt eine Bingo Welt!", " "));
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = smeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(smeta, profile);
        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        skullBingo.setItemMeta(smeta);

        return skullBingo;
    }

    public static ItemStack getGlobeSkull1(String name) {
        for (GlobeSkull1 head : GlobeSkull1.values()) {
            if (head.getIdTag().equalsIgnoreCase(name)) {
                return head.getItemStack();
            }
        }
        return null;
    }

    public static ItemStack createGlobeSkull1(String url, String name) {

        ItemStack skullBingo = new ItemStack(Material.PLAYER_HEAD, 1);
        if (url.isEmpty()) return skullBingo;
        SkullMeta smeta1 = (SkullMeta) skullBingo.getItemMeta();
        smeta1.setDisplayName("§6§lWelt 1");
        smeta1.setLore(Arrays.asList(" ", "§7Rechtsklick: Detail Seite", "§7Linksklick: Quickjoin", " "));
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = smeta1.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(smeta1, profile);
        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        skullBingo.setItemMeta(smeta1);

        return skullBingo;
    }

    public static ItemStack getGlobeSkull2(String name) {
        for (GlobeSkull2 head : GlobeSkull2.values()) {
            if (head.getIdTag().equalsIgnoreCase(name)) {
                return head.getItemStack();
            }
        }
        return null;
    }

    public static ItemStack createGlobeSkull2(String url, String name) {

        ItemStack skullBingo = new ItemStack(Material.PLAYER_HEAD, 1);
        if (url.isEmpty()) return skullBingo;
        SkullMeta smeta1 = (SkullMeta) skullBingo.getItemMeta();
        smeta1.setDisplayName("§6§lWelt 2");
        smeta1.setLore(Arrays.asList(" ", "§7Rechtsklick: Detail Seite", "§7Linksklick: Quickjoin", " "));
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = smeta1.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(smeta1, profile);
        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        skullBingo.setItemMeta(smeta1);

        return skullBingo;
    }

    public static ItemStack getGlobeSkull3(String name) {
        for (GlobeSkull3 head : GlobeSkull3.values()) {
            if (head.getIdTag().equalsIgnoreCase(name)) {
                return head.getItemStack();
            }
        }
        return null;
    }

    public static ItemStack createGlobeSkull3(String url, String name) {

        ItemStack skullBingo = new ItemStack(Material.PLAYER_HEAD, 1);
        if (url.isEmpty()) return skullBingo;
        SkullMeta smeta1 = (SkullMeta) skullBingo.getItemMeta();
        smeta1.setDisplayName("§6§lWelt 3");
        smeta1.setLore(Arrays.asList(" ", "§7Rechtsklick: Detail Seite", "§7Linksklick: Quickjoin", " "));
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = smeta1.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(smeta1, profile);
        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        skullBingo.setItemMeta(smeta1);

        return skullBingo;
    }

    public static ItemStack getGlobeSkull4(String name) {
        for (GlobeSkull4 head : GlobeSkull4.values()) {
            if (head.getIdTag().equalsIgnoreCase(name)) {
                return head.getItemStack();
            }
        }
        return null;
    }

    public static ItemStack createGlobeSkull4(String url, String name) {

        ItemStack skullBingo = new ItemStack(Material.PLAYER_HEAD, 1);
        if (url.isEmpty()) return skullBingo;
        SkullMeta smeta1 = (SkullMeta) skullBingo.getItemMeta();
        smeta1.setDisplayName("§6§lWelt 4");
        smeta1.setLore(Arrays.asList(" ", "§7Rechtsklick: Detail Seite", "§7Linksklick: Quickjoin", " "));
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = smeta1.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(smeta1, profile);
        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        skullBingo.setItemMeta(smeta1);

        return skullBingo;
    }

    public static ItemStack getDeko1(String name) {
        for (DekoGS1 head : DekoGS1.values()) {
            if (head.getIdTag().equalsIgnoreCase(name)) {
                return head.getItemStack();
            }
        }
        return null;
    }

    public static ItemStack createDeko1(String url, String name) {

        ItemStack skullBingo = new ItemStack(Material.PLAYER_HEAD, 1);
        if (url.isEmpty()) return skullBingo;
        SkullMeta smeta1 = (SkullMeta) skullBingo.getItemMeta();
        smeta1.setDisplayName("§6§lWelt 1");
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = smeta1.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(smeta1, profile);
        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        skullBingo.setItemMeta(smeta1);

        return skullBingo;
    }

    public static ItemStack getDeko2(String name) {
        for (DekoGS2 head : DekoGS2.values()) {
            if (head.getIdTag().equalsIgnoreCase(name)) {
                return head.getItemStack();
            }
        }
        return null;
    }

    public static ItemStack createDeko2(String url, String name) {

        ItemStack skullBingo = new ItemStack(Material.PLAYER_HEAD, 1);
        if (url.isEmpty()) return skullBingo;
        SkullMeta smeta1 = (SkullMeta) skullBingo.getItemMeta();
        smeta1.setDisplayName("§6§lWelt 2");
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = smeta1.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(smeta1, profile);
        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        skullBingo.setItemMeta(smeta1);

        return skullBingo;
    }

    public static ItemStack getDeko3(String name) {
        for (DekoGS3 head : DekoGS3.values()) {
            if (head.getIdTag().equalsIgnoreCase(name)) {
                return head.getItemStack();
            }
        }
        return null;
    }

    public static ItemStack createDeko3(String url, String name) {

        ItemStack skullBingo = new ItemStack(Material.PLAYER_HEAD, 1);
        if (url.isEmpty()) return skullBingo;
        SkullMeta smeta1 = (SkullMeta) skullBingo.getItemMeta();
        smeta1.setDisplayName("§6§lWelt 3");
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = smeta1.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(smeta1, profile);
        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        skullBingo.setItemMeta(smeta1);

        return skullBingo;
    }

    public static ItemStack getDeko4(String name) {
        for (DekoGS4 head : DekoGS4.values()) {
            if (head.getIdTag().equalsIgnoreCase(name)) {
                return head.getItemStack();
            }
        }
        return null;
    }

    public static ItemStack createDeko4(String url, String name) {

        ItemStack skullBingo = new ItemStack(Material.PLAYER_HEAD, 1);
        if (url.isEmpty()) return skullBingo;
        SkullMeta smeta1 = (SkullMeta) skullBingo.getItemMeta();
        smeta1.setDisplayName("§6§lWelt 4");
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = smeta1.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(smeta1, profile);
        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        skullBingo.setItemMeta(smeta1);

        return skullBingo;
    }


}
