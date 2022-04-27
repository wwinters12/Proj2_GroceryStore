package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StoreInventory {

    List<Item> storeInventory = new ArrayList<>();
    Map<String,Item> hashInventory = new HashMap<>();

    public StoreInventory(){
    }

    public Map<String,Item> createInventory(){
        Item item1 = new Item("BlackBerries", 4.99, true, 20);
        Item item2 = new Item("Muffins", 9.99, false, 5);
        Item item3 = new Item("Bread", 2.99, true, 7);
        Item item4 = new Item("Hershey", 1.99, true, 10);
        Item item5 = new Item("Strawberry", 4.99, true, 20);
        Item item6 = new Item("Tofu", 6.85, true, 6);
        Item item7 = new Item("Salmon", 4.99, true, 20);
        Item item8 = new Item("Steak", 4.99, true, 20);
        Item item9 = new Item("Peanut Butter", 4.99, true, 20);

        storeInventory.add(item1);
        storeInventory.add(item2);
        storeInventory.add(item3);
        storeInventory.add(item4);
        storeInventory.add(item5);
        storeInventory.add(item6);
        storeInventory.add(item7);
        storeInventory.add(item8);
        storeInventory.add(item9);

        hashInventory.put(item1.getName(), item1);
        hashInventory.put("Muffins", item2);
        hashInventory.put("Bread", item3);
        hashInventory.put("Hershey", item4);
        hashInventory.put("Strawberry", item5);
        hashInventory.put("Tofu", item6);
        hashInventory.put("Salmon", item7);
        hashInventory.put("Steak", item8);
        hashInventory.put("Peanut Butter", item9);

        return hashInventory;
    }

    public Set<String> hashInventory(String input){
        return hashInventory.keySet();
    }
}