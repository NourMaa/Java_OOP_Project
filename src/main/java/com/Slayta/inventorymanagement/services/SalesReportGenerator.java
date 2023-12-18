package main.java.com.Slayta.inventorymanagement.services;
import java.io.FileNotFoundException;

import main.java.com.Slayta.inventorymanagement.util.SalesDataHandler;

public class SalesReportGenerator {
    private InventoryManager inventoryManager;
    
    //constructor 
    public  SalesReportGenerator() {
    
    }
    public void Sales_History() throws FileNotFoundException{
                SalesDataHandler salesDataHandler=new SalesDataHandler();
                 salesDataHandler.displaySalesTransactions();
            }
    
    public void Sales_transactions_Summary() throws FileNotFoundException  {       
        SalesDataHandler salesDataHandler=new SalesDataHandler();
        System.out.println("Sales Report: Sales transactions Summary");
                System.out.println("Total number of Sales Transcations"+salesDataHandler.num_transcations());
                // Show Total Revenue 
                System.out.println("Total Revenue of Sales Transcations"+ salesDataHandler.calculateTotalRevenue()+" TD");
                // Average Transaction Amount
                double avg=salesDataHandler.calculateTotalRevenue()/salesDataHandler.num_transcations();
                System.out.printf("Average Transaction Amount %.2d  TD"+avg);
                // Show Most and Least Popular Ingredients  
                salesDataHandler.Ingredients_poularity();        
      
    }   
            public void Inventory_Status() throws FileNotFoundException {
        System.out.println("Inventory Status Report");
        System.out.println("Ingredient and reamining quantity ");
        inventoryManager.display_inventory();        
            }
            

    }
