package com.app.web;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.metier.CatalogueImpl;
import com.app.metier.Produit;

/**
 * Servlet implementation class ServletRedirectModif
 */
@WebServlet("/ServletRedirectModif")
public class ServletRedirectModif extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		CatalogueImpl metier= new CatalogueImpl();
		Produit p = metier.getProduit(id);
		request.setAttribute("prod", p);
		request.getRequestDispatcher("ModifierProduit.jsp").forward(request, response);
	}


}
