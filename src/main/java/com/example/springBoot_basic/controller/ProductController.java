package com.example.springBoot_basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springBoot_basic.dto.ProductDTO;
import com.example.springBoot_basic.service.ProductServiceImpl;

@Controller
public class ProductController {
	
	@Autowired
	private ProductServiceImpl service;
	//List
	//http://localhost:8081/
	@RequestMapping("/")
	public String indexHome(Model model) {
		
		List<ProductDTO> list = service.listAll();
		model.addAttribute("list",list);
		return "index";  // 타임리프 템플릇 => tmplates/index.html
	}
	
	//insert  버튼   new
	@RequestMapping("/new")
	public String newProductForm(Model model) {
		
		ProductDTO dto =new ProductDTO();
		model.addAttribute("dto", dto);    //th:object="${dto}"
		
		return "new_product";// 타임리프 템플릇 => tmplates/new_product.html
	}
	
	
	//insert버튼 =insert,update
	@RequestMapping("/save")
	public String saveProduct(@ModelAttribute("dto") ProductDTO dto) {
		//insert : pk 가 존재하이 않을때 insert
		//update : pk 가 존재 할때 해당키의 데이터를 update
		service.save(dto);
		return "redirect:/"; //한번이 마지막에  추가된 후  index.html 리스트 이동
	}
	
	//edit  버튼
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editProductForm(@PathVariable(name="id")int id) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("edit_product");
		ProductDTO dto =service.get(id);
		mav.addObject("dto", dto);
		return mav;  // 타임리프 템플릿 =? templates /edit_product.html

	}

	//delete 버튼
	
	@RequestMapping("/delete/{id}")
	public String deleteProductForm(@PathVariable(name="id")int id) {
		
		service.delete(id);
		return "redirect:/"; // 한건이 삭제된 후 index.html의 리스트 이동 

	}

}
