package com.threads;

public class DD {
    public static void main(String[] args) {
        long 1 = System.currentTimeMillis();
        someHeavyOperation();
        System.out.println(System.currentTimeMillis() - 1);
    }

    private static void someHeavyOperation() throws InterruptedException {
        
    }
}
