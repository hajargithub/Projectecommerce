package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static Connection TestConnection() {
		 Connection co=null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("driver ok");
				String url="jdbc:mysql://mysql8002.site4now.net:3306/db_a9df6d_dbecom";
				String user="a9df6d_dbecom";
				String pass="Java@123321";
				co=DriverManager.getConnection(url,user,pass);
				System.out.println("cnx ok");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return co;
				}
}
