package com.study.java8;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorIntroduce {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                  new Apple("green", 150)
                 ,new Apple("yellow", 120)
                 ,new Apple("green", 170)
                 ,new Apple("green", 150)
                 ,new Apple("yellow", 120)
                 ,new Apple("green", 170));

        List<Apple> green = list.stream().filter(a -> a.getColor().equals("green")).collect(Collectors.toList());
        Optional.ofNullable(green).ifPresent(System.out::println);
        System.out.println("=====================");
        Optional.ofNullable(groupByFunction(list)).ifPresent(System.out::println);
        System.out.println("=====================");
        Optional.ofNullable(groupByCollector(list)).ifPresent(System.out::println);
    }

    private static Map<String, List<Apple>> groupByFunction(List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        apples.stream().forEach(a -> {
            List<Apple> colorList = Optional.ofNullable(map.get(a.getColor())).orElseGet(() -> {
                List<Apple> list = new ArrayList<>();
                map.put(a.getColor(), list);
                return list;
            });
            colorList.add(a);
        });
        return map;
    }

    private static Map<String, List<Apple>> groupByCollector(List<Apple> apples) {
        return apples.stream().collect(Collectors.groupingBy(a -> a.getColor()));
    }
}
