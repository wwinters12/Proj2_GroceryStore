package test.user;

import main.Cart;
import main.Item;
import main.user.Customer;

public class CustomerTest {

    @Test
    void ConstructorTest(){
        Cart cart = new Cart();
        StoreInventory storeInventory = new StoreInventory();
        Customer customer1 = new Customer(123, cart);
        
        customer1.addItem(new Item("Tofu", 6.85, true, 6));
        assertEquals(123,customer1.getId());
        
    }

    private void assertEquals(int i, int id) {
    }

   
}
