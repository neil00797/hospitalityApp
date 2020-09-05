package org.hospitality.app.service.user;

/*
    author: @NeilJohnson
    desc: Occupant service interface
    date: 01-09-2020
 */

import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface OccupantService extends IService<Occupant, String> {
    Set<Occupant> getAll();

    //Unique business logic
    Set<Occupant> getByFirstName();
}
