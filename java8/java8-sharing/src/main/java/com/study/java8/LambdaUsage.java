package com.study.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LambdaUsage {

    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (predicate.test(a)){
                result.add(a);
            }
        }
        return result;
    }

    private static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (predicate.test(a.getWeight())){
                result.add(a);
            }
        }
        return result;
    }

    private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<Long, String> biPredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (biPredicate.test(a.getWeight(), a.getColor())){
                result.add(a);
            }
        }
        return result;
    }

    private static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumer) {
        for (Apple a : source) {
            consumer.accept(a);
        }
    }

    private static void simpleBigConsumer(String str, List<Apple> source, BiConsumer<String, Apple> biConsumer) {
        for (Apple a : source) {
            biConsumer.accept(str,a);
        }
    }

    private static String testFunction(Apple apple, Function<Apple, String> fun) {
        return fun.apply(apple);
    }

    private static Apple testBiFunction(String color, int weight, BiFunction<String, Integer, Apple> bF) {
       return bF.apply(color, weight);
    }


    public static void main(String[] args) {
//        Runnable r1 = () -> System.out.println("Hello");
//        new Thread(r1).start();

        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 120), new Apple("blue", 160));

        List<Apple> result = filter(list, (apple) -> apple.getColor().equals("green"));
        System.out.println(result);

        System.out.println("==============================");
        List<Apple> result1 = filterByWeight(list, (w) -> w >= 150);
        System.out.println(result1);

        System.out.println("==============================");
        List<Apple> result2 = filterByBiPredicate(list, (w, c) -> w >= 150 && c.equals("green"));
        System.out.println(result2);

        System.out.println("==============================");
        simpleTestConsumer(list, (apple) -> System.out.println(apple));

        System.out.println("==============================");
        simpleBigConsumer("XXX", list, (s, apple) -> System.out.println(s + apple.getColor() + ":" + apple.getWeight()));

        System.out.println("==============================");
        String str = testFunction(new Apple("black", 200), (apple) -> apple.getColor());
        System.out.println(str);

        System.out.println("==============================");
        IntFunction<Apple> intFun = (i) -> new Apple("b", i);
        Apple apply = intFun.apply(250);
        System.out.println(apply);

        System.out.println("==============================");
        Apple apple1 = testBiFunction("y", 550, (c, w) -> new Apple(c, w));
        Apple apple2 = testBiFunction("yy", 5550, Apple::new);
        System.out.println(apple1);
        System.out.println(apple2);

        System.out.println("==============================");
        Supplier<String> s = String::new;
        System.out.println(s.get().getClass());

        System.out.println("==============================");
        //类名::new (args) -> new 类名(args)
        Apple apple = createApple(Apple::new);
        System.out.println(apple);
    }

    private static Apple createApple(Supplier<Apple> supplier) {
       return supplier.get();
    }
}
