package com.threads.counter;

public class CounterApplication {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new CounterTask());
        Thread thread2 = new Thread(new CounterTask());
        Thread thread3 = new Thread(new CounterTask());
        Thread thread4 = new Thread(new CounterTask());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


        Thread.sleep(1000);

        System.out.println(CounterSummaryService.getInstance().get());

    }
}
