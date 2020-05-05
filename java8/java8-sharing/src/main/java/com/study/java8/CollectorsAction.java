package com.study.java8;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class CollectorsAction {

    private final static List<Dish> menu = Arrays.asList(
                    new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 300, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {
        testAveragingDouble();
        System.out.println("==============");
        testAveragingInt();
        System.out.println("==============");
        testCounting();
        System.out.println("==============");
        testGroupingByFunction();
        System.out.println("==============");
        testGroupingByFunctionAndCollector();
        System.out.println("==============");
        testGroupingByFunctionAndSupplierAndCollector();
        System.out.println("==============");
        testSummarizing();

    }

    private static void testAveragingDouble() {
        System.out.println("testAveragingDouble");
        Optional.ofNullable(menu.stream().collect(Collectors.averagingDouble(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testAveragingInt() {
        System.out.println("testAveragingInt");
        Optional.ofNullable(menu.stream().collect(Collectors.averagingInt(Dish::getCalories)))
                .ifPresent(System.out::println);
    }

    private static void testCounting() {
        System.out.println("testCounting");
        Optional.of(menu.stream().collect(Collectors.counting())).ifPresent(System.out::println);
    }

    private static void testGroupingByFunction() {
        System.out.println("testGroupingByFunction");
        Optional.of(menu.stream().collect(Collectors.groupingBy(Dish:: getType))).ifPresent(System.out::println);
    }

    private static void testGroupingByFunctionAndCollector() {
        System.out.println("testGroupingByFunctionAndCollector");
        Optional.of(menu.stream().collect(Collectors.groupingBy(Dish:: getType, Collectors.averagingInt(Dish::getCalories)))).ifPresent(System.out::println);
    }

    private static void testGroupingByFunctionAndSupplierAndCollector() {
        System.out.println("testGroupingByFunctionAndSupplierAndCollector");
        TreeMap<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.averagingInt(Dish::getCalories)));
        Optional.of(collect.getClass()).ifPresent(System.out::println);
        Optional.of(collect).ifPresent(System.out::println);
    }

    private static void testSummarizing() {
        System.out.println("testGroupingByFunctionAndCollector");
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.of(collect).ifPresent(System.out::println);
    }
}
