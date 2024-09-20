package com.baina.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baina.mgmt.dto.ProductDto;
import com.baina.mgmt.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
		return ResponseEntity.ok(productService.addProduct(productDto));
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable int id){
		return ResponseEntity.ok(productService.getProduct(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable int id,@RequestBody ProductDto productDto){
		return ResponseEntity.ok(productService.updateProduct(id, productDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		return ResponseEntity.ok(productService.deleteProduct(id));
	}
	

}
