package org.hospitality.app.factory.user;

import org.hospitality.app.entity.utility.Ailment;
import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.util.Helper;
import org.hospitality.app.util.StringHelper;

import java.util.Date;

public class OccupantMedicalDetailsFactory {

    public static OccupantMedicalDetails createOccupantMedicalDetails(String ailmentID,String occupantID,int height, int weight, Date dateOfBirth){
        if(StringHelper.isEmpty(ailmentID)||StringHelper.isEmpty(occupantID))
            return new OccupantMedicalDetails.Builder().setOccupantID(occupantID)
                    .setAilmentID(ailmentID)
                    .setWeight(weight)
                    .setHeight(height)
                    .setDateOfBirth(dateOfBirth)
                    .build();
        OccupantMedicalDetails occupantMedicalDetails = new OccupantMedicalDetails.Builder()
                .setOccupantID(occupantID)
                .setAilmentID(ailmentID)
                .setHeight(height)
                .setWeight(weight)
                .setDateOfBirth(dateOfBirth)
                .build();
        return occupantMedicalDetails;
    }
}
