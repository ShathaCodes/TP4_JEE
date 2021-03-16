package com.app.metier;

import java.util.List; 

public interface ICatalogue {
	public List<Produit> getProduitsParMotCle(String mc);
	public Produit getProduit(Long id);
	public void addProduit(Produit p);
	public void deleteProduit(int id);
	public void updateProduit(Produit P);
	public List<Produit> getAll();
}