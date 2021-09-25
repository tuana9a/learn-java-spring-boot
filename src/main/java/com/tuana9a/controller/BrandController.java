package com.tuana9a.controller;

import com.tuana9a.entities.data.Brand;
import com.tuana9a.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/brands")
public class BrandController extends BaseController<Brand> {
    public BrandController(BrandService brandService){
        super(brandService);
    }
}
