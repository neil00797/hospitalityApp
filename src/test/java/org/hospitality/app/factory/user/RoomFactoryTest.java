package org.hospitality.app.factory.user;

import org.hospitality.app.entity.user.Room;
import org.junit.Assert;
import org.junit.Test;

public class RoomFactoryTest {

    @Test
    public void createRoom() {
        Room room = RoomFactory.createRoom("Available", "");

        Assert.assertEquals(room, room);
    }
}