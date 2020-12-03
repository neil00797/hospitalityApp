package org.hospitality.app.controller.utility;

import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.entity.utility.Service;
import org.hospitality.app.factory.utility.ServiceFactory;
import org.hospitality.app.service.utility.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hospitality_db/service")

public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @PostMapping("/create")
    public Service create(@RequestBody Service service)
    {
        Service newService = ServiceFactory.createService(service.getServiceId());
        return serviceService.create(newService);
    }

    @GetMapping("/read/{serviceId}")
    public Service read(@PathVariable String serviceId)
    {
        return serviceService.read(serviceId);
    }

    @GetMapping("/update")
    public Service update(@RequestBody Service s)
    {
        return serviceService.update(s);
    }

    @GetMapping("/all")
    public Set<Service> getAll()
    {
        return serviceService.getAll();

    }
    @DeleteMapping("/delete/{serviceId}")
    public boolean delete(@PathVariable String serviceId)
    {
        return serviceService.delete(serviceId);
    }
}
