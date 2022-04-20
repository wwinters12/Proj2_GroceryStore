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

    public double payBillCash(double amount){
        double billTotal = 0;
        double tax = 0;
        double subTotal = 0;
        if(Usercart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < Usercart.cart.size(); i++){
            tax = tax + (Usercart.cart.get(i).getPrice() * .13);
        }
        subTotal = Usercart.calculateSubTotal();
        billTotal = subTotal + tax;
        if(amount < billTotal){
            throw new IllegalArgumentException("Not enough money");
        }
        else{
            return amount - billTotal;
        }
    }
    
}
