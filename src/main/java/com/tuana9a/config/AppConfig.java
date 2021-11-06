package com.tuana9a.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Value("${custom.name}")
    public String CUSTOM_NAME;

    @Value("${file.upload.location}")
    public String FILE_UPLOAD_LOCATION;

}
