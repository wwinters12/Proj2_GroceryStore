package test;


import java.util.Map;
import java.util.Scanner;

import main.Cart;
import main.Item;
import main.StoreInventory;
import main.user.Customer;
import main.user.Employee;

public class ShoppingInterface {
    public static void main(String[] args){
        try (Scanner in = new Scanner(System.in)) {
            String welcome = "Welcome to the grocery store!";
            

            boolean running = true;
            Cart cart = new Cart();
            double bill = -1;
            Customer customer = new Customer(01, cart);
            Employee employee = new Employee(01, cart, 1234);
            StoreInventory inventory = new StoreInventory();
            Map<String,Item> storeInventory = inventory.createInventory();
            String stuff = storeInventory.keySet().toString();




            while(running || bill!=0.0) {
                System.out.println(welcome);
                System.out.println("Would you like to begin checking out?(y/n)");
                String input = in.nextLine();
                if(input.equals("y")){
                    while(!input.equals("pay")){
                        System.out.println("Add Item to cart.");
                        System.out.println(stuff);
                        input = in.nextLine();
                        customer.addItem(input);
                        System.out.println("MENU:");
                        System.out.println("1. pay");
                        System.out.println("2. void item");
                        System.out.println("3. void all");
                        System.out.println("4. deposit");
                        System.out.println("Reciept: " + customer.printBill());
                        if(input.equals("void item")){
                            System.out.println("What would you like to void");
                            input = in.nextLine();
                            employee.voidItem(customer, input);
                            System.out.println("Your item has been voided!");
                            System.out.println("MENU:");
                            System.out.println("1. pay");
                            System.out.println("2. void item");
                            System.out.println("3. void all");
                            System.out.println("4. deposit");
                            input = in.nextLine();
                        }

                        else if(input.equals("void all")){
                            employee.voidBill(customer);
                            System.out.println("Thank you, have a good day!");
                            break;
                        }
                    }
                    if(input.equals("pay")){
                        if(cart.cart.size()==0){
                            throw new NullPointerException("Empty cart");
                        }
                        bill = employee.calculateBill(customer);
                        System.out.println(bill);
                        System.out.println("How will you pay your bill?");

                        while(bill!=0.00){
                            input = in.nextLine();
                            if(input.equals("card")){
                                customer.addCard(100);
                                customer.payBillCard();
                                System.out.println("Approved");
                                running=false;
                                break;
                            }
                            if(input.equals("cash")){
                                System.out.println("How much cash?");
                                double input1 = in.nextFloat();
                                double change = customer.payBillCash(input1);
                                while(change==-1){
                                    System.out.println("Not enough money!");
                                    input1 = in.nextFloat();
                                    System.out.println("Please insert more money.");
                                    change = customer.payBillCash(input1);
                                }
                                System.out.println("Your change is: " + change);
                                System.out.println("Thanks, Have a good day!");
                                running=false;
                                break;
                                }
                            }

                            if(bill==0.00){
                                System.out.println("Have a good day!");
                                break;
                            }
                        }


                        if(input.equals("deposit")){
                            double input1 = in.nextDouble();
                            System.out.println("How much $$$?");
                            customer.depositMoney(input1);
                            System.out.println("You now have: "+ customer.getCardBalance());
                        }
 
            
                    }
                    else{
                        System.out.println("Have a good day!");
                    }
 
                    

                    
                }
                System.out.println("Have a good day!");
                running=false;
                                
            }
        }
    }

