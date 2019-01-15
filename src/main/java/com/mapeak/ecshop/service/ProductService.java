package com.mapeak.ecshop.service;

import java.util.List;

import org.apache.logging.log4j.core.config.status.StatusConfiguration.Verbosity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
 
import com.mapeak.ecshop.domain.Product;
 
public interface ProductService {

	//查询所有商品
	public List<Product> findAll();
	
	//分页查询商品
	public Page<Product> findAll(Pageable pageable);
	 
	public Page<Product> findAll(Pageable pageable, Specification<Product> spec);
	
	public void save(Product product);
	
	public Product findById(Integer id);

	public void delete(String ids);
} 
