package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AdminPanel extends JFrame  {
    public AdminPanel() {
        this.setSize(850, 300);
        JButton signout = new JButton("Sign out");
        signout.setBounds(335, 200, 160, 30);
        this.setTitle("Admin panel");
        this.getContentPane().setLayout((LayoutManager)null);
        this.setLocationRelativeTo((Component)null);
        this.setBackground(Color.white);
        this.setLayout((LayoutManager)null);
        Container c = new Container();
        c.setBackground(Color.white);
        c.add(signout);
        this.setContentPane(c);
        this.setResizable(false);
        Adminn a=new Adminn();
        JButton removeUser = new JButton("Remove Admin");
        removeUser.setBounds(50, 50, 130, 100);
        c.add(removeUser);

        JButton addUser = new JButton("Add User");
        addUser.setBounds(200, 50, 130, 100);
        c.add(addUser);

        JButton addTrip = new JButton("Add Trip");
        addTrip.setBounds(350, 50, 130, 100);
        c.add(addTrip);

        JButton addAdmin = new JButton("Add Admin");
        addAdmin.setBounds(650, 50, 130, 100);
        c.add(addAdmin);

        JButton removeTrip = new JButton("Remove Trip");
        removeTrip.setBounds(500, 50, 130, 100);
        c.add(removeTrip);


        addUser.addActionListener(e -> {signupgui newUser=new signupgui();});
        signout.addActionListener(e -> {
            try {
                Loginpage l = new Loginpage();
                l.setVisible(true);
                this.dispose();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        });
        removeUser.addActionListener(e -> {
            String username=JOptionPane.showInputDialog("Enter Name");
            a.Remove_User(username);
        });
        removeTrip.addActionListener(e -> {
            String tripId=JOptionPane.showInputDialog("Enter tripId");
            try {
                a.Removetrip(tripId);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        addAdmin.addActionListener(e -> {AddAdminGUI newAdmin=new AddAdminGUI();});
        addTrip.addActionListener(e-> {
            newroute r = new newroute();
            r.setVisible(true);
        });


        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
