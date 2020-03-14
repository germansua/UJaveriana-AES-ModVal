package co.edu.javeriana.pica.jvm.performance;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        for (int i  = 1; i <= 20; i++) {
            System.out.println("Is prime 1: " + i + ": " + main.isPrime(i));
            System.out.println("Is prime 2: " + i + ": " + main.isPrimeV2(i));
            System.out.println("Is prime 3: " + i + ": " + main.isPrimeV3(i));
            System.out.println("Is prime 4: " + i + ": " + main.isPrimeV4(i));
            System.out.println("Is prime 5: " + i + ": " + main.isPrimeV5(i));
        }
    }

    public boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrimeV2(int n) {
        int nSqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= nSqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrimeV3(int n) {
        return IntStream.range(2, n).filter(i -> n % i == 0).count() == 0;
    }

    public boolean isPrimeV4(int n) {
        int nSqrt = (int) Math.sqrt(n);
        return IntStream.rangeClosed(2, nSqrt).filter(i -> n % i == 0).count() == 0;
    }

    public boolean isPrimeV5(int n) {
        int nSqrt = (int) Math.sqrt(n);
        return IntStream.rangeClosed(2, nSqrt).parallel().filter(i -> n % i == 0).count() == 0;
    }
}
