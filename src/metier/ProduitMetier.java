package metier;


import java.util.List;

import dao.ProduitsDAO;

import entities.Produits;

public class ProduitMetier implements IProduitMetier{
	
	private ProduitsDAO dao=new ProduitsDAO();

	@Override
	public void ajoutproduits(Produits p) {
	dao.ajoutproduits(p);
		
	}

	@Override
	public List<Produits> afficher() {
		return dao.afficher();
	}


				
			

}
