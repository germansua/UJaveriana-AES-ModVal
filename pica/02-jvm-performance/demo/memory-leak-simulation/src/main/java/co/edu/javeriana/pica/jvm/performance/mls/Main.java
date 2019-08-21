package co.edu.javeriana.pica.jvm.performance.mls;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting...");

        int index = 0;
        boolean hasArgs = args.length > 0;
        Map<MyKey, String> myMap = new HashMap<>();

        while (true) {
            if (!hasArgs) {
                myMap.put(new MyKey("key"), "value");
            } else {
                myMap.put(new MyFixedKey("key"), "value");
            }

            if (index++ % 1000 == 0) {
                System.out.println("Elements in map: " + myMap.size());
                double freeMem = (double) Runtime.getRuntime().freeMemory() / 1_048_576;
                System.out.printf("Free Memory: %.2f MBs%n", freeMem);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}