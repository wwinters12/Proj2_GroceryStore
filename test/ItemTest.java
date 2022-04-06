package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Item;

public class ItemTest {
    
    @Test
    public void constructorTest(){
        Item blackberries = new Item("blackberries", 4.99, true, 20);

        assertEquals(blackberries.getName(), "blackberries"); //getName test
        assertEquals(blackberries.getPrice(), 4.99, 0.00); //getPrice test
        assertEquals(blackberries.isTaxed(), true); //isTaxed test
        assertEquals(blackberries.getQuantity(), 20); //getQuantity test
    }
}
