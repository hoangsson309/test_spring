package com.demo_spring1.demo.model;

import javax.persistence.*;

@Entity //chi ra day la 1 thuc the
@Table(name = "Product")
public class Product {
	@Id // khoa chinh
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id tu sinh
	private Long id;
	@Column(name = "product_name")
	private String product_name;
	
	@Column(name = "year_debut")
	private int year_debut;
	@Column(name = "price")
	private Double price;
	@Column(name = "url_link")
	private String url;
	
	public Product() {
	}
	
	public Product(String product_name, int year_debut, Double price, String url) {
		this.product_name = product_name;
		this.year_debut = year_debut;
		this.price = price;
		this.url = url;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public int getYear_debut() {
		return year_debut;
	}
	
	public void setYear_debut(int year_debut) {
		this.year_debut = year_debut;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", product_name='" + product_name + '\'' +
				", year_debut=" + year_debut +
				", price=" + price +
				", url='" + url + '\'' +
				'}';
	}
}
