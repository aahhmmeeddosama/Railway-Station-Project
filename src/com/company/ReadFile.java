package com.company;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
    public <T> ArrayList<T> readFile(String fileName) throws IOException {
        ArrayList<T> Arr = new ArrayList<>();
        try {
            try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(fileName))) {
                Arr=(ArrayList<T>)read.readObject();
            }

        }catch (FileNotFoundException e)
        {

        }catch(EOFException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Arr;
    }

}
