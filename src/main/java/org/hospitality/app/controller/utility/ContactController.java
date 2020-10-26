package org.hospitality.app.controller.utility;

// Author: Thokozile Snono
// Entity: ContactController

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.factory.user.ContactFactory;
import org.hospitality.app.service.utility.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/create")
    public Contact create(@RequestBody Contact contact) {
        Contact contactNew = ContactFactory.createContact(contact.getEmail(),contact.getContactNumber());
        return contactService.create(contactNew);
    }

    @GetMapping("/all")
    public Set< Contact > getAll(){
        return contactService.getAll();
    }
}