package org.hospitality.app.entity.user;

import org.hospitality.app.entity.service.Ailment;

import java.util.Date;
import java.util.Objects;

public class OccupantMedicalDetails {
    private String ailmentId,occupantId;
    private int height,weight;
    private Date dateOfBirth;

    private OccupantMedicalDetails(Builder builder){
        this.ailmentId = builder.ailmentID;
        this.occupantId= builder.occupantID;
        this.height = builder.height;
        this.weight = builder.weight;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public String getAilmentId() {
        return ailmentId;
    }

    public String getOccupantId() {
        return occupantId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OccupantMedicalDetails)) return false;
        OccupantMedicalDetails that = (OccupantMedicalDetails) o;
        return getAilmentId().equals(that.getAilmentId()) &&
                getOccupantId().equals(that.getOccupantId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAilmentId(), getOccupantId());
    }

    @Override
    public String toString() {
        return "OccupantMedicalDetails{" +
                "ailmentId='" + ailmentId + '\'' +
                ", occupantId='" + occupantId + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public static class Builder{
        private String ailmentID,occupantID;
        private int height,weight;
        private Date dateOfBirth;

        public Builder setAilmentID (String ailmentID){
            this.ailmentID=ailmentID;
            return this;
        }
        public Builder setOccupantID (String occupantID){
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
