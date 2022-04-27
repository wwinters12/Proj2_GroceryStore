package test.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.Assert;

import main.Cart;
import main.Item;
import main.user.Customer;

public class CustomerTest {

    @Test
    void ConstructorTest(){
        Cart cart = new Cart();
        Customer customer1 = new Customer(123, cart);
        assertEquals(123, customer1.getId());
    }

    @Test
    public void printbillTest(){
        Cart cart = new Cart();
        Customer customer1 = new Customer(123, cart);

        Item bread = new Item("bread", 3.18, true, 50);
        Item milk = new Item("milk", 4.79, true, 25);
        Item eggs = new Item("eggs", 5.69, true, 10);
        ArrayList<Item> testCart = new ArrayList<Item>();

        assertThrows(IllegalArgumentException.class,() -> customer1.printBill().get(0));
        
        testCart.add(bread);
        testCart.add(milk);
        testCart.add(eggs);
        cart.setCart(testCart);

        assertEquals(customer1.printBill().get(0), "Name: bread\tPrice: 3.18\tQuantity: 50");
        assertEquals(customer1.printBill().get(2), "Name: eggs\tPrice: 5.69\tQuantity: 10");
    }

    @Test
    public void payBillCashTest(){
        Cart cart = new Cart();
        Customer customer1 = new Customer(123, cart);

        Item bread = new Item("bread", 3.18, true, 50);
        Item milk = new Item("milk", 4.79, true, 25);
        Item eggs = new Item("eggs", 5.69, true, 10);
        ArrayList<Item> testCart = new ArrayList<Item>();

        assertThrows(IllegalArgumentException.class,() -> customer1.payBillCash(1));

        testCart.add(bread);
        cart.setCart(testCart);

        Assert.assertEquals(customer1.payBillCash(20), 20 - 3.5934, 0.00001);
        assertThrows(IllegalArgumentException.class,() -> customer1.payBillCash(1));

        testCart.add(milk);
        testCart.add(eggs);
        cart.setCart(testCart);

        assertEquals(customer1.payBillCash(25), 25 - 15.4358, 0.0001);
    }

    @Test
    public void payBillCardTest(){
        Cart cart = new Cart();
        Customer customer1 = new Customer(123, cart);

        Item bread = new Item("bread", 3.18, true, 50);
        Item milk = new Item("milk", 4.79, true, 25);
        Item eggs = new Item("eggs", 5.69, true, 10);
        ArrayList<Item> testCart = new ArrayList<Item>();

        assertThrows(IllegalArgumentException.class,() -> customer1.payBillCard());

        testCart.add(bread);
        cart.setCart(testCart);

        customer1.addCard(20);
        customer1.payBillCard();
        assertEquals(customer1.getCardBalance(), 20 - 3.5934, 0.0001);

        customer1.addCard(1);
        assertThrows(IllegalArgumentException.class,() -> customer1.payBillCard());

        testCart.add(milk);
        testCart.add(eggs);
        cart.setCart(testCart);

        customer1.addCard(25);
        customer1.payBillCard();
        assertEquals(customer1.getCardBalance(), 25 - 15.4358, 0.0001);
    }
}