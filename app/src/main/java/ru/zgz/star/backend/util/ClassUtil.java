package ru.zgz.star.backend.util;

import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.Set;
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
  public static Set<Class<?>> findAllClasses(String packageName) throws IOException {
    return ClassPath.from(ClassLoader.getSystemClassLoader()).getAllClasses().stream()
        .filter(clazz -> clazz.getPackageName().equalsIgnoreCase(packageName))
        .map(clazz -> clazz.load())
        .collect(Collectors.toSet());
  }
}
