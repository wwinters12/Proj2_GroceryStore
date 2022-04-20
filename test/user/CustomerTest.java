package test.user;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import main.Cart;
import main.Item;
import main.user.Customer;

public class CustomerTest {

    @Test
    public void constructorTest(){
        Cart cart = new Cart();
        Customer customer1 = new Customer(123, cart);
        assertEquals(123, customer1.getId());
    }

    @Test
    public void printbillTest(){
        Cart cart = new Cart();
        Customer customer1 = new Customer(123, cart);

        Item bread = new Item("bread", 3.18, true, 50);
        ArrayList<Item> testCart = new ArrayList<Item>();

        assertThrows(IllegalArgumentException.class,() -> customer1.printBill().get(0));
        
        testCart.add(bread);
        cart.setCart(testCart);

        assertEquals(customer1.printBill().get(0), "Name: bread\tPrice: 3.18\tQuantity: 50");
    }

    @Test
    public void payBillCashTest(){
        Cart cart = new Cart();
        Customer customer1 = new Customer(123, cart);

        Item bread = new Item("bread", 3.18, true, 50);
        ArrayList<Item> testCart = new ArrayList<Item>();

        assertThrows(IllegalArgumentException.class,() -> customer1.payBillCash(1));

        testCart.add(bread);
        cart.setCart(testCart);

        assertEquals(customer1.payBillCash(20), 20 - 3.5934, 0.00001);
        assertThrows(IllegalArgumentException.class,() -> customer1.payBillCash(1));
    }
}
