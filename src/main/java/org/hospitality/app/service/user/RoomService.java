package org.hospitality.app.service.user;

/*
    author: @NeilJohnson
    desc: Room service interface
    date: 05-09-2020
 */

import org.hospitality.app.entity.user.Room;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface RoomService extends IService<Room, String> {
    Set<Room> getAll();

    //Unique business logic
    Set<Room> getAvailable();
}
