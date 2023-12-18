package main.java.com.Slayta.inventorymanagement.model;

import java.util.Scanner;

import main.java.com.Slayta.inventorymanagement.services.InventoryManager;
import main.java.com.Slayta.inventorymanagement.util.SalesDataHandler; 


public class Cashier extends User {
    private final Scanner scanner;
    public static int num_orders = 0;
    
public Cashier(String username,Scanner scanner) {
        super("", username, "","Cashier");
         this.scanner=scanner;
    }
     
        @Override
         public int get_log_out_num()
         {
             return 2;
         }

    @Override
    public int get_menu() {
        System.out.println("Cashier Tasks Menu");
        System.out.println("(1) Enter new order");
        System.out.println("(2) Log out");
        System.out.println("Please indicate the task number you'd like to address");
        int input;
        while (true) {
         input = scanner.nextInt();
        if (input >= 1 && input <= 2) {
        break; // Exit the loop if the input is valid
        } else {
        System.out.println("Invalid input. Please try again");
        }
        }
        return input;
    }

    @Override
    public void tasks(int input) {
         
    switch (input) {
        case 1:
                 InventoryManager inventoryManager=new InventoryManager();
                 SalesDataHandler salesDataHandler=new SalesDataHandler();
            num_orders++;
            System.out.println("Order: " + num_orders);
            int num_ingredients = 0;
            while (num_ingredients < 5) {
                System.out.println("How many ingredients? An order should have at least 5 ingredients");
                num_ingredients = scanner.nextInt();
            }
            for (int i = 1; i < num_ingredients+1; i++) {
                System.out.println("Ingredient " + i);
                System.out.println("Enter name");
                String name = scanner.next();
                // Check if ingredient exists in inventory
                if (inventoryManager.check_ingredient(name)) {
                    System.out.println("Enter how many portions");
                    int num_Portions = scanner.nextInt();
                    SaleTransaction newTransaction = new SaleTransaction(num_orders, name, num_Portions);
                    salesDataHandler.addSaleTransaction(newTransaction);
                    // Call InventoryManager.getPortion(name) to get portion size 
                    double portionSize = inventoryManager.getPortion(name);
                    double quantityToSubtract = -(portionSize * num_Portions);
                    // Update the inventory by calling the InventoryManager.updateIngredientQuantity(name, quantityToSubtract)
                    inventoryManager.updateIngredientQuantity(name, quantityToSubtract);
                }
            }
            System.out.println("Orders processed successfully");
            break;

        case 2:
            System.out.println("You have been successfully logged out. Until next time!");
            return;

        default:
            System.out.println("Invalid input. Please try again");
    }
}

}
    

