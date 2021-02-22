package com.company;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class routes implements Serializable{
    private String tripID;
    private String endPoint;
    private String startPoint;
    private String routeName;
    private String distance;
    public Train t;
    // Times T = new Times();



    public void setTripID(String tripID) {
        this.tripID = tripID;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }





    public String getEndPoint() {
        return endPoint;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getTripID() {
        return tripID;
    }

    public String getDistance() {
        return distance;
    }



    public String getRouteName() {
        routeName=startPoint +" - "+endPoint + "  route";
        return routeName;
    }


    public void Display_Route_Data() {

        System.out.println("Trip Code " + this.getTripID());
        System.out.println(this.getRouteName());
        System.out.println("Train Type is " + this.t.TrainType);


    }












   /* public void Askforinfo_passenger() throws IOException {
        System.out.println("Please enter the nextinformation of thr route");
        System.out.println("name of start point route");
        startPoint=s.nextLine();
        list.add(startPoint);
        System.out.println("name of end point route");
        endPoint=s.nextLine();
        list.add(endPoint);
        list.add(getRouteName());


        try { list = read.readFile("Routes.bin");
        }
        catch (IOException e) {}

        System.out.println(list.toString());


    }*/


}