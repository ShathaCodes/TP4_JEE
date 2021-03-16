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
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		if (login != null && pass != null && !login.equals("") && !pass.equals("")) {
			GestionUtilisateur gu = new GestionUtilisateur();
			Utilisateur user = gu.authentifier(login, pass);
			if (user != null) {
				HttpSession maSession = request.getSession(true);
				maSession.setAttribute("user", user);
				if(user.getLogin().equals("admin"))
					maSession.setAttribute("admin", user);
				request.getRequestDispatcher("Bienvenue.jsp").forward(request, response);
			}
			else {
				request.setAttribute("echec", "Connection error ");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}

}
