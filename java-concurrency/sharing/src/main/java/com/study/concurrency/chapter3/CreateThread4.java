package com.study.concurrency.chapter3;

public class CreateThread4 {

    private static int counter = 1;

    public static void main(String[] args) {

        /*Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Error e) {
                    System.out.println(counter);
                }
            }

            private void add(int i) {
                counter++;
                add(i + 1);
            }
        });
        t1.start();*/

        System.out.println(1 << 24);
        Thread t2 = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Error e) {
                    System.out.println(counter);
                }
            }

            private void add(int i) {
                counter++;
                add(i + 1);
            }
        }, "t2", 1 << 24);
        t2.start();
    }
}
