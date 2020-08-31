package org.hospitality.app.factory.user;

import org.hospitality.app.entity.service.Ailment;
import org.hospitality.app.entity.user.OccupantMedicalDetails;

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
