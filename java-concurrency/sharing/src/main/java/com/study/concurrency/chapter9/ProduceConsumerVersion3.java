package com.study.concurrency.chapter9;

import java.util.stream.Stream;

//线程间的通信 （正确的例子）[消费者和生产者都是多线程线程]
public class ProduceConsumerVersion3 {
    private int i = 0;
    private volatile boolean isProduceed = false;
    private final Object LOCK = new Object();

    public void produce() {
        synchronized (LOCK) {
            while (isProduceed) {
                try {
                    LOCK.wait();  //说明生产者已经生产了一个并且消费者还没有开始消费，进入等待 [wait的意思是放弃cpu执行权，由别人去唤醒你]
                } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
            }
            i++;
            System.out.println(Thread.currentThread().getName() + "->" + i);
            LOCK.notifyAll(); //把所有wait的线程都唤醒
            isProduceed = true;

        }
    }

    public void consulme() {
        synchronized (LOCK) {
            while (!isProduceed) {
                try {
                    LOCK.wait(); ////说明生产者没有生产，进入等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() +"->" + i);
            LOCK.notifyAll(); //把所有wait的线程都唤醒
            isProduceed = false;
        }
    }



    public static void main(String[] args) {
        ProduceConsumerVersion3 pc = new ProduceConsumerVersion3();
        Stream.of("p1", "p2").forEach(n -> new Thread(n) {
            @Override
            public void run() {
                while (true)
                    pc.produce();
            }
        }.start());

        Stream.of("c1", "c2").forEach(n -> new Thread(n) {
            @Override
            public void run() {
                while (true)
                    pc.consulme();
            }
        }.start());
    }
}
