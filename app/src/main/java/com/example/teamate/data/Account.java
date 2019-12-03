package com.example.teamate.data;

public class Account {
    // Fields
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private int companyID;
    private char[] password;

    // Constructors
    public Account() {}
    public Account(String inFirst, String inLast, String inEmail, String inUser, int inID, char[] inPassword) {
        this.firstName = inFirst;
        this.lastName = inLast;
        this.email = inEmail;
        this.username = inUser;
        this.companyID = inID;
        this.password = inPassword;
    }
    // Getters and Setters
    // First Name
    public void setFirstName(String inFirst) {
        this.firstName = inFirst;
    }
    public String getFirstName() {
        return this.firstName;
    }
    // Last Name
    public void setLastName(String inLast) {
        this.lastName = inLast;
    }
    public String getLastName() {
        return this.lastName;
    }
    // Email
    public void setEmail(String inEmail) {
        this.email = inEmail;
    }
    public String getEmail() {
        return this.email;
    }
    // Username
    public void setUsername(String inUser) {
        this.username = inUser;
    }
    public String getUsername() {
        return this.username;
    }
    // CompanyID
    public void setID(int inID) {
        this.companyID = inID;
    }
    public int getID() {
        return this.companyID;
    }
    // Password
    public void setPassword(char[] inPassword) {
        this.password = inPassword;
    }
    public char[] getPassword() {
        return this.password;
    }
}
