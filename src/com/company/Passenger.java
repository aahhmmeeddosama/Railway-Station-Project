package com.company;

import java.io.*;

public class Passenger extends User implements Serializable {


    public String Address;
    public String Mobile_Number;

    public String getfullName(){ return getFirstName() + " " + getLastName();}


    public void Display_Passenger_Data() {

        System.out.println(this.getFirstName());
        System.out.println(this.getLastName());
        System.out.println(this.Address);
        System.out.println(this.Mobile_Number);
        System.out.println(this.getUserName());
        System.out.println(this.getPassword());
    }
}
