package com.mapeak.ecshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mapeak.ecshop.domain.Product;

public interface ProductDao extends JpaRepository<Product, Integer>,
	JpaSpecificationExecutor<Product>{

}
