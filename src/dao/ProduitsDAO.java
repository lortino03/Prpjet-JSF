package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import entities.Produits;
import outils.Connexion;

public class ProduitsDAO implements IProduitsDAO {

	private Session session;

	public ProduitsDAO() {

		session = Connexion.getInstance().getSession();
	}

	public void ajoutproduits(Produits p) {

		Transaction transaction = session.beginTransaction();
		session.persist(p);
		transaction.commit();

	}

	@Override
	public List<Produits> afficher() {
		@SuppressWarnings("unchecked")
		List<Produits> produit = session.createQuery(" from Produits p ").list();
		if (!produit.isEmpty()) {
			System.out.println(produit);
		}
		return produit;

	}

}
