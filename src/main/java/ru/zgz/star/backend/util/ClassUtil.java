package ru.zgz.star.backend.util;

import com.google.common.reflect.ClassPath;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

/** Set of tools for classes */
public class ClassUtil {
  /**
   * Finds all classes in a package
   *
   * @param packageName name of package
   * @return Set of classes
   * @throws IOException if package was not found
   */
  public static List<Class<?>> findAllClasses(String packageName) throws IOException {
    return ClassPath.from(ClassLoader.getSystemClassLoader()).getAllClasses().stream()
        .filter(clazz -> clazz.getPackageName().equalsIgnoreCase(packageName))
        .map(ClassPath.ClassInfo::load)
        .collect(Collectors.toList());
  }

  /**
   * Merges two objects into new one.
   * Iterates through all fields of the first object and, if null takes value from the second
   *
   * @param one first object
   * @param another second object
   * @return new object
   */
  public static Object mergeObjects(Object one, Object another) {
    for (Field field : one.getClass().getDeclaredFields()) {
      Object value = getFieldValue(one, field);
      if (value == null) {
        try {
          field.setAccessible(true);
          field.set(one, getFieldValue(another, field));
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
    return one;
  }

  private static Object getFieldValue(Object instance, Field field) {
    try {
      for (Method method : instance.getClass().getDeclaredMethods()) {
        if (method.getName().equalsIgnoreCase("get" + field.getName())
            && method.getName().length() == field.getName().length() + 3) {
          return method.invoke(instance);
        }
      }
    } catch (InvocationTargetException | IllegalAccessException e) {
      e.printStackTrace();
      return null;
    }
    return null;
  }
}
