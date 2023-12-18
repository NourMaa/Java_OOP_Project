package main.java;

import java.util.Scanner;

import main.java.com.Slayta.inventorymanagement.model.Admin;
import main.java.com.Slayta.inventorymanagement.model.Cashier;
import main.java.com.Slayta.inventorymanagement.model.Chief_of_Services;
import main.java.com.Slayta.inventorymanagement.model.Data_Analyst;
import main.java.com.Slayta.inventorymanagement.model.User;
import main.java.com.Slayta.inventorymanagement.services.AuthenticationManager;
import main.java.com.Slayta.inventorymanagement.util.UserFileHandler;

public class main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            UserFileHandler userFileHandler=new UserFileHandler();
            boolean do_log_in = true;
            do {
                System.out.println("LOG IN");
 authentication = new AuthenticationManager();
                String username = authentication.authenticateUser();
                String role = authentication.getRole(username);

                // Instantiate User based on role
                User user = null;   //outside the switch statement so that it can be used to perform tasks  
                switch (role.toLowerCase()) {
                // User authentication
                AuthenticationManager
                    case "admin":
                        user = new Admin(username,scanner,userFileHandler);
                        break;
                    case "cashier":
                        user = new Cashier(username,scanner);
                        break;
                    case "chief of services":
                        user = new Chief_of_Services(username,scanner);
                        break;
                    case "data analyst":
                        user = new Data_Analyst(username,scanner);
                        break;
                }

                // Perform tasks based on user's role
                if (user != null) {
                    while (true) {
                        int input = user.get_menu();
                        user.tasks(input);
                        if (input == user.get_log_out_num()) {
                          break; 
                            }
                    }
                }

    
                System.out.println("Do you want to log in again? (yes/no)");
                String input= scanner.next();
                if(input.equalsIgnoreCase("no"))
                {do_log_in = false;}

                
            } while (do_log_in);
        }
        System.out.println("The system is successfully closed. Until next time!");
    }
}