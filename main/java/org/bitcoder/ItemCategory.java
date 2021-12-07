package org.bitcoder;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemCategory {
    private static final List<ItemCategory> itemCategories = new ArrayList<>();

    private static final Map<String, ItemCategory> categoriesHashMap = new HashMap<>();
    private final ItemStack[] itemStacks;
    private final String name;


    public static void putCategory(ItemCategory category) {
        categoriesHashMap.put(category.getName(), category);

    }

    public static List<ItemCategory> getItemCategories() {
        return itemCategories;
    }

    public ItemStack[] getItemStacks() {
        return itemStacks;
    }


    public String getName() {
        return name;
    }


    public static ItemCategory getItemCategory(String name) {
        for (ItemCategory itemCategory : itemCategories) {
            if (itemCategory.name.equals(name)) return itemCategory;
        }
        return null;
    }


    public ItemCategory(ItemStack[] items, String name) {
        this.itemStacks = items;
        this.name = name;
        itemCategories.add(this);

    }

}
