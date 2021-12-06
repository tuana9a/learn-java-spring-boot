package com.tuana9a.controllers;

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
public class FileController {
    @Autowired
    private AppConfig config;

    @LogTime
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<Object> upload(@RequestParam("files") MultipartFile[] files) throws Exception {
        Path folder = Paths.get(config.FILE_UPLOAD_LOCATION);
        for (MultipartFile file : files) {

            if (file == null) continue;

            String name = file.getOriginalFilename();
            name = (name == null ? "unknown.txt" : name);
            Files.copy(file.getInputStream(), folder.resolve(name));
        }
        return ResponseEntity.noContent().build();
    }
}
