package test;

import java.util.Scanner;

import main.Cart;

import main.user.Customer;
import main.user.Employee;

public class ShoppingInterface {
    public static void main(String[] args){
        try (Scanner in = new Scanner(System.in)) {
            String welcome = "Welcome to the grocery store!";

            boolean running = true;
            Cart cart = new Cart();
            double bill;


            while(running) {
                System.out.println(welcome);
                System.out.println("Would you like to begin checking out?(y/n)");
                String input = in.nextLine();
                if(input.equals("y")){
                    System.out.println("If youre done adding items to cart, say done");
                    Customer customer = new Customer(01, cart);
                    Employee employee = new Employee(01, cart, 1234);
                    System.out.println("type item");
                    while(!input.equals("done")){
                        input = in.nextLine();
                        customer.addItem(input);
                        System.out.println("type done if you'd like a total of the bill.");
                        System.out.println("void item if you'd like to void an item");
                        System.out.println("type void all if you'd like to void entire bill");
                        System.out.println("type deposit if you need to add money");
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
                                break;
                            }
                            else if(input.equals("cash")){
                                System.out.println("How much cash?");
                                double input1 = in.nextFloat();
                                customer.payBillCash(input1);
                                System.out.println("Thanks, Have a good day!");
                            }
                        }
                        if(bill==0.00){
                            System.out.println("Have a good day!");
                            break;
                        }
                    }
                    else if(input.equals("void item")){
                        System.out.println("What would you like to void");
                        employee.voidItem(input);
                    }
                    else if(input.equals("void all")){
                        employee.voidBill(customer);
                    }
                    else if(input.equals("deposit")){
                        double input1 = in.nextDouble();
                        customer.depositMoney(input1);
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
