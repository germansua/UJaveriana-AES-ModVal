package co.edu.javeriana.pica.jvm.performance.pf;

import java.util.ArrayList;
import java.util.List;

public final class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Point> getNeighbors(int radius) {
        List<Point> result = new ArrayList<>();
        for (int xx = -radius; xx <= radius; xx++) {
            for (int yy = -radius; yy <= radius; yy++) {
                if (!(xx == this.x && yy == this.y)) {
                    result.add(new Point(xx, yy));
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}