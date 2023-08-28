package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import Entity.Role;
import Entity.User;

public class UserDao {
	public static void addUser(User U) {
		Connection conx=ConnectionTest.TestConnection();
		try {
			Statement st=conx.createStatement();
			System.out.println(U.getRole().getRoleName());
			long idRole=getRoleId(U.getRole().getRoleName());
			System.out.println(idRole);
			String query="INSERT INTO `user` (`idUser`, `nom`, `prenom`, `age`, `date_naissance`, `email`, `password`, `idRole`) VALUES (NULL,'"+U.getNom()+"' , '"+U.getPrenom() +"', "+U.getAge()+", '"+U.getDate_naissance()+"', '"+U.getEmail()+"', '"+U.getPassword()+"', "+idRole+");";
			 int rowsAffected = st.executeUpdate(query);
	            if (rowsAffected > 0) {
	                System.out.println("User added successfully.");
	            } else {
	                System.out.println("Failed to added user.");
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static long getRoleId(String name) {
		 long idRole=0;
		  Connection c = ConnectionTest.TestConnection();
			try {
				Statement st=c.createStatement();
				ResultSet resultat= st.executeQuery(" SELECT `idRole` FROM `role` WHERE`RoleNom`='"+name+"'");
			
						if(resultat.next())
				{
							idRole=resultat.getLong("idRole");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return idRole;
		}
	public static User getUser(String email, String password) {
		Connection c=ConnectionTest.TestConnection();
		User  user=null;
		try {
			Statement st=c.createStatement();
			System.out.println("statement ok");
			
			ResultSet resultSet = st.executeQuery("SELECT * FROM User u JOIN Role r ON u.idRole = r.idRole WHERE u.email ='"+email+"' AND u.password = '"+password+"'");
			
			if (resultSet.next()) {
				long iduser = resultSet.getLong("idUser");
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				int age=resultSet.getInt("age");
				Date dateN=resultSet.getDate("date_naissance");
				String email1 = resultSet.getString("email");
				String password1 = resultSet.getString("password");
				long idRole = resultSet.getLong("idRole");
				String roleName = resultSet.getString("RoleNom");
				Role R= new Role(idRole,roleName);
				user =new User(iduser,nom,prenom,age,dateN,email1,password1,R);
				
			}
			c.close();	
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return user;
	}


}
