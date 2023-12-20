package com.guilherme.storemanagementapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilherme.storemanagementapi.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
