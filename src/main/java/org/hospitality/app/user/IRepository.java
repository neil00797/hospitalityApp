package org.hospitality.app.user;

// Author: Thokozile Snono
// Entity: Contact
// Date: 31 August 2020

public interface IRepository <type, email, contactNumber>{
    type create(type t);
    type read(email email);
    type upadate(type t);
    boolean delete(email email);
}
