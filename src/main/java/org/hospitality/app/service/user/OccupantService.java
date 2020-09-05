package org.hospitality.app.service.user;

import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface OccupantService extends IService<Occupant, String> {
    Set<Occupant> getAll();

    //Unique business logic
    Set<Occupant> getAllStartingWithN();

   // Occupant create(Occupant occupant);
}
