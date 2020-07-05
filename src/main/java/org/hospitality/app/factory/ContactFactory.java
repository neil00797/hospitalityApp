package org.hospitality.app.factory;

// Author: Thokozile Snono
// Entity: Contact
// Date: 3 July

import org.hospitality.app.entity.Contact;
import org.hospitality.app.util.GenericHelp;
import org.hospitality.app.util.Helper;

public class ContactFactory {

    public static Contact createContact(String email, String contactNumber){
        String contactNum = GenericHelp.generateContact();
        Contact contact = new Contact.Builder()
                .setContactNumber(contactNumber)
                .setEmail(email)
                .build();
        return contact ;
    }
}
