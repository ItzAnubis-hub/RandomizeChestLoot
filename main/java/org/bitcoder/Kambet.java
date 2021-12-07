package org.bitcoder;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kambet extends JavaPlugin implements Listener {
    ItemFill itemFill = new ItemFill();

    public static final ItemStack[] defaultStack = new ItemStack[]{
                                                new ItemStack(Material.TORCH),
                                                new ItemStack(Material.BEDROCK)
    };

    public static final ItemStack[] combatStack = new ItemStack[]{
            new ItemStack(Material.DIAMOND_SWORD),
            new ItemStack(Material.IRON_SWORD)
    };

    public static final
        ItemCategory defaultCategory = new ItemCategory(100, defaultStack);

    public static final
        ItemCategory combatCategory = new ItemCategory(100, combatStack);


    @Override
    public void onEnable() {
        getLogger().info("Task42");
        getServer().getPluginManager().registerEvents(this, this);
        itemFill.addItem(defaultCategory);
        itemFill.addItem(combatCategory);
    }

    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent e){
        InventoryHolder holder = e.getInventory().getHolder();
        System.out.println(1);

        itemFill.howManyNeedItem = 5;
        itemFill.howManyItems = 21;

        itemFill.fill(holder);

    }



}
