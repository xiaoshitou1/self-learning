package com.study.java8;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelProcessing {

    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());

//        System.out.println("The best process time(normalAdd)=>" + measureSumPerformance(t -> ParallelProcessing.normalAdd(t), 10_000_000));
        System.out.println("The best process time(normalAdd)=>" + measureSumPerformance(ParallelProcessing::normalAdd, 100_000_000) + " MS");

//        System.out.println("The best process time(normalAdd)=>" + measureSumPerformance(ParallelProcessing::iterateStream, 100_000_000) + " MS");
//
//        System.out.println("The best process time(normalAdd)=>" + measureSumPerformance(ParallelProcessing::parallelStream, 100_000_000) + " MS");
//
//        System.out.println("The best process time(normalAdd)=>" + measureSumPerformance(ParallelProcessing::parallelStream2, 100_000_000) + " MS");

        System.out.println("The best process time(normalAdd)=>" + measureSumPerformance(ParallelProcessing::parallelStream3, 10_000_000) + " MS");
    }
    
    private static long measureSumPerformance(Function<Long, Long> adder, long limit) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i< 10;i++) {
            long startTimeStamp = System.currentTimeMillis();
            Long result = adder.apply(limit);
            long duration = System.currentTimeMillis() - startTimeStamp;
//            System.out.println("The result of sum=>" + result);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;

    }

    private static long iterateStream(long limit) {
        return Stream.iterate(1L, i -> i+1)
                .limit(limit).reduce(0L, Long::sum);
    }

    private static long parallelStream(long limit) {
        return Stream.iterate(1L, i -> i + 1).parallel()
                .limit(limit).reduce(0L, Long::sum);
    }
    //Stream.iterate 产生的源非常消耗性能
    private static long parallelStream2(long limit) {
        return Stream.iterate(1L, i -> i + 1).mapToLong(Long::longValue).parallel()
                .limit(limit).reduce(0L, Long::sum);
    }

    //LongStream.rangeClosed(1, limit) 源性能好
    private static long parallelStream3(long limit) {
        return LongStream.rangeClosed(1, limit).parallel().reduce(0L, Long::sum);
    }

    private static long normalAdd(long limit) {
        long resut = 0L;
        for (long i = 1L; i < limit; i++) {
            resut += i;
        }
        return resut;
    }
}
