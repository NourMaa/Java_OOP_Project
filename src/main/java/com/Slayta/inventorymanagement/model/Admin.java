package main.java.com.Slayta.inventorymanagement.model;

import java.util.Scanner;
import main.java.com.Slayta.inventorymanagement.util.UserFileHandler;

public class Admin extends User {
    
    private final Scanner scanner;
    private UserFileHandler userFileHandler;

    
    public Admin(String username,Scanner scanner , UserFileHandler userFileHandler) {
        super("", username, "","Admin");
        this.scanner=scanner;
        this.userFileHandler = userFileHandler;
    }
    @Override
         public int get_log_out_num()
         {
             return 6;
         }
    @Override
    public int get_menu()
    {
        System.out.println( "Admin Tasks Menu");
        System.out.println("(1) add a new user");
        System.out.println("(2) remove a user");
        System.out.println ("(3) update a user's role");
        System.out.println( "(4) update a user's username");
        System.out.println( "(5) update a user's credentials");
        System.out.println( "(6) log out");
        int input;
        while (true) {
         input = scanner.nextInt();
        if (input >= 1 && input <= 6) {
        break; // Exit the loop if the input is valid
        } else {
        System.out.println("Invalid input. Please try again");
        }
        }
        return input;
    }

    @Override
    public void tasks(int input)
    {
        switch (input) {
   case 1:
        System.out.println("Enter new username:");
        String username = scanner.next();
        System.out.println("Enter his ID:");
        String id = scanner.next();
        System.out.println("Enter his password:");
        String password = scanner.next();
        System.out.println("Enter his role:");
        String role = scanner.next();
        userFileHandler.add_user(id,username,password,role);
        
        break;

    case 2:
        System.out.println("Enter username to remove:");
        String usernameToRemove = scanner.next();
        userFileHandler.remove_user(usernameToRemove);
        break;

    case 3:
        System.out.println("Enter username:");
        String usernameToUpdateRole = scanner.next();
        System.out.println("Enter new role:");
        String newRoleToUpdate = scanner.next();
            {
                userFileHandler.update_role(usernameToUpdateRole, newRoleToUpdate);
            }
        break;


    case 4:
        System.out.println("Enter username:");
        String usernameToUpdateUsername = scanner.next();
        System.out.println("Enter new username:");
        String newUsernameToUpdate = scanner.next();
        userFileHandler.update_username(usernameToUpdateUsername, newUsernameToUpdate);
        break;

    case 5:
        System.out.println("Enter username:");
        String usernameToUpdatePassword = scanner.next();
        System.out.println("Enter new password:");
        String newPasswordToUpdate = scanner.next();
        userFileHandler.update_password(usernameToUpdatePassword, newPasswordToUpdate);
        break;

    case 6:
        System.out.println("You have been successfully logged out. Until next time!");
        return;

    default:
        System.out.println("Invalid input. Please try again");
}
    }

}
