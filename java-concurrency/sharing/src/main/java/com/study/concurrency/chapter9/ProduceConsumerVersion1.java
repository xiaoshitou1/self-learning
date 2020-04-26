package com.study.concurrency.chapter9;

//线程间的通信 （错误的例子）
public class ProduceConsumerVersion1 {

    private int i = 1;
    final private Object LOCK = new Object();

    public void produce() {
        synchronized (LOCK) {
            System.out.println("p->" + (i++));
        }
    }

    public void conme() {
        synchronized (LOCK) {
            System.out.println("p->" + i);
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion1 pc = new ProduceConsumerVersion1();

        new Thread("p") {
            @Override
            public void run() {
               while (true) {
                   pc.produce();
               }
            }
        }.start();

        new Thread("c") {
            @Override
            public void run() {
                while (true) {
                    pc.conme();
                }
            }
        }.start();
    }

}
