package com.app.metier;

import java.util.ArrayList;
import java.util.List;

public class Panier {
	
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	List<Produit> produits = new ArrayList<>();
	
	public List<Produit> getProduits() {
		return produits;
		}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
		}
	public void addProduit(Produit p) {
		this.produits.add(p);
	}
	public void removeProduit(Long id) {
		for (int i =0 ; i<produits.size();i++)
			if(produits.get(i).getIdProduit()==id)
				produits.remove(i);
	}
	public void clearPanier() {
		this.produits = new ArrayList<>();
	}
	
	}
