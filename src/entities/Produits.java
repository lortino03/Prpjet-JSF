package entities;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Produits")

public class Produits {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prod")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prix")
	private float prix;
	
	@Column(name="date")
	private Date date;

						// Constructeurs
	public Produits() {

	}
	

	public Produits(String code, String nom, float prix, Date date) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.date = date;
	}
	
							// Getters  /setters


						public int getId() {
							return id;
						}
					

						public void setId(int id) {
							this.id = id;
						}
					
						public String getCode() {
							return code;
						}
					
						public void setCode(String code) {
							this.code = code;
						}
					
						public String getNom() {
							return nom;
						}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
								 
									// toString
			@Override
			public String toString() {
				return "Produits [id=" + id + ", code=" + code + ", nom=" + nom + ", prix=" + prix
						+ ", date=" + date + "]";
			}


}
