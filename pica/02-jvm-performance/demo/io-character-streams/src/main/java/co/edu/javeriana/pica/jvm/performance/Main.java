package co.edu.javeriana.pica.jvm.performance;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            throw new IllegalArgumentException("Incorrect number of elements (expected file path)");
        }

        String originalFile = args[0];
        try (BufferedReader br = new BufferedReader(new FileReader(new File(originalFile)))) {
            Map<String, Long> countWordsMap = new TreeMap<>(
                    br.lines().flatMap(line ->
                            Arrays.stream(line.split("\\s"))).
                            collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            );

            countWordsMap.forEach((k, v) -> System.out.println(k + " = " + v));
        } catch (IOException ex) {
            System.out.println("Something bad has happened: " + ex);
        }
    }
}
