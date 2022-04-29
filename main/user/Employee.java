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

    public void voidItem(Customer customer,String input){
        for (int i = 0; i < customer.Usercart.cart.size(); i++){
            if(customer.Usercart.cart.get(i).getName().equals(input)){
                customer.Usercart.cart.remove(i);
                break;
            }
        }

    }

    public void voidBill(Customer customer){
        for(int i = 0; i < customer.Usercart.cart.size(); i++){
            customer.Usercart.cart.remove(i);
        }
        
    }

    public ArrayList<String> printBill(Cart customerCart){
        ArrayList<String> bill = new ArrayList<String>();
        if(customerCart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < customerCart.cart.size()-1; i++){
            bill.add("Name: " + customerCart.cart.get(i).getName() + "\tPrice: " + customerCart.cart.get(i).getPrice()
            + "\tQuantity: " + customerCart.cart.get(i).getQuantity());
        }
        return bill;
    }

    public double calculateBill(Customer customer){
        double billTotal = 0;
        if(customer.Usercart.cart.size() == 0){
            throw new IllegalArgumentException("Nothing in the cart");
        }
        for(int i = 0; i < customer.Usercart.cart.size()-1; i++){
            billTotal += (customer.Usercart.cart.get(i).getPrice() * 1.13);
        }

        return billTotal;
    }


}
