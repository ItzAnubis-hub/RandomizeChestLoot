package org.bitcoder;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemCategory {
    public static final List<ItemCategory> itemCategories = new ArrayList<>();
    public int chance;
    public ItemStack[] itemStacks;



    public ItemCategory(int chance, ItemStack[] items) {
        this.chance = chance;
        this.itemStacks = items;
        itemCategories.add(this);

    }



}
