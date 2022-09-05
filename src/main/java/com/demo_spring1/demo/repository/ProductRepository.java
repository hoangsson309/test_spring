package com.demo_spring1.demo.repository;

import com.demo_spring1.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query(value = "select id, product_name,year_debut, price, url_link from Product ", nativeQuery = true)
	List<Product> getAllList();
	
}
