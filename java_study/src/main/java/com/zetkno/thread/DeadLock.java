package com.zetkno.thread;

class XiaoQiang {
    public synchronized void say(WangJian wangJian) {
        System.out.println("先让我跑");
    }
}

class WangJian {
    public synchronized void say(XiaoQiang xq) {
        System.out.println("留下买路财");
    }
}

public class DeadLock {

}
