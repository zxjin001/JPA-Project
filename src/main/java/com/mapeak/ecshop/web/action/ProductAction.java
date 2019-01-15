package com.mapeak.ecshop.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.mapeak.ecshop.domain.Product;
import com.mapeak.ecshop.service.ProductService;
import com.mchange.v1.db.sql.CBPCursor;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Result;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/product")
public class ProductAction extends ActionSupport implements ModelDriven<Product> {

	private Product product = new Product();

	@Override
	public Product getModel() {
		return product;
	}

	// 接收 startPrice 和 endPrice
	private Double startPrice;
	private Double endPrice;

	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
	}

	public void setEndPrice(Double endPrice) {
		this.endPrice = endPrice;
	}

	// 注入 Service 对象
	@Resource
	private ProductService productService;

	// 查询所有商品
	@Action("list")
	public String list() throws Exception {
		// 查询数据
		List<Product> list = productService.findAll();
		// 把 List 集合转换为 json 数组
		return writeJson(list);
	}

	// 专门把 Java 对象转换为 JSON 字符串
	private String writeJson(Object obj) throws IOException {
		// 使用 fastJSON 工具
		String json = JSON.toJSONString(obj);
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/json;charset=utf-8");
		resp.getWriter().write(json);
		return NONE;
	}

	// 使用属性驱动接收数据
	// 接收 page 和 rows
	private Integer page;
	private Integer rows;

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	// 存储导出的数据
	private Map<String, Object> result = new HashMap<String, Object>();

	@Action("listByPage")
	public String listByPage() throws Exception {
		// 创建 Pageable 对象
		Pageable pageable = new PageRequest(page - 1, rows);

		// 使用 Spring Data JPA 提供 Specification 封装条件数据
		Specification<Product> spec = new Specification<Product>() {
			@Override
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

				List<Predicate> list = new ArrayList<Predicate>();

				// 名称
				if (product.getName() != null && !product.getName().trim().equals("")) {
					list.add(cb.like(root.get("name").as(String.class), "%" + product.getName() + "%"));
				}
				// 开始现价
				if (startPrice != null) {
					list.add(cb.ge(root.get("currentPrice").as(Double.class), startPrice));
				}
				// 结束现价
				if (endPrice != null) {
					list.add(cb.le(root.get("currentPrice").as(Double.class), endPrice));
				}

				Predicate[] array = new Predicate[list.size()];
				return cb.and(list.toArray(array));
			}
		};

		// 分页查询
		Page<Product> page = this.productService.findAll(pageable, spec);
		// 当前页显示数据
		List<Product> list = page.getContent();
		// 总记录数
		long count = page.getTotalElements();
		// 发送给 datagrid 显示
		result.put("rows", list);
		result.put("total", count);

		return writeJson(result);
	}
 
	@Action("save")
	public String save() throws Exception {
		try {
			this.productService.save(product);
			result.put("success", true);
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("success", false);
			result.put("msg", ex.getMessage());
		}
		return writeJson(result);
	}
	
	@Action("findById")
	public String findById() throws Exception{
	    Product pro = this.productService.findById(product.getId());
	    return  writeJson(pro);
	}
	
	//接收 ids
	private String ids;
	public void setIds(String ids){
		this.ids = ids;
	}
	 
	@Action("delete")
	public String delete() throws Exception{
		try {
			this.productService.delete(ids);
			result.put("success", true);
		} catch (Exception ex) {
			ex.printStackTrace();
			result.put("success", false);
			result.put("msg", ex.getMessage());
		}
		return writeJson(result);
	}

}
