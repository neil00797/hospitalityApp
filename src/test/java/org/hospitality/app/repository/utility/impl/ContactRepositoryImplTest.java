package org.hospitality.app.repository.utility.impl;

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.factory.user.ContactFactory;
import org.hospitality.app.repository.utility.ContactRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactRepositoryImplTest {

    @Autowired
    private static ContactRepository repository;
            //= ContactRepositoryImpl.getRepository();
    private static Contact contact = ContactFactory.createContact("thokozile@gmail.com","073");

    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }

    @Test
    public void create(){
        Contact created = repository.save(contact);
        Assert.assertEquals(contact.getEmail(), created.getEmail());
        System.out.println("Created: " + created);
    }

    @Test
    public void read(){
        Contact read = repository.getOne(contact.getEmail());
        System.out.println("Read: " + read);
    }

    @Test
    public void update(){
        Contact.Builder builder = new Contact.Builder();
        builder.copy(contact);
        builder.setEmail("zile@gmail.com");
        builder.setContactNumber("073");
        Contact upadated = builder.build();
        System.out.println("Updated: " + upadated);
    }

    @Test
    public void delete(){
        this.repository.deleteById(toString());
        if (this.repository.existsById(toString()));
    }
}