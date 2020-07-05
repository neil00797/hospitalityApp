package org.hospitality.app.factory;

import org.hospitality.app.entity.Ailment;
import org.hospitality.app.entity.OccupantMedicalDetails;

import java.util.Date;

public class OccupantMedicalDetailsFactory {
    public static OccupantMedicalDetails createOccupantMedicalDetails(Ailment ailment, int height, int weight, Date dateOfBirth){
        OccupantMedicalDetails occupantMedicalDetails = new OccupantMedicalDetails.Builder()
                .setAilment(ailment)
                .setHeight(height)
                .setWeight(weight)
                .setDateOfBirth(dateOfBirth)
                .build();
        return occupantMedicalDetails;
    }
}
