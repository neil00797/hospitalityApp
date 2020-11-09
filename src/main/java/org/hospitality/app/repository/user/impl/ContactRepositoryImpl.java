package org.hospitality.app.repository.user.impl;

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.repository.user.ContactRepository;

import java.util.HashSet;
import java.util.Set;

public class ContactRepositoryImpl implements ContactRepository {

    private static ContactRepository repository = null;
    private Set< Contact > contactDB;

    private ContactRepositoryImpl() {this.contactDB = new HashSet<>();}

    public static ContactRepository getRepository(){
        if (repository == null) repository = new ContactRepositoryImpl();
        return repository;
    }

    @Override
    public Set< Contact > getAll() {
        return this.repository.getAll();
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
