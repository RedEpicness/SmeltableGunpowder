package me.redepicness.smeltablegunpowder;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class SmeltableGunpowder extends JavaPlugin {

    public static @NotNull FurnaceRecipe GUNPOWDER_RECIPE = new FurnaceRecipe(
            new NamespacedKey("redepicness", "gunpowder"),
            new ItemStack(Material.TNT),
            Material.GUNPOWDER,
            0,
            40
    );

    @Override
    public void onEnable() {
        getSLF4JLogger().info("Adding gunpowder recipe...");
        Bukkit.addRecipe(GUNPOWDER_RECIPE);
        Bukkit.getPluginManager().registerEvents(new FurnaceListener(), this);
    }

}
