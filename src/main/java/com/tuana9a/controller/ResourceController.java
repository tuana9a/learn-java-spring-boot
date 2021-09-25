package com.tuana9a.controller;

import com.tuana9a.aop.LogTime;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${file.upload.location}")
    private String location;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index.html";
    }

    @RequestMapping(value = "/favicon.ico", method = RequestMethod.GET)
    public String favicon() {
        return "avatar.ico";
    }

    @LogTime
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<Object> upload(@RequestParam("files") MultipartFile[] files) throws Exception {
        Path folder = Paths.get(location);
        for (MultipartFile file : files) {
            if (file == null)
                continue;

            String name = file.getOriginalFilename();
            name = (name == null ? "unknown.txt" : name);
            Files.copy(file.getInputStream(), folder.resolve(name));
        }
        return ResponseEntity.noContent().build();
    }
}
