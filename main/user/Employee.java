package main.user;

import java.util.ArrayList;

import main.Cart;

public class Employee {
    Cart cart;
    int idNum;
    int pin;

    public Employee(int idNum, Cart cart, int pin) {
        this.cart = cart;
        this.idNum = idNum;
        this.pin = pin;
    }

    public void voidItem(String input){

    }

    public void voidBill(Customer customer){
        
    }

    public ArrayList<String> printBill(Cart customerCart){
        ArrayList<String> bill = new ArrayList<String>();
        if(customerCart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < customerCart.cart.size(); i++){
            bill.add("Name: " + customerCart.cart.get(i).getName() + "\tPrice: " + customerCart.cart.get(i).getPrice()
            + "\tQuantity: " + customerCart.cart.get(i).getQuantity());
        }
        return bill;
    }

    public double calculateBill(Customer customer){
        return -1;
    }


}
