package com.study.java8;

import java.util.concurrent.*;

/**
 * 使用java自带的future模式
 */
public class FutureInAction2 {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(10000L);
                return "I am finished";
            } catch (InterruptedException e) {
                return "I am Error";
            }
        });
        System.out.println("=================");
        System.out.println("other task");
        System.out.println("=================");

//        String value = future.get(10, TimeUnit.MICROSECONDS);
        while (!future.isDone()) {
            Thread.sleep(10);
        }
        System.out.println("value: " + future.get());
        executorService.shutdown();   //Executors 创建的单线程不会自动关闭，它处理一个任务后，会一直等待新的任务。需要手动关闭这个线程

    }
}
