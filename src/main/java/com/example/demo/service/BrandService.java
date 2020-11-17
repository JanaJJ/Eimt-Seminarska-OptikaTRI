package com.example.demo.service;

import com.example.demo.model.Brand;

import java.io.IOException;
import java.util.List;

public interface BrandService {
    List<Brand> findAll();
    Brand findBrandById(Long id);
    Brand saveBrand(Brand brand) throws IOException;
    Brand updateBrand(Brand brand) throws IOException;
    void deleteBrand(Long id);

}
