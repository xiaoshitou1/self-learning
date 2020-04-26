package com.study.java8;

import com.sun.javafx.stage.FocusUngrabEvent;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference {
    public static void main(String[] args) {
        Consumer<String> consulmer = (s) -> System.out.println(s);
        userConsumer(consulmer, "Hello Rick");

        System.out.println("==========================");
        userConsumer(System.out::println, "Hello, Rick!");

        System.out.println("==========================");

        //静态方法的引用
        int value = Integer.parseInt("123");
        Function<String, Integer> f = (n) -> Integer.parseInt(n);
        Integer apply = f.apply("666");
        System.out.println(apply);

        Function<String, Integer> f1 = Integer::parseInt;
        Integer apply1 = f1.apply("777");
        System.out.println(apply1);

        //实例方法引用
        BiFunction<String, Integer, Character> f2 = (s, n) ->  s.charAt(n);
        Character rick = f2.apply("rick", 2);
        System.out.println(rick);

        BiFunction<String, Integer, Character> f3 = String::charAt;
        Character c = f3.apply("hello", 2);
        System.out.println(c);

        //对象方法引用
        String str = new String("Rick");
        Function<Integer, Character> f4 = (n) -> str.charAt(n);
        Character apply2 = f4.apply(2);
        System.out.println(apply2);

        String string = new String("Hello");
        Function<Integer, Character> f5 = string::charAt;
        Character apply3 = f5.apply(4);
        System.out.println(apply3);

        System.out.println("=================================");
        //自定义函数接口
        ThreeFunction<String, Long, String, ComplexApple> tf = ComplexApple::new;
        ComplexApple apply4 = tf.apply("y", 20L, "rick");
        System.out.println(apply4);
    }

    private static <T> void userConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
        consumer.accept(t);
    }
}
