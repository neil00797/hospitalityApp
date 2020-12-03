package org.hospitality.app.util;

// Author: Thokozile Snono
// Entity: Contact
// Date: 3 July

import java.util.UUID;

public class GenericHelp {

    public static String generateContact(){
        return UUID.randomUUID().toString();
    }
}
