package com.study.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class StreamInAction {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> result = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(v -> v.getValue()))
                .collect(toList());
        System.out.println(result);

        System.out.println("======================================");

        //(2) 交易员都在哪些不同的城市工作过？
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("======================================");

        //(3) 查找所有来自于剑桥的交易员，并按姓名排序。
        transactions.stream()
                .map(t->t.getTrader())
                .filter(trader->trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(n -> n.getName()))
                .forEach(System.out::println);

        System.out.println("===========================");

        //(4) 返回所有交易员的姓名字符串，按字母顺序排序
        String reduce = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (name1, name2) -> name1 + name2);
        System.out.println(reduce);

        System.out.println("===========================");

        //(5) 有没有交易员是在米兰工作的？
        boolean b = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(b);

        System.out.println("===========================");

        //(6) 打印生活在剑桥的交易员的所有交易额。
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .forEach(System.out::println);

        System.out.println("===========================");

        //(7) 所有交易中，最高的交易额是多少？
        Integer maxVaule = transactions.stream()
                .map(t -> t.getValue())
                .reduce(0,Integer::max);
        System.out.println(maxVaule);

        System.out.println("===========================");

        //(8) 找到交易额最小的交易。
        Optional<Transaction> min = transactions.stream()
                .reduce((t1, t2) ->
                        t1.getValue() < t2.getValue() ? t1 : t2);
        Transaction transaction = min.get();
        System.out.println(transaction);




        System.out.println("++++++++++++++++");
        //(3) 查找所有来自于剑桥的交易员，并按姓名排序。
        //除非流水线上触发一个终端操作，否则中间操作不会执行任何处理
        transactions.stream()
                .map(d -> {
                            System.out.println("map>>" + d.getTrader());
                            return d.getTrader();
                         })
                .filter(trader-> {
                                   System.out.println("filter>>" + trader);
                                    return trader.getCity().equals("Cambridge");
                                   });

    }
}
