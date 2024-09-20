package com.baina.mgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baina.mgmt.dto.ProductDto;


public interface ProductService {
	
	public ProductDto addProduct(ProductDto productDto);
	
	public List<ProductDto> getAllProducts();
	
	public ProductDto updateProduct(int id,ProductDto productDto);
	
	public String deleteProduct(int id);
	
	public ProductDto getProduct(int id);

}
