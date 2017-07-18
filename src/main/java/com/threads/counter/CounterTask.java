package com.threads.counter;

public class CounterTask implements Runnable {

    @Override
    public void run() {
        CounterSummaryProvider provider = CounterSummaryProvider.getInstance();
        CounterSummaryService service = CounterSummaryService.getInstance();
        int threadCounter = 0;
        while (provider.hasNext()) {
            //z listy biore kolejny element do sprawdzenia
            int nextValue = provider.getNextValue();
            threadCounter++;
            //sprawdzam, czy pobrana wartosc jest parzysta
            //jesli jest, to podbijam counterEvenNumbers
            if (nextValue % 2 == 0) {
                service.increaseCounter();
            }
        }
        System.out.println("Proceeded: " + threadCounter);
        //wyswietlam liczba parzystych liczb z listy

    }
}
