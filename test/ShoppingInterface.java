package test;

import java.util.Scanner;

import main.Item;
import main.Cart;
import main.Store;
import main.StoreInventory;
import main.user.Customer;
import main.user.Employee;

public class ShoppingInterface {
    public static void main(String[] args){
        try (Scanner in = new Scanner(System.in)) {
            String welcome = "Welcome to the grocery store!";

            boolean running = true;
            Cart cart = new Cart();
            StoreInventory storeInventory = new StoreInventory();
            String itemName;



            while(running) {
                System.out.println(welcome);
                System.out.println("Would you like to begin checking out?(y/n)");
                String input = in.nextLine();
                if(input.equals("y")){
                    System.out.println("If youre done adding items to cart, say done");
                    Customer customer = new Customer(01, cart);
                    Employee employee = new Employee(01, cart, 1234);
                    System.out.println("type item");
                    input = in.nextLine();
                    while(!input.equals("done")){
                        input = in.nextLine();
                        //Customer needs to add item
                    }
                    System.out.println("type total if you'd like a total of the bill.");
                    System.out.println("void item if you'd like to void an item");
                    System.out.println("type void all if you'd like to void entire bill");
                    if(input.equals("total")){
                        employee.calculateBill(customer);
                    }
                    else if(input.equals("void item")){
                        System.out.println("What would you like to void");
                        employee.voidItem(input);
                    }
                    else if(input.equals("void all")){
                        employee.voidBill(customer);
                    }
                    

                    
                }
                else{
                    System.out.println("Have a good day!");
                    break;
                }
            }
        }

    }
}
