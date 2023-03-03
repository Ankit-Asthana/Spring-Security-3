package com.exam.model;
//this class is being used for accepting the username and password from the user
public class JwtRequest {
    //here we get the username and password
    String username;
    String password;

    public JwtRequest(String username,String password) {
        this.username=username;
        this.password=password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username=username;
    }
    public void setPassword(String password) {
        this.password=password;
    }
}
