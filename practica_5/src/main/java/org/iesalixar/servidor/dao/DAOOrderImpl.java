package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Order;
import org.iesalixar.servidor.model.OrderDetail;

public class DAOOrderImpl implements DAOOrder {

	@Override
	public Order getOrder(int orderNumber) {
		Order order = null;
		
		Connection con = null;

		try {
			
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			String sql = "select * from orders where  orderNumber=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, orderNumber);
			

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				order = new Order();
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setRequiredDate(rs.getString("requiredDate"));
				order.setShippedDate(rs.getString("shippedDate"));
				order.setStatus(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getInt("customerNumber"));
								
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return order;
	}

	@Override
	public ArrayList<Order> getAllOrders() {
		ArrayList<Order> orders = new ArrayList<Order>();
		Connection con = null;
		
		try {
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			String sql = "select * from orders";
			PreparedStatement statement = con.prepareStatement(sql);
			
			

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Order order = new Order();
				
				order = new Order();
				order.setOrderNumber(rs.getInt("orderNumber"));
				order.setOrderDate(rs.getString("orderDate"));
				order.setRequiredDate(rs.getString("requiredDate"));
				order.setShippedDate(rs.getString("shippedDate"));
				order.setStatus(rs.getString("status"));
				order.setComments(rs.getString("comments"));
				order.setCustomerNumber(rs.getInt("customerNumber"));
				
				orders.add(order);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return orders;
	}

	@Override
	public boolean updateOrder(Order order) {
		int resultado = 0;
		Connection con=  null;
		PoolDB pool = new PoolDB();
		con = pool.getConnection();
		
		try {
			
			String sql = "update orders set customerNumber = ? where orderNumber = ?";
						
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, order.getCustomerNumber());
			statement.setInt(2, order.getOrderNumber());
						
			resultado = statement.executeUpdate();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
			
			return (resultado == 0 ? false : true);
		
		
	}

}