package dao;

import java.util.List;

import entities.Produits;

public interface IProduitsDAO {
	public void ajoutproduits(Produits p);
	public List<Produits> afficher();

}
