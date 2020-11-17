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
    @Autowired
    private ProductRepository productRepository;


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
    @RequestMapping(value = "/save/{catId}",method = RequestMethod.POST)
    public String saveForProduct(@ModelAttribute("product") Product product,@PathVariable Long catId){
        productService.saveProduct(product);
        productService.findAllByCategory(catId);

        return "redirect:/home";
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
        return "redirect:/home";
    }

    //////////////////////////////////////////////////////////////////////////
 /*
 @RequestMapping("/brand/{id}")
    public String brand(Model model,@PathVariable String id){

        List<Product> products = this.productService.findAllProducts();
        List<Product> productList = new ArrayList<>();
        for (Product p : products){
            String name = p.getBrand().getName();
            if (name.equals(id) ){
                productList.add(p);
            }
        }
        model.addAttribute("products",productList);
        return "index";
    }

 @RequestMapping("/{brandId}")
    public String showbyBrand(Model model ,@PathVariable Long brandId){
        List<Product> products=productService.findAllByBrand(brandId);
        model.addAttribute("products",products);
        return "index";
    }
    @RequestMapping("/{categoryId}")
    public String showbyCategory(Model model ,@PathVariable Long categoryId){
        Product products=productService.findProductbyId(categoryId);
        model.addAttribute("products",products);
        return "index";
    }


    @RequestMapping("/{id}")
    public String findbyId(Model model ,@PathVariable Long id){
       Product products=productService.findProductbyId(id);
       model.addAttribute("products",products);
        return "index";
    }

    */

}
