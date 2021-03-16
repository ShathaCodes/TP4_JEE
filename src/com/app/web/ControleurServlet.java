package com.app.web;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.metier.CatalogueImpl;
import com.app.metier.Produit;
import com.app.metier.ProduitModele;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/controleur")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String motCle = request.getParameter("motCle");
		
		ProduitModele pm = new ProduitModele();
		
		CatalogueImpl metier= new CatalogueImpl();
		List<Produit> produits = metier.getProduitsParMotCle(motCle);
		if (produits.isEmpty())
			request.getRequestDispatcher("ArticleInexistant.jsp").forward(request, response);
		else {
		pm.setMotCle(motCle);
		pm.setProduits(produits);
		HttpSession maSession = request.getSession();
		maSession.setAttribute("modele", pm);
		
		Cookie cookie=new Cookie ("cookie", "article recherche existe") ;
		response.addCookie(cookie) ;
		
		request.getRequestDispatcher("ProduitsView.jsp").forward(request, response);
		}
		
	}

}
