package com.example.springBoot_basic.service;

import java.util.List;

import com.example.springBoot_basic.dto.ProductDTO;

public interface ProductService {
	
	public List<ProductDTO> listAll(); // list
	
	public void save(ProductDTO dto);  //insert
	
	
	public ProductDTO get(int id);   //1건 select
	
	
	public void delete(int id);   // 1건 지우기

}
