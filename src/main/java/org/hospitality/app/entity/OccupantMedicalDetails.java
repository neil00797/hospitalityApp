package org.hospitality.app.entity;

public class OccupantMedicalDetails {
    private Ailment ailment;

    private OccupantMedicalDetails(Builder builder){
        this.ailment = builder.ailment;
    }

    public Ailment getAilment() {
        return ailment;
    }

    @Override
    public String toString() {
        return "OccupantMedicalDetails{" +
                "ailment=" + ailment +
                '}';
    }

    public static class Builder{
        private Ailment ailment;

        public Builder setAilment (Ailment ailment){
            this.ailment=ailment;
            return this;
        }

        public Builder copy(OccupantMedicalDetails occupantMedicalDetails){
            this.ailment=ailment;
            return this;
        }
        public OccupantMedicalDetails build(){return new OccupantMedicalDetails(this);}
    }
}
