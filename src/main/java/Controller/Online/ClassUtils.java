package Controller.Online;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassUtils {

    public static Object createInstanceFromClassName(String className, int x, int y) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(className);
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            return constructor.newInstance(x, y);
        } catch (NoSuchMethodException e) {
            throw new InstantiationException("Constructor with specified parameter types not found for class: " + className);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

