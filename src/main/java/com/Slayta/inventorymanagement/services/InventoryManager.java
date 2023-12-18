package main.java.com.Slayta.inventorymanagement.services;

import java.util.ArrayList;
import java.util.List;

import main.java.com.Slayta.inventorymanagement.model.Ingredient;

public class InventoryManager {
    
    private List<Ingredient> list_of_ingredients;  

    public InventoryManager() {
        this.list_of_ingredients = new ArrayList<>();
    }
 
    public void display_inventory() 
        {
        //display available ingredients and their corresponding quantites 
        System.out.println("Current Inventory:");

        for (Ingredient ingredient : list_of_ingredients) {
            System.out.println("Ingredient: " + ingredient.getName() +
                    ", Quantity: " + ingredient.getQuantity() +
                    ", Price: $" + ingredient.getPrice() +
                    ", Category: " + ingredient.getCategory());
        }

        System.out.println("---------------------------");
    }
    
        
    public boolean check_ingredient(String ingredient_name) 
    {
        for (Ingredient ingredient : list_of_ingredients) {
            if (ingredient.getName().equals(ingredient_name)) {
                return true; // Ingredient found
            }
        }

        // Ingredient not found
        System.out.println("Ingredient '" + ingredient_name + " does not exist.");
        return false;   
    }

    public void displayIngredient(String ingredientName) {
                boolean ingredientFound = false;
        
                for (Ingredient ingredient : list_of_ingredients) {
                    if (ingredient.getName() .equals(ingredientName)) {
                        ingredientFound = true;
                        System.out.println("Ingredient Details:");
                        System.out.println("Name: " +ingredient.getName() );
                        System.out.println("Quantity: " + ingredient.getQuantity());
                        System.out.println("Price: $" + ingredient.getPrice());
                        System.out.println("Category: " + ingredient.getCategory());
                        break;
                    }
                }
        
                if (!ingredientFound) {
                    System.out.println("Ingredient '" + ingredientName + "' does not exist.");
                }
            }
        
        
    
    public void get_quantity(String ingredientName)
    {
        boolean ingredientFound = false;

        for (Ingredient ingredient : list_of_ingredients) {
            if (ingredient.getName().equals(ingredientName)) {
                ingredientFound = true;
                System.out.println(ingredientName + " Quantity  = " + ingredient.getQuantity());
                break;
            }
        }

        if (!ingredientFound) {
            System.out.println("Ingredient '" + ingredientName + "' does not exist.");
        }
    }
    
    
    public double getPortion(String ingredientName) {
        for (Ingredient ingredient : list_of_ingredients) {
            if (ingredient.getName().equals(ingredientName)) {
                return ingredient.getPortion();
            }}
            System.out.println("Ingredient '" + ingredientName + "' does not exist.");
            return 0; // Default portion if ingredient is not found    
    }

    public void see_stockouts()
    {
        System.out.println("Stockouts:");

        for (Ingredient ingredient : list_of_ingredients) {
            if (ingredient.getQuantity() == 0) {
                System.out.println("We are run out of " + ingredient.getName());
            }
        }
    }
            
    public void addIngredient(Ingredient new_ingredient) {
        int existingIngredientIndex = findIngredientIndex(new_ingredient.getName());

        if (existingIngredientIndex != -1) {
            System.out.println("Ingredient already exists.");
        } else {
            list_of_ingredients.add(new_ingredient);
            System.out.println("Ingredient added successfully to the inventory.");
        }
    }


    public void removeIngredient(String ingredientName)
    {
        int ingredientIndex = findIngredientIndex(ingredientName);

        if (ingredientIndex != -1) {
            list_of_ingredients.remove(ingredientIndex);
            System.out.println("Ingredient deleted successfully.");
        } else {
            System.out.println("Ingredient '" + ingredientName + "' does not exist.");
        }
    }

    public void updateIngredientQuantity(String ingredientName, double quantityUpdate) {
        int ingredientIndex = findIngredientIndex(ingredientName);

        if (ingredientIndex != -1) {
            Ingredient ingredientToUpdate = list_of_ingredients.get(ingredientIndex);

            if (quantityUpdate < 0) {
                ingredientToUpdate.decrease_quantity(-quantityUpdate);
            } else {
                ingredientToUpdate.increase_quantity(quantityUpdate);
            }

            System.out.println("Ingredient updated successfully.");
        } else {
            System.out.println("Ingredient '" + ingredientName + "' not found.");
        }
    } 


    public void updateIngredientPortionSize(String ingredientName, double newPortionSize) {
        int ingredientIndex = findIngredientIndex(ingredientName);

        if (ingredientIndex != -1) {
            Ingredient ingredientToUpdate = list_of_ingredients.get(ingredientIndex);
            ingredientToUpdate.setPortion(newPortionSize);
            System.out.println("Ingredient portion size updated successfully.");
        } else {
            System.out.println("Ingredient '" + ingredientName + "' does not exist.");
        }
    }
   
        
    public void updateIngredientPortionPrice(String ingredientName, double newPortionPrice) {
        int ingredientIndex = findIngredientIndex(ingredientName);

        if (ingredientIndex != -1) {
            Ingredient ingredientToUpdate = list_of_ingredients.get(ingredientIndex);
            ingredientToUpdate.setPrice(newPortionPrice);
            System.out.println("Ingredient portion price updated successfully.");
        } else {
            System.out.println("Ingredient '" + ingredientName + "' does not exist.");
        }
    }

    private int findIngredientIndex(String ingredientName) {
        for (int i = 0; i < list_of_ingredients.size(); i++) {
            if (list_of_ingredients.get(i).getName().equals(ingredientName)) {
                return i; // Ingredient found, return its index
            }
        }
        return -1; // Ingredient not found
    }
}


    