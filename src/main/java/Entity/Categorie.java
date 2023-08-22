package Entity;

import java.util.List;

public class Categorie {
private long idCategorie;
private String title;
private List<Produit> produits;

public Categorie(long idCategorie, String title, List<Produit> produits) {
	this.idCategorie = idCategorie;
	this.title = title;
	this.produits = produits;
}
public long getIdCategorie() {
	return idCategorie;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public List<Produit> getProduits() {
	return produits;
}
public void setProduits(List<Produit> produits) {
	this.produits = produits;
}
}
