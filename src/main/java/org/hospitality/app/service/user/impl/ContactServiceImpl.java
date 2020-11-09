package org.hospitality.app.service.user.impl;

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.repository.user.ContactRepository;
import org.hospitality.app.repository.user.impl.ContactRepositoryImpl;
import org.hospitality.app.service.user.ContactService;

import java.util.HashSet;
import java.util.Set;

public class ContactServiceImpl implements ContactService {

    private static ContactService service = null;
    private ContactRepository repository;

    private ContactServiceImpl() {
        this.repository = ContactRepositoryImpl.getRepository();
    }

    public static ContactService getService() {
        if (service == null) service = new ContactServiceImpl();
        return service;
    }

    @Override
    public Set< Contact > getAll() {
        return this.repository.getAll();
    }

    @Override
    public Set< Contact > getAllStartingWithA() {
        Set<Contact> contacts = getAll();
        Set<Contact> contactsWithA = new HashSet<>();
        for (Contact contact : contacts){
            if (contact.getEmail().trim().toLowerCase().startsWith("c")){
                contactsWithA.add(contact );
            }
        }
        return contactsWithA;
    }

    @Override
    public Contact create(Contact t) {
        return this.repository.create(t);
    }

    @Override
    public Contact read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Contact update(Contact t) {
        return this.repository.update(t);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
