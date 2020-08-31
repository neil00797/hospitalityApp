package org.hospitality.app.repository.user;
/*
    author: @NeilJohnson
    desc: Room Repository
    date: 29-06-2020
 */
import org.hospitality.app.entity.user.Room;
import org.hospitality.app.repository.IRepository;

import java.util.Set;

public interface RoomRepository extends IRepository<Room, String> {
    Set<Room> getAll();
}
