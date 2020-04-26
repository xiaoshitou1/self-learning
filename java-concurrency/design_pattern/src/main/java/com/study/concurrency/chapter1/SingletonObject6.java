package com.study.concurrency.chapter1;

/**
 * 优雅的方式
 */
public class SingletonObject6 {

    private static class InstanceHolder {
        private static final SingletonObject6 instance = new SingletonObject6();
    }

    public SingletonObject6 getInstance() {
        return InstanceHolder.instance;
    }
}
