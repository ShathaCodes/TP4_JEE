package com.app.metier;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.Utilitaire;


public class CatalogueImpl implements ICatalogue {
	@Override
	public List<Produit> getProduitsParMotCle(String mc) { 
		List<Produit> prods= new ArrayList<Produit>();
		Connection conn=Utilitaire.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from PRODUITS where NOM_PRODUIT LIKE ?");
			ps.setString(1, "%"+mc+"%"); ResultSet rs = ps.executeQuery(); while (rs.next()) {
				Produit p = new Produit(); p.setIdProduit(rs.getLong("ID_PRODUIT")); p.setNomProduit(rs.getString("NOM_PRODUIT")); p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				prods.add(p);
				}
		} catch (SQLException e) { e.printStackTrace();
		}
		return prods;
		}
	@Override
	public List<Produit> getAll() { 
		List<Produit> prods= new ArrayList<Produit>();
		Connection conn=Utilitaire.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from `produits`");
			 ResultSet rs = ps.executeQuery();
			 while (rs.next()) {
				Produit p = new Produit(); p.setIdProduit(rs.getLong("ID_PRODUIT")); p.setNomProduit(rs.getString("NOM_PRODUIT")); p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				prods.add(p);
				}
		} catch (SQLException e) { e.printStackTrace();
		}
		return prods;
		}
	@Override
	public Produit getProduit(Long id) { 
		Produit p = null;
		Connection conn=Utilitaire.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("select * from PRODUITS where ID_PRODUIT=?");
			ps.setLong(1,id);
			ResultSet rs = ps.executeQuery(); while (rs.next()) {
				 p= new Produit(); p.setIdProduit(rs.getLong("ID_PRODUIT")); p.setNomProduit(rs.getString("NOM_PRODUIT")); p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));

				}
		} catch (SQLException e) { e.printStackTrace();
		}
		return p;
		}
	@Override
	public void addProduit(Produit p) {
		Connection conn=Utilitaire.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("insert into `produits` (NOM_PRODUIT,PRIX,QUANTITE) values(?,?,?)");
			ps.setString(1,p.getNomProduit()); ps.setDouble(2,p.getPrix());ps.setInt(3,p.getQuantite());
			ps.executeUpdate();
			} catch (SQLException e2) { e2.printStackTrace();
			}		}
	@Override
	public void deleteProduit(int id) {
		Connection conn=Utilitaire.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from `produits` where ID_PRODUIT=? ");
			ps.setLong(1,id);
			ps.executeUpdate();
			} catch (SQLException e2) { e2.printStackTrace();
			}				}
	@Override
	public void updateProduit(Produit p) {
		Connection conn=Utilitaire.getConnection();
		try {
			PreparedStatement ps= conn.prepareStatement("update `produits` set NOM_PRODUIT=?, PRIX=?, QUANTITE=? where ID_PRODUIT=? ");
			ps.setString(1,p.getNomProduit()); ps.setDouble(2,p.getPrix());ps.setInt(3,p.getQuantite());
			ps.setLong(4,p.getIdProduit());
			ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		}
		}
	}