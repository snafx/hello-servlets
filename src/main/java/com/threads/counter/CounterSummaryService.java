package com.threads.counter;

public class CounterSummaryService {
    private static CounterSummaryService ourInstance = new CounterSummaryService();

    public synchronized static CounterSummaryService getInstance() {
        return ourInstance;
    }

    private int counter;

    private CounterSummaryService() {
    }

    public synchronized void increase() {
        counter++;
    }

    public int get() {
        return counter;
    }
}
