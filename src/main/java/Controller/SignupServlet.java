package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDao;
import DAO.UserDao;
import Entity.Role;
import Entity.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int  age = Integer.parseInt(request.getParameter("age"));
		String   dateString = request.getParameter("date_naissance");
		String  email = request.getParameter("email");
        String password = request.getParameter("password");
        
		  // Step 1: Parse the input string date into a java.util.Date object
      SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date dateNaissanceUtil = inputDateFormat.parse(dateString);

      // Step 2: Create a java.sql.Date object from the java.util.Date object
      long milliseconds = dateNaissanceUtil.getTime();
      java.sql.Date dateNaissanceSql = new java.sql.Date(milliseconds);
        String role = AdminDao.authenticateUser(email, password);
        User user=UserDao.getUser(email, password);

	       if ("USER".equals(role)) {
	        	  // Authentification réussie, créez une session et stockez l'info d'authentification
	            HttpSession session = request.getSession();
	           session.setAttribute("isUserLoggedIn", true);
	           session.setAttribute("user", user);

	            // Redirigez vers le tableau de bord de l'administrateur
	            response.sendRedirect("venustyle.jsp");
	     	   
	        }else if ("ADMIN".equals(role)) {
	        	  // Authentification réussie, créez une session et stockez l'info d'authentification
	            HttpSession session = request.getSession();
	           session.setAttribute("isAdminLoggedIn", true);
	           session.setAttribute("user", user);

	            // Redirigez vers le tableau de bord de l'administrateur
	            response.sendRedirect("adminDashboard.jsp");
	     	   
	        } else {
	        	 Role role1= new Role("USER");
	 	        User user1=new User(nom,prenom,age, dateNaissanceSql,email,password,role1);
	 	        UserDao.addUser(user1);
	 	        response.sendRedirect("login.jsp");
	        }
	    
	    } catch (ParseException e) {
	        e.printStackTrace();
	        // Handle the exception as needed (e.g., display an error message)
	    }


	}

}
