package com.example.udemy_thecompleteandroid14developercourse_build100apps.FirebaseRealTimeDatabase;

public class User {
    String name;
    String email;
    
    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
    
    public User(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
