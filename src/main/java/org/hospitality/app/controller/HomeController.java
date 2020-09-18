package org.hospitality.app.controller;
import org.springframework.boot.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    @RequestMapping({"/","/indexd.xys"})
    String home(){
        return "Hospitality Application running DEMO";
    }
}
