package co.edu.javeriana.pica.frameworks.di;

public class Main {

    @Inject
    String hello = "Hello";

    @Inject("A different Value")
    String world = "World";

    String noDI = "I own my value";

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        Container.init(main);
        System.out.println(main.hello + " : " + main.world + " : " + main.noDI);
    }
}
