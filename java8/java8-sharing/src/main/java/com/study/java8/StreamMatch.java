package com.study.java8;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMatch {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        boolean b = stream.allMatch(i -> i > 0);
        System.out.println(b);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        b = stream.allMatch(i -> i > 6);
        System.out.println(b);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        b = stream.noneMatch(i -> i < 0);
        System.out.println(b);
    }
}
