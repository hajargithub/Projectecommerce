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
				String url="jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7640908";
				String user="sql7640908";
				String pass="qCjxbkxVa2";
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
