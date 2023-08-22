package Entity;

public class Ligne_Commande {
	private long idC;
	private int quantite;
	private double prix_total;
	private Produit P;
	private Commande C;
	public Ligne_Commande(long idC, int quantite, double prix_total, Produit p, Commande c) {
		super();
		this.idC = idC;
		this.quantite = quantite;
		this.prix_total = prix_total;
		P = p;
		C = c;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix_total() {
		return prix_total;
	}
	public void setPrix_total(double prix_total) {
		this.prix_total = prix_total;
	}
	public Produit getP() {
		return P;
	}
	public void setP(Produit p) {
		P = p;
	}
	public Commande getC() {
		return C;
	}
	public void setC(Commande c) {
		C = c;
	}
	public long getIdC() {
		return idC;
	}
	

}
