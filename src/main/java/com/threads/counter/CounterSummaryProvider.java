package com.threads.counter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CounterSummaryProvider {
    private static CounterSummaryProvider ourInstance = new CounterSummaryProvider();

    public synchronized static CounterSummaryProvider getInstance() {
        return ourInstance;
    }

    private List<Integer> list;
    private Iterator<Integer> iterator;

    private CounterSummaryProvider() {
        initList();
        iterator = list.iterator();
    }

    //generujemy liste losowych liczb
    private void initList() {
        this.list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt());
        }
    }

    public synchronized int getNextValue() {
        return iterator.next();
    }

    public synchronized boolean hasNext() {
        return iterator.hasNext();
    }
}
