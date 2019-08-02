package co.edu.javeriana.pica.jvm.performance;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Main04 {

    public static void main(String[] args) {
        SoftReference<Object> softReference = new SoftReference<>(new Object());
        WeakReference<Object> weakReference = new WeakReference<>(new Object());
    }
}
