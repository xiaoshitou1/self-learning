package com.study.java8;

public class Dish {

    public enum Type {MEAT, FISH, OTHER}

    private final String name;            //菜品名称
    private final boolean vegetarian;    //是否是素食
    private final int calories;            //提供的卡路里
    private final Type type;            //菜品类型

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public String toString() {
        return name;
    }
}
 