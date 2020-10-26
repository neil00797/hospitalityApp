package org.hospitality.app.repository.utility;

// Author: Thokozile Snono
// Entity: ContactRepository

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.entity.user.Room;
import org.hospitality.app.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ContactRepository extends JpaRepository <Contact , String> {
        //IRepository < Contact, String > {
    Set< Contact > getAll();
}
