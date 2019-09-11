package co.edu.javeriana.pica.jvm.performance.pf;

import java.util.List;

public class BlurPixel {

    public static RGB blur(RGB pixel, List<RGB> neighbors) {
        RGB raw = neighbors.stream().reduce(pixel, (one, two) ->
                new RGB(
                        one.getAlpha() + two.getAlpha(),
                        one.getRed() + two.getRed(),
                        one.getGreen() + two.getGreen(),
                        one.getBlue() + two.getBlue())
        );

        int numElements = neighbors.size() + 1;
        return new RGB(
                raw.getAlpha() / numElements,
                raw.getRed() / numElements,
                raw.getGreen() / numElements,
                raw.getBlue() / numElements);
    }
}
