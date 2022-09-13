package com.demo_spring1.demo.controller;

import com.demo_spring1.demo.model.Product;
import com.demo_spring1.demo.model.ResponseObject;
import com.demo_spring1.demo.repository.ProductRepository;
import com.demo_spring1.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "api/v1/Products")
public class ProductController {
	//DI = Dependency Injection
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ProductService service;
	
	//All List
	@GetMapping("/getAll")
	//localhost:8080/api/v1/Products
	List<Product> getAllProducts() {
		return service.getAllList();
	}
	
	//find by id
	@GetMapping(value = "/{id}")
	ResponseEntity<ResponseObject> findById(@PathVariable Long id){
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
