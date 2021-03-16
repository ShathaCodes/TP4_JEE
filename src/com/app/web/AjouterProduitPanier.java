package com.app.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.metier.CatalogueImpl;
import com.app.metier.Panier;
import com.app.metier.Produit;

/**
 * Servlet implementation class AjouterProduitPanier
 */
@WebServlet("/AjouterProduitPanier")
public class AjouterProduitPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}else {
		Panier panier = (Panier) session.getAttribute("panier");
		if (panier == null) {
			panier = new Panier();
		}
		Long id = Long.parseLong(request.getParameter("id"));
		CatalogueImpl ci = new CatalogueImpl();
		Produit p = ci.getProduit(id);
		if(p.getQuantite()>0) {
		panier.addProduit(p);
		session.setAttribute("panier", panier);
		request.setAttribute("success", "The product has been added to your cart!");
		}
		else {
			request.setAttribute("fail", "Insuffisant quantity.");
		}
		request.getRequestDispatcher("AffichageProduits").forward(request, response);
		//response.sendRedirect("/TP4_JEE/AffichageProduits");
		}
	}


}
