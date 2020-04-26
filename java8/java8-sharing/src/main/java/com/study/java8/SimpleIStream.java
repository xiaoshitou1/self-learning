package com.study.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class SimpleIStream {
    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<String> list = getDishNamesByStream(menu);
        System.out.println(list);

        List<String> ParallelList = getDishNamesByParallelStream1(menu);
        System.out.println(ParallelList);
    }

    //以卡路里升序的方法打印卡路里在400以下的菜品名称清单
    private static  List<String> getDishNamesByStream(List<Dish> menu) {
       return  menu.stream().
               filter(d -> d.getCalories() < 400).
               sorted(Comparator.comparing(Dish::getCalories)).
               map(Dish::getName).
               collect(toList());
    }
    //并行流
    private static  List<String> getDishNamesByParallelStream1(List<Dish> menu) {
        return  menu.parallelStream().
                filter(d -> d.getCalories() < 400).
                sorted(Comparator.comparing(Dish::getCalories)).
                map(Dish::getName).
                collect(toList());
    }

}
