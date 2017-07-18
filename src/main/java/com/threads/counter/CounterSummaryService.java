package com.threads.counter;

/**
 * klasa - singleton do przechowywania licznika liczb parzystych
 * wiele watkow na raz bedzie zwiekszalo tutejszy licznik
 * wiec jego zwiekasznie musi byc synchronized
 */
public class CounterSummaryService {
    private static CounterSummaryService ourInstance = new CounterSummaryService();

    public synchronized static CounterSummaryService getInstance() {
        return ourInstance;
    }

    private int counter;

    private CounterSummaryService() {
    }

    //metoda ktora zwiekszy wartosc countera
    public synchronized void increaseCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
