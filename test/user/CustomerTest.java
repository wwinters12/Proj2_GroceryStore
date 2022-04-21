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
