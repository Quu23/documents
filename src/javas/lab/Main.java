package javas.lab;

import javas.maths.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(integral.simpson_rule(new Function() {
            @Override
            public double func(double x) {
                return 1/x;
            }   
            @Override
            public boolean isEvenFunction() {
                return false;
            }
            @Override
            public boolean isOddFunction() {
                return true;
            }
        }, 2, 6, 4));
    }

}