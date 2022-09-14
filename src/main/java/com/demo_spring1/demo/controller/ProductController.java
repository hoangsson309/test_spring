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

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
//@RequestMapping(path = "manageProduct")
public class ProductController {
    //DI = Dependency Injection
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService service;

    //All List
    @GetMapping(value = "/products")
    //localhost:8080/products
    public String getAllProducts(Model model) {
        List<Product> list = service.getAllList();
        model.addAttribute("list", list);
        return "products";
    }

    //find by id
//    @GetMapping("/{id}")
//    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
//        return service.findById(id);
//    }

    @GetMapping(value = "/products/new")
    public String showFormAdd(Product product, Model model){
        model.addAttribute("product", product);
        return "new_form";
    }

    @PostMapping(value = "/products/insert")
        //Them 1 ban ghi
    public String insert(Product product, Model model) {
        model.addAttribute("product", product);
        service.insert(product);
        return "redirect:/products";
    }

    @GetMapping(value = "/products/edit/{id}")
    public String showFormEdit(Product product, @PathVariable("id") Long id, Model model){
        model.addAttribute("product", product);
        return "edit_form";
    }

    @PostMapping(value = "/products/update/{id}")
        //Sua
    public String update(Product product, @PathVariable ("id") Long id, Model model) {
        model.addAttribute("product", product);
        service.update(product, id);
        return "redirect:/products";
    }

    @GetMapping(value = "/products/delete/{id}")
        //Xoa
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/products";
    }
}
