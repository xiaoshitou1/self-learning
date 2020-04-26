package com.study.concurrency.chapter12;

public class ThreadGroupCreate {

    public static void main(String[] args) {
        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "g1") {
            @Override
            public void run() {
                while (true) {
                    System.out.println(getThreadGroup().getName());
                    System.out.println(getThreadGroup().getParent());
                    System.out.println(getThreadGroup().getParent().activeCount());
                    try {
                        Thread.sleep(10_0000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();
    }
}
