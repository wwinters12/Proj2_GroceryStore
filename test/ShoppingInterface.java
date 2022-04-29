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
            double bill;
            Customer customer = new Customer(01, cart);
            Employee employee = new Employee(01, cart, 1234);
            StoreInventory inventory = new StoreInventory();
            Map<String,Item> storeInventory = inventory.createInventory();
            String stuff = storeInventory.keySet().toString();





            while(running) {
                System.out.println(welcome);
                System.out.println("Would you like to begin checking out?(y/n)");
                String input = in.nextLine();
                if(input.equals("y")){
                    System.out.println("If youre done adding items to cart, say done");

                    System.out.println("type item");
                    while(!input.equals("done")){
                        System.out.println(stuff);
                        input = in.nextLine();
                        customer.addItem(input);
                        System.out.println("MENU:");
                        System.out.println("1. done --> if finished shopping.");
                        System.out.println("2. void --> if an item void is needed.");
                        System.out.println("3. void all --> to void bill.");
                        System.out.println("4. deposit --> if not enough money on card.");
                    }
                    if(input.equals("done")){
                       
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
                                while(input.equals("void item")){
                                    System.out.println("What would you like to void");
                                    input = in.nextLine();
                                    employee.voidItem(customer, input);
                                    System.out.println("Your item has been voided!");
                                    System.out.println("Your total is" + customer.printBill());
                                    input = in.nextLine();
                                    break;

                                    
                                }
                                if(input.equals("void all")){
                                    employee.voidBill(customer);
                                    System.out.println("Thank you, have a good day!");
                                    break;
                                }
                                if(input.equals("deposit")){
                                    double input1 = in.nextDouble();
                                    System.out.println("How much $$$?");
                                    customer.depositMoney(input1);
                                    System.out.println("You now have: "+ customer.getCardBalance());
                                }
                            }
                            if(bill==0.00){
                                System.out.println("Have a good day!");
                                break;
                            }
                        }
 
            
                    }
                    else{
                        System.out.println("Have a good day!");
                    }
 
                    

                    
                }
                running=false;
                                
            }
        }
    }

