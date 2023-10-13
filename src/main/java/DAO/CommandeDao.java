package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Entity.Commande;
import Entity.Produit;
import Entity.Role;
import Entity.User;


public class CommandeDao {
	public static List<Commande> AfficherCommandeListe()
	{
		Connection co = ConnectionTest.TestConnection();//cette etap qui nous donne la liaison avec la connection
		 
		 List<Commande> list =new ArrayList<>();

			try{
				Statement st=null;
				 st = co.createStatement();
					System.out.println("statement ok3");
					ResultSet res= st.executeQuery("SELECT * FROM `commande` C INNER JOIN `User` U ON C.`idUser`=U.idUser  INNER JOIN role R ON U.idRole=R.idRole");

						 while(res.next())
						 { 
						 long idCommande=res.getLong("idComnande"); 
						 
						 Date created_at=res.getDate("created_at"); 
						 System.out.println(created_at);
						 long idUser=res.getLong("idUser");
						 
						 String nom = res.getString("nom");
						 String prenom = res.getString("prenom");
						 int age = res.getInt("age");  // Assurez-vous d'avoir une colonne 'age' dans votre table.
						 Date date_naissance = res.getDate("date_naissance");
						 String email = res.getString("email");
						 String password = res.getString("password");
						 long idRole = res.getLong("idRole");
						 String nomRole = res.getString("RoleNom");
						 Role R=new Role(idRole,nomRole);

						User p1= new User(idUser, nom , prenom,age,date_naissance,email,password,R);
						Commande p2= new Commande(idCommande ,created_at, p1);
						 list.add(p2);
								}
					    	}catch(SQLException e) {
							e.printStackTrace();
			
						   }
						return list;
	}	
//	public static long addCommande(Commande C) {
//		Connection conx=ConnectionTest.TestConnection();
//		try {
//			Statement st=conx.createStatement();
////			System.out.println(p.getCategorie());
////			System.out.println(idCat);
//			String query="INSERT INTO `commande` (`idComnande`, `created_at`, `idUser`) VALUES (NULL, '2023-08-28', '3');)";
//			 int rowsAffected = st.executeUpdate(query);
//	            if (rowsAffected > 0) {
//	                System.out.println("Product added successfully.");
//	            } else {
//	                System.out.println("Failed to added product.");
//	            }
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
