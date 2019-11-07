package com.zetkno.designPatterns;

import java.lang.reflect.InvocationTargetException;

/**
 * 客户端程序类不直接牵扯到对象的实例化管理，只与接口发生关联
 * 通过工厂获取指定接口的指定实例化对象
 */
public class FactoryTest {
    public static void main(String[] args) {
        IMessage iMessage = Factory.getInstance("com.zetkno.designPatterns.NetMessage",IMessage.class);
        iMessage.send();
    }
}

interface IMessage {
    void send();
}

class NetMessage implements IMessage {
    public void send() {
        System.out.println("【网络消息发送】www.google.com");
    }
}

class Factory {
    private Factory() {
//        没有产生实例化对象的意义，所以构造方法私有化
    }
//    反射工厂设计模式
public static <T> T getInstance(String className,Class<T> clazz) {
        T instance = null;
        try {
            instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}






