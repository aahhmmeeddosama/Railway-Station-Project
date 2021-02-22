package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SignUp implements Serializable{
    Passenger p = new Passenger();
    Adminn A = new Adminn();
    private  Scanner s = new Scanner(System.in);
    WriteFile write=new WriteFile();
    ReadFile read =new ReadFile();
    String file = "Accounts.bin";
    public void Askforinfo() throws IOException {

        String temp, passc;
        System.out.println("Now please fill your data");
        System.out.println("Enter your Firstname");
        temp = s.nextLine();
        p.setFirstName(temp);
        System.out.println("Enter your LastName");
        temp = s.nextLine();
        p.setLastName(temp);
        System.out.println("Enter your Address");
        temp = s.nextLine();
        p.Address = temp;
        System.out.println("Enter your Mobile Number");
        temp = s.nextLine();
        p.Mobile_Number = temp;
        do{System.out.println("Enter your UserName");
        temp = s.nextLine();
        if(temp.contains("@admin"))
            System.out.println("user mustn't contain '@admin'");
        }while(temp.contains("@admin"));
        p.setUserName(temp);
        while (true)
        {
            System.out.println("Enter your Password");
        temp = s.nextLine();
        System.out.println("Confirm your Password");
        passc = s.nextLine();
        if (temp.equals(passc)) {
            p.setPassword(temp);
            break;
        }
            System.out.println("Your password doesn't match");
       }

        Saveinfo(p,file);
        System.out.println("CONGRATS YOUR ACCOUNT WAS CREATED \n-----------------------------------------\n Now please signin ");
    }

    public void save_passenger (String first , String last , String Address , String Mobile_Number ,
                                String Username , String Pass) throws FileNotFoundException {
        p.setFirstName(first);
        p.setLastName(last);
        p.Mobile_Number = Mobile_Number;
        p.Address = Address;
        p.setUserName(Username);
        p.setPassword(Pass);
        p.Display_Passenger_Data();
        Saveinfo(p,file);
    }
    public void save_Admin (String first , String Username , String Pass) throws FileNotFoundException {
        A.setFirstName(first);
        A.setUserName(Username);
        A.setPassword(Pass);
        Saveinfo(A,"Admin.bin");
    }

public void ADD_ADMIN() throws IOException {
    String temp;
    String file = "Admin.bin";
    System.out.println("Now please fill your data");
    System.out.println("Enter the Admin name");
    temp = s.nextLine();
    A.setFirstName(temp);
    do{System.out.println("Enter your Username");
    temp = s.nextLine();
    if(!temp.contains("@admin"))
        System.out.println("username must contain '@admin'");
    }while(!temp.contains("@admin"));
    A.setUserName(temp);
    System.out.println("Enter Password");
    temp = s.nextLine();
    A.setPassword(temp);
    Saveinfo(A,file);

}
    public <T> void Saveinfo( T p , String filename ) throws FileNotFoundException {

        ArrayList<T> list = new ArrayList<>();
        try { list = read.readFile(filename); }
        catch (IOException e) { e.printStackTrace(); }
         list.add(p);
        try {
            write.writeFile(filename,list); }
        catch (IOException e) { System.out.println(e); }

    }
}



