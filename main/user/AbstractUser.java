package main.user;

import main.Cart;

public abstract class AbstractUser {
    Cart cart;

    public String[] printBill(){
        return cart.items;
    }

}