package main.user;

import main.Cart;
import main.Item;

public class Customer extends AbstractUser{

    public Customer(int idNum, Cart cart) {
        super(idNum, cart);
    }

    public int getId(){
        return idNum;
    }

    public void addItem(Item item){

    }

    public void reqVoidItem(Item item){

    }

    public void reqVoidBill(Item item){
        
    }
    
}
