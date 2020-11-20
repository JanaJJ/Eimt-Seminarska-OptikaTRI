package com.example.demo.controller;

import com.example.demo.model.Brand;
import com.example.demo.model.Product;
import com.example.demo.service.BrandService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/brG")
    public String showbyBrandG(Model model){
        List<Product> products=productService.findAllByBrand(1L);
        model.addAttribute("products",products);
        return "Dioptricglasses";
    }

    @RequestMapping("/brB")
    public String showbyBrandB(Model model){
        List<Product> products=productService.findAllByBrand(2L);
        model.addAttribute("products",products);
        return "Dioptricglasses";
    }

    @RequestMapping("/brT")
    public String showbyBrandBT(Model model){
        List<Product> products=productService.findAllByBrand(3L);
        model.addAttribute("products",products);
        return "Dioptricglasses";
    }

    @RequestMapping("/brS")
    public String showbyBrandBS(Model model){
        List<Product> products=productService.findAllByBrand(4L);
        model.addAttribute("products",products);
        return "ChildrenGlasses";
    }
    @RequestMapping("/brL")
    public String showbyBrandBL(Model model){
        List<Product> products=productService.findAllByBrand(5L);
        model.addAttribute("products",products);
        return "ContactLenses";
    }

    ///////////////////////////////////////////////////////////////////////

    @RequestMapping("/brGS")
    public String showbyBrandGSunglasses(Model model){
        List<Product> products=productService.findAllByBrand(1L);
        model.addAttribute("products",products);
        return "Sunglasses";
    }

    @RequestMapping("/brBS")
    public String showbyBrandBSunglasses(Model model){
        List<Product> products=productService.findAllByBrand(2L);
        model.addAttribute("products",products);
        return "Sunglasses";
    }

    @RequestMapping("/brTS")
    public String showbyBrandBTSunglasses(Model model){
        List<Product> products=productService.findAllByBrand(3L);
        model.addAttribute("products",products);
        return "Sunglasses";
    }

}
