package Entity;

import java.util.List;

public class Categorie {
private long idCategorie;
private String title;
private List<Produit> produits;

public Categorie( String title) {
	this.title = title;
}

public Categorie(long idCategorie, String title) {
	this.idCategorie = idCategorie;
	this.title = title;
}

@Override
public String toString() {
	return "Categorie [idCategorie=" + idCategorie + ", title=" + title + "]";
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
