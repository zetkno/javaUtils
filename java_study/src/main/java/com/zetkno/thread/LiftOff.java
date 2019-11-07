package com.zetkno.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "LiftOff!") + "),";
    }

    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}

class MainThread {
    public static void main(String[] args) {
//        LiftOff liftOff = new LiftOff();
//        Thread thread = new Thread(liftOff);
//        thread.start();
//        System.out.println("Waiting for LiftOff");

//        for (int i = 0; i < 5; i++) {
//            new Thread(new LiftOff()).start();
//        }
//        System.out.println("Waiting for LiftOff");
    }
}