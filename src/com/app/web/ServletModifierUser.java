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
 * Servlet implementation class ServletModifier
 */
@WebServlet("/ServletModifierUser")
public class ServletModifierUser extends HttpServlet {
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
			String name = request.getParameter("name");
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			String email = request.getParameter("email");
			String ville = request.getParameter("ville");
			Utilisateur u = (Utilisateur) maSession.getAttribute("user");
			u.setEmail(email);
			u.setLogin(login);
			u.setName(name);
			u.setPass(pass);
			u.setVille(ville);
			GestionUtilisateur gu = new GestionUtilisateur();
			gu.modifier(u);
			request.setAttribute("success", "User updated");
			request.getRequestDispatcher("Bienvenue.jsp").forward(request, response);
		}
	}

}
