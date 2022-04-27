package main.user;

import java.util.ArrayList;

import main.Cart;
import main.Item;

public class Customer  {
    Cart Usercart;
    int idNum;

    public Customer(int idNumIn, Cart cartIn) {
        Usercart = cartIn;
        idNum = idNumIn;
    }

    public int getId(){
        return idNum;
    }

    public ArrayList<String> printBill(){
        ArrayList<String> bill = new ArrayList<String>();
        Usercart.getCart();
        if(Usercart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < Usercart.cart.size(); i++){
            bill.add("Name: " + Usercart.cart.get(i).getName() + "\tPrice: " + Usercart.cart.get(i).getPrice()
            + "\tQuantity: " + Usercart.cart.get(i).getQuantity());
        }
        return bill;
    }

    public void addItem(Item input){

    }

    public void reqVoidItem(Item item){

    }

    public void reqVoidBill(Item item){
        
    }

    public void addItem(String string, double d, boolean b, int i) {
        
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
