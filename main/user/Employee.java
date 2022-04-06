package main.user;

import main.Item;

public class Employee extends AbstractUser{
    int idNum  ;

    public Employee(int idNumIn){
        this.idNum = idNumIn;
    }

    public void voidItem(Item item){

    }

    public void voidBill(Customer customer){
        
    }

    public double calculateBill(Customer customer){
        return -1;
    }


}
