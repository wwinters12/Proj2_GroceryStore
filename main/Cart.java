package main;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private double subtotal;
    public ArrayList<Item> cart;

    public Cart(){
        subtotal = 0;
        cart = new ArrayList<Item>();
    }

    public void setCart(List<Item> testCart){
        cart = (ArrayList<Item>) testCart;
    }

    public ArrayList<Item> getCart(){
        return cart;
    }

    public double calculateSubTotal(){
        for(int i = 0 ; i < cart.size(); i++){
            subtotal = cart.get(i).getPrice() + subtotal;
        }
        return subtotal;
    }
}
