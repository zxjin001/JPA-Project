package com.mapeak.ecshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapeak.ecshop.dao.ProductDao;
import com.mapeak.ecshop.domain.Product;
import com.mapeak.ecshop.service.ProductService;

@Service
@Transactional  //添加事务管理
public class ProductServiceImpl implements ProductService {
 
	//注入 DAO 对象
	@Resource
	private ProductDao dao;

	@Override
	public void delete(String ids) {
		if (ids != null && !ids.equals("")) {
			String[] idArray = ids.split(",");
			for (String id : idArray) {
				dao.delete(Integer.parseInt(id));
			}
		}
	}
 
	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Page<Product> findAll(Pageable pageable, Specification<Product> spec) {
		return dao.findAll(spec, pageable);
	}

	@Override
	public void save(Product product) {
		dao.save(product);
	}

	@Override
	public Product findById(Integer id) {
		return dao.findOne(id);
	}

}
