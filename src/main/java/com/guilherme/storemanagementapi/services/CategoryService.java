package com.guilherme.storemanagementapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.storemanagementapi.domain.Category;
import com.guilherme.storemanagementapi.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Optional<Category> findById(Long id) {
		return repository.findById(id);
	}
}
