package metier;

import java.util.List;
import entities.Produits;

public interface IProduitMetier {
	public void ajoutproduits(Produits p);
	public List<Produits> afficher();
}
