//Plugin by: InstantSKillzTv
//-> Mullemann25 and Mannam01
package de.instantskillz.challengeplugin.Util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeLoader {

    public void registerRecipes() {
        ItemStack bifi = new ItemStack(Material.COOKED_BEEF);
        ItemMeta bifiMeta = bifi.getItemMeta();
        bifiMeta.setDisplayName("§6§lBiFi");
        bifi.setItemMeta(bifiMeta);
        ShapelessRecipe bifiRecipe = new ShapelessRecipe(bifi);
        bifiRecipe.addIngredient(Material.ROTTEN_FLESH);
        bifiRecipe.addIngredient(Material.COOKED_CHICKEN);
        bifiRecipe.addIngredient(Material.COOKED_RABBIT);

        ItemStack bifiRoll = new ItemStack(Material.BREAD);
        ItemMeta bifiRollMeta = bifiRoll.getItemMeta();
        bifiRollMeta.setDisplayName("§6§lBiFi Roll");
        bifiRoll.setItemMeta(bifiRollMeta);
        ShapedRecipe bifiRollRecipe = new ShapedRecipe(bifiRoll);
        bifiRollRecipe.shape("BBB", "FFF", "BBB");
        bifiRollRecipe.setIngredient('B', Material.BREAD);
        bifiRollRecipe.setIngredient('F', Material.COOKED_BEEF);

        Bukkit.addRecipe(bifiRecipe);
        Bukkit.addRecipe(bifiRollRecipe);
    }
}

