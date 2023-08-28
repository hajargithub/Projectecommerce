package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.CategorieDao;
import DAO.ProduitDao;
import Entity.Categorie;
import Entity.Produit;

/**
 * Servlet implementation class ServletAddProduit
 */
@WebServlet("/ServletAddProduit")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class ServletAddProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie>ListC=CategorieDao.AllCategorie();
		request.setAttribute("ListC",ListC);
		this.getServletContext().getRequestDispatcher("/ajoutProduit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String nom =request.getParameter("nom");
		long prix=Long.parseLong(request.getParameter("prix"));
		int qt_dispo=Integer.parseInt(request.getParameter("quantity_dispo"));
	    // Retrieve the selected category's ID		
	    long selectedCategoryId = Long.parseLong(request.getParameter("selectedCategoryId")); 
	    Categorie C=CategorieDao.getCategorieById(selectedCategoryId);
Part file=request.getPart("image");
		
		String imageFileName=file.getSubmittedFileName();  // get selected image file name
		System.out.println("Selected Image File Name : "+imageFileName);
		
		String uploadPath="/assets/images/"+imageFileName;  // upload path where we have to upload our actual image
		System.out.println("Upload Path : "+uploadPath);
		
		// Uploading our selected image into the images folder
		
		try
		{
		
		FileOutputStream fos=new FileOutputStream(uploadPath);
		InputStream is=file.getInputStream();
		
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(imageFileName);
		Produit P=new Produit(nom,prix,qt_dispo,imageFileName,C);
		ProduitDao.insererProduit(P);
	      response.sendRedirect(request.getContextPath() + "/ServletListProduits");
	}
	

}
