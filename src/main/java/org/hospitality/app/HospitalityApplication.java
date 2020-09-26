package org.hospitality.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HospitalityApplication {

    @RequestMapping({"/","/indexd.xys"})
    String home(){
        return "Hospitality Application running DEMO";
    }

    public static void main (String[]args){
        SpringApplication.run(HospitalityApplication.class, args);
    }
}
