package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long id) {
        return this.categoryRepository.findById(id).get();
    }

    @Override
    public Category saveCategory(Category category) throws IOException {
        return this.categoryRepository.save(category);
    }
    @Override
    public void deleteCategory(Long id) {
        this.categoryRepository.deleteById(id);
    }
}
