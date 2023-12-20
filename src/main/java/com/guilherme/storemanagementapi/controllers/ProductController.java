package com.guilherme.storemanagementapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.storemanagementapi.domain.Product;
import com.guilherme.storemanagementapi.dtos.ProductDTO;
import com.guilherme.storemanagementapi.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController { 

	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody ProductDTO product) {
		Product newProduct = productService.createProduct(product);
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = this.productService.getAll();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable(value = "id") Long id, @Valid ProductDTO productDTO) {
		Optional<Product> productOptional = productService.findById(id);
		if (!productOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The product was not found.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(productOptional.get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> putProductById(@PathVariable(value = "id") Long id, @Valid ProductDTO productDTO) {
		Optional<Product> productOptional = productService.findById(id);
		if (!productOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The product was not found.");
		}
		Product product = productOptional.get();
		BeanUtils.copyProperties(productDTO, product);
		productService.saveProduct(product);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	@DeleteMapping("{id}") 
	public ResponseEntity<Object> deleteProductById(@PathVariable(value = "id") Long id, @Valid ProductDTO productDTO) {
		Optional<Product> productOptional = productService.findById(id);
		if (!productOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The product was not found.");
		}
		productService.delete(productOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("The product was sucessfuly deleted!");
	}
}
