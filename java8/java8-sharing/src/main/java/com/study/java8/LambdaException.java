package com.study.java8;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaException {


    public static void main(String[] args) {
        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        Comparator<Apple> byColor2 = (o1, o2) ->o1.getColor().compareTo(o2.getColor());

        Function<String, Integer> flambda = s -> s.length();  // (String s)->s.length()
        Predicate<Apple> plambda = (Apple a) -> a.getColor().equals("green");
        Function<Apple, Boolean> f = (Apple a) -> a.getColor().equals("green");
    }
}
