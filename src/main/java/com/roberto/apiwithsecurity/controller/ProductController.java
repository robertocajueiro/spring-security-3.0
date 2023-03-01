package com.roberto.apiwithsecurity.controller;

import com.roberto.apiwithsecurity.dto.Product;
import com.roberto.apiwithsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome this endpoint is not secure";
    }

    @GetMapping("/all")
    public List<Product> getAllTheProducts(){
        return service.getProducts();
    }
}
