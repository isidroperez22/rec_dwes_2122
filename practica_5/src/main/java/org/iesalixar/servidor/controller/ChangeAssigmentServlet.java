package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.dao.DAOOrderImpl;
import org.iesalixar.servidor.model.Order;

/**
 * Servlet implementation class ChangeAssigmentServlet
 */
@WebServlet("/ChangeAssigmentServlet")
public class ChangeAssigmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAssigmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer orderNumber = Integer.parseInt(request.getParameter("ord"));
		
		DAOCustomerImpl dao = new DAOCustomerImpl();
		DAOOrderImpl daoOrd = new DAOOrderImpl();
		
		request.setAttribute("ord", daoOrd.getOrder(orderNumber));
		request.setAttribute("customer", dao.getAllCustomers());
		
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/changeOrder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerNumber = Integer.parseInt(request.getParameter("cust"));
		Integer orderNumber = Integer.parseInt(request.getParameter("ord"));
		
		DAOOrderImpl dao = new DAOOrderImpl();
		Order order = new Order();
		
		order.setOrderNumber(orderNumber);
		order.setCustomerNumber(customerNumber);
		
		dao.updateOrder(order);
		
		if (dao.updateOrder(order) == true) {
            request.setAttribute("error", "Cliente cambiado correctamente.");

            doGet(request, response);
            return;

        } else {
            request.setAttribute("error", "Error al cambiar de cliente.");

            doGet(request, response);
            return;

        }
		
	}

}
