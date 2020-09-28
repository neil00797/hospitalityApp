package org.hospitality.app.controller.utility;

import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.factory.user.StayInformationFactory;
import org.hospitality.app.service.utility.StayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

public class StayInformationController
{

        @Autowired
        private StayInfoService stayInformationService;

        @PostMapping("/create")
        public StayInformation create(@RequestBody StayInformation stayInformation)
        {
            StayInformation newStayInformation = StayInformationFactory.createStayInformation(stayInformation.getStayDuration());
            return stayInformationService.create(newStayInformation);
        }

        @GetMapping("/read/{stayDuration}")
        public StayInformation read(@PathVariable String stayDuration)
        {
            return stayInformationService.read(stayDuration);
        }

        @GetMapping("/update")
        public StayInformation update(@RequestBody StayInformation s)
        {
            return stayInformationService.update(s);
        }


        @DeleteMapping("/delete/{stayDuration}")
        public boolean delete(@PathVariable String stayDuration)
        {
            return stayInformationService.delete(stayDuration);
        }


        @GetMapping("/all")
        public Set<StayInformation> getAll()
        {
            return stayInformationService.getAll();

        }
}

