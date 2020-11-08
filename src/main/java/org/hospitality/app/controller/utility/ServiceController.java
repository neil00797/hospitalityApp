package org.hospitality.app.controller.utility;

import org.hospitality.app.entity.utility.Service;
import org.hospitality.app.factory.utility.ServiceFactory;
import org.hospitality.app.service.utility.impl.ServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/service")

public class ServiceController {

    @Autowired
    private ServiceServiceImpl serviceService;

    @PostMapping("/create")
        public Service create(@RequestBody Service service) {
        Service newService = ServiceFactory.createService(service.getServiceType());
        return serviceService.create(newService);
    }

    @GetMapping("/read/{id}")
    public Service read(@PathVariable String id) {
        return serviceService.read(id);
    }

    @PostMapping("/update")
    public Service update(@RequestBody Service service) {
        return serviceService.update(service);
    }

    @GetMapping("/all")
    public Set<Service> getAll() {
        return serviceService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        serviceService.delete(id);
    }
}