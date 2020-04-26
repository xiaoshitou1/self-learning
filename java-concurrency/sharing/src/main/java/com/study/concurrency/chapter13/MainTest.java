package com.study.concurrency.chapter13;

public class MainTest {

    public static void main(String[] args) {
        OUTER:
        while (true) {
            System.out.println("=======");
            while (true) {
                System.out.println("+++++++++");
                break OUTER;
            }
        }

        System.out.println("---------");
    }
}
