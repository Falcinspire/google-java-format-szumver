package com.google.googlejavaformat.java;

public class CamelCaseChecker {
    public static boolean isProbablyLowerCamelCase(String name) {
        if (name.length() == 0) return false;
        if (!Character.isLowerCase(name.charAt(0))) return false;
        if (name.contains("_")) return false;

        return true;
    }
    public static boolean isProbablyUpperCamelCase(String name) {
        if (name.length() == 0) return false;
        if (!Character.isUpperCase(name.charAt(0))) return false;
        if (name.contains("_")) return false;

        return true;
    }
    public static boolean probablyFollowsFinalConvention(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isUpperCase(c) && !Character.isDigit(c) && c != '_') return false;
        }
        return true;
    }
}