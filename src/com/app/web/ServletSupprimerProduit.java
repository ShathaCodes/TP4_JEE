package com.app.web;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.metier.CatalogueImpl;

/**
 * Servlet implementation class ServletSupprimer
 */
@WebServlet("/ServletSupprimerProduit")
public class ServletSupprimerProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt( request.getParameter("id"));
		CatalogueImpl metier= new CatalogueImpl();
		metier.deleteProduit(id);
		request.setAttribute("success", "Product removed successfully");
		response.sendRedirect("/TP4_JEE/AffichageProduits");
	}

}
