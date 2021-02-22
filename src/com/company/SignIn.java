package com.company;

import com.itextpdf.text.BadElementException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SignIn extends User{


    boolean b = false;
    Scanner s = new Scanner(System.in);
    Scanner u = new Scanner(System.in);
    ReadFile read = new ReadFile();
    public Passenger p = new Passenger();
    public Adminn A = new Adminn();
    Home H = new Home();
    int r  = 0 ;
    Ticket t = new Ticket();
    char tic;
    int numofseats;
    SignUp signUp=new SignUp();




    public int signin(String username , String password) throws IOException {
        do {
            if (username.contains("@")) {
                ArrayList<Adminn> AccountsA;
                AccountsA = read.readFile("Admin.bin");
                for (Adminn admin : AccountsA) {
                    if (admin.getUserName().equals(username) && admin.getPassword().equals(password)){
                        b = true;
                        break;
                    } else {
                        b = false;
                    }
                }

                if (b) {
                   return 1;
                } else {
                    return 0;
                }

            }

            else {
                ArrayList<Passenger> AccountsP;
                AccountsP = read.readFile("Accounts.bin");
                for (Passenger account : AccountsP) {
                    if (account.getUserName().equals(username) && account.getPassword().equals(password)) {
                        p = account;
                        b = true;
                        break;
                    } else {
                        b = false;
                    }
                }

                if (b) {
                    return 2;
                } else {
                    return 0;
                }

            }
        } while (!b);
    }

    public void ASI() throws IOException{
        if (getUserName().contains("@")){
            int a;
            H.AdminsWelcomeDisplay();
            a=Integer.parseInt(s.nextLine());
            switch(a){
                case 1 -> A.Askforinfo_Admin();
                case 2 -> {
                    H.Displayroutes();
                    String id;
                    System.out.println("enter trip ID you want to remove");
                    id=u.nextLine();
                    A.Removetrip(id);
                }
                case 3 -> A.ADDADMIN();
                case 4 -> {
                    String user;
                    System.out.println("Enter the username you want to delete");
                    user = u.nextLine();
                    A.Remove_User(user);
                }
                case 5 -> {
                    ASI();
                }
                default -> {
                    System.out.println("please enter the right number of you your choice");
                    ASI();
                }
            }
            System.out.println("if you \n want to do anything else 'press 1' \n  want logout 'press 2' \n  want to exit 'press 3'");
            a=Integer.parseInt(s.nextLine());
            switch (a){
                case 1 -> {
                    H.AdminsWelcomeDisplay();
                    ASI();
                }
                case 2 ->{
                    H.WelcomeDisplay();
                    a=Integer.parseInt(s.nextLine());
                    switch (a) {
                        case 1 -> {

                            ASI();
                        }

                        case 2 -> {
                            signUp.Askforinfo();
                            ASI();
                        }
                    }
                }
                case 3 -> System.exit(1);
            }
        }

        else{
            System.out.println("This is our available Routes for Today ");
            H.Displayroutes();
            System.out.println("Choose one of them to start booking ");
            r = Integer.parseInt(s.nextLine());
            t.Display_ticket_pricing();
            tic = s.next().charAt(0);
            t = new Ticket(tic);
            System.out.println("How many tickets do you need to book");
            numofseats = s.nextInt();
            System.out.println("you booked " + numofseats + " seats");
            H.getRoute(r).Display_Route_Data();
            System.out.println("With  "+ t.calculatetotalticketprice(numofseats) + " EGP");
          /*  try {
                //t.printTicket(numofseats , H.getRoute(r) , this);
            } catch (BadElementException e) {
                e.printStackTrace();
            }*/

        }

    }
}
