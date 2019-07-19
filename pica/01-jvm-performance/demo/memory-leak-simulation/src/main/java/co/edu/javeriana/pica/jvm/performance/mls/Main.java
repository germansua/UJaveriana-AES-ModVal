package co.edu.javeriana.pica.jvm.performance.mls;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }
        System.out.println("Starting...");

        Map<MyKey, String> myMap = new HashMap<>();
        int index = 0;

        while (true) {
            myMap.put(new MyKey("key"), "value");

            if (index++ % 1000 == 0) {
                System.out.println("Elements in map: " + myMap.size());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}