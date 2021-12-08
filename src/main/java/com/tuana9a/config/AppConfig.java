package com.tuana9a.config;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class AppConfig {
    @Value("${custom.name}")
    public String CUSTOM_NAME;

    @Value("${custom.root_folder}")
    public String ROOT_FOLDER;

    public Integer CODE_OK = 1;

    public Integer CODE_NOT_OK = 0;

    public String JWT_TOKEN_NAME = "token";

}
