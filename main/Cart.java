package main;

import java.text.DecimalFormat;
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

    public Double calculateSubTotal(){
        String digits = "###.##";
        DecimalFormat decimal = new DecimalFormat(digits);
        for(int i = 0 ; i < cart.size(); i++){
            subtotal = cart.get(i).getPrice() + subtotal;
        }
        String sub = decimal.format(subtotal);
        Double stotal = Double.parseDouble(sub);
        return stotal;
    }
}
