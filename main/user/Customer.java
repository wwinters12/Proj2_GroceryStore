package main.user;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

import main.Cart;
import main.Item;
import main.StoreInventory;

public class Customer  {
    Cart Usercart;
    int idNum;
    StoreInventory inventory;
    double cardBalance;

    public Customer(int idNumIn, Cart cartIn) {
        Usercart = cartIn;
        idNum = idNumIn;
        inventory = new StoreInventory();

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
        for(int i = 0; i < Usercart.cart.size()-1; i++){
            bill.add("Name: " + Usercart.cart.get(i).getName() + "\tPrice: " + Usercart.cart.get(i).getPrice());
        }
        return bill;
    }

    public Item addItemString(String input){
        if(!input.equals("done")){
            Map<String,Item> store = inventory.createInventory();
            return store.get(input);
        }
        else{
            return null;
        }
        
    }
    
    public void addItem(String itemString){
        Usercart.cart.add(addItemString(itemString));
    }

    public void reqVoidItem(Item item){
        

    }

    public void reqVoidBill(Item item){
        
    }

    public double payBillCash(double amount){
        String digits = "###.##";
        DecimalFormat decimal = new DecimalFormat(digits);
        double billTotal = 0;
        if(Usercart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < Usercart.cart.size()-1; i++){

            billTotal += (Usercart.cart.get(i).getPrice() * 1.13);
        }
        if(amount < billTotal){
            return -1;
            //throw new IllegalArgumentException("Not enough money");
        }
        else{
            String sub = decimal.format(amount - billTotal);
            Double finalAmount = Double.parseDouble(sub);
            return finalAmount;
        }
    }

    public void payBillCard(){
        double billTotal = 0;
        if(Usercart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < Usercart.cart.size()-1; i++){
            billTotal += (Usercart.cart.get(i).getPrice() * 1.13);
        }
        if(cardBalance < billTotal){
            throw new IllegalArgumentException("Not enough money");
        }
        cardBalance -= billTotal;
    }

    public void addCard(double amount){
        cardBalance = amount;
    }

    public double getCardBalance(){
        return cardBalance;
    }

    public void depositMoney(double amount){
        cardBalance += amount;
    }
    
}
