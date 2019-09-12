package co.edu.javeriana.pica.jvm.performance.pf;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void getNeighborsTest() {
        Point point = new Point(0, 0);
        System.out.println(point.getNeighbors(1));
    }
}