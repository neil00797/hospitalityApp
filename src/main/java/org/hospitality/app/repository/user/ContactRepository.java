package org.hospitality.app.repository.user;

// Author: Thokozile Snono
// Entity: Contact
// Date: 31 August 2020

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.repository.IRepository;
import org.hospitality.app.service.IService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ContactRepository extends IService< Contact, String> {
    Set<Contact> getAll();

    //Set<Contact> getAllStartingWithA();
}