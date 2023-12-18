package main.java.com.Slayta.inventorymanagement.model;

import java.io.FileNotFoundException;
import java.util.Scanner;

import main.java.com.Slayta.inventorymanagement.services.SalesReportGenerator;


public class Data_Analyst extends User{

    private final Scanner scanner;

    public Data_Analyst(String username,Scanner scanner) {
        super("", username, "","Data Analyst");
        this.scanner=scanner;
    }
        
    @Override
         public int get_log_out_num()
         {
             return 4;
         }
    
    @Override
    public int get_menu() {
        System.out.println("Data Analyst Tasks Menu");
        System.out.println("(1) Display Sales History ");
        System.out.println("(2) Generate Sales Report ");
        System.out.println("(3) Display Inventoy Status");
        System.out.println("(4) Log Out");
        int input;
        while (true) {
         input = scanner.nextInt();
        if (input >= 1 && input <= 4) {
        break; // Exit the loop if the input is valid
        } else {
        System.out.println("Invalid input. Please try again");
        }
        }
      
        return input;
    }

    @Override
    public void tasks(int input) {
        SalesReportGenerator salesReportGenerator = new SalesReportGenerator();
        switch (input) {
            case 1:
            {
                try {
                    salesReportGenerator.Sales_History();
                } catch (FileNotFoundException ex) {
                    System.out.print("Error: File not Found");
                }
            }
                break;


            case 2:
            {
                try {
                    salesReportGenerator.Sales_transactions_Summary();
                } catch (FileNotFoundException ex) {
                    System.out.print("Error: File not Found");
                }
            }
                break;

            case 3:
            {
                try {
                    salesReportGenerator.Inventory_Status();
                } catch (FileNotFoundException ex) {
                    System.out.print("Error: File not Found");
                }
            }
                break;


            case 4:
                System.out.println("You have been successfully logged out. Until next time!");
                return;

            default:
                System.out.println("Invalid input. Please try again");
        }
    }
}


    


