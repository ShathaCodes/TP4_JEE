package com.app.dao;

import java.sql.*;
import java.util.Vector;

import com.app.metier.Utilisateur; 

public class GestUsersDAO {
	public Utilisateur loadUser(String login, String pass){ 
		Connection conn=Utilitaire.getConnection();
		Utilisateur u=null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from `utilisateurs` where LOGIN=? and PASS=?");
			ps.setString(1,login);
			ps.setString(2,pass);
			ResultSet rsUser=ps.executeQuery();
			if(rsUser.next()){
				u=new Utilisateur();
				u.setIdUser(new Integer(rsUser.getInt("ID_USER")));
				u.setLogin(rsUser.getString("LOGIN"));
				u.setPass(rsUser.getString("PASS")); 
				u.setEmail(rsUser.getString("EMAIL")); 
				u.setVille(rsUser.getString("VILLE"));
				u.setName(rsUser.getString("NAME"));
				}
			} catch (SQLException e) { e.printStackTrace();
			
			}
		return u;
		}
	public void addUser(String l,String p,String n, String e,String v){ 
		Connection conn=Utilitaire.getConnection();
		Utilisateur u=null;
		try {
			PreparedStatement ps=conn.prepareStatement("insert into `utilisateurs` (LOGIN,PASS,NAME,EMAIL,VILLE) values(?,?,?,?,?)");
			ps.setString(1,l); ps.setString(2,p);ps.setString(3,n); ps.setString(4,e); ps.setString(5,v);
			ps.executeUpdate();
			} catch (SQLException e2) { e2.printStackTrace();
			}
		}
	public Vector<Utilisateur> selectAll(){
		Connection conn=Utilitaire.getConnection();
		Vector<Utilisateur> users=new Vector<Utilisateur>();
		Utilisateur u=null; 
		try {
			PreparedStatement ps=conn.prepareStatement("select * from `utilisateurs` ");
			ResultSet rsUser=ps.executeQuery();
			while(rsUser.next()){
				u=new Utilisateur();
				u.setIdUser(new Integer(rsUser.getInt("ID_USER"))); 
				u.setLogin(rsUser.getString("LOGIN"));
				u.setPass(rsUser.getString("PASS")); 
				u.setEmail(rsUser.getString("EMAIL")); 
				u.setVille(rsUser.getString("VILLE"));
				u.setName(rsUser.getString("NAME"));
				users.add(u);
				}
			} catch (SQLException e) { e.printStackTrace();
			}
		return users;
		}
	
	
	
	public void deleteUser(int id) {
		Connection conn=Utilitaire.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from `utilisateurs` where ID_USER=? ");
			ps.setInt(1,id);
			ps.executeUpdate();
			} catch (SQLException e2) { e2.printStackTrace();
			}				}

	public void updateUser(Utilisateur u) {
		Connection conn=Utilitaire.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("update `utilisateurs` set NAME=?, EMAIL=? , VILLE=? , LOGIN=? , PASS=? where ID_USER=? ");
			ps.setString(1,u.getName()); ps.setString(2,u.getEmail());ps.setString(3,u.getVille()); ps.setString(4,u.getLogin()); ps.setString(5,u.getPass());
			ps.setLong(6,u.getIdUser());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		}
		}
	
	}