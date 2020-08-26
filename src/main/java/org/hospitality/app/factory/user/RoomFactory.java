package org.hospitality.app.factory.user;
/*
    author: @NeilJohnson
    desc: Factory Test for Occupant
    date: 29-06-2020
 */
import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.entity.user.Room;
import org.hospitality.app.util.Helper;

public class RoomFactory {
    public static Room createRoom(String availability, Occupant occupant)
    {
        String roomId = Helper.generateId();

        Room room = new Room.Builder()
                .setRoomNumber(roomId)
                .setOccupantId(occupant.getOccupantId())
                .setAvailability(availability)
                .build();

        return room;
    }
}
