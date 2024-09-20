package com.baina.mgmt.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baina.mgmt.dto.ProductDto;
import com.baina.mgmt.entity.Product;
import com.baina.mgmt.exception.ResourceNotFoundException;
import com.baina.mgmt.repository.ProductRepository;
import com.baina.mgmt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductDto addProduct(ProductDto productDto) {
		
		final Product product = mapper.map(productDto, Product.class);
		
		Product save = productRepository.save(product);
		
		return mapper.map(save, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		
		List<ProductDto> productsDtos = productRepository.findAll().stream().map((product)->mapper.map(product, ProductDto.class)).collect(Collectors.toList());
		
		return productsDtos;
	}

	@Override
	public ProductDto updateProduct(int id, ProductDto productDto) {
		
		Product prod=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("given product not found in our DB :"+id));
		
		prod.setCategory(productDto.getCategory());
		prod.setCompany(productDto.getCompany());
		prod.setName(productDto.getName());
		prod.setPrice(productDto.getPrice());
		
		return mapper.map(productRepository.save(prod), ProductDto.class);
	}

	@Override
	public String deleteProduct(int id) {

		Product prod=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("given product not found in our DB :"+id));
		productRepository.delete(prod);
		
		return "product with id : "+id+" deleted succesfully";
		
	}

	@Override
	public ProductDto getProduct(int id) {
		
		Product prod=productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("given product not found in our DB :"+id));
		return mapper.map(prod, ProductDto.class);
	}

}
