package org.hospitality.app.util;

import java.util.UUID;

public class Helper {
    public static String generateId(){

        return UUID.randomUUID().toString();
    }
}
