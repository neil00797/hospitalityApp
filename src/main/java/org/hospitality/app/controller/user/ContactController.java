package org.hospitality.app.controller.user;

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.entity.user.Room;
import org.hospitality.app.factory.user.ContactFactory;
import org.hospitality.app.service.user.ContactService;
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

    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact){
        return contactService.update(contact);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        contactService.delete(id);
    }

    @GetMapping("/all")
    public Set< Contact > getAll(){
        return contactService.getAll();
    }

    @GetMapping("/read/{id}")
    public Contact read(@PathVariable String id){
        return contactService.read(id);
    }
}
