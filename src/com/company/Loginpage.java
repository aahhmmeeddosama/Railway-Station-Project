package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Loginpage extends JFrame {
    JLabel hyperLink = new JLabel("Dont have an account? SignUp");
    JLabel signinU = new JLabel("Username");
    JLabel signinP = new JLabel("password");
    JButton BSignIn = new JButton("Sign In");
    SignIn in = new SignIn();
    JTextField logInUName = new RoundJTextField(20);
    JPasswordField LogInPassword = new RoundJPasswordField(20);
    JFrame frame = this;
    public Loginpage()throws IOException
    {

        this.setSize(500,500);
        this.setResizable(false);
        setTitle("Railway Booking System");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel signinPanel = new JPanel(new FlowLayout());
        JPanel LogoPanel = new JPanel();

        LogoPanel.setBackground(Color.white);
        signinPanel.setBackground(Color.white);


        JPanel twoPanelContainer;
        twoPanelContainer = new JPanel(new GridLayout(2,1));
        twoPanelContainer.add(LogoPanel);
        twoPanelContainer.add(signinPanel);



        JPanel allThree = new JPanel(new GridLayout(1,2));
        allThree.add(twoPanelContainer);
        allThree.add(new imagePanel());


        BufferedImage img = ImageIO.read(new File("train.png"));
        Image newImage = img.getScaledInstance(200, 150, Image.SCALE_DEFAULT);
        JLabel picLabel = new JLabel(new ImageIcon(newImage));
        LogoPanel.setLayout(new BorderLayout());
        LogoPanel.add(picLabel,BorderLayout.CENTER);




        signinPanel.add(signinU);
        signinPanel.add(logInUName);
        signinPanel.add(signinP);
        signinPanel.add(LogInPassword);
        signinPanel.add(BSignIn);
        BSignIn.addActionListener((ActionListener) new actions());

        signinPanel.add(hyperLink);
        hyperLink.setForeground(Color.RED.darker());

        hyperLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        hyperLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                signupgui s = new signupgui();
                frame.dispose();

            }
        });


        getContentPane().add(allThree);

    }


    public class imagePanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            this.setBackground(Color.gray);
            BufferedImage img = null;
            try{
                img = ImageIO.read(new File("steel.png"));}
            catch(IOException e){System.out.println("error");}


            g.drawImage(img, 0, 0, null);


        }


    }


    public class actions extends Component implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            TrainsList T;
            String u , p;
            u = logInUName.getText();
            p = LogInPassword.getText();
            int flag;
            try {
                flag = in.signin(u,p);
                if(flag == 2)
                {
                    T = new TrainsList(u);
                    frame.dispose();
                }
                else if (flag == 1)
                {
                   AdminPanel a = new AdminPanel();
                   a.setVisible(true);
                   frame.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong username or Password");

                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }



        }

    }


    public class CustomBorder extends AbstractBorder
    {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y,
                                int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D)g;
            Paint COLOR_BORDE_SIMPLE = null;
            g2d.setPaint(COLOR_BORDE_SIMPLE);
            Shape shape = new RoundRectangle2D.Float(0, 0, c.getWidth()-1,
                    c.getHeight()-1,20, 20);
            g2d.draw(shape);
        }
    }


    public class RoundJTextField extends JTextField
    {
        private Shape shape;
        public RoundJTextField(String text,int size) {
            super(text,size);
            setOpaque(false);
        }
        public RoundJTextField(int size) {
            super(size);
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }
    public class RoundJPasswordField extends JPasswordField
    {
        private Shape shape;
        public RoundJPasswordField(String text,int size) {
            super(text,size);
            setOpaque(false);
        }
        public RoundJPasswordField(int size) {
            super(size);
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }
    public class roundJButton extends JButton
    {
        private Shape shape;
        public roundJButton()
        {
            super();
        }
        public roundJButton(String text)
        {
            super(text);
        }
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            super.paintComponent(g);
        }
        @Override
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(5, 5, getWidth()-5, getHeight()-5, 20, 20);
        }
        @Override
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }
    private void exit(){
        this.dispose();
    }
}
