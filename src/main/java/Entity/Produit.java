package Entity;

import java.util.List;

public class Produit {
	private long idProduit;
	private String nom;
	private double prix;
	private int quantite_dispo;
	private List<String> urlPhotos ;
	private Categorie categorie;
	
	public Produit(long idProduit, String nom, double prix, int quantite_dispo, List<String> urlPhotos,
			Categorie categorie) {
		this.idProduit = idProduit;
		this.nom = nom;
		this.prix = prix;
		this.quantite_dispo = quantite_dispo;
		this.urlPhotos = urlPhotos;
		this.categorie = categorie;
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

	public List<String> getUrlPhotos() {
		return urlPhotos;
	}

	public void setUrlPhotos(List<String> urlPhotos) {
		this.urlPhotos = urlPhotos;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	


}
