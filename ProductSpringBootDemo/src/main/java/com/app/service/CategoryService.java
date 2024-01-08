package com.app.service;


import java.util.List;

import com.app.dto.CategoryDto;

public interface CategoryService {

	CategoryDto addNewCategory(CategoryDto cat);
	List<CategoryDto> listAllCategory();
}
