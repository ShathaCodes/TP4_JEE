package com.app.web;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.metier.CatalogueImpl;
import com.app.metier.Produit;

/**
 * Servlet implementation class ServletModifier
 */
@WebServlet("/ServletModifierProduit")
public class ServletModifierProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession=request.getSession(false);
		if (maSession == null || maSession.getAttribute("admin") == null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else {
		String nom = request.getParameter("name");
		double prix =Double.parseDouble( request.getParameter("prix"));
		int quantite =Integer.parseInt( request.getParameter("quant"));
		Long id = Long.parseLong(request.getParameter("id"));
		Produit p = new Produit(nom,prix,quantite);
		p.setIdProduit(id);
		CatalogueImpl metier= new CatalogueImpl();
		metier.updateProduit( p);
		request.setAttribute("success", "Produit modifié avec succes");
		response.sendRedirect("/TP4_JEE/AffichageProduits");
		}
	}

}
