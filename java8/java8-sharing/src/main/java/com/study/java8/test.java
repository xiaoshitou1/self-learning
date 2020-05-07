package com.study.java8;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        for (int i = 1; i<=102; i++) {
            System.out.println(i + ",dg507e4be1e819rl5nk1jk7k" +i + ",Y,NONE,,,NONE,,,,");
        }
    }


    private interface B {
        default void hello() {
            System.out.println("===D.hello==");
        }
    }

    private static class C implements B {
        @Override
        public void hello() {
            B.super.hello();


        }
    }
}
