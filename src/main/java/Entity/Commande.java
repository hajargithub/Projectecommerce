package Entity;

import java.util.Date;

public class Commande {
	private long idCommande;
	private Date created_at;
	private User user;
	
	
	public Commande(long idCommande, Date created_at, User user) {
		super();
		this.idCommande = idCommande;
		this.created_at = created_at;
		this.user = user;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getIdCommande() {
		return idCommande;
	}

}
