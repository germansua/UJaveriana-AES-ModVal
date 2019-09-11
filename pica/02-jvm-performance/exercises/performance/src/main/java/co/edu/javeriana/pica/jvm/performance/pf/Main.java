package co.edu.javeriana.pica.jvm.performance.pf;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedImage srcImage = ImageIO.read(new File("/Users/gersua/Desktop/beach-bird-s-eye-view-coast-50594.jpg"));
        int with = srcImage.getWidth();
        int height = srcImage.getHeight();

        BufferedImage dstImage = new BufferedImage(with, height, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < with; x++) {
            for (int y = 0; y < height; y++) {
                RGB pixel = new RGB(srcImage.getRGB(x, y));
                List<RGB> neighborPixels = NeighborPixels.getNeighborPixels(1, srcImage, x, y);
                RGB newPixel = BlurPixel.blur(pixel, neighborPixels);
                dstImage.setRGB(x, y, newPixel.getRBGAsInteger());
            }
        }

        ImageIO.write(dstImage, "png", new File("/Users/gersua/Desktop/blur.png"));
    }
}
