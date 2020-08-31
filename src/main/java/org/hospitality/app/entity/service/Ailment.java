package org.hospitality.app.entity.service;

public class Ailment {
    private String ailmentID,ailmentDesc;
    private Medicine medicine;

    private Ailment(Builder builder){
        this.ailmentID=builder.ailmentID;
        this.ailmentDesc=builder.ailmentDesc;
        this.medicine=builder.medicine;
    }

    public String getAilmentID() {
        return ailmentID;
    }

    public String getAilmentDesc() {
        return ailmentDesc;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    @Override
    public String toString() {
        return "Ailment{" +
                "ailmentID='" + ailmentID + '\'' +
                ", ailmentDesc='" + ailmentDesc + '\'' +
                ", medicine=" + medicine +
                '}';
    }

    public static class Builder{
        private String ailmentID,ailmentDesc;
        private Medicine medicine;

        public Builder setAilmentID(String ailmentID){
            this.ailmentID =ailmentID;
            return this;
        }
        public Builder setAilmentDesc(String ailmentDesc){
            this.ailmentDesc=ailmentDesc;
            return this;
        }
        public Builder setMedicine (Medicine medicine){
            this.medicine =medicine;
            return this;
        }
        public Builder copy(Ailment ailment){
            this.medicine=medicine;
            this.ailmentDesc=ailmentDesc;
            this.ailmentID=ailmentID;
            return this;
        }
        public Ailment build(){return new Ailment(this);}
    }
}
