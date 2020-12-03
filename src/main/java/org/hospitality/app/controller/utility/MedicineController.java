package org.hospitality.app.controller.utility;

import org.hospitality.app.entity.utility.Medicine;
import org.hospitality.app.factory.utility.MedicineFactory;
import org.hospitality.app.service.utility.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hospitality_db/medicine")

public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @PostMapping("/create")
    public Medicine create(@RequestBody Medicine medicine) {
        Medicine newMedicine = MedicineFactory.createMedicine(medicine.getMedicineID());
        return medicineService.create(newMedicine);
    }

    @GetMapping("/update")
    public Medicine update(@RequestBody Medicine s)
    {
        return medicineService.update(s);
    }

    @GetMapping("/read/{medicineId}")
    public Medicine read(@PathVariable String medicineId)
    {
        return medicineService.read(medicineId);
    }

    @GetMapping("/all")
    public Set<Medicine> getAll(){
        return medicineService.getAll();
    }

    @DeleteMapping("/delete/{medicineId}")
    public boolean delete(@PathVariable String medicineId)
    {
        return medicineService.delete(medicineId);
    }
}
