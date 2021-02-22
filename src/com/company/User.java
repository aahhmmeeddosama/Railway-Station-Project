package com.company;

import java.io.Serializable;

public class User implements Serializable {
    private String FirstName;
    private String LastName;
    private String UserName;
    private String Password;
    private String Gender;

    //setter
    public void setFirstName(String firstName) { FirstName = firstName; }
    public void setLastName(String lastName) { LastName = lastName; }
    public void setUserName(String userName) { this.UserName = userName; }
    public void setPassword(String password) { Password = password; }
    //getter
    public String getFirstName() { return FirstName; }
    public String getPassword() { return Password; }
    public String getUserName() { return UserName; }
    public String getLastName() { return LastName; }
}
