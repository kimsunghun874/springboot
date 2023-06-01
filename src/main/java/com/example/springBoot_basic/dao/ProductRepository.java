package com.example.springBoot_basic.dao;

// 플젝 생성시 dependencies에 추가 SQL> spring DATa jpa => 추가 안하면 import 안됨 
import org.springframework.data.jpa.repository.JpaRepository; 

import com.example.springBoot_basic.dto.ProductDTO;

// extends  JpaRepository<DTO,Integer>
public interface ProductRepository extends JpaRepository<ProductDTO , Integer>{

}
