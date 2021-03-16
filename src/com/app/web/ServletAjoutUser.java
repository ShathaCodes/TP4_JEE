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
 * Servlet implementation class ServletAjout
 */
@WebServlet("/ServletAjoutUser")
public class ServletAjoutUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession=request.getSession(false);
		if (maSession == null || maSession.getAttribute("user") == null || maSession.getAttribute("admin") != null)  {
				String login = request.getParameter("login");
				String pass = request.getParameter("pass");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String ville = request.getParameter("ville");
				Utilisateur u = new Utilisateur();
				u.setLogin(login);
				u.setPass(pass); 
				u.setEmail(email); 
				u.setVille(ville);
				u.setName(name);
				GestionUtilisateur gu = new GestionUtilisateur();
				gu.ajouter(u);
				if(maSession.getAttribute("admin") == null)
				request.getRequestDispatcher("index.jsp").forward(request, response);
				else
					request.getRequestDispatcher("ServletAffichage").forward(request, response);
		}
		else  {
			request.getRequestDispatcher("Bienvenue.jsp").forward(request, response);
		}
	}

}
