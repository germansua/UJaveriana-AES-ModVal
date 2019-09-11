package co.edu.javeriana.pica.jvm.performance.pf;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.stream.Collectors;

public class NeighborPixels {

    public static List<RGB> getNeighborPixels(int radius, BufferedImage bufferedImage, int x, int y) {
        int with = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        return new Point(x, y)
                .getNeighbors(radius)
                .stream()
                .filter(point -> isValidPixelForImage(point, with, height))
                .map(point -> bufferedImage.getRGB(point.getX(), point.getY()))
                .map(RGB::new)
                .collect(Collectors.toList());
    }

    public static boolean isValidPixelForImage(Point point, int with, int height) {
        return point.getX() >= 0 && point.getY() >= 0 && point.getX() < with && point.getY() < height;
    }
}