package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Categorie;
import Entity.Produit;


public class CategorieDao {
	public static void AjouterCategorie(Categorie E)
	{
		 Connection c =	ConnectionTest.TestConnection();
		 
		 //System.out.println(c);
			//Statement  st=null;
			
			  try{ Statement st = c.createStatement();
			  System.out.println("statement ok");
			//  System.out.println(E.getFiliere());
				ResultSet res= st.executeQuery("select * from categorie where Title ='"+E.getTitle()+"'");
			
				if(res.next()) {
	               		System.out.println("can't insert the categorie bcs already exist");		
				}else {
				 st.executeUpdate("INSERT INTO `categorie` (`Title`) VALUES ('"+E.getTitle()+"')"); 
			      System.out.println("ok");	
				}

			  }catch(SQLException e) { e.printStackTrace();
			  
			  }    
	}
	 public static long InsererCategorie(Categorie E) {
	        Connection c = ConnectionTest.TestConnection();
	        long generatedId = -1;  // Default value in case of failure
	        try {
	            String query = "INSERT INTO categorie (Title) VALUES ('" + E.getTitle() + "')";
	            Statement st = c.createStatement();
	            int affectedRows = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
	            if (affectedRows > 0) {
	                try (ResultSet generatedKeys = st.getGeneratedKeys()) {
	                    if (generatedKeys.next()) {
	                    	// Get the generated idCategorie
	                        generatedId = generatedKeys.getLong(1);    
	                    }
	                }
	                
	                System.out.println("Category added successfully. Generated ID: " + generatedId);
	            } else {
	                System.out.println("Failed to add category.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }  
	        return generatedId;  // Return the generated ID or -1 if an error occurred
	    }

public static long getCategorieId(String name) {
		 long idCat=0;
		  Connection c = ConnectionTest.TestConnection();
			try {
				Statement st=c.createStatement();
				ResultSet resultat= st.executeQuery(" SELECT idCategorie FROM `categorie` WHERE `Title`='"+name+"' ");
			
						if(resultat.next())
				{
					idCat=resultat.getLong("idCategorie");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return idCat;
		}
public static Categorie getCategorieById(long id) {
	Connection c = ConnectionTest.TestConnection();
	Categorie C=null;
	try {
		Statement st=c.createStatement();
		ResultSet resultat= st.executeQuery(" SELECT * FROM `categorie` WHERE `idCategorie`="+id);
		
		if(resultat.next())
		{
			long idCat=resultat.getLong("idCategorie");
			String title=resultat.getString("Title");
			C= new Categorie(idCat , title);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return C;
}
	 public static List<Categorie> AllCategorie() {
		 Connection c =	ConnectionTest.TestConnection();

		 List<Categorie> listC =new ArrayList<>();

			try{
				Statement st=null;
				 st = c.createStatement();
					System.out.println("statement ok");
					ResultSet res= st.executeQuery("SELECT * FROM `categorie` ORDER BY`idCategorie`ASC;");//get a copie of result 
				
						 while(res.next())
						 { 
						long id=res.getLong("idCategorie"); 
						 String nom=res.getString("Title"); 
						
						 Categorie p2= new Categorie(id , nom);
						 listC.add(p2);
						 //System.out.println(list);
					}

		    	}catch(SQLException e) {
				e.printStackTrace();

			   }
			return listC;
	}
	 public static void SupCategorie(long idCat) {
		 Connection c =	ConnectionTest.TestConnection();

		try{
			Statement st=null;
			 st = c.createStatement();
				System.out.println("statement ok5");
				System.out.println(idCat);

				ResultSet res= st.executeQuery("select * from categorie where idCategorie ="+idCat+"; ");//get a copie of result 
				if(res.next()) {
					ResultSet products= st.executeQuery("select * from produit where IdCategorie ="+idCat+"; ");//get a copie of result 
					if(products.next()) {
						System.out.println("you can't delete categorie bcs is full");
					} else {
						st.executeUpdate("delete from categorie where idCategorie ="+idCat+"");
						System.out.println("deleted");
					}
					
				 
				}else {
					System.out.println("doesnt exist");
				}

	    	}catch(SQLException e) {
			e.printStackTrace();

		   }
	}
	 public static void modifieCategorie(Categorie F) {
		 Connection c =	ConnectionTest.TestConnection();
		 System.out.println(F.getIdCategorie());
		 System.out.println(F.getTitle());
		try{
			Statement st=null;
			 st = c.createStatement();
				System.out.println("statement ok5");
				ResultSet res= st.executeQuery("select * from categorie where idCategorie="+F.getIdCategorie()+"") ;//get a copie of result "
			
				if(res.next()) {
					System.out.println("hi");
					st.executeUpdate("UPDATE `categorie` SET `Title` ='"+F.getTitle()+"'  WHERE `categorie`.`idCategorie` = "+F.getIdCategorie()+ "");
					System.out.println("UPDATED");
				 
				}else {
					System.out.println("doesnt exist");
				}

	    	}catch(SQLException e) {
			e.printStackTrace();

		   }
	}
	    public static List<Produit> FindProduitsByCategory(long id) {
	    	 Connection c =	ConnectionTest.TestConnection();
			 List<Produit> list =new ArrayList<>();

	 		try{
	 			Statement st=null;
	 			 st = c.createStatement();
	 				System.out.println("statement FindProduitsByCategory");

	 				ResultSet resultat= st.executeQuery("SELECT DISTINCT* FROM `produit` p INNER JOIN categorie c ON p.`IdCategorie`=c.idCategorie where c.IdCategorie ="+id);//get a copie of result 
	 				 while(resultat.next())
					 { 
	 					long idC=resultat.getLong("idProduit");
	 					String nom=resultat.getString("nom");
	 					long prix=resultat.getLong("prix");
	 					int qt_dispo=resultat.getInt("quantite_dispo");
	 					long idCat=resultat.getInt("IdCategorie");
	 					String titleCat=resultat.getString("Title");
	 					String url=resultat.getString("urlPhoto");
	 					Categorie C=new Categorie(idCat,titleCat);
	 					Produit p=new Produit(idC, nom, prix, qt_dispo,url,C);
					 list.add(p);
					 //System.out.println(list);
				}
	 					
	 				 
	 				

	 	    	}catch(SQLException e) {
	 			e.printStackTrace();

	 		   }
			return list;
		}
}
