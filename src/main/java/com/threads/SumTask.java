package com.threads;

import java.util.List;
/**
 * zwykla klasa implementujaca interfejs  runable - moze byc wykonywana na watkach
 * ta klasa w metodzie run sumuje wszystkie integery przekazane do niejw konstruktorze
 */
public class SumTask implements Runnable {

    private List<Integer> list;

    public SumTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * int sum = 0;
         * for (int element : list) {
         *      sum += element;
         * }
         * System.out.println("My sum is: " + sum);
         */
        int sum = list.stream()
                .mapToInt(e -> e)  //zwroci intStream, a strumien intow posiada metode sum
                .sum();

        //zamiast wypisania dodaje moj wynik do jedynego obiektu klasu Summer
        Summer.getInstance().add(sum);
        //po tej operacji odpalam metode psujacą - po to zeby watki nazwajem na siebie czekaly
        Summer.getInstance().test();
    }
}
