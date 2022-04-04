package test.user;
import main.user.Customer;

public class CustomerTest {

    @Test
    void ConstructorTest(){
        Customer customer1 = new Customer(123);
        assertEquals(123,customer1.getId());
    }

    private void assertEquals(int i, int id) {
    }

   
}
