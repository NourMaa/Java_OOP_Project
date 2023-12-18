package main.java.com.Slayta.inventorymanagement.model;

import java.util.Date;

public class SaleTransaction extends Transaction {
        private Ingredient ingredient; 
        private int OrderId; 
        private String ingredientName;
        private int numberOfPortions;
        private Date date;
        String transaction_type;
        
    //parameterized constructor 
    public SaleTransaction(int OrderId, String ingredientName, int numberOfPortions, Date date){
        super(ingredientName, date, "Sale");
        this.OrderId=OrderId;
        this.numberOfPortions=numberOfPortions; 
    }
    
    public SaleTransaction(int OrderId, String ingredientName, int numberOfPortions) {
        super(ingredientName, new Date(), "Sale"); 
        this.OrderId = OrderId;
        this.numberOfPortions = numberOfPortions;
    }

    //Getters
    
    public int get_OrderId()
    {
        return this.OrderId; 
    }
    public int get_numberOfPortions()
    {
                return this.numberOfPortions; 

    }
   public String get_ingredientName() 
    {
       return this.ingredientName; 
    }
     public Date get_date()
       {
                return this.date; 

    }
         public double calculate_tanscation_amount()
        {   
            return (ingredient.getPortion()*numberOfPortions*ingredient.getPrice());
        }    

       @Override
        public String toString()
         {  
             return  " OrderId: " + OrderId + super.toString()+ " numberOfPortions: " + numberOfPortions;
         }
}

