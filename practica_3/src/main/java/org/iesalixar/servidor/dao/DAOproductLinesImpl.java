package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.ProductLines;

public class DAOproductLinesImpl implements DAOproductLines {

	@Override
	public List<ProductLines> getCategorias() {
		PoolDB pool = new PoolDB();
		Connection conn = pool.getConnection();
		ArrayList<ProductLines> categoriaList = new ArrayList<>();

		try {

			String sql = "select productline from productlines";
			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				ProductLines productLine = new ProductLines();

				productLine.setProductLine(rs.getString("productLine"));

				categoriaList.add(productLine);

			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return categoriaList;
	}
	
	@Override
	public ProductLines getProductLines(String textDescription, String htmlDescription) {
		
		ProductLines productLines = null;
		
		try {
			PoolDB pool = new PoolDB();
			String sql = "select * from productlines where textDescription = ? and htmlDescription = ?";
			PreparedStatement statement = pool.getConnection().prepareStatement(sql);
			statement.setString(1, textDescription);
			statement.setString(2, htmlDescription);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				productLines = new ProductLines();
				
				productLines.setProductLine(rs.getString("productLine"));
				productLines.setTextDescription(rs.getString("textDescription"));
				productLines.setHtmlDescription(rs.getNString("htmlDescription"));
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			}
		
		return productLines;
	}

	@Override
	public boolean removeProductLines(String productLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProductLines(ProductLines productLines) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertProductLines(String prudctLine, String textDescription, String htmlDescription) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
