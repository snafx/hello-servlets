package com.threads;

import java.util.ArrayList;
import java.util.List;

public class Summer {

    private static Summer instance = null;

    public static Summer getInstance() {
        if (instance == null) {
            instance = new Summer();
        }
        return instance;
    }

    private List<Integer> list = new ArrayList<>();

    public synchronized void add(int sum) {
        list.add(sum);
    }

    public int sumElements() {
        return list.stream().mapToInt(e -> e).sum();
    }

    public String getNumbers() {
        return list.toString();
    }

    public synchronized void test() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }

    private Summer() {
    }
}
