package main.java.com.Slayta.inventorymanagement.model;

public class Ingredient {
    //instance variables
    private String id;
    private String category; // vegs, fruits, nuts 
    private String name; 
    private double portion_size;
    private double price;   //portion price
    private double quantity;   // quantity in the inventory
     
    
    public Ingredient(String id , String category, String name , double portion_size , double price , double quantity) 
    {
        this.id=id; 
        this.category = category;
        this.name = name;
        this.portion_size=portion_size;
        this.price = price;
        this.quantity = quantity;

    }
    
    // default constructors
    public Ingredient(String id , String name)
    {         this.id = id; 
              this.name = name;
              this.category="Others";
              this.quantity = 0;
              this.price = 0;
              this.portion_size=1;

    }
    
    public Ingredient(String id , String name, int quantity)
    {         
              this.id=id; 
              this.name = name;
              this.category="Others";
              this.quantity = quantity ;
              this.price = 0;
              this.portion_size=1;
    }
    
    public Ingredient(String id , String name, String category)
    {         
              this.id=id; 
              this.name = name;
              this.category= category;
              this.quantity = 0;
              this.price = 0;
              this.portion_size=1;
    }
   
        // Getters
            
        public String getName() {  
        return this.name;
        }
        
        public String getCategory() {  
        return this.category;
        }
        
       public double getPrice() {  
        return this.price;
        }
        
        public double getPortion() {  
        return this.portion_size;
        }
        public double getQuantity() {  
        return this.quantity;
        }
        
        //Setters  
        public void setPrice(double price) { 
              this.price = price;
        }
        public void setPortion(double portion) { 
                this.portion_size = portion;
        }
        
        public void increase_quantity(double quantity_added) {
                this.quantity += quantity_added;
        }
    
        public void decrease_quantity(double quantity_reduced) {
                this.quantity -= quantity_reduced;

         }
       
    @Override
        public String toString() 
        {
            String ingredient_data=""; // ingredient attributes
            return ingredient_data; 
        }
        
}