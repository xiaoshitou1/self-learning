package com.study.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {

    public static void main(String[] args) {
        createStreamFromCollection().forEach(System.out::println);

        System.out.println("=================================");
        createStreamFromValues().forEach(System.out::println);

        System.out.println("=================================");
        createStreamFromArrays().forEach(System.out::println);

        System.out.println("=================================");
        createStreamFromFile();

        System.out.println("=================================");
        createStreamIterator().forEach(System.out::println);

        System.out.println("=================================");
        createStreamGenerate().forEach(System.out::println);
    }

    /**
     * Generate the stream object from collection
     * @return
     */
    private static Stream<String> createStreamFromCollection() {
        List<String> list = Arrays.asList("hello", "alex", "rick", "world", "stream");
        return list.stream();
    }

    private static Stream<String> createStreamFromValues() {
        Stream<String> stream = Stream.of("hello", "alex", "rick", "world", "stream");
        return stream;
    }

    private static Stream<String> createStreamFromArrays() {
        String[] str = {"hello", "alex", "rick", "world", "stream"};
        return Arrays.stream(str);
    }

    private static Stream<String> createStreamFromFile() {
        Path path = Paths.get("D:\\soft\\idea\\java8\\java8-sharing\\src\\main\\java\\com\\study\\java8\\CreateStream.java");
        try (Stream<String> lines = Files.lines(path)){
            lines.forEach(System.out::println);
            return lines;
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }

    private static Stream<Integer> createStreamIterator() {
        Stream<Integer> limit = Stream.iterate(0, n -> n + 2).limit(10);
        return limit;
    }

    private static Stream<Double> createStreamGenerate() {
        return Stream.generate(Math::random).limit(10);
    }
}
