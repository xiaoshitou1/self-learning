package com.study.concurrency.chapter12;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ThreadGroupAPI {

    public static void main(String[] args) {
        //tg1 的父亲线程组是main线程组
        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "T1"){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();

        //tg2的父线程组是tg1
        ThreadGroup tg2 = new ThreadGroup(tg1, "TG2");
        Thread t2 = new Thread(tg2, "T2") {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
//        tg1.setDaemon(true);
        t2.start();
        System.out.println(tg1.isDestroyed());

        System.out.println(tg1.activeCount());
        System.out.println(tg1.activeGroupCount());
        tg1.checkAccess();
//        tg1.destroy();
        Thread[] ts1 = new Thread[tg1.activeCount()];
        int enumerate = tg1.enumerate(ts1);
        System.out.println(">>" + enumerate);
        Arrays.asList(ts1).forEach(System.out::println);

    }
}
