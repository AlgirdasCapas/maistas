package org.example.user;

public class UserSingleton {
    private static UserSingleton instance;
    private String username;

    private UserSingleton() {
    }
    public  static UserSingleton getInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

