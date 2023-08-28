package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategorieDao;
import Entity.Produit;

/**
 * Servlet implementation class ServletProduitsByCatg
 */
@WebServlet("/ServletProduitsByCatg")
public class ServletProduitsByCatg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProduitsByCatg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 long categoryId = Long.parseLong(request.getParameter("idCategorie"));
			List<Produit>  listP = CategorieDao.FindProduitsByCategory(categoryId);
			request.setAttribute("list",listP);
			System.out.println(listP);
	this.getServletContext().getRequestDispatcher("/listProduitParCat.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
