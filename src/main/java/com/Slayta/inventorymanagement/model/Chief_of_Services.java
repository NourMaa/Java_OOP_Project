package main.java.com.Slayta.inventorymanagement.model;

import java.util.Scanner;

import main.java.com.Slayta.inventorymanagement.services.InventoryManager;


public class Chief_of_Services extends User {

    private final Scanner scanner;
    
public Chief_of_Services(String username,Scanner scanner) {
        super("", username, "","Chief of Services");
        this.scanner=scanner;

    }
      

    @Override
         public int get_log_out_num()
         {
             return 10;
         }


   @Override
    public int get_menu() {
     int input;
    while (true) {
        System.out.println("Chief Of Service Tasks Menu");
        System.out.println("(1) See the inventory (available ingredients and their corresponding quantities)");
        System.out.println("(2) See a specific ingredient data");
        System.out.println("(3) See the quantity available of a specific ingredient");
        System.out.println("(4) See Stockouts");
        System.out.println("(5) Add a new ingredient");
        System.out.println("(6) Remove an ingredient");
        System.out.println("(7) Update ingredient quantity");
        System.out.println("(8) Update ingredient portion size");
        System.out.println("(9) Update ingredient portion price");
        System.out.println("(10) Log Out");
        System.out.println("Please indicate the task number you'd like to address");

        if (scanner.hasNextInt()) {
            input = scanner.nextInt();
            if (input >= 1 && input <= 10) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 10.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // consume invalid input
        }
    }
    return input;
}

@Override
public void tasks(int input) {
    InventoryManager inventoryManager=new InventoryManager();
    switch (input) {
        case 1:
            inventoryManager.display_inventory();
            break;

        case 2:
            System.out.println("Enter ingredient name:");
            String ingredientName = scanner.next();
            inventoryManager.displayIngredient(ingredientName);
            break;

        case 3:
            System.out.println("Enter ingredient name:");
            String ingredientName2 = scanner.next();
            inventoryManager.get_quantity(ingredientName2);
            break;

        case 4:
            inventoryManager.see_stockouts();
            break;

        case 5:
            System.out.println("Enter ingredient data:");
            System.out.println("Enter ingredient name:");
            String name = scanner.next();
            System.out.println("Enter ingredient ID:");
            String id = scanner.next();
            System.out.println("Enter ingredient category:");
            String category = scanner.next();            
            System.out.println("Enter ingredient portion size:");
            double portionSize = scanner.nextDouble();
            System.out.println("Enter ingredient price :");
            double price = scanner.nextDouble();
            System.out.println("Enter ingredient quantity:");
            double quantity = scanner.nextDouble();            
            Ingredient newIngredient = new Ingredient(id, category, name, portionSize, price, quantity);
            inventoryManager.addIngredient(newIngredient);
            System.out.println("Ingredient added successfully");
            break;

        case 6:
            System.out.println("Enter ingredient name:");
            String ingredientName6 = scanner.next();
            inventoryManager.removeIngredient(ingredientName6);
            break;

        case 7:
            System.out.println("Enter ingredient name:");
            String ingredientName7 = scanner.next();
            System.out.println("Add or subtract quantity:");
            double quantityChange = scanner.nextDouble();
            inventoryManager.updateIngredientQuantity(ingredientName7,quantityChange);
            break;

        case 8:
            System.out.println("Enter ingredient name:");
            String ingredientName8 = scanner.next();
            System.out.println("Enter new portion size:");
            double newPortionSize = scanner.nextDouble();
            inventoryManager.updateIngredientPortionSize(ingredientName8, newPortionSize);
            break;

        case 9:
            System.out.println("Enter ingredient name:");
            String ingredientName9 = scanner.next();
            System.out.println("Enter new portion price:");
            double newPortionPrice = scanner.nextDouble();
            inventoryManager.updateIngredientPortionPrice(ingredientName9, newPortionPrice);
            break;

        case 10:
            System.out.println("You have been successfully logged out. Until next time!");
            return;

        default:
            System.out.println("Invalid input. Please try again");
    }
}
}
    