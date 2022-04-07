package main;

import java.util.ArrayList;

public class Cart {
    private double subtotal;
    public ArrayList<Item> cart;

    public Cart(){
        subtotal = 0;
        cart = new ArrayList<Item>();
    }

    public void setCart(ArrayList<Item> cartIn){
        cart = cartIn;
    }

    public ArrayList<Item> getCart(){
        return cart;
    }

    public double calculateSubTotal(){
        for(int i = 0 ; i < cart.size(); i++){
            if(cart.get(i).isTaxed()){
                subtotal = cart.get(i).getPrice() + (cart.get(i).getPrice() * .13) + subtotal;
            }
            else{
                subtotal = cart.get(i).getPrice() + subtotal;
            }
        }

        return subtotal;
    }
}
