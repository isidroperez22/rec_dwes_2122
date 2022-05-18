package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Product;

public class DAOProductImpl implements DAOProduct {

	@Override
	public ArrayList<Product> getProduct(String categoria) {
		
		ArrayList<Product> productsList = new ArrayList<>();
		Product product;
		Connection con = null;
		
		try {

			String sql = "select * from products where productLine=?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, categoria);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				product = new Product();

				product.setProductCode(rs.getString("productCode"));
				product.setProductName(rs.getString("productName"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getNString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMsrp(rs.getDouble("MSRP"));

				productsList.add(product);
				
			}


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return productsList;
		
	}

	@Override
	public ArrayList<Product> getProductSearch(String searchTerm) {
		
		ArrayList<Product> products = new ArrayList<Product>();
		Product product = null;

		try {
			
			PoolDB pool = new PoolDB();
			String sql = "select * from products where  productName LIKE ? OR productLine LIKE ?";
			PreparedStatement statement = pool.getConnection().prepareStatement(sql);
			statement.setString(1, "%"+searchTerm+"%");
			statement.setString(2, "%"+searchTerm+"%");
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMsrp(rs.getDouble("MSRP"));
				
				products.add(product);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return products;

	}
	
	public String echo() {
		return "echo";
	}

	@Override
	public Product getProductByCode(String code) {
		Product product = null;

		try {
			PoolDB pool = new PoolDB();
			String sql = "select * from products where productCode=?";
			PreparedStatement statement = pool.getConnection().prepareStatement(sql);
			statement.setString(1, code);
			

			ResultSet rs = statement.executeQuery();

			// Como el campo de búsqueda es la clave solo debería obtener un resultado
			// si no es así estaremos machacando cada vez el valor de customer y
			while (rs.next()) {

				product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMsrp(rs.getDouble("MSRP"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return product;

	}

	@Override
	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		
		Connection con = null;
		
		try {
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			String sql = "select * from products";
			PreparedStatement statement = con.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Product product = null;
				
				product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setProductCode(rs.getString("productCode"));
				product.setProductLine(rs.getString("productLine"));
				product.setProductScale(rs.getString("productScale"));
				product.setProductVendor(rs.getString("productVendor"));
				product.setProductDescription(rs.getString("productDescription"));
				product.setQuantityInStock(rs.getInt("quantityInStock"));
				product.setBuyPrice(rs.getDouble("buyPrice"));
				product.setMsrp(rs.getDouble("MSRP"));
				
				products.add(product);

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return products;
	}

	@Override
	public boolean insertProduct(Product product) {
		int resultado=0;
		Connection con = null;
		
		try {

			String sql = "insert into products values(?,?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, product.getProductCode());
			statement.setString(2, product.getProductName());
			statement.setString(3, product.getProductLine());
			statement.setString(4, product.getProductScale());
			statement.setString(5, product.getProductVendor());
			statement.setString(6, product.getProductDescription());
			statement.setInt(7, product.getQuantityInStock());
			statement.setDouble(8, product.getBuyPrice());
			statement.setDouble(9, product.getMsrp());
			
			resultado = statement.executeUpdate();
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		return (resultado==0?false:true);
			
	}
	

}
