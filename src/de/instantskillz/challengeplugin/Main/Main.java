//Plugin by: InstantskillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Main;

import de.instantskillz.challengeplugin.Commands.*;
import de.instantskillz.challengeplugin.Listener.*;
import de.instantskillz.challengeplugin.Util.Navigator;
import de.instantskillz.challengeplugin.Util.RecipeLoader;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

//import de.instantskillz.challengeplugin.Commands.BingoWorldStart;
//import de.instantskillz.challengeplugin.Commands.BingoWorldStop;
//import de.instantskillz.challengeplugin.Commands.WorldDelete;
//import de.instantskillz.challengeplugin.Commands.WorldGenerator;

public class Main extends JavaPlugin {

    private static Main plugin;
    public final String PREFIX = "§aServer " + "§8>> §r";
    public SneakKillListener skl = new SneakKillListener();
    public GameModeListener gml = new GameModeListener();
    //Mein Pimmel ist groß

    //SneakKillEvent
    private boolean SKL = true;
    //TimerAn/Aus
    private boolean timer = true;
    //KillALL
    private boolean KA = true;
    //FallDMG
    private boolean FDMG = true;
    //Backpack
    private boolean BP = true;
    //BINGO
    private boolean BINGO = true;
    //EnderDragonKill
    private boolean EDK = true;
    //UUHC
    private boolean UUHC = true;
    //UHC
    private boolean UHC = true;

    public static Main getPlugin() {
        return plugin;
    }

    public void onEnable() {
        plugin = this;

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

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(muteCommand, this);
        pluginManager.registerEvents(new KillatAllListener(), this);
        pluginManager.registerEvents(new DamageChatListener(), this);
        pluginManager.registerEvents(new SneakKillListener(), this);
        //pluginManager.registerEvents(new FallDMGListener(), this);
        pluginManager.registerEvents(new Navigator(), this);
        //pluginManager.registerEvents(new RandomItemsChest(), this);
        pluginManager.registerEvents(new GameModeListener(), this);
        pluginManager.registerEvents(new BingoStart(), this);
        pluginManager.registerEvents(new EnderDragonKill(), this);
        pluginManager.registerEvents(new UUHC(), this);
        pluginManager.registerEvents(new UHC(), this);

        for (Player all : Bukkit.getOnlinePlayers()) {
            all.sendMessage("§aServer " + "§8>> " + "§aPlugin geladen.");
            all.setGameMode(GameMode.ADVENTURE);
        }

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


}
