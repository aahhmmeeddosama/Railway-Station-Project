package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Adminn extends User implements Serializable {



    static routes route = new routes();
    transient private Scanner s = new Scanner(System.in);
    private static ArrayList<routes> list = new ArrayList<>();
    transient ReadFile read = new ReadFile();
    transient WriteFile write = new WriteFile();
    private static ArrayList<routes> element = new ArrayList<>( );
    private ArrayList<Adminn> plist = new ArrayList<>( );
    private int var;
    private char c;

    public void Askforinfo_Admin() throws IOException {
        System.out.println("Please enter the nextinformation of thr route");
        System.out.println("Enter the trip ID");
        route.setTripID(s.nextLine());
        System.out.println("name of start point route");
        route.setStartPoint(s.nextLine());
        System.out.println("name of end point route");
        route.setEndPoint(s.nextLine());
        System.out.println("Enter the train Type");
        c = s.next().charAt(0);
        route.t = new Train(c);
     /*     System.out.println("what's the time of the Trip");
      System.out.print("enter the hour of trip:  ");
        var=s.nextInt();
      //  route.T.setStartHour(var);
        System.out.print("enter the minutes of trip:  ");
        var=s.nextInt();
      //  route.T.setStartMinute(var);
        System.out.println("How long the time will the trip take");
        System.out.print("enter the duration hours:  ");
        var=s.nextInt();
     //   route.T.setHduration(var);
        System.out.print("enter the duration minutes"  );
        var=s.nextInt();
      //  route.T.setMduration(var);*/
        route.getRouteName();

        savetrip(route);
        char x;
        System.out.println("want to add another route Y for yes N for no");
        x = s.next().charAt(0);
        if(x == 'Y')
        {
            Askforinfo_Admin();
        }
    }
    public void Removetrip (String ID) throws IOException {

        element = read.readFile("Routes.bin");

        for (int i=0;i<element.size();i++)
        {
            if (element.get(i).getTripID().equals(ID))
            {
                var = i;
                break;
            }

        }
        element.remove(var);
        write.writeFile("Routes.bin",element);

    }
    public void Add_User() throws FileNotFoundException {
        SignUp up = new SignUp();
        try {
            up.Askforinfo();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void ADDADMIN ()
    {
        SignUp up = new SignUp();
        try {
            up.ADD_ADMIN();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void Remove_User(String Username)
    {
        try { plist = read.readFile("Admin.bin"); }
        catch (IOException e) {}
        for (int i=0;i<plist.size();i++)
        {
            if (plist.get(i).getUserName().equals(Username))
            {
                var = i;
                break;
            }

        }
        try {

            plist.remove(var);

        }
        catch (Exception e)
        {
            System.out.println("Admin not found");
        }
        try {write.writeFile("Admin.bin",plist);}
        catch (IOException e) { System.out.println(e);
        }

    }


    public void savetrip(routes p) {

        try {
            list = read.readFile("Routes.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.add(p);
        try {
            write.writeFile("Routes.bin",list); }
        catch (IOException e) { System.out.println(e); }

    }


}