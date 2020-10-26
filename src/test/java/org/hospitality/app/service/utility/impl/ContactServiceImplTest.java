package org.hospitality.app.service.utility.impl;

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.factory.user.ContactFactory;
import org.hospitality.app.service.utility.ContactService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactServiceImplTest {

    @Autowired
    private static ContactService service;
            //= ContactServiceImpl.getService();
    private static Contact contact = ContactFactory.createContact("zile@gmail.com", "073");

    @Test
    public void getAll() {
        Set<Contact> contacts = service.getAll();
        assertEquals(1, contacts.size());
        System.out.println("All contacts: " + contacts);
    }

    @Test
    public void a_create() {
        Contact created;
        created = service.create(contact);
        Assert.assertEquals(contact.getEmail(), created.getEmail());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Contact read = service.read(contact.getEmail());
        System.out.println("Read:" + read);
    }

    @Test
    public void update() {
        Contact.Builder builder = new Contact.Builder();
        builder.copy(contact);
        builder.setEmail("zile@gmail.com");
        builder.setContactNumber("073");
        Contact upadated = builder.build();
        System.out.println("Updated: " + upadated);
    }

    @Test
    public void delete() {
        boolean deleted = service.delete(contact.getEmail());
        Assert.assertTrue(deleted);
    }
}