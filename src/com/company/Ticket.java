package com.company;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ticket {

    String type;
    int Price;
    int num;
    Ticket()
    {

    }
   Ticket(char T)
   {

      switch (T)
      {
          case 'P'->
                  {
                      Price = 150;
                      type = "Platinum";
                  }
          case 'G'->
                  {
                      Price = 100;
                      type = "Gold";
                  }
          case 'S'->
                  {
                      Price = 50;
                      type = "Silver";
                  }
      }

   }

   public void Display_ticket_pricing()
    {
        System.out.println("Type \n P for platinum Ticket with 150 EGP \n G for Gold Ticket with 100 EGP \n S for Sliver ticket with 50 EGP");
    }
   public int calculatetotalticketprice(int x)
   {
       int total;
       total = Price *x;
       return total;
   }

   public void printTicket(int numofseats , routes r , Passenger s) throws IOException, BadElementException {
    String imgSrc = "Images\\LOGO.jpg";
     int serial = (int)((Math.random() * (500000 - 99999))+ 99999) + 1000000;




       Document doc = new Document();
       try {
           Image  img = Image.getInstance(imgSrc);
           PdfWriter.getInstance(doc , new FileOutputStream(s.getfullName() + " Tickets.pdf"));
           doc.open();
           doc.add(img);
           doc.add(new Paragraph("Tickets are booked by " + s.getfullName()));
           doc.add(new Paragraph("       you booked " + numofseats + " seats"));
           doc.add(new Paragraph("       With " +this.calculatetotalticketprice(numofseats) + " EGP"));
           doc.add(new Paragraph("     "));
           doc.add(new Paragraph("     "));
           doc.add(new Paragraph("     "));
           for (int i = 0; i < numofseats; i++) {

               doc.add(new Paragraph("**************************************************************************"));
               doc.add(new Paragraph("*       TicketSerialNumber  #" + serial++));
               doc.add(new Paragraph("*       "+r.getTripID()));
               doc.add(new Paragraph("*       "+r.getRouteName()));
               doc.add(new Paragraph("*       Train Type is " + r.t.TrainType));
               doc.add(new Paragraph("*       Your Ticket type is  " + this.type ));
               doc.add(new Paragraph("*       Ticket Price is  " + this.Price + "EGP"));
               doc.add(new Paragraph("**************************************************************************"));
               doc.add(new Paragraph("     "));
               doc.add(new Paragraph("     "));
               doc.add(new Paragraph("     "));
               doc.add(new Paragraph("     "));
               doc.add(new Paragraph("     "));
           }

           doc.close();

       } catch (DocumentException | FileNotFoundException e) {
           e.printStackTrace();
       }
       System.out.println("Your Tickets is saved as a pdf and ready to print");
   }

}
