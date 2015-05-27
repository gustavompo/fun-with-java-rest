package com.avenuecode.jchallenge.dao;

import java.util.List;

import com.avenuecode.jchallenge.domain.Product;


public class ProductDaoImpl extends PagedDao<Product> implements ProductDao{
	
	@Override
	public List<Product> listProducts(int limit, int offset) {
		return list(limit, offset);
	}

	@Override
	public Product getProduct(int productId) {
		return get(productId);
	}
	
	@Override
	public int saveProduct(Product product) {
		return save(product);
	}
	
	@Override
	public void updateProduct(Product product) {
		update(product);
	}

}
