package co.edu.javeriana.pica.jvm.performance.si;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        final int NUMBER_OF_STRINGS = 50_000_000;
        List<String> strings = new ArrayList<>(NUMBER_OF_STRINGS);

        System.out.printf("Demo started interning %s strings...%n", NumberFormat.getNumberInstance().format(NUMBER_OF_STRINGS));

        Instant startTime = Instant.now();

        IntStream.range(0, NUMBER_OF_STRINGS).forEach(i -> {
            String tmpStr = "Hello World " + i + "!";
            if (args.length > 0) {
                strings.add(tmpStr.intern());
            }
        });

        Instant endTime = Instant.now();

        System.out.println("Total Duration: " + Duration.between(startTime, endTime).toMillis() + " ms");
    }
}
