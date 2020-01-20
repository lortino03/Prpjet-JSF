package managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import entities.Produits;
import metier.ProduitMetier;

public class ProduitsManagBean {

	private Produits produit = new Produits();
	private ProduitMetier metier = new ProduitMetier();
	Produits p = new Produits();
	private List<Produits> produits = new ArrayList<>();
	private ProduitMetier service;
	private List<String> images;


	public ProduitsManagBean() {
		produit = new Produits();
		produits=new ArrayList<Produits>();
		metier = new ProduitMetier();
		images= new ArrayList<>();
		
			for( int i =1; i<5; i++) {
				images.add("prod"+i+".jpg");
			}
		

			
	}

					public ProduitMetier getMetier() {
						return metier;
					}
				
					public void setMetier(ProduitMetier metier) {
						this.metier = metier;
					}
				
					public Produits getP() {
						return p;
					}
				
					public void setP(Produits p) {
						this.p = p;
					}
				
					public List<Produits> getProduits() {
						return metier.afficher();
					}
				
					public void setProduits(List<Produits> produits) {
						this.produits = produits;
					}
				
					public ProduitMetier getService() {
						return service;
					}
				
					public void setService(ProduitMetier service) {
						this.service = service;
					}
				
				
					public List<String> getImages() {
						return images;
					}
				
					public void setImages(List<String> images) {
						this.images = images;
					}

	public void ajouter() {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "succeed add",
				"code produit:" + produit.getCode() + "Prix du produit:" + produit.getPrix() + "$"));

	}

	public void ajouterproduit() throws IOException {

		metier.ajoutproduits(produit);
		produit = new Produits();
		
		FacesContext fcontex= FacesContext.getCurrentInstance();// on instancie l'obejt facescontex
		ExternalContext externalcontext= fcontex.getExternalContext();
		externalcontext.redirect(externalcontext.getRequestContextPath()+"/listproduit.xhtml");
	}


	
	public Produits getProduit() {
		return produit;
	}

	public void setProduit(Produits produit) {
		this.produit = produit;
	}
	
	
	public ProduitsManagBean(Produits produit, ProduitMetier metier, Produits p, List<Produits> produits,
			ProduitMetier service, List<String> images) {
		super();
		this.produit = produit;
		this.metier = metier;
		this.p = p;
		this.produits = produits;
		this.service = service;
		this.images = images;
	}


}
