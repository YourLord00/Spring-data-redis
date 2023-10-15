package com.jkhan.redis;

import com.jkhan.redis.entity.Product;
import com.jkhan.redis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringDataRedisApplication {

	@Autowired
	private ProductDao productDao;

	@PostMapping
	public Product save(@RequestBody Product product) {
		return productDao.save(product);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id) {
		return productDao.findProductById(id);
	}


	@PostMapping("delete/{id}")
	public String  removeProduct(@PathVariable int id) {
		return productDao.deleteProduct(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisApplication.class, args);
	}

}
