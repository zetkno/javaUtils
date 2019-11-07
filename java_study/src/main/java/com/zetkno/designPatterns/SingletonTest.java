package com.zetkno.designPatterns;

public class SingletonTest {
    public static void main(String[] args) {

    }
}

/**
 * （懒汉式）单例模式  线程安全的
 */
class Singleton {
    private static volatile Singleton instance = null;
    private Singleton(){

    }
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
