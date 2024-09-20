package com.baina.mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baina.mgmt.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
