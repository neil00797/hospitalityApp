package org.hospitality.app.repository.user.impl;
/*
    author: @NeilJohnson
    desc: Room Repository Implementation
    date: 29-06-2020
 */
import org.hospitality.app.entity.user.Room;
import org.hospitality.app.repository.user.RoomRepository;

import java.util.HashSet;
import java.util.Set;

public class RoomRepositoryImpl implements RoomRepository {
    private static RoomRepository repository = null;
    private Set<Room> roomDB;

    private RoomRepositoryImpl(){
        this.roomDB = new HashSet<>();
    }

    public static RoomRepository getRepository(){
        if (repository == null) repository = new RoomRepositoryImpl();
        return repository;
    }

    @Override
    public Room create(Room room) {
        this.roomDB.add(room);
        return room;
    }

    @Override
    public Room read(String s) {
        for (Room room: this.roomDB){
            if(room.getRoomNumber().equalsIgnoreCase(s))
                return room;
        }

        return null;
    }

    @Override
    public Room update(Room room) {
        boolean deleteRoom = delete(room.getRoomNumber());
        if (deleteRoom){
            this.roomDB.add(room);
            return room;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Room room = read(s);

        if(room != null){
            this.roomDB.remove(room);
            return true;
        }
        return false;
    }

    @Override
    public Set<Room> getAll() {
        return this.roomDB;
    }
}
