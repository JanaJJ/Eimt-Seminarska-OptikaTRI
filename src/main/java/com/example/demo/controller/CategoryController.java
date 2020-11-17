package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.assertj.core.internal.Lists;
import org.assertj.core.util.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    //vrati gi site dioptriski
    @RequestMapping("/dioptric")
    public String viewAllDioptric(Model model){
        List<Product> products=productService.findAllByCategory(2l);
        model.addAttribute("products",products);
        return "Dioptricglasses";
    }

    //vrati gi site za sonce
    @RequestMapping("/sunglasses")
    public String viewAllSunglasses(Model model){
        List<Product> products=productService.findAllByCategory(1l);
        model.addAttribute("products",products);
        return "Sunglasses";
    }

    //vrati gi site za deca
    @RequestMapping("/children")
    public String viewAllChildren(Model model){
        List<Product> products=productService.findAllByCategory(3l);
        model.addAttribute("products",products);
        return "ChildrenGlasses";
    }

    //vrati gi site leki
    @RequestMapping("/lenses")
    public String viewAllLenses(Model model){
        List<Product> products=productService.findAllByCategory(4l);
        model.addAttribute("products",products);
        return "ContactLenses";
    }
}
