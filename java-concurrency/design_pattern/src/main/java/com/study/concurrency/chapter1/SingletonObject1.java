package com.study.concurrency.chapter1;

/**
 * 饿汉式
 */
public class SingletonObject1 {
    private  final static SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1(){

    }

    public static SingletonObject1 getInstance() {
        return instance;
    }
}
