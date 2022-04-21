package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.lang.reflect.Array;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.model.Reserva;

/**
 * Servlet implementation class ReservarServlet
 */
@WebServlet("/ReservarServlet")
public class ReservarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/reservar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		Reserva reserva = new Reserva();
		
		String[] servicios = request.getParameterValues("checkbox");
		String inicio = request.getParameter("inicio");
		String fin = request.getParameter("fin");
		Integer personas = Integer.parseInt(request.getParameter("personas"));
		
		reserva.setInicio(inicio);
		reserva.setFin(fin);
		reserva.setPersonas(personas);
		reserva.setServicios(servicios);
		
		sesion.setAttribute("reserva", reserva);
		
		sesion.setAttribute( "servicios",servicios);
		sesion.setAttribute( "inicio",inicio);
		sesion.setAttribute( "fin",fin);
		sesion.setAttribute( "personas",personas);
		sesion.setAttribute("longitud", servicios.length);
		
		response.sendRedirect("confirmar");
		
	}

}
