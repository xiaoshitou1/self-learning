package com.study.concurrency.chapter4;

import java.util.concurrent.TimeUnit;

public class DaemonThread2 {

    public static void main(String[] args) throws  Exception {

        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {

                    while (true) {
                        System.out.println("==========");
//                        Thread.sleep(100_000);
                    }

            });
//            innerThread.setDaemon(true);
            innerThread.start();
            System.out.println(innerThread.getThreadGroup().getName());

        });
        t.setDaemon(true);
        t.start();
        System.out.println(t.getThreadGroup().getName());
        TimeUnit.SECONDS.sleep(10);
    }
}
