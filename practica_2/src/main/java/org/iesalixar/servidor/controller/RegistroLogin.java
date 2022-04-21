package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class RegistrioLogin
 */
@WebServlet("/RegistrioLogin")
public class RegistroLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/registro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usaurio");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		String email = request.getParameter("email");
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		
		Usuario user = new Usuario();
		DAOUsuarioImpl dao = new DAOUsuarioImpl();
		
		if(dao.getUsuario(usuario) != null) {
			request.setAttribute("error", "Usuario existente");
			doGet(request,response);
			return;
		} else if(!password.equals(confirm)) {
			request.setAttribute("error", "Las contraseñas deben de ser iguales");
			doGet(request,response);
			return;
		} else {
			password = PasswordHashGenerator.hashPassword(password);
			user.setUsuario(usuario);
			user.setPassword(password);
			user.setEmail(email);
			user.setFirstName(first);
			user.setLastName(last);
			user.setRole("usuario");
			
			dao.registerUsuario(user);
			
		}
		response.sendRedirect(request.getContextPath());
		
	}

}
