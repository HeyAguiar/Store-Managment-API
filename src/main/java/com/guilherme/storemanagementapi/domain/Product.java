package com.guilherme.storemanagementapi.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guilherme.storemanagementapi.dtos.ProductDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="products")
@Table(name="TB_PRODUCTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Product implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "TB_PRODUCTS, category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private Category category;
	@Column(nullable = false)
	private Date expirationDate;
	@Column(nullable = false)
	private int quantity;
	
	public Product(ProductDTO data) {
		this.name = data.name();
		this.description = data.description();
		this.price = data.price();
		this.category = data.category();
		this.expirationDate = data.expirationDate();
		this.quantity = data.quantity();
	}
	
	public String getFormttedExpirationDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return sdf.format(expirationDate);
	}
}
