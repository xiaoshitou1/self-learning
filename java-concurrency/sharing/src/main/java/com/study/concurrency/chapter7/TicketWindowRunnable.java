package com.study.concurrency.chapter7;

public class TicketWindowRunnable implements  Runnable{
    private static final int MAX = 500;
    private static int index = 1;
    private final Object MONITOR = new Object();

    public void run() {
        while (true) {
            synchronized (MONITOR) {
                if (index > MAX) {
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+ "==>the current number is: " + (index++));
            }

        }
    }
}
