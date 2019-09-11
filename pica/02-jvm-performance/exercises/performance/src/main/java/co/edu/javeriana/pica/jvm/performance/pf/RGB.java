package co.edu.javeriana.pica.jvm.performance.pf;

public final class RGB {

    private int alpha;
    private int red;
    private int green;
    private int blue;

    public RGB(int value) {
        alpha = (value & 0xff000000) >> 24;
        red = (value & 0x00ff0000) >> 16;
        green = (value & 0x0000ff00) >> 8;
        blue = (value & 0x000000ff) >> 0;
    }

    public RGB(int alpha, int red, int green, int blue) {
        this.alpha = alpha;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getAlpha() {
        return alpha;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getRBGAsInteger() {
        return alpha << 24 | red << 16 | green << 8 | blue << 0;
    }

    @Override
    public String toString() {
        return "RGB{" +
                "alpha=" + alpha +
                ", red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}