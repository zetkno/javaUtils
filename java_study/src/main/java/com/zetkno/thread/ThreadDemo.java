package com.zetkno.thread;

class MyThread implements Runnable {
    private int ticket = 10;
    public synchronized boolean sale() {
        if (this.ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票，ticket = " + this.ticket--);
            return true;
        } else {
            return false;

        }
    }

    @Override
    public void run() {
        while (this.sale()) {
            ;
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        MyThread mt = new MyThread();
        new Thread(mt, "票贩子A").start();
        new Thread(mt, "票贩子B").start();
        new Thread(mt, "票贩子C").start();

//        Thread thread = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                if (i%3 ==0) {
//                    Thread.yield();
//                    System.out.println("我礼让了");
//                }
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "执行,i = " + i);
//            }
//        },"有礼貌的线程");
//        thread.start();
//        for (int j = 0; j < 100; j++) {
//            Thread.sleep(100);
//            System.out.println("主线程执行  j = " + j);
//        }

    }
}
