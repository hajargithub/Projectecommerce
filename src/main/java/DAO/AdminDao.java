package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao {
	public static String authenticateUser(String email, String password) {
   		Connection c=ConnectionTest.TestConnection();
   		String  adminRole=null;
	        try {
	        	Statement st=c.createStatement();
				System.out.println("statement ok");
	        	
              ResultSet resultSet = st.executeQuery("SELECT * FROM User u JOIN Role r ON u.idRole = r.idRole WHERE u.email ='"+email+"' AND u.password = '"+password+"'");
				
              if (resultSet.next()) {
                  adminRole = resultSet.getString("RoleNom");
              }
              c.close();	
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        }
			return adminRole;
	    }

}
