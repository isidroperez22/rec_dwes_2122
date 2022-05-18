package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOrderDetailsImpl;
import org.iesalixar.servidor.dao.DAOOrderImpl;
import org.iesalixar.servidor.dao.DAOProductImpl;

/**
 * Servlet implementation class CustomerReportServlet
 */
@WebServlet("/CustomerReportServlet")
public class CustomerReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOOrderDetailsImpl dao = new DAOOrderDetailsImpl();
		DAOProductImpl daop = new DAOProductImpl();
		Integer orderNumber = Integer.parseInt(request.getParameter("ord"));
		
		request.setAttribute("ord", request.getParameter("ord"));
		request.setAttribute("od", dao.getDetailsFromOrder(orderNumber));
		
		request.getRequestDispatcher("/WEB-INF/view/orderReport.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
