package com.company;



import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       /* Home H = new Home();
        SignUp signup = new SignUp();
        SignIn signin = new SignIn();
        Scanner s = new Scanner(System.in);
        int Choice;
        H.WelcomeDisplay();
       Choice = Integer.parseInt(s.nextLine());
        switch (Choice) {
            case 1 -> {
                signin.signin();
                signin.ASI();
            }

            case 2 -> {
                  signup.Askforinfo();
                  signin.signin();
                  signin.ASI();
            }
        }
*/
        Loginpage l = new Loginpage();
        l.setVisible(true);
    }

}
