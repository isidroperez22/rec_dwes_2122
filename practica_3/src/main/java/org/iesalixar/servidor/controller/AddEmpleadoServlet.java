package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.dao.DAOOfficeImpl;
import org.iesalixar.servidor.model.Employee;

/**
 * Servlet implementation class AddEmpleadoServlet
 */
@WebServlet("/AddEmpleadoServlet")
public class AddEmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AddEmpleadoServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOEmployeeImpl dao = new DAOEmployeeImpl();
		DAOOfficeImpl daoOffice = new DAOOfficeImpl();
		
		request.setAttribute("empleado", dao.getAllEmployees());
		request.setAttribute("oficina", daoOffice.getAllOffices());
		request.getRequestDispatcher("/WEB-INF/view/addEmpleado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int employeeNumber= Integer.parseInt(request.getParameter("employeeNumber"));
		String lastName= request.getParameter("lastName");
		String firstName= request.getParameter("name");
		String extension= request.getParameter("extension");
		String email= request.getParameter("email");
		String officeCode= request.getParameter("officeCode");
		int reportsTo= Integer.parseInt(request.getParameter("reportsTo"));
		//String jobTitle= request.getParameter("jobTitle");
		
		DAOEmployeeImpl dao = new DAOEmployeeImpl();
		Employee employee = new Employee();
		
		employee.setEmployeeNumber(employeeNumber);
		employee.setLastName(lastName);
		employee.setFirstName(firstName);
		employee.setExtension(extension);
		employee.setEmail(email);
		employee.setOfficeCode(officeCode);
		employee.setReportsTo(reportsTo);
		
		dao.insertEmployee(employee);
			
		logger.log(Level.INFO, "Empleado " + employee.getFirstName() + " añadido");
		
		response.sendRedirect(request.getContextPath() + "/Home");
	}

}
