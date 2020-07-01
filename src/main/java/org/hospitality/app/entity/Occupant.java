package org.hospitality.app.entity;
/*
    author: @NeilJohnson
    desc: Entity for Occupant
    date: 27-06-2020
 */

public class Occupant {
    private String occupantId, firstName, lastName;

    private Occupant(Builder builder){
        this.occupantId = builder.occupantId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getOccupantId() {
        return occupantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Occupant{" +
                "occupantId='" + occupantId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder{
        private String occupantId, firstName, lastName;

        public Builder setOccupantId(String occupantId){
            this.occupantId = occupantId;
            return this;
        }

        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Occupant occupant){
            this.occupantId = occupant.occupantId;
            this.firstName = occupant.firstName;
            this.lastName = occupant.lastName;
            return this;
        }

        public Occupant build(){
            return new Occupant(this);
        }

    }
}
