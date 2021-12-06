package com.tuana9a.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResourceController {

    @RequestMapping(value = "/application.properties", method = RequestMethod.GET)
    public String application_properties() {
        return "application.properties";
    }

}
