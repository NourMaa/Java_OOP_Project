package main.java.com.Slayta.inventorymanagement.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.Slayta.inventorymanagement.model.SaleTransaction;

public class SalesDataHandler {
 
    
    private static String path = "C:\\Users\\pc\\Desktop\\FLOWER\\Senior year\\Java\\Java Project Salad Bar\\src\\main\\resources\\Transactions.txt";
    private Scanner read_file;
    private PrintWriter write_file;
    
    public SalesDataHandler()
    {
      
    }
  
    //write new sale transaction to transactions.txt
    public void addSaleTransaction(SaleTransaction newSaleTransaction)
    {try {      

         write_file = new PrintWriter(new FileWriter(path, true));
        // write in file with formatting
        String transaction= "Order Id : "+ newSaleTransaction.get_OrderId() +" | Ingredient Name : "+  newSaleTransaction.get_ingredientName()+" | Number Of Portions : "+  newSaleTransaction.get_numberOfPortions()+" | Date : "+ newSaleTransaction.get_date()+" | Transaction Revenue : "+newSaleTransaction.calculate_tanscation_amount();
        write_file.println(transaction);
        System.out.println("Transaction added Successfully ");
            write_file.close();
       } catch (IOException e) {
            System.out.println("ERROR: Unable to open file for writing! ");
        }
    }
    
                
    //read sales transcation from file transactions.txt
      public void displaySalesTransactions() throws FileNotFoundException
      {
          try{
        read_file = new Scanner(new FileReader(path));

        while (read_file.hasNextLine()) {
           String line = read_file.nextLine();
           System.out.println(line);
            }
        read_file.close(); // Close the existing Scanner because it reaches the end of the file
        } catch (FileNotFoundException e) {
        System.out.println("ERROR: File not found!");
        }
      }
      
      private String findDataAtIndex(String line, int i)     //0: Order Id , 1: Ingredient Name, 2: Number Of Portions , 3: Date , 4: Transaction Revenue 
         {
         // split the line 
          String[] parts = line.split("\\|");
          return parts[i].trim();
        }

        public double calculateTotalRevenue() throws FileNotFoundException
        {
         double totalRevenue = 0;
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                totalRevenue += Double.parseDouble(findDataAtIndex(line, 4));
            }
            return totalRevenue;
        }
        }
        
         public void Ingredients_poularity() throws FileNotFoundException
         {
             List<String> ingredientsList = new ArrayList<>(); //list since the number of ingredients is not known 
             List<Integer> ingredientCounts = new ArrayList<>();

            try 
                (Scanner scanner = new Scanner(new File(path))) 
            {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String ingredientName = findDataAtIndex(line, 1);

                int index = ingredientsList.indexOf(ingredientName);
                if (index != -1) {
                    // Ingredient already in the list, increment its count
                    int count = ingredientCounts.get(index);
                    ingredientCounts.set(index, count + 1);
                } else {
                    // Ingredient not in the list
                    ingredientsList.add(ingredientName);
                    ingredientCounts.add(1);
                }
            }
                }

        // Find the most popular ingredient
        int maxCount = 0;
        int minCount = 0;
        String mostPopularIngredient = null;
        String leastPopularIngredient = null;

        for (int i = 0; i < ingredientCounts.size(); i++) {
            int count = ingredientCounts.get(i);
            if (count > maxCount) {
                maxCount = count;
                mostPopularIngredient = ingredientsList.get(i);
            }
        }
        System.out.println("Most Popular Ingredient: " + mostPopularIngredient);
        
        for (int i = 0; i < ingredientCounts.size(); i++) {
            int count = ingredientCounts.get(i);
            if (count < minCount) {
                minCount = count;
                leastPopularIngredient = ingredientsList.get(i);
            }
        }
        System.out.println("Least Popular Ingredient: " + leastPopularIngredient);
             }
         
        
        
        public void readOrderDetails(int orderId)
        {
            
        }

        public int num_transcations() throws FileNotFoundException   //number of transcations in file 
        {
         int count = 0;
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                count++;
            }
            return count;
        }}

    
        
   }