package com.threads.counter;

/**
 * singleton dostarcza liste wartosci
 * inny singleton dostarcza licznik do przechowywania ilosci liczb parzystych w liscie wartosci
 *
 * aplikacja tworzy watki i liczy ile jest liczb parzystych w liście elementow
 */
public class CounterApplication {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Oto lista dosprawdzenia: " + CounterSummaryProvider.getInstance().getList().toString());

        Thread thread1 = new Thread(new CounterTask());
        Thread thread2 = new Thread(new CounterTask());
        Thread thread3 = new Thread(new CounterTask());
        Thread thread4 = new Thread(new CounterTask());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


        Thread.sleep(1000);

        System.out.println("Liczba elementow parzystych: " + CounterSummaryService.getInstance().getCounter());

    }
}
