package com.app.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.app.metier.Panier;


/**
 * Servlet implementation class AjouterProduitPanier
 */
@WebServlet("/SupprimerPanier")
public class SupprimerPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Panier panier = (Panier) session.getAttribute("panier");
		panier.clearPanier();
		session.setAttribute("panier", panier);
		request.getRequestDispatcher("Panier.jsp").forward(request, response);
		
	}


}
