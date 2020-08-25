package org.hospitality.app.entity.user;

import org.hospitality.app.entity.service.Ailment;

import java.util.Date;

public class OccupantMedicalDetails {
    private Ailment ailment;
    private int height,weight;
    private Date dateOfBirth;

    private OccupantMedicalDetails(Builder builder){
        this.ailment = builder.ailment;
        this.height = builder.height;
        this.weight = builder.weight;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public Ailment getAilment() {
        return ailment;
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
                "ailment=" + ailment +
                ", height=" + height +
                ", weight=" + weight +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public static class Builder{
        private Ailment ailment;
        private int height,weight;
        private Date dateOfBirth;

        public Builder setAilment (Ailment ailment){
            this.ailment=ailment;
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
            this.ailment=ailment;
            this.height=height;
            this.weight=weight;
            this.dateOfBirth=dateOfBirth;
            return this;
        }
        public OccupantMedicalDetails build(){return new OccupantMedicalDetails(this);}
    }
}
