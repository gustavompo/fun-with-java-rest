package com.avenuecode.jchallenge.dao;

import java.util.List;

import com.avenuecode.jchallenge.domain.Product;


public class ProductDaoImpl extends PagedDao<Product> implements ProductDao{
	
	@Override
	public List<Product> listProducts(int first) {
		return list(first);
	}

	@Override
	public Product getProduct(int productId) {
		return (Product)get(productId);
	}
	
	public int saveProduct(Product product) {
		return (int) save(product);
	}

}
