package org.hospitality.app.factory.service;

import org.hospitality.app.entity.service.Ailment;
import org.hospitality.app.entity.service.Medicine;
import org.hospitality.app.util.Helper;

public class AilmentFactory {
    public static Ailment createAilment(String ailmentDesc, Medicine medicine){
        String ailmentID = Helper.generateId();
        Ailment ailment = new Ailment.Builder().
                setAilmentID(ailmentID).
                setAilmentDesc(ailmentDesc).
                setMedicine(medicine).build();

        return ailment;
    }
}
