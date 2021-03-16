package com.app.web;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.metier.GestionUtilisateur;
import com.app.metier.Utilisateur;

/**
 * Servlet implementation class ServletSupprimer
 */
@WebServlet("/ServletSupprimerUser")
public class ServletSupprimerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession=request.getSession(false);
		int id =Integer.parseInt( request.getParameter("id"));
		if (maSession == null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else {
		GestionUtilisateur gu = new GestionUtilisateur();
		gu.supprimer(id);
		if(maSession.getAttribute("admin") ==null) {
		maSession.removeAttribute("user");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
			request.getRequestDispatcher("ServletAffichage").forward(request, response);
		}
	}

}
