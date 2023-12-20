package com.guilherme.storemanagementapi.dtos;

import java.util.Date;

import com.guilherme.storemanagementapi.domain.Category;

public record ProductDTO(String name, String description, double price, Category category, Date expirationDate, int quantity) {

}
