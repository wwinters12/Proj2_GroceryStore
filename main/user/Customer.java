package main.user;

import main.Cart;
import main.Item;

public class Customer extends AbstractUser{

    public Customer(int idNum, Cart cart) {
        super(idNum, cart);
    }

    public int getId(){
        return idNum;
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
