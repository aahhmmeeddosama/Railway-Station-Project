package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Home {


    ReadFile read = new ReadFile();
    ArrayList<routes> r = new ArrayList<>();
    routes route = new routes();
    public void WelcomeDisplay()
    {
        System.out.println("Welcome to our online booking reservation System ");
        System.out.println("Press 1 to sign in");
        System.out.println("Press 2 for creating a new account");
    }

    public void Displayroutes()
    {

        try {
            r = read.readFile("Routes.bin");
        } catch (IOException e) {

        }


        for (int i = 0; i < r.size(); i++) {

            System.out.println("Press " + (i+1) + " ");r.get(i).Display_Route_Data();

        }
    }

    public routes getRoute(int x)
    {
        try {
            r = read.readFile("Routes.bin");
        } catch (IOException e) {

        }
        x-= 1;
        do {

            for (int i = 0; i < r.size(); i++) {
                if (i == x) {
                    route = r.get(i);
                    return route;
                }


            }
        }while (x > (r.size()-1));
        return route;
    }

    public void AdminsWelcomeDisplay(){
        System.out.println("Welcome Admin \n press 1 to add trip \n press 2 to remove trip \n press 3 to add new admin\n press 4 to remove admin\n press 5 to logout");

    }

}
