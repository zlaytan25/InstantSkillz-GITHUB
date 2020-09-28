//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Events;


import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ManHuntEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    final int MAX_SPIELER = 2;

    int spieler;
    int hunter;
    int player;


    static public HandlerList getHandlerList() {
        return handlers;
    }

    public int getMaxSpieler() {
        return MAX_SPIELER;
    }

    public int getSpieler() {
        return spieler;
    }

    public void setSpieler(int a) {
        spieler = spieler + a;
    }

    public int getHunter() {
        return hunter;
    }

    public void setHunter(int h) {
        hunter = hunter + h;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int p) {
        player = player + p;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
