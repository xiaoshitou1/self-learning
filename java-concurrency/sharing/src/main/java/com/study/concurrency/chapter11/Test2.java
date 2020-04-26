package com.study.concurrency.chapter11;

import java.util.Arrays;
import java.util.Optional;

public class Test2 {

    public void test(){
        // .getStackTrace() --> 打印线程的堆栈信息
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e -> !e.isNativeMethod())
                .forEach(e -> Optional.of(e.getClassName() + ":" + e.getMethodName() + ": " + e.getLineNumber())
                .ifPresent(System.out::println));

    }
}
