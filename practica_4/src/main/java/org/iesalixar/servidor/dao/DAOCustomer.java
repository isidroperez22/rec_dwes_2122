package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Customer;

public interface DAOCustomer {
	
	public ArrayList<Customer> getAllCustomers();
	public Customer getCustomer(String Name);
	public boolean insertCustomer(Customer customer);

}
