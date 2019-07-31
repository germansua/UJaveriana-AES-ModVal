package co.edu.javeriana.pica.jvm.performance;

import java.util.ArrayList;
import java.util.List;

public class Main02 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        addJVM(list);
    }

    public static void addJVM(List<String> anyList) {
        anyList.add("JVM");
    }
}
