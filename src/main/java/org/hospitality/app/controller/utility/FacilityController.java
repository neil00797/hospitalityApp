package org.hospitality.app.controller.utility;

import org.hospitality.app.entity.utility.Facility;
import org.hospitality.app.factory.utility.FacilityFactory;
import org.hospitality.app.service.utility.impl.FacilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/facility")

public class FacilityController {

    @Autowired
    private FacilityServiceImpl facilityService;

    @PostMapping("/create")
        public Facility create(@RequestBody Facility facility) {
        Facility newFacility = FacilityFactory.createService(facility.getServiceType());
        return facilityService.create(newFacility);
    }

    @GetMapping("/read/{id}")
    public Facility read(@PathVariable String id) {
        return facilityService.read(id);
    }

    @PostMapping("/update")
    public Facility update(@RequestBody Facility f) {
        return facilityService.update(f);
    }

    @GetMapping("/all")
    public Set<Facility> getAll() {
        return facilityService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        facilityService.delete(id);
    }
}