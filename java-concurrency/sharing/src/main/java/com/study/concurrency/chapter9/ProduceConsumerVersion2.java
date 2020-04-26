package com.study.concurrency.chapter9;

import java.util.stream.Stream;

//线程间的通信 （正确的例子）[消费者和生产者都是单线程]
public class ProduceConsumerVersion2 {
    private int i = 0;
    private volatile boolean isProduceed = false;
    private final Object LOCK = new Object();

    public void produce() {
        synchronized (LOCK) {
            if (isProduceed) {
                try {
                    LOCK.wait();  //说明生产者已经生产了一个并且消费者还没有开始消费，进入等待 [wait的意思是放弃cpu执行权，进入wait的队列，由别人去唤醒你(即从wait队列取出)]
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println(Thread.currentThread().getName() +"->" + i);
                LOCK.notify(); //生产了一个，并且通知消费者进行消费
                isProduceed = true;
            }
        }
    }

    public void consulme() {
        synchronized (LOCK) {
            if (isProduceed) {
                System.out.println(Thread.currentThread().getName()+ "->" + i);
                LOCK.notify(); //消费完了，然后通知生产者去生产
                isProduceed = false;
            } else {
                try {
                    LOCK.wait(); ////说明生产者没有生产，进入等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion3 pc = new ProduceConsumerVersion3();
        new Thread("p") {
            @Override
            public void run() {
                while (true)
                    pc.produce();
            }
        }.start();

        new Thread("c") {
            @Override
            public void run() {
                while (true)
                    pc.consulme();
            }
        }.start();
    }
}
