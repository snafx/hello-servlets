package com.threads;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        MyTask myTask1 = new MyTask("1");
        MyTask myTask2 = new MyTask("2");
        MyTask myTask3 = new MyTask("3");

        Thread thread1 = new Thread(myTask1);
        Thread thread2 = new Thread(myTask2);
        Thread thread3 = new Thread(myTask3);


        //w ten sposob wykonają się asynchronicznie (rownolegle), metoda start()

        //wariant asynchroniczny
        // uruchomia sie asynchronicznie, wszystkie 3 na raz
        // choc nadal bedzie jakas kolejnosc startu poszczegolnych watkow
        // to juz zalezy od procka i szybkocsi przydzialu pamieci na poszczegolne watki
        // a zatem wiadomosc z poszczegolnych watkow wyswietli sie w jakijs przypadkowej kolejnosci
        // w szczegolnosci jakis watek moze byc szybszy niz wypisanie tekstow "starting thread two"
        // lub "starting thread three"!
        // chociaz napis "Starting thread one" zawsze bedzie pierwszy

        //watkow nie mozna uruchomiac ponownie ani restartowac
        //mozna je wystartowac tylko raz

        thread1.start();
        thread2.start();
        thread3.start();

        /**
         * Synchroniczne wywołanie:
         *
         * MyTask myTask1 = new MyTask();
         * MyTask myTask2 = new MyTask();
         * MyTask myTask3 = new MyTask();
         *
         * wykonaja sie synchronicznie (jeden po drugim), metoda run()
         * myTask1.run();
         * myTask2.run();
         * myTask3.run();
         **/

        //wariant asynchroniczny, poszczegolnewatki sumuja liste integerow ze swoich obiektow

        System.out.println("***************************");

        SumTask sumTask1 = new SumTask(Arrays.asList(5,7,9,15,32,12,6,8));
        SumTask sumTask2 = new SumTask(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1));
        SumTask sumTask3 = new SumTask(Arrays.asList(3432, 2344, 4322, 8888, 6564, 67565, 4233, 12345, 7765));

        Thread sumThread1 = new Thread(sumTask1);
        Thread sumThread2 = new Thread(sumTask2);
        Thread sumThread3 = new Thread(sumTask3);

        //startujemy wątki
        sumThread1.start();
        sumThread2.start();
        sumThread3.start();

        //MORE:
        //tutaj moze sie zdarzyc, ze zakazdymodpaleniem programu dostane inna sume sum
        //to dlatego, ze prawdopodobnie kazdy watek na raz chce wpisac swoja sume na np.
        //pierwszy element listy. I udaje im sie to!
        //zeby to naprawic nalezy dopisac "synchronized" do sygnatury metody add w Summerze
        //oraz w metodzie getInstance
        //ten zabieg zapobiegnie temu, ze kazdy watek bedzie sie pchał na ten sam element tablicy
        // (ustawi te watki w kolejce, jak do kasy)
        //dzieki temu kazdy watek wrzuci swoj wynik na osobne miejsce na liscie


    }
}
