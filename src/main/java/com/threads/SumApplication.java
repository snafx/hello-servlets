package com.threads;

import java.util.Arrays;
import java.util.List;

public class SumApplication {
    public static void main(String[] args) throws InterruptedException {
        SumTask sumTask = new SumTask(Arrays.asList(1,2,3,4,5,6,7,8,9,3,5,7,6,3,1,9));
        SumTask sumTask2 = new SumTask(Arrays.asList(6, 4, 3, 56, 7, 89, 10,3,6,7,83,8,9));
        SumTask sumTask3 = new SumTask(Arrays.asList(16, 42, 3, 56, 7, 93, 160,3,6,71,31,81,9));
        SumTask sumTask4 = new SumTask(Arrays.asList(36, 4, 3, 56, 7, 96, 10,43,63,72,321,8,19));
        SumTask sumTask5 = new SumTask(Arrays.asList(35,3,5,86));

        Thread thread = new Thread(sumTask);
        Thread thread2 = new Thread(sumTask2);
        Thread thread3 = new Thread(sumTask3);
        Thread thread4 = new Thread(sumTask4);
        Thread thread5 = new Thread(sumTask5);

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

//        sumTask.run();
//        sumTask2.run();
//        sumTask3.run();

        Thread.sleep(2000);

        System.out.println(Summer.getInstance().getNumbers());
        System.out.println(Summer.getInstance().sumElements());
    }
}
