package test.user;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import main.Cart;
import main.Item;
import main.user.Customer;
import main.user.Employee;

public class EmployeeTest {

    @Test
    public void printbillTest(){
        Cart cart = new Cart();
        Employee employee = new Employee(123, cart, 123);

        Item bread = new Item("bread", 3.18, true, 50);
        ArrayList<Item> testCart = new ArrayList<Item>();

        assertThrows(IllegalArgumentException.class,() -> employee.printBill(cart).get(0));
        
        testCart.add(bread);
        cart.setCart(testCart);

        assertEquals(employee.printBill(cart).get(0), "Name: bread\tPrice: 3.18\tQuantity: 50");
    }

    @Test
    public void calculateBillTest(){
        Cart cart = new Cart();
        Employee employee = new Employee(123, cart, 123);
        Customer customer = new Customer(456, cart);

        Item bread = new Item("bread", 3.18, true, 50);
        Item milk = new Item("milk", 4.79, true, 25);
        Item eggs = new Item("eggs", 5.69, true, 10);
        ArrayList<Item> testCart = new ArrayList<Item>();

        assertThrows(IllegalArgumentException.class,() -> employee.calculateBill(customer));

        testCart.add(bread);
        cart.setCart(testCart);

        assertEquals(employee.calculateBill(customer), 3.5934, .0001);

        testCart.add(milk);
        testCart.add(eggs);
        cart.setCart(testCart);

        assertEquals(employee.calculateBill(customer), 15.4358, .0001);
    }
    
}
