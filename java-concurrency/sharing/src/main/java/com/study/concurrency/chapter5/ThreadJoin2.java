package com.study.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

public class ThreadJoin2 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t1.join(); //join的意思是： 当前线程【这里指main线程】等待子线程【这里指t1线程】结束才开始执行

        Optional.of("all of tasks finsh don.").ifPresent(System.out::println);
        IntStream.range(1, 100)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));

//        Thread.currentThread().join(); //main线程等待main线程结束才结束【这里就会使main线程一直在执行】
    }
}
