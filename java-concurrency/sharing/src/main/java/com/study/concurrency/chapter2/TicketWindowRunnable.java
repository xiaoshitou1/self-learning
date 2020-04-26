package com.study.concurrency.chapter2;

public class TicketWindowRunnable  implements  Runnable{
    private static final int MAX = 50;
    private static int index = 1;

    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread()+ "==>the current number is: " + (index++));
        }
    }
}
