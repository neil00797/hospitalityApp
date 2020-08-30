package org.hospitality.app.factory.user;

import org.hospitality.app.entity.service.Ailment;
import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.util.Helper;

import java.util.Date;

public class OccupantMedicalDetailsFactory {
    public static OccupantMedicalDetails createOccupantMedicalDetails(int height, int weight, Date dateOfBirth){
        String occupantId = Helper.generateId();
        String ailmentId = Helper.generateId();

        OccupantMedicalDetails occupantMedicalDetails = new OccupantMedicalDetails.Builder()
                .setAilmentID(ailmentId)
                .setOccupantID(occupantId)
                .setHeight(height)
                .setWeight(weight)
                .setDateOfBirth(dateOfBirth)
                .build();
        return occupantMedicalDetails;
    }
}
