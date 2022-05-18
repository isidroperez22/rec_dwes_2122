package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.OrderDetail;

public interface DAOOrderDetails {
	
	public ArrayList<OrderDetail> getDetailsFromOrder(int orderNumber);
	
}
