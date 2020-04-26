package com.study.concurrency.chapter2;

public class Bank {
    public static void main(String[] args) {
        TicketWindow t1 = new TicketWindow("counter1");
        t1.start();
        TicketWindow t2 = new TicketWindow("counter2");
        t2.start();
        TicketWindow t3 = new TicketWindow("counter3");
        t3.start();
        TicketWindow t4 = new TicketWindow("counter4");
        t4.start();
    }
}
