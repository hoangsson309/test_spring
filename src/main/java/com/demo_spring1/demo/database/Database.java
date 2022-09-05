//package com.demo_spring1.demo.database;
//
//import com.demo_spring1.demo.model.Product;
//import com.demo_spring1.demo.repository.ProductRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Database {
//	private static Logger logger = LoggerFactory.getLogger(Database.class);
//	@Bean
//	CommandLineRunner initDatabase(ProductRepository repository) {
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				Product product1 = new Product("Iphone 11 black", 2019, 14.00d, "");
//				Product product2 = new Product("Iphone 12 pro white", 2020, 17.400d, "");
//				logger.info("insertdata: " +repository.save(product1));
//				logger.info("insertdata: " +repository.save(product2));
//			}
//		};
//	}
//}
