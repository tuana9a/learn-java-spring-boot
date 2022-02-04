package com.tuana9a.learnjavaspringboot.controllers.v5;

import com.tuana9a.learnjavaspringboot.entities.Brand;
import com.tuana9a.learnjavaspringboot.services.v5.BrandService5;
import com.tuana9a.learnjavaspringboot.utils.JsonResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v5/brands")
public class BrandController5 extends BaseController5<Brand> {
    public BrandController5(BrandService5 brandService5, JsonResponseUtils jsonResponseUtils) {
        super(brandService5, jsonResponseUtils);
    }
}
