package com.threads;

public class Application {
    public static void main(String[] args) {

        MyTask myTask1 = new MyTask("1");
        MyTask myTask2 = new MyTask("2");
        MyTask myTask3 = new MyTask("3");

        Thread thread1 = new Thread(myTask1);
        Thread thread2 = new Thread(myTask2);
        Thread thread3 = new Thread(myTask3);

        //w ten sposob wykonają się asynchronicznie (rownolegle), metoda start()
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
    }
}
