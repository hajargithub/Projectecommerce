package Entity;

import java.util.List;

public class Panier {
	private long idPanier;
	private List<Ligne_Panier>LigneP;
	public List<Ligne_Panier> getLigneP() {
		return LigneP;
	}
	public void setLigneP(List<Ligne_Panier> ligneP) {
		LigneP = ligneP;
	}
	public long getIdPanier() {
		return idPanier;
	}
	

}
