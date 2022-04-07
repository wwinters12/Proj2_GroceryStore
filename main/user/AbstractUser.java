package main.user;

import java.util.ArrayList;
import main.Cart;

public abstract class AbstractUser {
    Cart cart;
    int idNum;

    public AbstractUser(int idNum, Cart cart){
        this.idNum = idNum;
        this.cart = cart;
    }

    public ArrayList<String> printBill(){
        ArrayList<String> bill = new ArrayList<String>();
        if(cart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < cart.cart.size(); i++){
            bill.add("Name: " + cart.cart.get(i).getName() + "\tPrice: " + cart.cart.get(i).getPrice()
            + "\tQuantity: " + cart.cart.get(i).getQuantity());
        }
        return bill;
    }

}