package main.user;

import java.util.ArrayList;
import main.Cart;

public abstract class AbstractUser {
    Cart Usercart;
    int idNum;

    public AbstractUser(int idNum, Cart cart){
        this.idNum = idNum;
        this.Usercart = cart;
    }

    public ArrayList<String> printBill(){
        ArrayList<String> bill = new ArrayList<String>();
        if(Usercart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < Usercart.cart.size(); i++){
            bill.add("Name: " + Usercart.cart.get(i).getName() + "\tPrice: " + Usercart.cart.get(i).getPrice()
            + "\tQuantity: " + Usercart.cart.get(i).getQuantity());
        }
        return bill;
    }

}