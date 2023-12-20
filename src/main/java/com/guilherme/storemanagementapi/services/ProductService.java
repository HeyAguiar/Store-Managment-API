package com.guilherme.storemanagementapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.storemanagementapi.domain.Product;
import com.guilherme.storemanagementapi.dtos.ProductDTO;
import com.guilherme.storemanagementapi.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	public Product createProduct(ProductDTO data) {
		Product newProduct = new Product(data);
		this.saveProduct(newProduct);
		return newProduct;
	}
	
	public void saveProduct(Product product) {
		this.repository.save(product);
	}
	public List<Product> getAll() {
		return this.repository.findAll();
	}
	
	public Optional<Product> findById(Long id) {
		return this.repository.findById(id);
	}
	public void delete(Product product) {
		this.repository.delete(product);
	}

	
}
