package com.study.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OptionalInAction {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.sort(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2){
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
    }
}
