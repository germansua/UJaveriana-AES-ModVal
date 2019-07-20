package co.edu.javeriana.pica.jvm.performance;

public class Main03 {

    public static void main(String[] args) {
    }

    public void doStuff() {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "Hello";

        String str4 = new String("World");
        boolean assert1 = str1 == str3; // true boolean assert2 = str2 == str4; // false
    }

    public void doStuff2() {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "Hello";
        String str4 = new String("World");
        str4 = str4.intern();

        boolean assert1 = str1 == str3; // true
        boolean assert2 = str2 == str4; // true
    }
}
