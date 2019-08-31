package co.edu.javeriana.pica.jvm.performance.rc;

import java.util.stream.IntStream;

class Counter {
    public static long value = 0;
}

class CounterModifier implements Runnable {

    private boolean shouldSycn;

    public CounterModifier(boolean shouldSycn) {
        this.shouldSycn = shouldSycn;
    }

    public synchronized void synchronizedIncrease() {
        increase();
    }

    public void increase() {
        System.out.println("Counter value: " + ++Counter.value);
    }
    @Override
    public void run() {
        IntStream.range(0, 5)
                .forEach(i -> {
                    if (shouldSycn) synchronizedIncrease(); else increase();
                });
    }
}

public class Main {

    public static void main(String[] args) {
        CounterModifier counterModifier = new CounterModifier(args.length != 0);
        IntStream.range(0, 3).forEach(i -> new Thread(counterModifier).start());
    }
}
