package me.redepicness.smeltablegunpowder;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.CookingRecipe;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FurnaceListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onGunpowderSmelt(@NotNull FurnaceSmeltEvent event){
        CookingRecipe<?> recipe = event.getRecipe();

        if(recipe == null || !recipe.key().equals(SmeltableGunpowder.GUNPOWDER_RECIPE.key()))
            return;

        event.setCancelled(true);

        Block block = event.getBlock();
        Furnace state = (Furnace) event.getBlock().getState();
        ItemStack smelting = state.getInventory().getSmelting();
        float power = smelting != null ? smelting.getAmount() : 1f;

        // So the explosion damages players and isn't trapped in the block
        block.breakNaturally(new ItemStack(Material.NETHERITE_PICKAXE));
        block.getLocation().toCenterLocation().createExplosion(power);
    }

}
