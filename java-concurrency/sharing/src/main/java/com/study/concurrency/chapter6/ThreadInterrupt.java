package com.study.concurrency.chapter6;

import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadInterrupt {

    private static Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        t.start();
        Thread.sleep(100);
        System.out.println("++>" + t.isInterrupted());
        t.interrupt();
        System.out.println("==>" + t.isInterrupted());

    }

    Thread t = new Thread(() -> {

        while (true) {
            synchronized (MONITOR) {
                try {
                    MONITOR.wait(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.interrupted()); //这里线程是采用实现Runnable接口创建的，所以没有isInterrupted方法，所以使用静态方法interrupted()【其作用和t.isInterrupted()一样】
                }
            }
        }
    });




}
