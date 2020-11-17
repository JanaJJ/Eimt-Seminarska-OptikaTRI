package com.example.demo.service;


import com.example.demo.model.Brand;
import com.example.demo.model.Category;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findCategoryById(Long id);
    Category saveCategory(Category category) throws IOException;
    void deleteCategory(Long id);



}
