package co.edu.javeriana.pica.jvm.performance;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    private static final int iterations = 71000;
    private static final int sizeModule = 10000;
    private static final int gcModule = 500;

    public static void main(String[] args) {
        System.out.println("Program Started");

        System.out.println("-----------------------------------------------------");
        System.out.println("Strong Reference");
        List<Object> strongReferenceList = new ArrayList<>();
        IntStream.range(0, iterations)
                .forEach(i -> {
                    strongReferenceList.add(new SoftReference<>(new Object()));
                    if (i % sizeModule == 0) {
                        System.out.println("List size: " + strongReferenceList.size());
                    }

                    if (i % gcModule == 0) {
                        System.gc();
                    }
                });

        System.out.println("Total of not null references: " +
                strongReferenceList.stream()
                        .filter(elem -> elem != null)
                        .count()
        );
        strongReferenceList.clear();

        System.out.println("-----------------------------------------------------");
        System.out.println("Soft Reference");
        List<SoftReference<Object>> softReferenceList = new ArrayList<>();
        IntStream.range(0, iterations)
                .forEach(i -> {
                    softReferenceList.add(new SoftReference<>(new Object()));
                    if (i % sizeModule == 0) {
                        System.out.println("List size: " + softReferenceList.size());
                    }

                    if (i % gcModule == 0) {
                        System.gc();
                    }
                });

        System.out.println("Total of not null references: " +
                softReferenceList.stream()
                        .filter(elem -> elem.get() != null)
                        .count()
        );
        strongReferenceList.clear();

        System.out.println("-----------------------------------------------------");
        System.out.println("Weak Reference: ");
        List<WeakReference<Object>> weakReferenceList = new ArrayList<>();
        IntStream.range(0, iterations)
                .forEach(i -> {
                    weakReferenceList.add(new WeakReference<>(new Object()));
                    if (i % sizeModule == 0) {
                        System.out.println("List size: " + weakReferenceList.size());
                    }

                    if (i % gcModule == 0) {
                        System.gc();
                    }
                });

        System.out.println("Total of not null references: " +
                weakReferenceList.stream()
                        .filter(elem -> elem.get() != null)
                        .count()
        );

        System.out.println("End of program!");
    }
}
