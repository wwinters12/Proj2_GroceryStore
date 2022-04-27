package main.user;

import java.util.ArrayList;

import main.Cart;
import main.Item;
import main.StoreInventory;

public class Customer  {
    Cart usercart;
    int idNum;
    StoreInventory inventory;

    public Customer(int idNumIn, Cart cartIn) {
        usercart = cartIn;
        idNum = idNumIn;

    }

    public int getId(){
        return idNum;
    }

    public ArrayList<String> printBill(){
        ArrayList<String> bill = new ArrayList<String>();
        usercart.getCart();
        if(usercart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < usercart.cart.size(); i++){
            bill.add("Name: " + usercart.cart.get(i).getName() + "\tPrice: " + usercart.cart.get(i).getPrice()
            + "\tQuantity: " + usercart.cart.get(i).getQuantity());
        }
        return bill;
    }

    public void addItem(String input){
        if(input.equals("done")){
            input.equals("done");
        }
        else if(inventory.hashInventory(input)!=null){
            usercart.cart.add((Item) inventory.hashInventory(input));
        }
 
        
        
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
        if(usercart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < usercart.cart.size(); i++){
            tax = tax + (usercart.cart.get(i).getPrice() * .13);
        }
        subTotal = usercart.calculateSubTotal();
        billTotal = subTotal + tax;
        if(amount < billTotal){
            throw new IllegalArgumentException("Not enough money");
        }
        else{
            return amount - billTotal;
        }
    }
    
}
