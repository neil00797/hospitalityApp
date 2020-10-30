package org.hospitality.app.service.user.impl;

/*
    author: @NeilJohnson
    desc: Room service implementation test
    date: 05-09-2020
 */

import org.hospitality.app.entity.user.Room;
import org.hospitality.app.factory.user.RoomFactory;
import org.hospitality.app.service.user.RoomService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RoomServiceImplTest {
    private static RoomService service;
    private static Room room = RoomFactory.createRoom("Unavailable", "");
    private static Room room2 = RoomFactory.createRoom("Available", "5464498");

    @Test
    public void e_getAll() {
        Set<Room> rooms = service.getAll();
        assertTrue(true);
        System.out.println("All rooms: " + rooms + "\n");
    }

    @Test
    public void a_create() {
        Room created1 = service.create(room);
        Assert.assertEquals(room.getRoomNumber(), created1.getRoomNumber());

        Room created2 = service.create(room2);
        Assert.assertEquals(room2.getRoomNumber(), created2.getRoomNumber());

        System.out.println("Created1: " + created1 + "\n" + "Created2: " +  created2 + "\n");
    }

    @Test
    public void b_read() {
        Room read = service.read(room.getRoomNumber());
        Room read2 = service.read(room2.getRoomNumber());

        System.out.println("Read1: " + read + "\n" + "Read2: " + read2 + "\n");
    }

    @Test
    public void c_update() {
        Room updated = new Room.Builder().copy(room).setAvailability("Available").build();
        updated = service.update(updated);

        Room updated2 = new Room.Builder().copy(room2).setAvailability("Unavailable").build();
        updated2 = service.update(updated2);

        System.out.println("Updated1: " + updated + "\n" + "Updated2: " + updated2 + "\n");
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(room.getRoomNumber());
        boolean deleted2 = service.delete(room2.getRoomNumber());

        Assert.assertTrue(deleted);
        Assert.assertTrue(deleted2);

        System.out.println("Successfully deleted!");
    }

    @Test
    public void d_getAvailable() {
        Set<Room> availRoom = service.getAvailable();
        System.out.println("Available rooms: " + availRoom + "\n");
    }
}