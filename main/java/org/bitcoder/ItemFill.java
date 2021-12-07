package org.bitcoder;

import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ItemFill {
    public final  Map<ItemCategory, ItemStack[]> chanceOfFill = new HashMap<>();
    private  final Random randOfItem   = new Random();

    public void addItem(ItemCategory category) {
        chanceOfFill.put(category, category.itemStacks);
        chanceOfFill.values().forEach(System.out::println);
    }

    private ItemStack randomizeItem(ItemCategory itemCategory) {
        int rnd = new Random().nextInt(itemCategory.itemStacks.length);
        return itemCategory.itemStacks[rnd];
    }

    private ItemCategory randomizeCategory() {
        int rnd = new Random().nextInt(ItemCategory.itemCategories.size());
        return ItemCategory.itemCategories.get(rnd);
    }

    public int howManyItems;
    public int howManyNeedItem;

    public void fill(InventoryHolder holder) {
        if (!(holder instanceof Chest)) return;

        Inventory chestInventory = holder.getInventory();
        System.out.println(2);


        while (howManyNeedItem != 0) {
            int index = randOfItem.nextInt(27);
            ItemCategory itemCategory = randomizeCategory();
            ItemStack itemInChest = randomizeItem(itemCategory);

            chestInventory.setItem(index, itemInChest);

            chestInventory.getItem(index).setAmount(howManyItems);
            howManyNeedItem--;
        }
        System.out.println("stop adding.");


    }

}
