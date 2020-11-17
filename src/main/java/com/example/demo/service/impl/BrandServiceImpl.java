package com.example.demo.service.impl;

import com.example.demo.model.Brand;
import com.example.demo.repository.BrandRepository;
import com.example.demo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public List<Brand> findAll() {
        return this.brandRepository.findAll();
    }

    @Override
    public Brand findBrandById(Long id) {
        return this.brandRepository.findById(id).get();
    }

    @Override
    public Brand saveBrand(Brand brand) throws IOException {
        return this.brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(Brand brand) throws IOException {
        return null;
    }

    @Override
    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);

    }
}
