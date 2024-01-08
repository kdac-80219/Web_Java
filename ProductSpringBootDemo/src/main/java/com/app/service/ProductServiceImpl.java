package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CategoryDao;
import com.app.dao.ProductDao;
import com.app.dto.CategoryDto;
import com.app.dto.ProductDto;
import com.app.entities.Category;
import com.app.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao prodDao;
	
	@Autowired
	private CategoryDao catDao;
	
	@Autowired
	private ModelMapper mapper;
	
	
		
	@Override
	public List<Product> getAllProducts() {
		return prodDao.findAll();
	}
	
	@Override
	public ProductDto addProductDetails(Long CategoryId,ProductDto dto) {
		
		Category cat = catDao.findById(CategoryId).orElseThrow(()->new ResourceNotFoundException("INVALID DEPT ID!!!!!!"));
		
		Product prod = mapper.map(dto,Product.class);
		prod.setProdCategory(cat);
		Product product2 = prodDao.save(prod);
		
		return mapper.map(product2,ProductDto.class);
	}
	
	@Override
	public List<ProductDto> findProductByCategoryId(Long CategoryId) {

		return	 prodDao.findByProdCategoryId(CategoryId)
					   .stream()
					   .map(prod->mapper.map(prod,ProductDto.class))
					   .collect(Collectors.toList());
	}
	
	@Override
	public String deleteProductById(Long prodId) {
		String msg = "Product not found!!!";
		if(prodDao.existsById(prodId))
		{
			prodDao.deleteById(prodId);
			msg = "product deleted!!!!";
			return msg;
		}
		
		return msg;
	}
	
	@Override
	public String updateProductById(Long prodId,ProductDto proddto) {
		String msg = "Product not found!!!";
		
			Product pd = prodDao.findById(prodId).orElseThrow(()->new ResourceNotFoundException("Product Not found!!!") );
			pd.setPrice(proddto.getPrice());
			mapper.map(prodDao.save(pd),Product.class);
			msg = "Product Updated!!!";
		return msg;
	}
	
	@Override
	public String deleteProductByName(String name) {

		String msg = "Product not found!!";
		Product pro = prodDao.findByName(name);
		if(pro!=null)
		{
			prodDao.delete(pro);
			msg="Product Deleted!!!";
			return msg;
		}
		return msg;
	}

}
