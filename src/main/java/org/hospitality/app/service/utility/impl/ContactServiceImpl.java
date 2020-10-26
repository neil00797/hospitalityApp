package org.hospitality.app.service.utility.impl;

// Author: Thokozile Snono
// Entity: ContactServiceImpl

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.repository.utility.ContactRepository;
import org.hospitality.app.repository.utility.impl.ContactRepositoryImpl;
import org.hospitality.app.service.utility.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService {

    private static ContactService service = null;

    @Autowired
    private ContactRepository repository;

//    private ContactServiceImpl() {
//        this.repository = ContactRepositoryImpl.getRepository();
//    }

//    public static ContactService getService() {
//        if (service == null) service = new ContactServiceImpl();
//        return service;
//    }

    @Override
    public Set< Contact > getAllContactsWithX(){
        //Set <Contact> contacts = getAll();
        Set <Contact> contacts = getAll();
        Set<Contact> contactsWithX = new HashSet<>();
        for (Contact contact : contacts){
            if (contact.getEmail().trim().equalsIgnoreCase("X")){
                contactsWithX.add(contact );
            }
        }
        return contactsWithX;
    }

    @Override
    public Set<Contact> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Contact create(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact read(String s) {
        return this.repository.getOne(s);
    }

    @Override
    public Contact update(Contact contact) {
        if (this.repository.existsById(contact.getEmail())) {
        } else {
            this.repository.existsById(contact.getContactNumber());
        }
        return this.repository.save(contact);
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s)) return false;

        else return true;
    }
}
