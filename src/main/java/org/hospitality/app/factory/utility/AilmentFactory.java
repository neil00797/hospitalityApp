package org.hospitality.app.factory.utility;

import org.hospitality.app.entity.utility.Ailment;
import org.hospitality.app.entity.utility.Medicine;
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
