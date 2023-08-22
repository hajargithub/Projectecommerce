package Entity;

public class Ligne_Panier {
	private long idLP;
	private int quantite;
	private Panier Pr;
	private Produit P;
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Panier getPr() {
		return Pr;
	}
	public void setPr(Panier pr) {
		Pr = pr;
	}
	public Produit getP() {
		return P;
	}
	public void setP(Produit p) {
		P = p;
	}
	public long getIdLP() {
		return idLP;
	}
	
	

}
