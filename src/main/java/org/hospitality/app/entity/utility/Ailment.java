package org.hospitality.app.entity.utility;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
public class Ailment implements Serializable {
    @Id
    private String ailmentID;
    private String medicineId;
    private String ailmentDesc;

    protected Ailment(){}


    private Ailment(Builder builder){
        this.ailmentID=builder.ailmentID;
        this.ailmentDesc=builder.ailmentDesc;
        this.medicineId=builder.medicineId;
    }

    public String getAilmentID() {
        return ailmentID;
    }

    public String getAilmentDesc() {
        return ailmentDesc;
    }

    public String getMedicineId() {
        return medicineId;
    }

    @Override
    public String toString() {
        return "Ailment{" +
                "ailmentID='" + ailmentID + '\'' +
                ", ailmentDesc='" + ailmentDesc + '\'' +
                ", medicine=" + medicineId +
                '}';
    }

    public static class Builder{
        public String medicineId;
        private String ailmentID,ailmentDesc;


        public Builder setAilmentID(String ailmentID){
            this.ailmentID =ailmentID;
            return this;
        }
        public Builder setAilmentDesc(String ailmentDesc){
            this.ailmentDesc=ailmentDesc;
            return this;
        }
        public Builder setMedicine (String medicineId){
            this.medicineId =medicineId;
            return this;
        }
        public Builder copy(Ailment ailment){
            this.medicineId=medicineId;
            this.ailmentDesc=ailmentDesc;
            this.ailmentID=ailmentID;
            return this;
        }
        public Ailment build(){return new Ailment(this);}
    }
}
