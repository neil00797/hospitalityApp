package org.hospitality.app.repository;

import org.hospitality.app.entity.Contact;
import org.hospitality.app.factory.ContactFactory;
//import org.hospitality.app.repository.implentation.ContactRepositoryImpl;
import org.hospitality.app.repository.impl.ContactRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactRepositoryTest {
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
        Contact updated = new Contact.Builder().copy(contact).setEmail("thokozile@gmail.com").build();
        updated = repository.upadate(updated);
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
