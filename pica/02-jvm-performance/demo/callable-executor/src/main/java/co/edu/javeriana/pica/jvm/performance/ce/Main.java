package co.edu.javeriana.pica.jvm.performance.ce;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.LongStream;

class SumOfNumbers implements Callable<Long> {

    private long n;

    public SumOfNumbers(long n) {
        this.n = n;
    }

    @Override
    public Long call() throws Exception {
        System.out.println("Thread: " + Thread.currentThread().getName());
        return LongStream.rangeClosed(0, n).sum();
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Thread: " + Thread.currentThread().getName());

        SumOfNumbers sumTask = new SumOfNumbers(100);
        ExecutorService myExecutor = Executors.newSingleThreadExecutor();
        Future<Long> futureSumResult = myExecutor.submit(sumTask);

        System.out.println("We can do more stuff while waiting for the result to be process");
        System.out.println("The sum result is: " + futureSumResult.get());

        myExecutor.shutdown();
    }
}
