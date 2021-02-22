package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class signupgui extends JFrame implements ActionListener{

    private JButton submit;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel email;
    private JLabel password;
    private JLabel confirmPassword;
    private JLabel passwordL;
    private JLabel confirmPasswordL;
    private JLabel username;
    private JLabel gender;
    private JLabel phonenumber;
    private JTextField firstnameT;
    private JTextField lastnameT;
    private JTextField emailT;
    private JPasswordField passwordT;
    private JPasswordField confirmPasswordT;
    private JTextField phonenumberT;
    private JTextField usernameT;
    private JLabel usernameStatus;
    private JLabel emailStatus;
    private JLabel passwordStatus;
    private JRadioButton male;
    private JRadioButton female;
    SignUp up = new SignUp();
    JFrame f = this;
    public signupgui(){
        setSize(500,600);
        this.setTitle("Create an account !");
        this.getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        this.setBackground(Color.white);
        this.setLayout(null);
        Container c = new Container();
        c.setBackground(Color.white);
        this.setContentPane(c);

        this.setResizable(false);
        firstName=new JLabel("First Name : ");
        lastName=new JLabel("Last Name : ");
        email=new JLabel("E-mail : ");
        password=new JLabel("Password : ");
        confirmPassword=new JLabel("Confirm Password : ");
        username= new JLabel("Username : ");
        gender=new JLabel("Gender : ");
        phonenumber=new JLabel("Phonenumber : ");
        firstnameT= new JTextField("Enter first name ");
        lastnameT= new JTextField("Enter last name ");
        emailT= new JTextField("Enter email ");
        passwordT= new JPasswordField();
        confirmPasswordT= new JPasswordField();
        passwordL=new JLabel("*Enter password ");
        confirmPasswordL=new JLabel("*Confirm your password ");
        usernameT= new JTextField("Enter username ");
        phonenumberT= new JTextField("Enter phonenumber ");
        usernameStatus=new JLabel();
        emailStatus=new JLabel();
        passwordStatus=new JLabel();
        male=new JRadioButton("Male",false);
        female=new JRadioButton("Female",false);
        submit=new JButton("Submit");
        this.add(firstName);
        this.add(lastName);
        this.add(email);
        this.add(confirmPassword);
        this.add(username);
        this.add(gender);
        this.add(phonenumber);
        this.add(firstnameT);
        this.add(lastnameT);
        this.add(emailT);
        this.add(confirmPasswordT);
        this.add(usernameT);
        this.add(phonenumberT);
        this.add(password);
        this.add(passwordT);
        this.add(confirmPasswordL);
        this.add(male);
        this.add(female);
        this.add(submit);
        this.add(usernameStatus);
        this.add(passwordStatus);
        this.add(emailStatus);
        firstName.setBounds(20, 10, 73, 20);
        lastName.setBounds(20, 50, 76, 20);
        email.setBounds(20, 90, 48, 20);
        password.setBounds(20,130,76,20);
        confirmPassword.setBounds(20, 170, 123, 20);
        username.setBounds(20, 210, 73, 20);
        gender.setBounds(20, 250, 55, 20);
        phonenumber.setBounds(20, 290, 103, 20);
        //-----------------------------------------------
        firstnameT.setBounds(135, 10, 200, 23);
        lastnameT.setBounds(135, 50, 200, 23);
        emailT.setBounds(135, 90, 200, 23);
        passwordT.setBounds(135,130,200,23);
        confirmPasswordT.setBounds(135, 170, 200, 23);
        confirmPasswordL.setBounds(135, 190, 200, 23);
        usernameT.setBounds(135,210,200,23);
        phonenumberT.setBounds(135, 290, 200, 23);
        submit.addActionListener(e -> {

            System.out.println("clicked");
            try {
                savedata();
                JOptionPane.showMessageDialog(null,"data saved","Done",2);
                Loginpage l = new Loginpage();
                l.setVisible(true);
                f.dispose();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        usernameT.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if("Enter username ".equals(usernameT.getText())){
                    usernameT.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent fe) {
               /* HomePage.LoggedIn.loadhash();
                if (Guest.UserManager.containsKey(usernameT.getText())){
                    usernameStatus.setText("Username already exisit!!");
                    usernameStatus.setForeground(Color.RED);
                    usernameStatus.setVisible(true);
                }else{
                    usernameStatus.setText("Username Accepted");
                    usernameStatus.setForeground(Color.GREEN);
                    usernameStatus.setVisible(true);
                }*/
            }
        });
        firstnameT.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if("Enter first name ".equals(firstnameT.getText()))
                    firstnameT.setText(" ");
            }
            @Override
            public void focusLost(FocusEvent fe) {
            }
        });
        lastnameT.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if("Enter last name ".equals(lastnameT.getText()))
                    lastnameT.setText(" ");
            }
            @Override
            public void focusLost(FocusEvent fe) {
            }
        });
        emailT.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if("Enter email ".equals(emailT.getText()))
                    emailT.setText(" ");
            }
            @Override
            public void focusLost(FocusEvent fe) {
                if (emailT.getText().contains("@")&&emailT.getText().contains(".")){
                    emailStatus.setText("E-mail Accepted");
                    emailStatus.setForeground(Color.GREEN);
                    emailStatus.setVisible(true);
                }else{
                    emailStatus.setText("Incorrect E-mail");
                    emailStatus.setForeground(Color.RED);
                    emailStatus.setVisible(true);
                }
            }
        });
        passwordT.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if("*Enter password ".equals(passwordL.getText()));
                passwordL.setVisible(false);
            }
            @Override
            public void focusLost(FocusEvent fe) {
            }
        });
        confirmPasswordT.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if("*Confirm your password ".equals(confirmPasswordL.getText()))
                    confirmPasswordL.setVisible(false);
            }
            @Override
            public void focusLost(FocusEvent fe) {
                System.out.println(confirmPasswordT.getPassword());
                System.out.println(passwordT.getPassword());
                if(Arrays.equals(passwordT.getPassword(),confirmPasswordT.getPassword())){
                    passwordStatus.setText("Password matched");
                    passwordStatus.setForeground(Color.GREEN);
                    passwordStatus.setVisible(true);
                }else{
                    passwordStatus.setText("Password doesn't match");
                    passwordStatus.setForeground(Color.RED);
                    passwordStatus.setVisible(true);
                }
            }
        });
        phonenumberT.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                if("Enter phonenumber ".equals(phonenumberT.getText()))
                    phonenumberT.setText(" ");
            }
            @Override
            public void focusLost(FocusEvent fe) {
            }
        });

        //-------------------------------------------------------
        usernameStatus.setBounds(350,210 ,180 ,20 );
        passwordStatus.setBounds(340, 170, 200, 20);
        emailStatus.setBounds(350, 90, 180, 20);
        //-------------------------------------------------------
        male.setBounds(135, 250, 52, 20);
        female.setBounds(200, 250, 66, 20);

        submit.setBounds(180, 450, 130, 25);
        setVisible(true);

    }
        public void savedata() throws FileNotFoundException {
               if (firstnameT.getText().isBlank() || lastnameT.getText().isBlank() || emailT.getText().isBlank())
               {
                   JOptionPane.showMessageDialog(null,"Error" , "mesage", 2);
               }
               up.save_passenger(firstnameT.getText(),lastnameT.getText(),emailT.getText(),phonenumberT.getText(),usernameT.getText(),passwordT.getText());
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            savedata();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        System.out.println("clicked");

    }
}

