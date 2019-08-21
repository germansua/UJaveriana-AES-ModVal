package co.edu.javeriana.pica.jvm.performance;

class MyTask implements Runnable {

    private int value;
    private int times;

    public MyTask(int value, int times) {
        this.value = value;
        this.times = times;
    }

    public void run() {
        for(int i = 0; i < times; i++) {
            System.out.println(value);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            throw new IllegalArgumentException("The right number of parameters were not provided ");
        }
        int times = Integer.valueOf(args[0]);

        Thread t1 = new Thread(new MyTask(0, times));
        t1.start();

        Thread t2 = new Thread(new MyTask(1, times));
        t2.start();
    }
}
