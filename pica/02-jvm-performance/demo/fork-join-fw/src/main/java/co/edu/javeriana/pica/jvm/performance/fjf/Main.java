package co.edu.javeriana.pica.jvm.performance.fjf;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SquareSumRange extends RecursiveTask<Long> {

    private int from;
    private int to;
    private int threshold;
    private List<Integer> numbers;

    public SquareSumRange(int from, int to, int threshold, List<Integer> numbers) {
        this.from = from;
        this.to = to;
        this.threshold = threshold;
        this.numbers = numbers;
    }

    @Override
    public Long compute() {
        if ((to - from) <= threshold) {
            System.out.printf("%s: Working from %d to %d%n",
                    Thread.currentThread().getName(),
                    from, to);

            long result = 0;
            for (int i = from; i <= to; i++) {
                numbers.set(i, (int) Math.pow(numbers.get(i), 2));
                result += numbers.get(i);
            }
            return result;
        } else {
            int splitIndex = (to + from) / 2;

            SquareSumRange leftSide = new SquareSumRange(from, splitIndex, threshold, numbers);
            leftSide.fork();

            SquareSumRange rightSide = new SquareSumRange(splitIndex + 1, to, threshold, numbers);
            long rightSideResult = rightSide.compute();

            return leftSide.join() + rightSideResult;
        }
    }
}

public class Main {

    private static final List<Integer> NUMBERS = IntStream.range(0, 100_000).boxed().collect(Collectors.toList());
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors() * 2;
    private static final int THRESHOLD = NUMBERS.size() / NUMBER_OF_THREADS;

    public static void main(String[] args) {
        System.out.println("NUMBER_OF_THREADS: " + NUMBER_OF_THREADS);
        System.out.println("THRESHOLD: " + THRESHOLD);

        ForkJoinPool forkJoinPool = new ForkJoinPool(NUMBER_OF_THREADS);
        long finalResult = forkJoinPool.invoke(new SquareSumRange(0, NUMBERS.size() - 1, THRESHOLD, NUMBERS));
        System.out.println("The final result is: " + finalResult);
    }
}
