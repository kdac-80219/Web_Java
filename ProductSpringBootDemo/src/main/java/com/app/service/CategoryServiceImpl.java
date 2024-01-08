package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CategoryDao;
import com.app.dto.CategoryDto;
import com.app.entities.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao catDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CategoryDto addNewCategory(CategoryDto cat) {

		Category category = catDao.save(mapper.map(cat,Category.class));
		return mapper.map(category, CategoryDto.class);
	}
	
	@Override
	public List<CategoryDto> listAllCategory() {
		return catDao.findAll()
				.stream()
				.map(cat->mapper.map(cat,CategoryDto.class))
				.collect(Collectors.toList());
	}
}
