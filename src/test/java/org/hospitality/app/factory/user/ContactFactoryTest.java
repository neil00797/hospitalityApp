package org.hospitality.app.factory.user;

// Author: Thokozile Snono
// Entity: Contact
// Date: 3 July

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.factory.user.ContactFactory;
import org.junit.Test;

public class ContactFactoryTest {

    @Test
    public void createContact() {
        Contact contact = ContactFactory.createContact("thokozile@gmail.com", "073");
        System.out.println(contact);
    }
}