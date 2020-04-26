package com.study.concurrency.chapter2;

public class TicketWindow extends Thread {

    private final String name;
    private static final int MAX = 50;
    private static int index = 1;

    public TicketWindow (String name) {
        this.name = name;
    }

    @Override
    public void  run() {

        while (index <= MAX) {
            System.out.println(name + "-->the current number is: " + (index++));
        }
    }
}
