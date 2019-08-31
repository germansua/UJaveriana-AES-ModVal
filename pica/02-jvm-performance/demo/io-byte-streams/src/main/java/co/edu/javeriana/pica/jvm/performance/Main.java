package co.edu.javeriana.pica.jvm.performance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            throw new IllegalArgumentException("Incorrect Number of Arguments (expected origin file location)");
        }

        String originalFile = args[0];
        System.out.println(originalFile);

        String copyFile = originalFile + "_copy.png";
        System.out.println(copyFile);

        byte[] buffer = new byte[1024];

        try (FileInputStream fis = new FileInputStream(new File(originalFile));
             FileOutputStream fos = new FileOutputStream(new File(copyFile))){
            int readBytes;
            while ((readBytes = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, readBytes);
            }
        } catch (IOException ex) {
            System.out.println("Something wrong occurs: " + ex);
        }
    }
}
