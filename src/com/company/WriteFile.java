package com.company;

import java.io.*;
import java.util.ArrayList;

public class WriteFile  {
    public <T> void writeFile(String fileName, ArrayList<T> arg1)  throws IOException {
        try {
           ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(fileName));
            write.writeObject(arg1);
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> void writeFile(String fileName, T arg1)  throws IOException {
        ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(fileName));
        write.writeObject(arg1);
        write.close();
    }
}
