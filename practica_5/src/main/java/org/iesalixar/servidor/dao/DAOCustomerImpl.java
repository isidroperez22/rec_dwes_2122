package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Customer;


public class DAOCustomerImpl implements DAOCustomer {

	public DAOCustomerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {

		ArrayList<Customer> customerList = new ArrayList<>();
		Connection con = null;
		
		try {
			PoolDB pool = new PoolDB();
			String sql = "select * from customers";
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Customer customer = new Customer();
				
				customer.setCustomerNumber(rs.getInt("customerNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setContactFirstName(rs.getString("contactFirstName"));
				customer.setContactLastName(rs.getString("contactLastName"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddressLine1(rs.getString("addressLine1"));
				customer.setAddressLine2(rs.getString("addressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPostalCode(rs.getString("postalCode"));
				customer.setCountry(rs.getString("country"));
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
				customer.setCreditLimit(rs.getDouble("creditLimit"));
				
				customerList.add(customer);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return customerList;

	}

	@Override
	public Customer getCustomer(String customerName) {
		Connection con = null;
		PoolDB pool = new PoolDB();
		Customer customer = new Customer();
		try {
			String sql = "select c.customerName, sum(amount) as total, count(p.amount) as pedidos from customers c inner join pedidos p on c.customerNumber = p.customerNumber where customerName = ?";
			PreparedStatement statement = pool.getConnection().prepareStatement(sql);
			statement.setString(1, customerName);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				
				customer.setCustomerName(rs.getString(customerName));
						
				
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			}
		
		return customer;
	}

	@Override
	public boolean insertCustomer(Customer customer) {
		int resultado=0;
		Connection con = null;
		
		try {

			String sql = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, customer.getCustomerNumber());
			statement.setString(2, customer.getCustomerName());
			statement.setString(3, customer.getContactFirstName());
			statement.setString(4, customer.getContactLastName());
			statement.setString(5, customer.getPhone());
			statement.setString(6, customer.getAddressLine1());
			statement.setString(7, customer.getAddressLine2());
			statement.setString(8, customer.getCity());
			statement.setString(9, customer.getState());
			statement.setString(10, customer.getPostalCode());
			statement.setString(11, customer.getCountry());
			statement.setInt(12, customer.getSalesRepEmployeeNumber());
			statement.setDouble(13, customer.getCreditLimit());

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