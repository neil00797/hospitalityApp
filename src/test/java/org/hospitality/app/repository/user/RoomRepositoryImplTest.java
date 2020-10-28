package org.hospitality.app.repository.user;
/*
    author: @NeilJohnson
    desc: Room Implementation Test for create, read, update and deleting room
    date: 29-06-2020
 */
import org.hospitality.app.entity.user.Room;
import org.hospitality.app.factory.user.RoomFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomRepositoryImplTest {
    @Autowired
    private static RoomRepository repository;
    private static Room room = RoomFactory.createRoom("Available", "21237467");

    @Test
    public void a_create(){
        Room created = repository.save(room);
        Assert.assertEquals(room.getRoomNumber(), created.getRoomNumber());
        System.out.println("CreatedRoom: " + created);
    }

    @Test
    public void b_read(){
        Room read = repository.findById(room.getRoomNumber()).orElseGet(null);
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update(){
        Room updated = new Room.Builder().copy(room).setAvailability("Unavailable").setOccupantId("00797213").build();
        updated = repository.save(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete(){
        repository.deleteById(room.getRoomNumber());
    }

    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.findAll().stream().collect(Collectors.toSet()));
    }
}
