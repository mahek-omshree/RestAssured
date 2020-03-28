package com.student.utils;

import java.util.Random;

public class TestUtils {
    //actually provides unique or utility/useful methods such as random generated values

    public String createEmailId(String name, String domainName) {
        String emailId = name.concat(domainName);
        return emailId;
    }

    public static int randomId() {
        Random randomInt = new Random();
        return randomInt.nextInt(10000);
    }

    public static String randomValue() {
        Random random = new Random();
        int randomInt = random.nextInt(10000);
    return Integer.toString(randomInt);
    }

    public String createRandomEmailId(String domainName) {
        Random random = new Random();
        int randomIntToString = random.nextInt(200);
        String randomString = Integer.toString(randomIntToString);
        return randomString.concat("@" + domainName + ".com");
    }
}