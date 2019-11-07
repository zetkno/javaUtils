package com.zetkno.serializabledemo;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "xiaoZhang";
        e.address = "江干区";
        e.SSN = 11232;
        e.number = 1021;

        try {
            FileOutputStream fileOut = new FileOutputStream("F:/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.println("序列化");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
