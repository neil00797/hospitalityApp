package org.hospitality.app.factory.impl;
/*
    author: @NeilJohnson
    desc: Room Implementation Test for create, read, update and deleting room
    date: 29-06-2020
 */
import org.hospitality.app.entity.user.Room;
import org.hospitality.app.factory.user.RoomFactory;
import org.hospitality.app.repository.user.RoomRepository;
import org.hospitality.app.repository.user.impl.RoomRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomRepositoryImplTest {
    private static RoomRepository repository = RoomRepositoryImpl.getRepository();
    private static Room room = RoomFactory.createRoom("Available", "21237467");

    @Test
    public void a_create(){
        Room created = repository.create(room);
        Assert.assertEquals(room.getRoomNumber(), created.getRoomNumber());
        System.out.println("CreatedRoom: " + created);
    }

    @Test
    public void b_read(){
        Room read = repository.read(room.getRoomNumber());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update(){
        Room updated = new Room.Builder().copy(room).setAvailability("Unavailable").setOccupantId("00797213").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete(){
        boolean deleted = repository.delete(room.getRoomNumber());
        Assert.assertTrue(deleted);
        System.out.println("Successfully deleted!");
    }

    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }
}
