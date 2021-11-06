package com.tuana9a.controller;

import com.tuana9a.aop.LogTime;
import com.tuana9a.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ResourceController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index.html";
    }


}
