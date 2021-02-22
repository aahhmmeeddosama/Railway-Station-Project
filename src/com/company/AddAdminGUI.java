package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class AddAdminGUI extends JFrame implements ActionListener {
    private JButton submit;
    private JLabel Name;
    private JLabel password;
    private JLabel confirmPassword;
    private JLabel passwordL;
    private JLabel confirmPasswordL;
    private JLabel username;
    private JTextField NameT;
    private JPasswordField passwordT;
    private JPasswordField confirmPasswordT;
    private JTextField usernameT;
    private JLabel usernameStatus;
    private JLabel passwordStatus;

    SignUp up = new SignUp();
    public AddAdminGUI() {
        this.setSize(500, 500);
        this.setTitle("Create an account !");
        this.getContentPane().setLayout((LayoutManager)null);
        this.setLocationRelativeTo((Component)null);
        this.setBackground(Color.white);
        this.setLayout((LayoutManager)null);
        Container c = new Container();
        c.setBackground(Color.white);
        this.setContentPane(c);
        this.setResizable(false);
        this.Name = new JLabel(" Name : ");
        this.password = new JLabel("Password : ");
        this.confirmPassword = new JLabel("Confirm Password : ");
        this.username = new JLabel("Username : ");
        this.NameT = new JTextField("Enter first name ");
        this.passwordT = new JPasswordField();
        this.confirmPasswordT = new JPasswordField();
        this.passwordL = new JLabel("*Enter password ");
        this.confirmPasswordL = new JLabel("*Confirm your password ");
        this.usernameT = new JTextField("Enter username ");
        this.usernameStatus = new JLabel();
        this.passwordStatus = new JLabel();
        this.submit = new JButton("Submit");
        this.add(this.Name);
        this.add(this.confirmPassword);
        this.add(this.username);
        this.add(this.NameT);
        this.add(this.confirmPasswordT);
        this.add(this.usernameT);
        this.add(this.password);
        this.add(this.passwordT);
        this.add(this.confirmPasswordL);
        this.add(this.submit);
        this.add(this.usernameStatus);
        this.add(this.passwordStatus);
        this.Name.setBounds(20, 10, 73, 20);
        this.password.setBounds(20, 70, 76, 20);
        this.confirmPassword.setBounds(20, 100, 123, 20);
        this.username.setBounds(20, 40, 73, 20);
        this.NameT.setBounds(135, 10, 200, 23);
        this.passwordT.setBounds(135, 70, 200, 23);
        this.confirmPasswordT.setBounds(135, 100, 200, 23);
        this.confirmPasswordL.setBounds(135, 130, 200, 23);
        this.usernameT.setBounds(135, 40, 200, 23);
        submit.setBounds(250,380,100,80);
        this.submit.addActionListener((e) ->
        {
            try {
                up.save_Admin(NameT.getText(),usernameT.getText(),passwordT.getText());
                JOptionPane.showMessageDialog(null,"Admin Added sucessfully,Done,2");
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
