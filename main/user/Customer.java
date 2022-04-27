package main.user;

import main.Cart;
import main.Item;

public class Customer extends AbstractUser{
    private double cardBalance;

    public Customer(int idNum, Cart cart) {
        super(idNum, cart);
        cardBalance = 0;
    }

    public int getId(){
        return idNum;
    }

    public void addItem(String item){

    }

    public void reqVoidItem(Item item){

    }

    public void reqVoidBill(Item item){
        
    }

    public double payBillCash(double amount){
        double billTotal = 0;
        if(Usercart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < Usercart.cart.size(); i++){
            billTotal += (Usercart.cart.get(i).getPrice() * 1.13);
        }
        if(amount < billTotal){
            throw new IllegalArgumentException("Not enough money");
        }
        else{
            return amount - billTotal;
        }
    }

    public void payBillCard(){
        double billTotal = 0;
        if(Usercart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < Usercart.cart.size(); i++){
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
    
}
