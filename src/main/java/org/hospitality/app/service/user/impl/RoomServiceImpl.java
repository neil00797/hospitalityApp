package org.hospitality.app.service.user.impl;

/*
    author: @NeilJohnson
    desc: Room service implementation
    date: 05-09-2020
 */

import org.hospitality.app.entity.user.Room;
import org.hospitality.app.repository.user.RoomRepository;
import org.hospitality.app.service.user.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository repository;

    @Override
    public Set<Room> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Room create(Room room) {
        return this.repository.save(room);
    }

    @Override
    public Room read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Room update(Room room) {
        if (this.repository.existsById(room.getRoomNumber())) {
            return this.repository.save(room);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s))
        {
            return false;
        }

        return true;
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
