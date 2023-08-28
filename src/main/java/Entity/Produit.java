package Entity;

import java.util.List;

public class Produit {
	private long idProduit;
	private String nom;
	private double prix;
	private int quantite_dispo;
	private String urlPhoto ;
	private Categorie categorie;
	
	public Produit(String nom, double prix, int quantite_dispo,String urlPhoto, Categorie categorie) {
		this.nom = nom;
		this.prix = prix;
		this.quantite_dispo = quantite_dispo;
		this.urlPhoto = urlPhoto;
		this.categorie = categorie;
	}
	public Produit(long idProduit, String nom, double prix, int quantite_dispo, String urlPhoto, Categorie categorie) {
		super();
		this.idProduit = idProduit;
		this.nom = nom;
		this.prix = prix;
		this.quantite_dispo = quantite_dispo;
		this.urlPhoto = urlPhoto;
		this.categorie = categorie;
	}


	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nom=" + nom + ", prix=" + prix + ", quantite_dispo="
				+ quantite_dispo + ", urlPhoto=" + urlPhoto + ", categorie=" + categorie + "]";
	}
	public long getIdProduit() {
		return idProduit;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite_dispo() {
		return quantite_dispo;
	}

	public void setQuantite_dispo(int quantite_dispo) {
		this.quantite_dispo = quantite_dispo;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	


}
