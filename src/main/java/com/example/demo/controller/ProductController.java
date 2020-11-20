package com.example.demo.controller;

import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.BrandService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;


    //vrati home
    @RequestMapping("/")
    public String odviewHomePage(){
        return "Home";
    }
    //vrati home
    @RequestMapping("/home")
    public String viewHomePage(){
        return "Home";
    }
    //vrati about us
    @RequestMapping("/us")
    public String viewAboutUs(){
        return "AboutUs";
    }
    //vrati cart
    @RequestMapping("/cart")
    public String viewCart(){
        return "Cart";
    }

    //vrati gi site proizvodi
    @RequestMapping("/allP")
    public String findAllProducts(Model model){
        List<Product> products=productService.findAllProducts();
        model.addAttribute("listProducts",products);
        return "Allproducts";
    }
    //kreiraj nov produkt
    @RequestMapping("/new")
    public String showNewProduct(Model model){
        Product product=new Product();
        model.addAttribute("product",product);
        List<Category> category =  this.categoryService.findAll();
        model.addAttribute("category",category);
        List<Brand> brand = this.brandService.findAll();
        model.addAttribute("brand",brand);
        return "new_p";
    }
    //zacuvaj produkti
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveForProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);

        return "redirect:/allP";
    }
    //izmeni produkti
    @RequestMapping("/edit/{id}")
    public ModelAndView editNewProduct(Model model, @PathVariable(name="id")Long id){
        ModelAndView mav=new ModelAndView("edit_product");
        Product product=productService.findProductbyId(id);
        mav.addObject("product",product);
        List<Category> category =  this.categoryService.findAll();
        model.addAttribute("category",category);
        List<Brand> brand = this.brandService.findAll();
        model.addAttribute("brand",brand);
        return mav;
    }
    //izbrisi produkti
    @RequestMapping("/delete/{id}")
    public String deleteProducts(@PathVariable(name = "id")Long id)
    {
        productService.deleteProduct(id);
        return "redirect:/allP";
    }
}
