package com.guilherme.storemanagementapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.storemanagementapi.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
