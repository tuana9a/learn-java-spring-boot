package com.tuana9a.controller.v5;

import com.tuana9a.entities.Brand;
import com.tuana9a.service.BrandServiceV5;
import com.tuana9a.utils.JsonResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/learn/brands")
public class BrandControllerV5 extends BaseControllerV5<Brand> {
    public BrandControllerV5(BrandServiceV5 brandService, JsonResponseUtils jsonResponseUtils) {
        super(brandService, jsonResponseUtils);
    }
}
