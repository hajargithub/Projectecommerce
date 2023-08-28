package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDao;
import DAO.UserDao;
import Entity.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String role = AdminDao.authenticateUser(email, password);
	        User user=UserDao.getUser(email, password);

	        if ("ADMIN".equals(role)) {
	        	  // Authentification réussie, créez une session et stockez l'info d'authentification
	            HttpSession session = request.getSession();
	           session.setAttribute("isAdminLoggedIn", true);
	           session.setAttribute("user", user);
	            // Redirigez vers le tableau de bord de l'administrateur
	            response.sendRedirect("adminDashboard.jsp");
	     	   
	        } else if ("USER".equals(role)) {
	        	  // Authentification réussie, créez une session et stockez l'info d'authentification
	            HttpSession session = request.getSession();
	           session.setAttribute("isUserLoggedIn", true);
	           session.setAttribute("user", user);
	            // Redirigez vers le tableau de bord de l'administrateur
	            response.sendRedirect("ServletIndex");
	        } 
	        else {
	            // Échec de l'authentification, redirigez vers la page de connexion avec un message d'erreur
	            response.sendRedirect("signup.jsp");
	        }
		}
	      
	    
}	


