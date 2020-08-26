package org.hospitality.app.repository.user;
/*
    author: @NeilJohnson
    desc: Occupant Repository
    date: 29-06-2020
 */
import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.repository.IRepository;

import java.util.Set;

public interface OccupantRepository extends IRepository<Occupant, String> {
    Set<Occupant> getAll();
}
