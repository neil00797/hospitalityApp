package org.hospitality.app.entity.user;
/*
    author: @NeilJohnson
    desc: Entity for Occupant
    date: 27-06-2020
 */

public class Occupant {
    private String occupantId;
    private String firstName;
    private String lastName;
    private String allergyId;
    private String medicationId;

    public Occupant(Builder builder){
        this.occupantId = builder.occupantId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.allergyId = builder.allergyId;
        this.medicationId = builder.medicationId;
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

    public String getAllergyId() {
        return allergyId;
    }

    public String getMedicationId() {
        return medicationId;
    }

    @Override
    public String toString() {
        return "Occupant{" +
                "occupantId='" + occupantId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", allergyId='" + allergyId + '\'' +
                ", medicationId='" + medicationId + '\'' +
                '}';
    }

    public static class Builder{
        private String occupantId, firstName, lastName, allergyId, medicationId;

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

        public Builder setAllergyId(String allergyId){
            this.allergyId = allergyId;
            return this;
        }

        public Builder setMedicationId(String medicationId){
            this.medicationId = medicationId;
            return this;
        }

        public Builder copy(Occupant occupant){
            this.occupantId = occupant.occupantId;
            this.firstName = occupant.firstName;
            this.lastName = occupant.lastName;
            this.allergyId = occupant.allergyId;
            this.medicationId = occupant.medicationId;
            return this;
        }

        public Occupant build(){
            return new Occupant(this);
        }

    }
}
