package org.hospitality.app.repository.user.impl;

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.factory.user.ContactFactory;
import org.hospitality.app.repository.user.ContactRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactRepositoryImplTest {
    private static ContactRepository repository = ContactRepositoryImpl.getRepository();
    private static Contact contact = ContactFactory.createContact("thokozile@gmail.com","073");

    @Test
    public void a_create(){
        Contact created = repository.create(contact);
        Assert.assertEquals(contact.getEmail(), created.getEmail());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read(){
        Contact read = repository.read(contact.getEmail());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update(){
        Contact updated = new Contact.Builder().setContactNumber("thokozile@gmail.com").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete(){
        boolean deleted = repository.delete(contact.getEmail());
        Assert.assertTrue(deleted);
    }

    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }
}
