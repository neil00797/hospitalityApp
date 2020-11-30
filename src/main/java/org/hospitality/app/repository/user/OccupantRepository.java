package org.hospitality.app.repository.user;
/*
    author: @NeilJohnson
    desc: Occupant Repository
    date: 29-06-2020
 */
import org.hospitality.app.entity.user.Occupant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OccupantRepository extends JpaRepository<Occupant, String> {
    //Set<Occupant> getAll();
}
