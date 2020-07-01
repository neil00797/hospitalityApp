package org.hospitality.app.factory;
/*
    author: @NeilJohnson
    desc: Factory Test for Occupant
    date: 29-06-2020
 */
import org.hospitality.app.entity.Room;
import org.hospitality.app.util.Helper;

public class RoomFactory {
    public static Room createRoom(String availability)
    {
        String roomId = Helper.generateId();
        String occupantId = Helper.generateId();

        Room room = new Room.Builder()
                .setRoomNumber(roomId)
                .setOccupantId(occupantId)
                .setAvailability(availability)
                .build();

        return room;
    }
}
