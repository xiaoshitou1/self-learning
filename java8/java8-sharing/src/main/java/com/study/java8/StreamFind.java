package com.study.java8;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFind {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Optional<Integer> optional = stream.filter(i -> i % 2 == 0).findAny();
        System.out.println(optional.get());

       stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Optional<Integer> optional2 = stream.filter(i -> i % 8 == 0).findFirst();
        optional2.ifPresent(System.out::println);
    }
}
