package co.edu.javeriana.pica.jvm.performance.pf;

import java.awt.image.BufferedImage;
import java.util.List;

public class ProcessPixel {

    public static RGB process(BufferedImage srcImage, int x, int y) {
        RGB pixel = new RGB(srcImage.getRGB(x, y));
        List<RGB> neighborPixels = NeighborPixels.getNeighborPixels(1, srcImage, x, y);
        return BlurPixel.blur(pixel, neighborPixels);
    }
}
