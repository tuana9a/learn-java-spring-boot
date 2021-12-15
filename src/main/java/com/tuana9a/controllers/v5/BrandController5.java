package com.tuana9a.controllers.v5;

import com.tuana9a.entities.Brand;
import com.tuana9a.service.v5.BrandService5;
import com.tuana9a.utils.JsonResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v5/brands")
public class BrandController5 extends BaseController5<Brand> {
    public BrandController5(BrandService5 brandService5, JsonResponseUtils jsonResponseUtils) {
        super(brandService5, jsonResponseUtils);
    }
}
