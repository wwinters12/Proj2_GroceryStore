package main;

import java.util.ArrayList;
import java.util.List;

import main.user.Employee;

public class Store {
    private List<Item> inventory = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public Store(){
        //empty constructor
    }

    /**
     * 
     * @param itemToAdd
     */
    public void addItemToInventory(Item itemToAdd){

    }
    
    /**
     * 
     * @param employeeToAdd
     */
    public void addEmployee(Employee employeeToAdd){

    }

    public List<Item> getInventory() {
        return inventory;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}
