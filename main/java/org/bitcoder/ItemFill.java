package org.bitcoder;

import lombok.SneakyThrows;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SuppressWarnings("all")
public class ItemFill {
    private final Map<ItemCategory, ItemStack[]> chanceOfFill = new HashMap<>();
    private final Random randOfItem = new Random();

    private ItemStack randomizeItem(ItemCategory itemCategory) {
        ItemStack[] stacks = ItemCategory.getItemCategory(itemCategory.getName()).getItemStacks();
        int rnd = randOfItem.nextInt(ItemCategory.getItemCategory(itemCategory.getName()).getItemStacks().length);
        return stacks[rnd];
    }

    @SneakyThrows
    private ItemCategory randomizeCategory() {
        int rnd = randOfItem.nextInt(ItemCategory.getItemCategories().size());
        return ItemCategory.getItemCategories().get(rnd);
    }

    private int howManyItems;
    private int howManyNeedItem;

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
