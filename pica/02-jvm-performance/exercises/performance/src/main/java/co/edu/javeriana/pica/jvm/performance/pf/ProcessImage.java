package co.edu.javeriana.pica.jvm.performance.pf;

import java.awt.image.BufferedImage;

public class ProcessImage {

    public static BufferedImage process(BufferedImage srcImage) {
        int with = srcImage.getWidth();
        int height = srcImage.getHeight();
        BufferedImage dstImage = new BufferedImage(with, height, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < with; x++) {
            for (int y = 0; y < height; y++) {
                dstImage.setRGB(x, y, ProcessPixel.process(srcImage, x, y).getRBGAsInteger());
            }
        }

        return dstImage;
    }
}
