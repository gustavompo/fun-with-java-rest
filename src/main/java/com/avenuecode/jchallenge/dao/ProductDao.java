package com.avenuecode.jchallenge.dao;

import java.util.List;

import com.avenuecode.jchallenge.domain.Product;

public interface ProductDao {

	public List<Product> listProducts(int first);
	public Product getProduct(int productId);
	public int saveProduct(Product product) ;
}
