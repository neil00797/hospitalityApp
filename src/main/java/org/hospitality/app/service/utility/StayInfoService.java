package org.hospitality.app.service.utility;


import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.service.IService;

import java.util.Set;

/*
    Thaakir Ajouhaar - 217244394

 */

public interface StayInfoService extends IService<StayInformation, String>
{

    Set<StayInformation> getAll();

}
