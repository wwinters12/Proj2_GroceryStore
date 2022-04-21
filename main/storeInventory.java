package main;

import java.util.ArrayList;
import java.util.List;

public class storeInventory {

    List<Item> storeInventory = new ArrayList<>();

    public storeInventory(){

        
    }

    public List<Item> createInventory(){
        Item item1 = new Item("BlackBerries", 4.99, true, 20);
        Item item2 = new Item("Muffins", 9.99, false, 5);
        Item item3 = new Item("Bread", 2.99, true, 7);
        Item item4 = new Item("Hershey", 1.99, true, 10);
        Item item5 = new Item("Strawberry", 4.99, true, 20);
        Item item6 = new Item("Tofu", 6.85, true, 6);
        Item item7 = new Item("BlackBerries", 4.99, true, 20);
        Item item8 = new Item("BlackBerries", 4.99, true, 20);
        Item item9 = new Item("BlackBerries", 4.99, true, 20);

        storeInventory.add(item1);
        storeInventory.add(item2);
        storeInventory.add(item3);
        storeInventory.add(item4);
        storeInventory.add(item5);
        storeInventory.add(item6);
        storeInventory.add(item7);
        storeInventory.add(item8);
        storeInventory.add(item9);

        return storeInventory;
    }

   






























































    
}
