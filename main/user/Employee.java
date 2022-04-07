package main.user;

import main.Cart;
import main.Item;

public class Employee extends AbstractUser{
    int pin;

    public Employee(int idNum, Cart cart, int pin) {
        super(idNum, cart); 
        this.pin = pin;
    }

    public void voidItem(Item item){

    }

    public void voidBill(Customer customer){
        
    }

    public double calculateBill(Customer customer){
        return -1;
    }


}
