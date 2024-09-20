package com.baina.mgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
	private int id;
	
	private String name;
	
	private double price;
	
	private String category;
	
	private String company;



}
