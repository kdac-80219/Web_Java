package com.app.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CategoryDto;
import com.app.dto.ProductDto;
import com.app.entities.Product;
import com.app.service.CategoryService;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")

public class ProductController {

	@Autowired
	private ProductService prodService;
	
	public ProductController() {
		System.out.println("In ctor of "+getClass());
	}
	
	@GetMapping
	public List<Product>getAllProducts()
	{
		return prodService.getAllProducts();
	}
	
	@PostMapping("/{CategoryId}")
	public ProductDto addNewproduct(@PathVariable Long CategoryId,@RequestBody ProductDto prod)
	{
		System.out.println("In add new cat "+prod);
		return prodService.addProductDetails(CategoryId,prod);
	}	
	
	@GetMapping("/{categoryId}")
	public List<ProductDto> getProductsByCategoryId(@PathVariable Long categoryId)
	{
		return prodService.findProductByCategoryId(categoryId);
	}
	
//	@DeleteMapping("/{prodId}")
//	public String deleteProductByProdId(@PathVariable Long prodId)
//	{
//		return prodService.deleteProductById(prodId);
//	}
	
	@DeleteMapping("/{prodName}")
	public String deleteProductByProdId(@PathVariable String prodName)
	{
		return prodService.deleteProductByName(prodName);
	}
	
	@PutMapping("/update/{prodId}")
	public String updateProductPriceById(@PathVariable Long prodId,@RequestBody ProductDto prod)
	{
		return prodService.updateProductById(prodId,prod);
	}
	
	

}