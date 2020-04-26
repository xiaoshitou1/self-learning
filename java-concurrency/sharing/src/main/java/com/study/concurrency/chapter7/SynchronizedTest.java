package com.study.concurrency.chapter7;

import java.util.Optional;

public class SynchronizedTest {
    final static Object MONITOR = new Object();
    private static Thread t1;

    public static void main(String[] args) throws InterruptedException {
        t1 = new Thread() {
            @Override
            public void run() {
                synchronized (MONITOR) {
                    System.out.println("t1");
                    while (true) {
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (MONITOR) {
                    System.out.println("t2");
                    while (true) {

                    }
                }
            }
        };

        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(2000);
        t2.interrupt(); //这里由于t1获取到锁，t2线程就会一直处于等待状态，block 住了，即使调用interrupt的方法也无法打断t2，仅仅是把interrupt的标记改为true
        System.out.println(t2.isInterrupted());



    }
}
