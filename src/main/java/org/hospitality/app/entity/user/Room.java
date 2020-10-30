package org.hospitality.app.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/*
    author: @NeilJohnson
    desc: Factory Test for Occupant
    date: 29-06-2020
 */
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String roomNumber;
    private String occupantId, availability;

    protected Room(){}

    private Room(Builder builder){
        this.roomNumber = builder.roomNumber;
        this.occupantId = builder.occupantId;
        this.availability = builder.availability;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getOccupantId() {
        return occupantId;
    }

    public String getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", occupantId='" + occupantId + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }

    public static class Builder{
        private String roomNumber, occupantId, availability;

        public Builder setRoomNumber(String roomNumber){
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder setOccupantId(String occupantId){
            this.occupantId = occupantId;
            return this;
        }

        public Builder setAvailability(String availability){
            this.availability = availability;
            return this;
        }

        public Builder copy(Room room){
            this.roomNumber = room.roomNumber;
            this.occupantId = room.occupantId;
            this.availability = room.availability;
            return this;
        }

        public Room build(){
            return new Room(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber.equals(room.roomNumber) &&
                occupantId.equals(room.occupantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, occupantId);
    }
}
