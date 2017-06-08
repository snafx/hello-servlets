package com.sda.calc;

public class Calculator {

    public double add(double first, double second) {
        return first + second;
    }

    public double subtract(double first, double second) {
        return first - second;
    }

    public double multiply(double first, double second) {
        return first*second;
    }

    public double divide(double first, double second) {
        if (second == 0) {
            return 0;
        } else {
            return first / second;
        }
    }
}
