package ru.giv.star.api.utils;

import java.util.Random;

public class Utils {
  public static String generateInviteCode(String groupName, String roleCode) {
    int leftLimit = 97;
    int rightLimit = 122;
    int targetStringLength = 10;
    Random random = new Random();
    String randomString =
        random
            .ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    return "%s:%s:%s".formatted(randomString, groupName, roleCode);
  }
}
