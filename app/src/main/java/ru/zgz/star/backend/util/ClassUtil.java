package ru.zgz.star.backend.util;

import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassUtil {
  public static Set<Class<?>> findAllClasses(String packageName) throws IOException {
    return ClassPath.from(ClassLoader.getSystemClassLoader()).getAllClasses().stream()
        .filter(clazz -> clazz.getPackageName().equalsIgnoreCase(packageName))
        .map(clazz -> clazz.load())
        .collect(Collectors.toSet());
  }
}
