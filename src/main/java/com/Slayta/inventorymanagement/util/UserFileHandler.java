package main.java.com.Slayta.inventorymanagement.util;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UserFileHandler  {
    private static String path = "C:\\Users\\pc\\Desktop\\FLOWER\\Senior year\\Java\\Java Project Salad Bar\\src\\main\\resources\\user_data.txt";
    private Scanner read_file;
    private PrintWriter write_file;
    
    
    //constructor 
    public  UserFileHandler()
    {  
    try {   
            read_file = new Scanner(new FileReader(path));
            write_file = new PrintWriter(new FileWriter(path, true));
            if (!read_file.hasNextLine()) // empty file
            {
                // initialize default users
                initializeDefaultUsers();
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found!");
            } catch (IOException e) {
            System.out.println("ERROR: Unable to open file for reading or writing! " );
           
        }
    
    }
    
    // initialize default users
    private void initializeDefaultUsers() {
        try {
            write_file = new PrintWriter(new FileWriter(path, true)); // Use FileWriter with true for append mode
            write_file.println("1|nour|123|Admin");
            write_file.println("2|ons|1234|Admin");
        } catch (IOException e) {
            System.out.println("ERROR: Unable to open file for writing!");
        } 
    }
    
    //read file and user data  with substring (delimiter)
    public String find_info(String username , int i)
    {try {
        read_file.close(); // Close the existing Scanner because it reaches the end of the file,
        read_file = new Scanner(new FileReader(path)); // Reopen the Scanner

        while (read_file.hasNextLine()) {
            String line = read_file.nextLine();
            String[] userData = line.split("\\|");
            if (userData[1].equals(username)) {
                return userData[i];
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("ERROR: File not found!");
    }
    return ""; // return an empty string if username is not found 


    }
        public boolean checkUsername(String username)
         { 
         return find_info(username ,1).equals(username);  
         }
        
        public boolean checkPassword(String username ,String password)
         {    
             //check whether password user_data.txt is correct for the corresponding username                   
           return find_info(username ,2).trim().equals(password.trim());  
         }
        
         public String read_userId(String username)
         {  //find userid given its username 
            return find_info(username ,0);
         }
       
           public String read_password(String username)
         {              
             return find_info(username ,2);
         }
          
            public String read_role(String username)
         {
            return find_info(username ,3);
         }
    

    public void add_user(String id,String username, String password ,String role)
    {   try {      
        closeResources();

         write_file = new PrintWriter(new FileWriter(path, true));
        // write in file with formatting
        String userData = id + "|" + username+ "|" + password + "|" + role +'\n';
        write_file.println(userData);
        System.out.println("User added Successfully ");
        closeResources();
       } catch (IOException e) {
            System.out.println("ERROR: Unable to open file for writing! ");
        }
    }
    
    
    public void display_user_data() {
        try (Scanner read_file = new Scanner(new FileReader(path))) {
            while (read_file.hasNextLine()) {
                String line = read_file.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("ERROR: Unable to read user data from file.");
        } finally {
            closeResources();
        }
    }


   public void remove_user(String username)
   {
    try (Scanner read_file = new Scanner(new FileReader(path));
    PrintWriter tempWriter = new PrintWriter(new FileWriter("user_data.txt", true))) {

   while (read_file.hasNextLine()) {
       String line = read_file.nextLine();
       String[] userData = line.split("\\|");

       // Check if the current line contains the user to be removed
       if (!userData[1].equals(username)) {
           tempWriter.println(line);
       }
   }

   // Delete the original file
   File originalFile = new File(path);
   if (originalFile.delete()) {
       // Rename the temporary file to the original file name
       File tempFile = new File("temp_user_data.txt");
       if (!tempFile.renameTo(originalFile)) {
           System.out.println("ERROR: Unable to rename the temporary file.");
       }
   } else {
       System.out.println("ERROR: Unable to delete the original file.");
   }

} catch (IOException e) {
   System.out.println("ERROR: Unable to remove user from file.");
} finally {
   closeResources();
}

   }
   
   public void update_role(String username, String new_role) {
    try {
        closeResources();

        // Read the existing user data from the file
        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

        // Iterate through the lines to find and update the role
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] userData = line.split("\\|");
            
            // Check if the current line corresponds to the specified username
            if (userData.length >= 4 && userData[1].equals(username)) {
                // Update the role
                userData[3] = new_role;

                // Join the modified user data back to a string
                String updatedUserData = String.join("|", userData);

                // Update the list with the modified user data
                lines.set(i, updatedUserData);
                
                System.out.println("Role updated successfully for user: " + username);
                break; // No need to continue searching
            }
        }
        // Write the updated data back to the file
        Files.write(Paths.get(path), lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);

    } catch (IOException e) {
        System.out.println("ERROR: Unable to open or write to the file.");
    } finally {
        closeResources();
    }
}


   
   public void update_username(String username,String new_username)
   {try {
    closeResources();

    // Read the existing user data from the file
    List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

    // Iterate through the lines to find and update the username
    for (int i = 0; i < lines.size(); i++) {
        String line = lines.get(i);
        String[] userData = line.split("\\|");

        // Check if the current line corresponds to the specified username
        if (userData.length >= 4 && userData[1].equals(username)) {
            // Update the username directly
            userData[1] = new_username;

            // Join the modified user data back to a string
            String updatedUserData = String.join("|", userData);

            // Update the list with the modified user data
            lines.set(i, updatedUserData);

            System.out.println("Username updated successfully for user: " + new_username);
            break; // No need to continue searching
        }
    }

    // Write the updated data back to the file
    Files.write(Paths.get(path), lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);

} catch (IOException e) {
    System.out.println("ERROR: Unable to open or write to the file.");
} finally {
    closeResources();
}
       }
   
       public void update_password(String username, String new_pwd) {
        try {
            closeResources();
    
            // Read the existing user data from the file
            List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
    
            // Iterate through the lines to find and update the password
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] userData = line.split("\\|");
    
                // Check if the current line corresponds to the specified username
                if (userData.length >= 4 && userData[1].equals(username)) {
                    // Update the password directly
                    userData[2] = new_pwd;
    
                    // Join the modified user data back to a string
                    String updatedUserData = String.join("|", userData);
    
                    // Update the list with the modified user data
                    lines.set(i, updatedUserData);
    
                    System.out.println("Password updated successfully for user: " + username);
                    break; // No need to continue searching
                }
            }
    
            // Write the updated data back to the file
            Files.write(Paths.get(path), lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
    
        } catch (IOException e) {
            System.out.println("ERROR: Unable to open or write to the file.");
        } finally {
            closeResources();
        }
    }
   
   private void closeResources() {
      try{  
      if (read_file != null) {
            read_file.close();
        }
        if (write_file != null) {
            write_file.close();
        } 
    read_file = new Scanner(new FileReader(path));
     } catch (IOException e) {
            System.out.println("ERROR: Unable to close resources! " );
        }
   }}