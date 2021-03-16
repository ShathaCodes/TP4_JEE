package com.app.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.metier.GestionUtilisateur;
import com.app.metier.Utilisateur;

/**
 * Servlet implementation class ServletAffichage
 */
@WebServlet("/ServletAffichage")
public class ServletAffichage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession=request.getSession(false);
		if (maSession == null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else {
			Utilisateur user = (Utilisateur) maSession.getAttribute("user");
			if ( user != null) {
				GestionUtilisateur gu = new GestionUtilisateur();
				Vector<Utilisateur> users = gu.lister();
				for(int i=0;i<users.size();i++)
					if(users.get(i).getLogin().equals("admin"))
						users.remove(i);
				request.setAttribute("users", users);
				request.getRequestDispatcher("Affichage.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}


}
