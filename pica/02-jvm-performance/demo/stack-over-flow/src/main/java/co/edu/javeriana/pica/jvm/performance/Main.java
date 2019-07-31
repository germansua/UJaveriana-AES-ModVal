package co.edu.javeriana.pica.jvm.performance;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Invalid number of arguments, required 1");
        }

        if (!args[0].matches("\\d+")) {
            throw new IllegalArgumentException("Not a Number");
        }

        String factorialStr = args[0];
        System.out.printf("The factorial of %s is %s%n", factorialStr, factorial(Integer.valueOf(factorialStr)));
    }

    public static BigInteger factorial(int number) {
        if (number <= 1) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(number).multiply( factorial(number - 1) );
        }
    }
}
