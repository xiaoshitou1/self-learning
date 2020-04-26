package com.study.concurrency.chapter1;

/**
 * 枚举
 */
public class SingletonObject7 {

    private SingletonObject7 () {

    }

    private enum Singlton {
        INSTANCEW;

        private final SingletonObject7 instance;

        Singlton() {
            instance = new SingletonObject7();
        }

        public SingletonObject7 getInstance() {
            return instance;
        }
    }

    public static SingletonObject7 getInstance() {
        return Singlton.INSTANCEW.getInstance();
    }

}
