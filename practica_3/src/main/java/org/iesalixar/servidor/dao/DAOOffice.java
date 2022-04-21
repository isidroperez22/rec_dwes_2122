package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Office;



public interface DAOOffice {

	public List<Office> getAllOffices();
	public List<Office> getAllOfficesContext();
	
	public Office getOffice(String officeCode);
	
	
}
