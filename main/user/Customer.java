package main.user;

import java.util.ArrayList;

import main.Cart;
import main.Item;

public class Customer{
    Cart cart;
    int idNum;

    public Customer(int idNumIn, Cart cartIn) {
        cart = cartIn;
        idNum = idNumIn;
    }

    public int getId(){
        return idNum;
    }

    public ArrayList<String> printBill(){
        ArrayList<String> bill = new ArrayList<String>();
        cart.getCart();
        if(cart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < cart.cart.size(); i++){
            bill.add("Name: " + cart.cart.get(i).getName() + "\tPrice: " + cart.cart.get(i).getPrice()
            + "\tQuantity: " + cart.cart.get(i).getQuantity());
        }
        return bill;
    }

    public void addItem(Item item){

    }

    public void reqVoidItem(Item item){

    }

    public void reqVoidBill(Item item){
        
    }
    
}
