package com.zetkno.thread;

public class ThreadProducer {
    public static void main(String[] args) throws Exception{
        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}

//生产者
class Producer implements Runnable {

    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                this.msg.set("王健", "宇宙第一帅");
            } else {
                this.msg.set("小高", "猥琐之人");
            }
        }
    }
}

//消费者
class Consumer implements Runnable {
    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.msg.get());
        }
    }
}

class Message {
    private String title;
    private String content;
    private boolean flag = true;
//    flag = true允许生产

    public void setFlag() {
        this.flag = false;
    }

    public Message() {

    }

    public void set(String title, String content) {
        if (!this.flag) { //不允许生产
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.title = title;
        this.content = content;
        this.flag = false;  //已经生产过了
        super.notify();
    }

    public String get() {
        if (this.flag) {    // true 正在生产
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return this.title + "- - " + this.content;
        } finally {
            this.flag = true;  //消费完可以生产了
            super.notify();
        }

    }

}

