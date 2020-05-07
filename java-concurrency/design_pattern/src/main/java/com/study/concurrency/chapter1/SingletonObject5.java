package com.study.concurrency.chapter1;

/**
 * 5, 6, 7三种方式都是可行的
 */
public class SingletonObject5 {

    /**
     * volatile 不能保证原子性，但是可以保证内存的可见性，也保证有序性
     */
    private static volatile SingletonObject5 instance;


    private SingletonObject5() {

    }

    //double check and volatile
    public synchronized static SingletonObject5 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject5.class) {
                if (null == instance) {
                    instance = new SingletonObject5();
                }
            }
        }
        return SingletonObject5.instance;
    }
}
