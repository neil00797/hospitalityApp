package org.hospitality.app.controller.user;

import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.factory.user.OccupantMedicalDetailsFactory;
import org.hospitality.app.service.user.impl.OccupantMedicalDetailsServiceImpl;
import org.hospitality.app.service.user.impl.OccupantServiceImpl;
import org.hospitality.app.service.utility.impl.AilmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospitality_db/occupantmedicaldetails")
public class OccupantMedicalDetailsController {
    @Autowired
    private OccupantMedicalDetailsServiceImpl occupantMedicalDetailsService;
    @Autowired
    private OccupantServiceImpl occupantService;
    @Autowired
    private AilmentServiceImpl ailmentService;
     @PostMapping("/create")
    public OccupantMedicalDetails create (@RequestBody OccupantMedicalDetails occupantMedicalDetails){

        OccupantMedicalDetails newOccupantMedicalDetails= OccupantMedicalDetailsFactory.createOccupantMedicalDetails(occupantMedicalDetails.getAilmentID(),occupantMedicalDetails.getOccupantID(),occupantMedicalDetails.getHeight(),occupantMedicalDetails.getWeight(),occupantMedicalDetails.getDateOfBirth());
        return occupantMedicalDetailsService.create(newOccupantMedicalDetails);
    }
}
