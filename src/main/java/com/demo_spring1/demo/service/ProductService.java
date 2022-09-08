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
	@Autowired
	ProductRepository repository;
	
	public List<Product> getAllList(){
		return repository.getAllList();
	}
	
	public List<Product> getAllList1(){
		return repository.getAllList();
	}
	
	public ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
		//De day thong bao loi len giao dien ?
		//Ta phari chuan hoa doi tuong tra ve: data, message, status
		Optional<Product> found_product = repository.findById(id);
		//Optional laf 1 kieu co the null,
		//gia tri tra ve co the null, vaf Optional cho phep ta ktra co du lieu hay ko
		return found_product.isPresent() ?
				ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject("Thanh cong", "Thong tin san pham", found_product)
				) :
				ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						new ResponseObject("That bai", "Khong tim thay san pham voi id = " + id
								, null)
				);
	}
	
	public ResponseEntity<ResponseObject> insert(@RequestBody Product new_product) {
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("Thanh cong", "Them thanh cong", repository.save(new_product))
		);
	}
	
	public ResponseEntity<ResponseObject> update(@RequestBody Product new_product, @PathVariable Long id) {
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
		return product_check_update.isPresent() ?
				ResponseEntity.status(HttpStatus.OK).body(
						new ResponseObject("Thanh cong", "Sua thanh cong", "")
				) :
				ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						new ResponseObject("That bai", "Sua that bai vi khong tim thay" +
								" san pham voi id =" + id, "")
				);
	}
	
	public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
		boolean exits = repository.existsById(id);
		if (exits) {
			repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("Thanh cong", "Xoa thanh cong", "")
			);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new ResponseObject("That bai", "Xoa that bai vi khong tim thay id = " +id
						, "")
		);
	}
}
