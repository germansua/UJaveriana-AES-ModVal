package co.edu.javeriana.pica.framewors.di;

import java.lang.reflect.Field;

public class Container {

    public static void init(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                String value = annotation.value();
                field.setAccessible(true);
                field.set(obj, value);
            }
        }
    }
}
