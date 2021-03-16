package com.app.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.metier.CatalogueImpl;
import com.app.metier.Produit;
import com.app.metier.ProduitModele;

/**
 * Servlet implementation class AffichageProduits
 */
@WebServlet("/AffichageProduits")
public class AffichageProduits extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProduitModele pm = new ProduitModele();
		
		CatalogueImpl metier= new CatalogueImpl();
		List<Produit> produits = metier.getAll();
		
		
		pm.setMotCle("");
		pm.setProduits(produits);
		HttpSession maSession = request.getSession();
		maSession.setAttribute("modele", pm);
		
		request.getRequestDispatcher("ProduitsView.jsp").forward(request, response);
	}



}
