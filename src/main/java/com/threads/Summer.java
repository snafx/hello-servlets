package com.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * klasa - singleton
 * sluzy do przechowywania sum, które obliczane beda przez rozne wątki
 * te sumy przechowywane sa w liscie
 * wątek dziala w ten sposob, ze liczy swoja sume i do Summera dorzuca swoj wynik
 */

public class Summer {

    private static Summer instance = null;

    public static Summer getInstance() {
        if (instance == null) {
            instance = new Summer();
        }
        return instance;
    }

    private List<Integer> list = new ArrayList<>();

    //dodaje sume do listy zebranych sum
    public synchronized void add(int sum) {
        list.add(sum);
    }

    //zwraca sume wszystkich zebranych sum
    public int sumElements() {
        return list.stream().mapToInt(e -> e).sum();
    }

    //wypisuje zebrane wartosci
    public String getNumbers() {
        return list.toString();
    }

    //metoda psujaca
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
