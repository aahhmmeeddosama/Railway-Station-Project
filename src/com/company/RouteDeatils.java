package com.company;

import com.itextpdf.text.BadElementException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class RouteDeatils extends JFrame {
    Ticket t;

    public RouteDeatils(routes r, String u) throws IOException {


        setSize(600, 600);
        JButton BOOK = new JButton("Click to book the trip ");
        BOOK.setBounds(400, 500, 160, 30);
        this.setTitle("Details");
        this.getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        this.setBackground(Color.white);
        this.setLayout(null);
        Container c = new Container();
        c.setBackground(Color.white);
        this.setContentPane(c);
        this.setResizable(false);

        JLabel routeName = new JLabel("RouteName ");
        JLabel routestart = new JLabel("StartPoint ");
        JLabel routeEnd = new JLabel("EndPoint ");
        JLabel routeID = new JLabel("Code ");
        JLabel routeTrain = new JLabel("Train Type ");
        JLabel setticket = new JLabel("Choose ticket Type ");


        JLabel routeName1 = new JLabel(r.getRouteName());
        JLabel routestart1 = new JLabel(r.getStartPoint());
        JLabel routeEnd1 = new JLabel(r.getEndPoint());
        JLabel routeID1 = new JLabel(r.getTripID());
        JLabel routeTrain1 = new JLabel(r.t.TrainType);

        routeName.setBounds(50, 50, 100, 50);
        routeName1.setBounds(150, 50, 200, 50);
        routestart.setBounds(50, 100, 100, 50);
        routestart1.setBounds(150, 100, 100, 50);
        routeEnd.setBounds(50, 150, 100, 50);
        routeEnd1.setBounds(150, 150, 100, 50);
        routeID.setBounds(50, 200, 100, 50);
        routeID1.setBounds(150, 200, 100, 50);
        routeTrain.setBounds(50, 250, 100, 50);
        routeTrain1.setBounds(150, 250, 100, 50);


        c.add(routeName);
        c.add(routeName1);
        c.add(routestart);
        c.add(routestart1);
        c.add(routeEnd);
        c.add(routeEnd1);
        c.add(routeID);
        c.add(routeID1);
        c.add(routeTrain);
        c.add(routeTrain1);
        c.add(BOOK);

        ReadFile read = new ReadFile();
        Passenger O = new Passenger();
        ArrayList<Passenger> AccountsP;
        AccountsP = read.readFile("Accounts.bin");
        for (Passenger account : AccountsP) {
            if (account.getUserName().equals(u)) {
                O = account;
            }
            Passenger finalO = O;
            BOOK.addActionListener(e ->
            {
                String s = JOptionPane.showInputDialog("Press P for plat ticket , G for Gold ticket and S for silver ticket");
                if (s.equals("P")) {
                    t = new Ticket('P');
                } else if (s.equals("G")){
                    t = new Ticket('G');
                } else if (s.equals("S")) {
                    t = new Ticket('S');
                }
                String m = JOptionPane.showInputDialog("How Many Tickets do you need");
                int x = Integer.parseInt(m);
                int a = JOptionPane.showConfirmDialog(this, "you booked " + x + " seats" +
                        "At Route :" + r.getRouteName());
                if (a == JOptionPane.YES_OPTION) {
                    try {
                        t.printTicket(x, r, finalO);
                        JOptionPane.showMessageDialog(null,"Your tickets Are ready to be printed !!");
                        return;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (BadElementException badElementException) {
                        badElementException.printStackTrace();
                    }
                }

            });


        }


    }
}
