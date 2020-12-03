package org.hospitality.app.controller.utility;

import org.hospitality.app.entity.utility.Ailment;
import org.hospitality.app.factory.utility.AilmentFactory;
import org.hospitality.app.service.utility.AilmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hospitality_db/ailment")
public class AilmentController {
    @Autowired
    private AilmentService ailmentService;

    @PostMapping("/create")
    public Ailment create(@RequestBody Ailment ailment) {
        Ailment newAilment = AilmentFactory.createAilment(ailment.getAilmentID(), ailment.getMedicineId());
        return ailmentService.create(newAilment);
    }

    @GetMapping("/update")
    public Ailment update(@RequestBody Ailment s)
    {
        return ailmentService.update(s);
    }

    @GetMapping("/read/{ailmentId}")
    public Ailment read(@PathVariable String ailmentId)
    {
        return ailmentService.read(ailmentId);
    }

    @GetMapping("/all")
    public Set<Ailment> getAll(){
        return ailmentService.getAll();
    }

    @DeleteMapping("/delete/{ailmentId}")
    public boolean delete(@PathVariable String ailmentId)
    {
        return ailmentService.delete(ailmentId);
    }
}
