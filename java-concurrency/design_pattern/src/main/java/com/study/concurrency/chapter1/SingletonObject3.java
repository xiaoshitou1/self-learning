package com.study.concurrency.chapter1;

public class SingletonObject3 {

    private static SingletonObject3 instance;

    private SingletonObject3 () {

    }

    public synchronized static SingletonObject3 getInstance() { //这里加锁后，这个方法就变成串行，效率低
        if (instance == null) {
            instance = new SingletonObject3();
        }
        return SingletonObject3.instance;
    }
}
