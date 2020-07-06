package org.hospitality.app.factory;
/*
    author: @NeilJohnson
    desc: Factory Test for Occupant
    date: 29-06-2020
 */
import org.hospitality.app.entity.Occupant;
import org.hospitality.app.util.Helper;

public class OccupantFactory {
    public static Occupant createOccupant(String firstName, String lastName)
    {
        String occupantId = Helper.generateId();
        String allergyId = Helper.generateId();
        String medicationId = Helper.generateId();

        Occupant occupant = new Occupant.Builder()
                .setOccupantId(occupantId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAllergyId(allergyId)
                .setMedicationId(medicationId)
                .build();


        return occupant;
    }
}
