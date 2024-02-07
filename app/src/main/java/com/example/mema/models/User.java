package com.example.mema.models;

import java.io.Serializable;

public class User implements Serializable {

    private String email,password;
    private double balance;

    public User(String email, String password, double balance){
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean alertBalance(){
        return this.getBalance() < 10;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
