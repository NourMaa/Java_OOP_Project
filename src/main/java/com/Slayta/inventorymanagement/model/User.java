package main.java.com.Slayta.inventorymanagement.model;


public abstract class User {
    
    private final String userId;
    private final String username;
    private final String password;
    private final String role;

    public User(String userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    //abstract methods
    public abstract int get_menu();
    public abstract void tasks(int input);
    public abstract int get_log_out_num();

    
    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
    
}

