package org.hospitality.app.entity;

public class Medicine {
    private String medicineID,medicineDesc;

    private Medicine (Builder builder){
        this.medicineID = builder.medicineID;
        this.medicineDesc = builder.medicineDesc;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public String getMedicineDesc() {
        return medicineDesc;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineID='" + medicineID + '\'' +
                ", medicineDesc='" + medicineDesc + '\'' +
                '}';
    }

    public static class Builder{
        private String medicineID,medicineDesc;

        public Builder setMedicineID(String medicineID){
            this.medicineID=medicineID;
            return this;
        }
        public Builder setMedicineDesc(String medicineDesc){
            this.medicineDesc= medicineDesc;
            return this;
        }
        public Builder copy(Medicine medicine){
            this.medicineID = medicineID;
            this.medicineDesc = medicineDesc;
            return this;
        }
        public Medicine build(){
            return new Medicine(this);
        }
    }
}
