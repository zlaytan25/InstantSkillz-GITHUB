//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Util;

import de.instantskillz.challengeplugin.Main.Main;
import org.bukkit.inventory.ItemStack;

public enum DekoGS4 {

    GLOBED4("MTFiMzE4OGZkNDQ5MDJmNzI2MDJiZDdjMjE0MWY1YTcwNjczYTQxMWFkYjNkODE4NjJjNjllNTM2MTY2YiJ9fX0=", "GLOBED4");

    private ItemStack item;
    private String idTag;
    private String prefix = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";

    private DekoGS4(String texture, String id) {

        item = Main.createDeko4(prefix + texture, id);
        idTag = id;


    }

    public ItemStack getItemStack() {
        return item;
    }

    public String getIdTag() {
        return idTag;
    }

}
