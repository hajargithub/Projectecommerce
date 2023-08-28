package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategorieDao;
import Entity.Categorie;

/**
 * Servlet implementation class ServletUpdateCategorie
 */
@WebServlet("/ServletUpdateCategorie")
public class ServletUpdateCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUpdateCategorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		long idC =Long.parseLong(request.getParameter("idCategorie"));
		request.setAttribute("idC",idC);
//		 Categorie C=CategorieDao.getCategorieById(idC);
//		CategorieDao.modifieCategorie(C);
		this.getServletContext().getRequestDispatcher("/updatecatg.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Long idC=Long.parseLong(request.getParameter("idC"));
		System.out.println(idC);
		String nom =request.getParameter("title");
		Categorie Cat	= new Categorie(idC,nom);
       CategorieDao.modifieCategorie(Cat);
       response.sendRedirect(request.getContextPath() + "/ServletListCategories");
	}

}
