package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        hashInventory.put(item1.getName(), item1);
        hashInventory.put(item2.getName(), item2);
        hashInventory.put(item3.getName(), item3);
        hashInventory.put(item4.getName(), item4);
        hashInventory.put(item5.getName(), item5);
        hashInventory.put(item6.getName(), item6);
        hashInventory.put(item7.getName(), item7);
        hashInventory.put(item8.getName(), item8);
        hashInventory.put(item9.getName(), item9);

        return hashInventory;
    }

}