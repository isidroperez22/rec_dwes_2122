package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Employee;

public class DAOEmployeeImpl implements DAOEmployee{

	@Override
	public ArrayList<Employee> getAllEmployees() {
		
		ArrayList<Employee> employeesList = new ArrayList<>();
		Connection con = null;
		try {

			String sql = "select e.employeeNumber, e.firstName, e.lastName, o.city, e.reportsTo, e.jobTitle "
					+ "from employees e inner join offices o ON e.officeCode = o.officeCode";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Employee employee = new Employee();

				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setOfficeCode(rs.getString("city"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));
				
				employeesList.add(employee);
				}
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
			

		return employeesList;
		
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		int resultado=0;
		Connection con = null;
		
		try {

			String sql = "insert into employees values(?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, employee.getEmployeeNumber());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getFirstName());
			statement.setString(4, employee.getExtension());
			statement.setString(5, employee.getEmail());
			statement.setString(6, employee.getOfficeCode());
			statement.setInt(7, employee.getReportsTo());
			statement.setString(8, "becario");

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

	@Override
	public ArrayList<Employee> getAllJefes() {
		ArrayList<Employee> employeesList = new ArrayList<>();
		Connection con = null;
		try {

			String sql = "select e2.lastName,  e2.firstName "
					+ "from employees e1 inner join employees e2 ON e1.employeeNumber = e2.reportsTo";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Employee employee = new Employee();

				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				
				employeesList.add(employee);
				}
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		return employeesList;
	}

	@Override
	public Employee getEmpleado(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getJefe(int code) {
		Employee employee = null;
		Connection con = null;

		try {
			PoolDB pool = new PoolDB();
			String sql = "select * from employees where reportsTo=?";
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, code);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				employee = new Employee();
				
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
			}
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return employee;

	}
	
}
