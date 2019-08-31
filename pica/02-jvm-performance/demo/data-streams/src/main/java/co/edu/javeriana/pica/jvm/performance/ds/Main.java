package co.edu.javeriana.pica.jvm.performance.ds;

import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
        long finalResult = LongStream.range(0, 100_000)
                .parallel()
                .filter(x -> x % 2 == 0)
                .map(x -> (int) Math.pow(x, 2))
                .sum();
        System.out.println("The final result is: " + finalResult);
    }
}
