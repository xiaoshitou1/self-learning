package com.study.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

/**
 * 过滤目标（策略模式）
 */
public class FilterApple {

    //策略模式
    @FunctionalInterface
    public interface AppleFilter {
        boolean filter (Apple apple);
    }

    public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<Apple>();

        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAnd150WeightFilter implements AppleFilter{
        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green") && apple.getWeight() >=150);
        }
    }

    public static List<Apple> findApple2(List<Apple> apples, Function<Apple, Boolean> f) {
        List<Apple> list = new ArrayList<Apple>();

        for (Apple apple : apples) {
            if (f.apply(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 120), new Apple("green", 160));


        //实现类
        List<Apple> result = findApple(list, new GreenAnd150WeightFilter());
        System.out.println(result);

        // 匿名内部类
        List<Apple> result1 = findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "yellow".equals(apple.getColor());
            }
        });
        System.out.println(result1);

        //lambda 表达式
        List<Apple> lambdaResult = findApple(list, apple -> {
            return apple.getColor().equals("green");
        });
        System.out.println(lambdaResult);

        List<Apple> lambdaResult1 = findApple(list, apple -> apple.getColor().equals("green"));
        System.out.println(lambdaResult1);

        //==============================================
        //=============================================
        Function<Apple, Boolean> f = (Apple a) -> a.getColor().equals("green");
        Boolean green = f.apply(new Apple("green", 800));
        System.out.println(green);

        List<Apple> lambdaResult2 = findApple2(list, apple -> apple.getColor().equals("green"));
        System.out.println(lambdaResult2);

    }
}





