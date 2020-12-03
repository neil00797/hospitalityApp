package org.hospitality.app.controller.user;

import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.factory.user.OccupantFactory;
import org.hospitality.app.service.user.OccupantService;
import org.hospitality.app.service.user.impl.OccupantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hospitality_db/occupant")
public class OccupantController {
    @Autowired
    private OccupantServiceImpl occupantService;

    @PostMapping("/create")
    public Occupant create(@RequestBody Occupant occupant) {
        Occupant newOccupant = OccupantFactory.createOccupant(occupant.getFirstName(), occupant.getLastName());
        return occupantService.create(newOccupant);
    }

    @GetMapping("/read/{id}")
    public Occupant read(@PathVariable String id){
        return occupantService.read(id);
    }

    @PostMapping("/update")
    public Occupant update(@RequestBody Occupant occupant){
        return occupantService.update(occupant);
    }

    @GetMapping("/all")
    public Set<Occupant> getAll(){
        return occupantService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        occupantService.delete(id);
    }
}
