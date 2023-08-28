package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.result.ResultSetFactory;

import Entity.Categorie;
import Entity.Produit;

public class ProduitDao {

	public static void insererProduit(Produit p) {
		Connection conx=ConnectionTest.TestConnection();
		try {
			Statement st=conx.createStatement();
			long idCat=CategorieDao.getCategorieId(p.getCategorie().getTitle());
			System.out.println(p.getCategorie());
			System.out.println(idCat);
			String query="INSERT INTO `produit`(`nom`, `prix`, `quantite_dispo`, `IdCategorie`, `urlPhoto`) VALUES ('"+p.getNom()+"', "+p.getPrix()+", "+p.getQuantite_dispo()+", "+idCat+",'"+p.getUrlPhoto()+"')";
			 int rowsAffected = st.executeUpdate(query);
	            if (rowsAffected > 0) {
	                System.out.println("Product added successfully.");
	            } else {
	                System.out.println("Failed to added product.");
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateProduit(Produit p) {
        Connection conx = ConnectionTest.TestConnection();
        try {
            Statement st = conx.createStatement();
            long idCat=CategorieDao.getCategorieId(p.getCategorie().getTitle());
			System.out.println(p.getCategorie());
			System.out.println(idCat);;
            String query = "UPDATE `produit` SET `nom` = '" + p.getNom() + "', `prix` = " + p.getPrix() + ", `quantite_dispo` = " + p.getQuantite_dispo() + ", `IdCategorie` = " + idCat + ",`urlPhoto`='"+p.getUrlPhoto()+"' WHERE `idProduit` = " + p.getIdProduit();
            int rowsAffected = st.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Failed to update product.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public static void delete(long idProduit)
	{
        Connection co = ConnectionTest.TestConnection();
		try {
			Statement st=co.createStatement();
			st.executeUpdate("DELETE FROM produit WHERE `idProduit`="+idProduit);
			System.out.println("Product has been delated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Produit findProduct(long idProduit)
	{
		Connection co = ConnectionTest.TestConnection();
		Produit p=null;
		try {
			Statement st=co.createStatement();
			ResultSet resultat= st.executeQuery("SELECT * FROM produit WHERE `idProduit`="+idProduit);
			while(resultat.next())
			{
				long id=resultat.getLong("idProduit");
				String nom=resultat.getString("nom");
				long prix=resultat.getLong("prix");
				int qt_dispo=resultat.getInt("quantite_dispo");
				long idCat=resultat.getInt("IdCategorie");
				Categorie C=CategorieDao.getCategorieById(idCat);
				String url=resultat.getString("urlPhoto");
			 p=new Produit(id, nom, prix, qt_dispo,url,C);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	public static List<Produit> selectAll()
	{
		List<Produit> produits=new ArrayList<>();
        Connection co = ConnectionTest.TestConnection();
		try {
			Statement st=co.createStatement();
			ResultSet resultat= st.executeQuery("SELECT DISTINCT* FROM `produit` p INNER JOIN categorie c ON p.`IdCategorie`=c.idCategorie ORDER By `idProduit`ASC;");
			while(resultat.next())
			{
				long id=resultat.getLong("idProduit");
				String nom=resultat.getString("nom");
				long prix=resultat.getLong("prix");
				int qt_dispo=resultat.getInt("quantite_dispo");
				long idCat=resultat.getInt("IdCategorie");
				String titleCat=resultat.getString("Title");
				String url=resultat.getString("urlPhoto");
				Categorie C=new Categorie(idCat,titleCat);
				Produit p=new Produit(id, nom, prix, qt_dispo,url,C);
				produits.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produits;
		
	}
	

}
