package co.edu.javeriana.pica.jvm.performance.pf;

import java.util.List;

public class BlurPixel {

    public static RGB blur(RGB pixel, List<RGB> neighbors) {
        return neighbors.stream().reduce(pixel, (one, two) -> one.average(two));
    }
}
