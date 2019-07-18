package co.edu.javeriana.pica.jvm.performance.mm;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPOutputStream;

public class Main {

    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {

        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Incorrect number of arguments. It's only expected the file name to GZIP.");
        }

        if (!Files.exists(Paths.get(args[0]))) {
            throw new IllegalArgumentException("The source file doesn't exist: " + args[0]);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (FileInputStream fis = new FileInputStream(args[0]);
             GZIPOutputStream gzipos = new GZIPOutputStream(baos)) {
            int n;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((n = fis.read(buffer)) != -1) {
                gzipos.write(buffer, 0, n);
            }
        } catch (IOException ex) {
            System.out.println("An error occurred while processing the input file: " + ex);
            System.exit(-1);
        }

        try (FileOutputStream fos = new FileOutputStream(
                new File(Paths.get(args[0]).normalize().toAbsolutePath().getParent().toFile(), Paths.get(args[0]).normalize().getFileName() + ".gz"))) {
            for (byte b : baos.toByteArray()) {
                fos.write(b);
                //fos.flush();
            }
        } catch (IOException ex) {
            System.out.println("An error occurred while processing the output file: " + ex);
            System.exit(-1);
        }
    }
}