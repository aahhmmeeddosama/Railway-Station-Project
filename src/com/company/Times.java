package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;

public class Times  implements Serializable{

    private int startHour;
    private int startMinute;
    private int hduration;
    private int mduration;
     private Calendar startTime=new GregorianCalendar(2013,10,28);
     private Calendar duration=new GregorianCalendar(2013,10,28);
     private Calendar arrivalTime=new GregorianCalendar(2013,10,28);
     private Scanner s = new Scanner(System.in);
     private TimeZone tz = TimeZone.getTimeZone("GMT+2");
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
    public void setStartHour(int startHour) { this.startHour = startHour; }
    public void setStartMinute(int startMinute) { this.startMinute = startMinute; }
    public void setHduration(int hduration) { this.hduration = hduration; }
    public void setMduration(int mduration) { this.mduration = mduration; }
    public void setStartTime() {
        startTime.setTimeZone(tz);
        startTime.set(Calendar.YEAR,startTime.getTime().getYear());
        startTime.set(Calendar.MONTH,startTime.getTime().getMonth());
        startTime.set(Calendar.DAY_OF_WEEK,startTime.getTime().getDay());
        startTime.set(Calendar.HOUR,getStartHour());
        startTime.set(Calendar.MINUTE,getStartMinute());
    }
    public void setDuration() {
        duration.setTimeZone(tz);
        duration.set(Calendar.HOUR,getHduration());
        duration.set(Calendar.MINUTE,getMduration());
    }
    public int getStartHour() { return startHour; }
    public int getStartMinute() { return startMinute; }
    public int getHduration() { return hduration; }
    public int getMduration() { return mduration; }
    public Calendar getStartTime() { return startTime; }
     public Calendar getDuration() { return duration; }
    public String getArrivalTime() { return CalculateArrivalTime(); }
       public String CalculateArrivalTime(){
        arrivalTime=startTime;
        arrivalTime.add(Calendar.HOUR,duration.getTime().getHours());
        arrivalTime.add(Calendar.MINUTE,duration.getTime().getMinutes());
        return sdf.format(arrivalTime.getTime());
    }

}
