package org.hospitality.app.repository;

// Author: Thokozile Snono
// Entity: Contact
// Date: 31 August 2020

import org.hospitality.app.entity.Contact;
import org.hospitality.app.user.IRepository;

import java.util.Set;

public abstract class ContactRepository implements IRepository<Contact, String> {
    public abstract Set<Contact> getAll();

    //Contact update(Contact contact);

    //Contact update(Contact contact);

    //Contact update(Contact updated);
}