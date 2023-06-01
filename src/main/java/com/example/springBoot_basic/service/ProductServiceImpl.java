package com.example.springBoot_basic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBoot_basic.dao.ProductRepository;
import com.example.springBoot_basic.dto.ProductDTO;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository dao;
	
	// list
	@Override
	public List<ProductDTO> listAll() {
		
		return dao.findAll();
	}
	
	//insert :pk 존자히자 않으면 insert
	//update :pk 존재 할때 해당 키와 데이터 update 
	@Override
	public void save(ProductDTO dto) {
		dao.save(dto);
		
		
	}
	 //1건 select
	@Override
	public ProductDTO get(int id) {
		return dao.findById(id).get();
	}
	 // 1건 지우기
	@Override
	public void delete(int id) {
		
		dao.deleteById(id);
	
		
	}

}
