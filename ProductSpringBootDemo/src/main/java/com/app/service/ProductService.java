package com.app.service;

import java.util.List;

import com.app.dto.ProductDto;
import com.app.entities.Product;

public interface ProductService
{
	ProductDto addProductDetails(Long CategoryId,ProductDto dto);
	List<ProductDto> findProductByCategoryId(Long CategoryId);
	String updateProductById(Long prodId,ProductDto prod);
	String deleteProductById(Long prodId);
	String deleteProductByName(String name);
	List<Product>getAllProducts();
	
}