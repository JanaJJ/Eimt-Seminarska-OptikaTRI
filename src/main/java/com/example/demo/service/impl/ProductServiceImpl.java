package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findProductbyId(Long id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public void saveProductToDB(MultipartFile file, Long id, String name, String description, Long price) {

    }


    @Override
    public List<Product> findAllByBrand(Long brandId) {
        List<Product> products=this.productRepository.findAll();
        List<Product> productList = new ArrayList<>();
        for(Product p:products){
            if(p.getBrand().getId()== brandId)
            {
                productList.add(p);
            }
        }
        return productList;
    }

    @Override
    public List<Product> findAllByCategory(Long categoryId) {

        List<Product> products=this.productRepository.findAll();
        List<Product> products1 = new ArrayList<>();
        for(Product p:products){
            if(p.getCategory().getId().equals(categoryId))
            {
                products1.add(p);
            }
        }
        return products1;
    }


    @Override
    public Product saveProduct(Product product){

        String slika = product.getImage().toString();
        product.setImage("img/"+slika);

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws IOException {
        return null;
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }
}
