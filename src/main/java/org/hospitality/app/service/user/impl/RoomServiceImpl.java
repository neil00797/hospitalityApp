package org.hospitality.app.service.user.impl;

/*
    author: @NeilJohnson
    desc: Room service implementation
    date: 05-09-2020
 */

import org.hospitality.app.entity.user.Room;
import org.hospitality.app.repository.user.RoomRepository;
import org.hospitality.app.repository.user.impl.RoomRepositoryImpl;
import org.hospitality.app.service.user.RoomService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class RoomServiceImpl implements RoomService {
    private static RoomService service = null;
    private RoomRepository repository;

    private RoomServiceImpl() {
        this.repository = RoomRepositoryImpl.getRepository();
    }

    public static RoomService getService(){
        if (service == null) service = new RoomServiceImpl();
        return service;
    }

    @Override
    public Set<Room> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Room create(Room room) {
        return this.repository.create(room);
    }

    @Override
    public Room read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Room update(Room room) {
        return this.repository.update(room);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public Set<Room> getAvailable() {
        Set<Room> rooms = getAll();
        Set<Room> availableRooms = new HashSet<>();

        for (Room room: rooms){
            if (room.getAvailability().equalsIgnoreCase("available")){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}
