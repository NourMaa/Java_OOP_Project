package main.java.com.Slayta.inventorymanagement.model;

import java.util.Date;

public class Transaction {  //one ingredient 
    
    private String ingredientName; 
    private Date date;
    private String transaction_type;  //sale, purchase ,return ...  

    public Transaction(String ingredientName, Date date, String transaction_type) {
        this.ingredientName = ingredientName;
        Date currentUtilDate = new Date();
        this.date = currentUtilDate;
        this.transaction_type = "Sale Transaction";
    }
                                                                                                           
       
    @Override
    public String toString()
    {  
        return " Date: " + this.date + "Transaction: "+this.transaction_type + " Ingredient: " + ingredientName ;
    }
    
    }



