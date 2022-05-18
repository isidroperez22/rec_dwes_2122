package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Employee;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(AddCustomerServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOEmployeeImpl dao = new DAOEmployeeImpl();
		
		request.setAttribute("empleados", dao.getAllEmployees());
		
		request.getRequestDispatcher("../WEB-INF/view/admin/addCustomer.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
		String customerName = request.getParameter("customerName");
		String contactLastName = request.getParameter("contactName");
		String contactFirstName = request.getParameter("ContactLastName");
		String phone = request.getParameter("phone");
		String addressLine1 = request.getParameter("address1");
		String addressLine2= request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("State");
		String postalCode = request.getParameter("cp");
		String country = request.getParameter("country");
		int salesRepEmployeeNumber = Integer.parseInt(request.getParameter("employee"));
		Double creditLimit = Double.parseDouble(request.getParameter("credito"));
		
		DAOEmployeeImpl dao = new DAOEmployeeImpl();
		DAOCustomerImpl daoCust = new DAOCustomerImpl();
		
		Employee empleado = new Employee();
		empleado = dao.getEmpleado(salesRepEmployeeNumber);
		
		
		Customer customer = new Customer();
		
		customer.setCustomerName(customerName);
		customer.setCustomerNumber(customerNumber);
		customer.setContactFirstName(contactFirstName);
		customer.setContactLastName(contactLastName);
		customer.setPhone(phone);
		customer.setAddressLine1(addressLine1);
		customer.setAddressLine2(addressLine2);
		customer.setCity(city);
		customer.setState(state);
		customer.setPostalCode(postalCode);
		customer.setCountry(country);
		customer.setSalesRepEmployeeNumber(salesRepEmployeeNumber);
		customer.setCreditLimit(creditLimit);
		
		daoCust.insertCustomer(customer);
		
		logger.log(Level.INFO, "Cliente " + customer.getCustomerName() + " añadido");
		
		response.sendRedirect(request.getContextPath() + "/Home");
	}

}
