package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.dao.DAOproductLinesImpl;
import org.iesalixar.servidor.model.Product;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AddProductServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOproductLinesImpl dao = new DAOproductLinesImpl();
		
		request.setAttribute("productLines", dao.getAllProductLines());
		
		request.getRequestDispatcher("/WEB-INF/view/addProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productLine = request.getParameter("productLine");
		String productScale = request.getParameter("productScale");
		String productVendor = request.getParameter("productVendor");
		String productDescription = request.getParameter("productDescription");
		int stock = Integer.parseInt(request.getParameter("stock"));
		Double buyPirce = Double.parseDouble(request.getParameter("buyPrice"));
		Double msrp = Double.parseDouble(request.getParameter("msrp"));
		
		Product product = new Product();
		
		DAOProductImpl dao = new DAOProductImpl();
		
		product.setProductCode(productCode);
		product.setProductName(productName);
		product.setProductLine(productLine);
		product.setProductScale(productScale);
		product.setProductVendor(productVendor);
		product.setProductDescription(productDescription);
		product.setQuantityInStock(stock);
		product.setBuyPrice(buyPirce);
		product.setMsrp(msrp);
		
		if(dao.getProductByCode(productCode) != null) {
			 request.setAttribute("error", "Ya existe es producto");
			 doGet(request, response);
		} else {
			dao.insertProduct(product);
			request.setAttribute("error", "Producto añadido");
			doGet(request, response);
            
		}
		
		
		logger.log(Level.INFO, "Producto " + product.getProductName() + " añadido");
	}

}
