package test.user;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import main.Cart;
import main.Item;
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
    
}
