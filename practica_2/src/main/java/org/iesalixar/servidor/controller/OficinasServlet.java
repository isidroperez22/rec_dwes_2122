package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOfficeImpl;
import org.iesalixar.servidor.model.Office;

/**
 * Servlet implementation class OficinasServlet
 */
@WebServlet("/OficinasServlet")
public class OficinasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OficinasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOOfficeImpl dao = new DAOOfficeImpl();
		
		String oficina = request.getParameter("oficinas");
		
		request.setAttribute("offices", dao.getAllOffices());
		
		request.setAttribute("oficinas", dao.getOffice(oficina));
		
		request.getRequestDispatcher("/WEB-INF/view/oficinas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("ofi");
		response.sendRedirect(request.getContextPath() + "/Oficinas?oficinas=" + code);
	}

}
