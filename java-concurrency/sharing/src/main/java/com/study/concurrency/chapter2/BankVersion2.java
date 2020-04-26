package com.study.concurrency.chapter2;

public class BankVersion2 {

    public static void main(String[] args) {
        final TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();

        Thread thread1 = new Thread(ticketWindowRunnable, "number1");
        Thread thread2 = new Thread(ticketWindowRunnable, "number2");
        Thread thread3 = new Thread(ticketWindowRunnable, "number3");
        thread1.start();
        thread2.start();
        thread3.start();


    }
}
