package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class newroute extends JFrame {
    private JButton submit;
    private JLabel sp;
    private JLabel EP;
    private JLabel type;
    private JLabel trip_ID;
    private JTextField spt;
    private JTextField tripIDt;
    private JTextField EPT;
    private JTextField typeT;

Adminn a= new Adminn();
    SignUp up = new SignUp();
    public newroute() {

        routes r = new routes();
        this.setSize(500, 500);
        this.setTitle("ADD ROUTE");
        this.getContentPane().setLayout((LayoutManager) null);
        this.setLocationRelativeTo((Component) null);
        this.setBackground(Color.white);
        this.setLayout((LayoutManager) null);
        Container c = new Container();
        c.setBackground(Color.white);
        this.setContentPane(c);
        this.setResizable(false);
        this.sp = new JLabel(" start point : ");
        this.EP = new JLabel("End Point : ");
        typeT = new JTextField("Train Type");
        this.type = new JLabel("enter V for VIP or F for FirstClass or P for Basic  : ");
        this.spt = new JTextField("start point ");
        EPT = new JTextField("Endpoint");
        tripIDt = new JTextField("tripID");
        trip_ID = new JLabel("TripID");
        this.submit = new JButton("Submit");
        c.add(sp);
        c.add(spt);
        c.add(EP);
        c.add(EPT);
        c.add(tripIDt);
        c.add(submit);
        c.add(trip_ID);
        c.add(type);
        c.add(typeT);
        this.sp.setBounds(20, 10, 73, 20);
        this.trip_ID.setBounds(20,100,123,20);
        this.tripIDt.setBounds(135, 100, 123, 20);
        this.type.setBounds(10, 150, 350, 20);
        this.spt.setBounds(135, 10, 200, 23);

        EP.setBounds(20,60,123,20);
        EPT.setBounds(135,60,123,20);
        submit.setBounds(250, 300, 100, 40);
        typeT.setBounds(10,200,100,20);

        this.submit.addActionListener((e) ->
                {
                        r.setStartPoint(spt.getText());
                        r.setEndPoint(EPT.getText());
                        r.setTripID(tripIDt.getText());
                        char b = typeT.getText().charAt(0);
                        r.t = new Train(b);
                        a.savetrip(r);
                        JOptionPane.showMessageDialog(null,"Trip Added sucessfully");

                }
        );
        this.setVisible(true);
    }
}
