package org.hospitality.app.util;
/*
    author: @NeilJohnson
    desc: String Helper for empty or null values
    date: 29-06-2020
 */

public class StringHelper {
    public static boolean isEmpty(String string) {
        if (string.isEmpty()) return true;
        if (string.equalsIgnoreCase("null")) return true;
        return false;
    }
}
