package com.demo_spring1.demo.service;

import com.demo_spring1.demo.model.Product;
import com.demo_spring1.demo.model.ResponseObject;
import com.demo_spring1.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
	//author: Hoang Nhu Son
	@Autowired
	ProductRepository repository;
	
	public List<Product> getAllList(){
		return repository.getAllList();
	}
	public Product findById(@PathVariable Long id) {
		//De day thong bao loi len giao dien ?
		//Ta phari chuan hoa doi tuong tra ve: data, message, status
		Optional<Product> found_product = repository.findById(id);
		//Optional laf 1 kieu co the null,
		//gia tri tra ve co the null, vaf Optional cho phep ta ktra co du lieu hay ko
		return found_product.isPresent()? found_product.get() : null;
	}
	
	public Product insert(Product new_product) {
		repository.save(new_product);
		return new_product;
	}
	
	public void update(Product new_product, @PathVariable Long id) {
		Optional<Product> product_check_update = repository.findById(id);
		if (product_check_update.isPresent()) {
			product_check_update.map(product -> {
				product.setProduct_name(new_product.getProduct_name());
				product.setYear_debut(new_product.getYear_debut());
				product.setPrice(new_product.getPrice());
				product.setUrl(new_product.getUrl());
				return repository.save(product);
			}).orElseGet(() -> {
				return null;
			});
		}
	}
	
	public void delete(@PathVariable Long id) {
		boolean exits = repository.existsById(id);
		if (exits) {
			repository.deleteById(id);
		}
	}
}
