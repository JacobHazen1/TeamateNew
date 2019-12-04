package com.example.teamate.data;

public class Account {
    // Fields
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private int companyID;
    private int accountID;
    private String password;

    // Constructors
    public Account() {}

    public Account(String inFirst, String inLast, String inEmail, String inPassword) {
        this.firstName = inFirst;
        this.lastName = inLast;
        this.email = inEmail;
        this.username = null;
        this.companyID = 0;
        this.accountID = 0;
        this.password = inPassword;
    }

    public Account(String inFirst, String inLast, String inEmail, String inUser, int inCID, int inAID, String inPassword) {
        this.firstName = inFirst;
        this.lastName = inLast;
        this.email = inEmail;
        this.username = inUser;
        this.companyID = inCID;
        this.accountID = inAID;
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
    public void setCompanyID(int inID) {
        this.companyID = inID;
    }
    public int getCompanyID() {
        return this.companyID;
    }
    // AccountID
    public void setAccountID(int inID) {
        this.accountID = inID;
    }
    public int getAccountID() {
        return this.accountID;
    }
    // Password
    public void setPassword(String inPassword) {
        this.password = inPassword;
    }
    public String getPassword() {
        return this.password;
    }
}
