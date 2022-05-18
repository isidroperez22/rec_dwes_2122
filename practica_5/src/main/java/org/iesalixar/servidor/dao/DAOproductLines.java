package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.ProductLines;


public interface DAOproductLines {
	
	public List<ProductLines> getAllProductLines();
	public ProductLines getProductLines(String productLine, String html);
	public boolean removeProductLines(String productLine);
	public boolean updateProductLines(ProductLines productLines);
	public boolean insertProductLines(String prudctLine, String textDescription, String htmlDescription);
}
