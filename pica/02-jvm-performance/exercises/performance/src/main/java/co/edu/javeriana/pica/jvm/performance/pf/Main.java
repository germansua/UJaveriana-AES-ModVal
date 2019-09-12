package co.edu.javeriana.pica.jvm.performance.pf;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Instant;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            System.err.println("Invalid number of arguments, expected path to an Image File!");
            System.exit(-1);
        }

        File srcFile = new File(args[0]);
        if (!srcFile.exists()) {
            System.err.printf("The file %s does not exists!", args[0]);
            System.exit(-1);
        }

        System.out.println("Starting...");
        File dstFile = new File(srcFile.getParent(), "blur.png");
        BufferedImage srcImage = ImageIO.read(srcFile);

        Instant startingTime = Instant.now();
        BufferedImage dstImage = ProcessImage.process(srcImage);
        Instant finalTime = Instant.now();
        System.out.printf("Total Processed Time: %d seconds %n", finalTime.getEpochSecond() - startingTime.getEpochSecond());

        System.out.println("Writing Image to disk...");
        ImageIO.write(dstImage, "png", dstFile);
        System.out.println("Finish");
    }
}
