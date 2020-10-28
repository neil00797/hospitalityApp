package org.hospitality.app.repository.user;
/*
    author: @NeilJohnson
    desc: Room Repository
    date: 29-06-2020
 */
import org.hospitality.app.entity.user.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    Set<Room> getAll();
}
