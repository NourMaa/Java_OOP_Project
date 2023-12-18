package main.java.com.Slayta.inventorymanagement.services;

import java.util.Scanner;

import main.java.com.Slayta.inventorymanagement.util.UserFileHandler;

public class AuthenticationManager {
    
    private final UserFileHandler userFileHandler;
    private final Scanner scanner;
    
    // Constructor
    public AuthenticationManager()
    {  
        this.userFileHandler = new UserFileHandler();
        this.scanner = new Scanner(System.in);
    }
    
    public String authenticateUser()
    {   
        String username;
        boolean username_in_userDataFile;
    
    do {
        // Prompt for username input
            System.out.print("Enter your username: ");
            username = scanner.nextLine();
            username_in_userDataFile= userFileHandler.checkUsername(username);
            if (username_in_userDataFile ==false) {
                System.out.println("Username not found! Please try again.");
            } else {
                // Username exists, and prompt for password
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();
                while (userFileHandler.checkPassword(username, password)==false) {
                    System.out.println("Wrong password! Please enter a correct password.");
                    password=scanner.nextLine();
                } 
                    // Password is correct, welcome the user
                    System.out.println("Welcome back, " + username );
                }

    } while (username_in_userDataFile == false);
    return username; 
    }
    
    public String getRole(String username) {
        return userFileHandler.read_role(username);    
    }
    
}
       
