package org.hospitality.app.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    @RequestMapping({"/","/index.xys"})
    String home(){
        return "Hospitality Application running DEMO";
    }
}
