package com.company;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.JobName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public  class TrainsList extends JFrame implements ActionListener {

    ReadFile read = new ReadFile();
    ArrayList<routes> r = new ArrayList<>();
    Image img;
    String s;
    public TrainsList (String u) {
        s = u;
        setSize(1000, 600);
        JButton profile = new JButton("View Profile ");
        JButton signout = new JButton("Sign out");
        profile.setBounds(10,10,160,30);
        signout.setBounds(800,10,160,30);
        this.setTitle("Train Booking ");
        this.getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        this.setBackground(Color.white);
        this.setLayout(null);
        Container c = new Container();
        c.setBackground(Color.white);
        c.add(profile);
        c.add(signout);
        this.setContentPane(c);
        this.setResizable(false);
        try {
            r = read.readFile("Routes.bin");
        } catch (IOException e) {

        }

        int x = 50;
        int y = 50;
        int row = 5;

        for (int i = 0; i < r.size(); i++) {
            JButton temp = new JButton(i+"");
            JLabel templabel = new JLabel(r.get(i).getRouteName());
            temp.setBounds(x,y,130,120);
            templabel.setBounds(x, y+120,150,50);
            try {
                img = ImageIO.read(getClass().getResource("train.png"));
                temp.setIcon((new ImageIcon(img)));
            } catch (Exception ex) {
                System.out.println(ex);
            }

            temp.addActionListener(click);
            c.add(templabel);
            c.add(temp);
            x += 180;
            if(i == row)
            {
                x = 50;
                y += 150;
                row += 6;
            }

        }
        profile.addActionListener(e->{
            try {
                Profile p = new Profile(u);
                p.setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        });
        signout.addActionListener(e -> {
            try {
                Loginpage l = new Loginpage();
                l.setVisible(true);
                this.dispose();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


        });
        this.setVisible(true);
    }
    Action click = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = Integer.parseInt(e.getActionCommand());
            RouteDeatils D = null;
            try {
                D = new RouteDeatils(r.get(index),s);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            D.setVisible(true);


        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
