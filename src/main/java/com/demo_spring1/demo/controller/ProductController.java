package com.demo_spring1.demo.controller;

import com.demo_spring1.demo.model.Product;
import com.demo_spring1.demo.model.ResponseObject;
import com.demo_spring1.demo.repository.ProductRepository;
import com.demo_spring1.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "manageProduct")
public class ProductController {
    //DI = Dependency Injection
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService service;

    //All List
    @GetMapping(value = "/product_list")
    //localhost:8080/products
    public String getAllProducts(Model model) {
        List<Product> list = service.getAllList();
        model.addAttribute("list", list);
        return "products";
    }

    //find by id
    @GetMapping(value = "/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/insert")
        //Them 1 ban ghi
    ResponseEntity<ResponseObject> insert(@RequestBody Product new_product) {
        return service.insert(new_product);
    }

    @PutMapping("/update/{id}")
        //Sua
    ResponseEntity<ResponseObject> update(@RequestBody Product new_product, @PathVariable Long id) {
        return service.update(new_product, id);
    }

    @DeleteMapping("/delete/{id}")
        //Xoa
    ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
