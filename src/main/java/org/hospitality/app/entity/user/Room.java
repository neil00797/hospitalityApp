package org.hospitality.app.entity.user;
/*
    author: @NeilJohnson
    desc: Factory Test for Occupant
    date: 29-06-2020
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Room implements Serializable {

    @Id
    private String roomNumber;
    private String occupantId, availability;

    private Room(Builder builder){
        this.roomNumber = builder.roomNumber;
        this.occupantId = builder.occupantId;
        this.availability = builder.availability;
    }

    protected Room(){}

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
}
