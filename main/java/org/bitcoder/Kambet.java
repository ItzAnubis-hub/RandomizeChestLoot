package org.bitcoder;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Kambet extends JavaPlugin implements Listener {
    ItemFill itemFill = new ItemFill();

    private static final ItemStack[] defaultStack = new ItemStack[]{
            new ItemStack(Material.TORCH),
            new ItemStack(Material.BEDROCK)
    };

    private static final ItemStack[] combatStack = new ItemStack[]{
            new ItemStack(Material.DIAMOND_SWORD),
            new ItemStack(Material.IRON_SWORD)
    };

    private static final
    ItemCategory defaultCategory = new ItemCategory(defaultStack, "blocks");

    private static final
    ItemCategory combatCategory = new ItemCategory(combatStack, "mortal");


    @Override
    public void onEnable() {
        getLogger().info("Task42");
        getServer().getPluginManager().registerEvents(this, this);

        ItemCategory.putCategory(defaultCategory);
        ItemCategory.putCategory(combatCategory);

    }

    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent e) {
        InventoryHolder holder = e.getInventory().getHolder();
        System.out.println(1);

        itemFill.howManyNeedItem = 5;
        itemFill.howManyItems = 21;

        itemFill.fill(holder);

    }


}
