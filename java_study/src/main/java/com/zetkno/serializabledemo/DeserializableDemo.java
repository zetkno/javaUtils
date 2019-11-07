package com.zetkno.serializabledemo;
import java.io.*;
public class DeserializableDemo {
    public static void main(String[] args) {
        Employee e = null;

        try {
            FileInputStream file = new FileInputStream("F:/employee.ser");
            ObjectInputStream input = new ObjectInputStream(file);
            e = (Employee) input.readObject();
            input.close();
            file.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
            return;
        }
        System.out.println(e.toString());
    }
}
