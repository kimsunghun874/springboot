package com.example.springBoot_basic.dto;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MVC_PRODUCT_TBL")
public class ProductDTO {

	private int id;
	private String name;
	private String brand;
	private String madein;
	private int price;
	
	
	@Id
	//@GeneratedValue(strategy=GenerationType,IDENTITY) //PK (id)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getMadein() {
		return madein;
	}
	
	public void setMadein(String madein) {
		this.madein = madein;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
}
