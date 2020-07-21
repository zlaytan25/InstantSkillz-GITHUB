//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BingoEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    final int MAX_SPIELER = 2;
    int spieler;

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

    public HandlerList getHandlers() {
        return handlers;
    }


}
