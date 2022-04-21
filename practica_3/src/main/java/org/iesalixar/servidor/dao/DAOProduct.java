package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Product;

public interface DAOProduct {
	
	public ArrayList<Product> getProduct(String productName);
	public Product getProductByCode(String code);
	public ArrayList<Product> getProductSearch(String searchTerm);

}
