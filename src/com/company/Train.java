package com.company;

import java.io.Serializable;

public class Train implements Serializable {

    int Seatsno;
    int carsno;
    String Traincode;
    String TrainType;
    public Train(char T)
    {
        switch (T)
        {
            case 'V'-> TrainType = "VIP";
            case 'F'-> TrainType = "FirstClass";
            case 'P'-> TrainType = "Basic";
        }
    }
    public void setTraincode( String Code)
    {
        this.Traincode = Code;
    }

    public String getTraincode()
    {
        return this.Traincode;
    }

}
