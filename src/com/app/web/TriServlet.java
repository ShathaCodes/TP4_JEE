package com.app.web;

import java.io.IOException;
import java.util.Comparator;
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
 * Servlet implementation class TriServlet
 */
@WebServlet("/TriServlet")
public class TriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tri = request.getParameter("tri");
		HttpSession maSession = request.getSession();
		ProduitModele pm = new ProduitModele();
		
		pm= (ProduitModele) maSession.getAttribute("modele");
		List<Produit> produits = pm.getProduits();
		if(tri.equals("name"))
			produits.sort(Comparator.comparing(Produit::getNomProduit));
		if(tri.equals("price"))
			produits.sort(Comparator.comparing(Produit::getPrix));
		
		pm.setMotCle("");
		pm.setProduits(produits);
		maSession.setAttribute("modele", pm);
		
		request.getRequestDispatcher("ProduitsView.jsp").forward(request, response);
	}

	
}
