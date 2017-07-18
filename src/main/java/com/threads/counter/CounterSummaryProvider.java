package com.threads.counter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * klasa - singleton ktora bedzie bedzie dostarczala liste elementow do sprawdzenia
 * wiele watkow ma pracowac na jednym obiekcie
 */
public class CounterSummaryProvider {
    private static CounterSummaryProvider ourInstance = new CounterSummaryProvider();

    public synchronized static CounterSummaryProvider getInstance() {
        return ourInstance;
    }

    private List<Integer> list;
    private Iterator<Integer> iterator;

    //konstruktor
    private CounterSummaryProvider() {
        initList();
        iterator = list.iterator();
    }

    //getter
    public List<Integer> getList() {
        return list;
    }

    //pomocnicza metoda inicjujaca
    //generujemy liste losowych liczb
    private void initList() {
        this.list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt());
        }
    }

    //metoda zwracajaca kolejną wartość do sprawdzenia
    //z tej metody bedzie korzystalo wiele watkow na raz
    //najpierw biore pierwszy element, drugi, trzeci, az do konca listy
    //to, ktory element zwrocic przechowuje w osobnym polu tej klasy
    //wersja lepsza: zaatwia to samo za pomoca iteratora!!!
    public synchronized int getNextValue() {
        return iterator.next();
    }

    //czy w liscie sa jeszcze wartosci do sprawdzenia?
    public synchronized boolean hasNext() {
        return iterator.hasNext();
    }
}
