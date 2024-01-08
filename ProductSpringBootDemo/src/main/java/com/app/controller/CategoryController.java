package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CategoryDto;
import com.app.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:3000")

public class CategoryController {

	@Autowired
	private CategoryService catService;
	
	public CategoryController() {
		System.out.println("In ctor of "+getClass());
	}
	
	@PostMapping
	public CategoryDto addNewCategory(@RequestBody CategoryDto cat)
	{
		System.out.println("In add new cat "+cat);
		return catService.addNewCategory(cat);
	}
	
	@GetMapping
	public List<CategoryDto> listAllCategory()
	{
		System.out.println("Inside list all categories");
		return catService.listAllCategory();
	}
	
	
	
}
