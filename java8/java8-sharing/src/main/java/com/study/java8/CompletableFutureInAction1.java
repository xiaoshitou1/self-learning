package com.study.java8;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureInAction1 {

    private final static Random RANDOM = new Random(System.currentTimeMillis());
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        
        new Thread(() -> {
            Double value = get();
            completableFuture.complete(value);
        }).start();
        
        System.out.println("=====no block...======");

        completableFuture.whenComplete((v, t) -> {
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(t).ifPresent(x -> x.printStackTrace());
        });

//        Optional.ofNullable(completableFuture.get()).ifPresent(System.out::println);
    }
    
     static Double get() {
        try {
            Thread.sleep(RANDOM.nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         double v = RANDOM.nextDouble();
        System.out.println(v);
         return v;
    }
}
