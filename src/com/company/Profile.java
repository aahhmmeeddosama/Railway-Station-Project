package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Profile extends JFrame {

    public Profile(String u) throws IOException {
        ReadFile read = new ReadFile();
        Passenger p = new Passenger();
        ArrayList<Passenger> AccountsP;
        AccountsP = read.readFile("Accounts.bin");
        for (Passenger account : AccountsP) {
            if (account.getUserName().equals(u)) {
                p = account;
            }
            setSize(600, 400);
            this.setTitle("Profile");
            this.getContentPane().setLayout(null);
            setLocationRelativeTo(null);
            this.setBackground(Color.white);
            this.setLayout(null);
            Container c = new Container();
            c.setBackground(Color.white);
            this.setContentPane(c);
            this.setResizable(false);

            JLabel first = new JLabel("First  :" + p.getFirstName());
            JLabel last = new JLabel("last  :" + p.getLastName());
            JLabel username = new JLabel("Username  :" + p.getUserName());
            JLabel pass = new JLabel("Password  :" + p.getPassword());
            JLabel email = new JLabel("Email  :" + p.Address);
            JLabel mobile_Number = new JLabel("Mobile Number  :" + p.Mobile_Number);
            first.setBounds(50, 50, 200, 50);
            last.setBounds(50, 100, 200, 50);
            username.setBounds(50, 150, 200, 50);
            pass.setBounds(50, 200, 200, 50);
            email.setBounds(50, 250, 200, 50);
            mobile_Number.setBounds(50, 300, 200, 50);

            c.add(first);
            c.add(last);
            c.add(pass);
            c.add(email);
            c.add(mobile_Number);
            c.add(username);

        }


    }
}
