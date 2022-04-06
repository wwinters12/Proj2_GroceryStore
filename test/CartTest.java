package test;

//import test.user.Test;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import main.Cart;
import main.Item;


/*
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Item;
*/


public class CartTest {
    
    @Test
    public void calculateSubTotalTest(){
        Cart cart = new Cart();
        Item berries = new Item("blackberries", 4.99, true, 20);
        Item bread = new Item("bread", 3.18, true, 50);
        Item milk = new Item("milk", 4.79, true, 25);
        Item eggs = new Item("eggs", 5.69, true, 10);

        ArrayList<Item> testCart = new ArrayList<Item>();
        testCart.add(berries);
        testCart.add(bread);
        testCart.add(milk);
        testCart.add(eggs);

        cart.setCart(testCart);

        assertEquals(21.0745, cart.calculateSubTotal(), 0);
    }
}
