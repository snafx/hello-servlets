package com.threads;

// zwykla klasa implementujaca interfejs Runnable - dzieki niemu moge stworzyc wątek

public class MyTask implements Runnable {

    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Hello World from Thread " + name + " thread.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
