package com.app.metier;
import java.util.Vector;

import com.app.dao.GestUsersDAO;


public class GestionUtilisateur {
	GestUsersDAO dao;
	public GestionUtilisateur(){
		dao=new GestUsersDAO();
		}
	public Utilisateur authentifier(String login, String pass){
		return dao.loadUser(login, pass);
		}
	public void ajouter(Utilisateur u){
		dao.addUser(u.getLogin(), u.getPass(), u.getName(),u.getEmail(),u.getVille());
		}
	public Vector<Utilisateur> lister(){
		return dao.selectAll();
		}
	public void modifier(Utilisateur u) {
		dao.updateUser(u);
	}
	public void supprimer(Integer i) {
		dao.deleteUser(i);
	}
	}
