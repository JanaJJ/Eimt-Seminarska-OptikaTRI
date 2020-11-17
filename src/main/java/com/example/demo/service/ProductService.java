package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product findProductbyId(Long id);
    public void saveProductToDB(MultipartFile file,Long id, String name, String description, Long price);
    List<Product> findAllByBrand(Long brandId);
    List<Product> findAllByCategory(Long categoryId);
    Product saveProduct(Product product) ;
    Product updateProduct(Long id,Product product) throws IOException;
    void deleteProduct(Long id);

}
