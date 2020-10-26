package org.hospitality.app.entity.user;

import org.hospitality.app.entity.utility.Ailment;

import java.io.Serializable;
import java.util.Date;

public class OccupantMedicalDetails implements Serializable {
    private String ailmentID,occupantID;
    private int height,weight;
    private Date dateOfBirth;
    private OccupantMedicalDetails(){}

    private OccupantMedicalDetails(Builder builder){
        this.ailmentID = builder.ailmentID;
        this.occupantID= builder.occupantID;
        this.height = builder.height;
        this.weight = builder.weight;
        this.dateOfBirth = builder.dateOfBirth;
    }
    public String getOccupantID() {
        return occupantID;
    }

    public String getAilment() {
        return ailmentID;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "OccupantMedicalDetails{" +
                "ailmentID='" + ailmentID + '\'' +
                ", occupantID='" + occupantID + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public static class Builder{
        private String ailmentID,occupantID;
        private int height,weight;
        private Date dateOfBirth;

        public Builder setAilmentID (String ailment){
            this.ailmentID=ailment;
            return this;
        }
        public Builder setOccupantID(String occupantID){
            this.occupantID=occupantID;
            return this;
        }
        public Builder setHeight(int height){
            this.height=height;
            return this;
        }
        public Builder setWeight(int weight){
            this.weight=weight;
            return this;
        }
        public Builder setDateOfBirth(Date dateOfBirth){
            this.dateOfBirth=dateOfBirth;
            return this;
        }

        public Builder copy(OccupantMedicalDetails occupantMedicalDetails){
            this.ailmentID=ailmentID;
            this.occupantID=occupantID;
            this.height=height;
            this.weight=weight;
            this.dateOfBirth=dateOfBirth;
            return this;
        }
        public OccupantMedicalDetails build(){return new OccupantMedicalDetails(this);}
    }
}
