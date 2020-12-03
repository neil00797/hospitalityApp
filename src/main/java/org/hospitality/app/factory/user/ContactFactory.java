package org.hospitality.app.factory.user;

// Author: Thokozile Snono
// Entity: Contact
// Date: 3 July

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.util.GenericHelp;

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
