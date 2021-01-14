package Add.Book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.softech.FileUpload;


/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
@MultipartConfig(fileSizeThreshold=1024*1024*1024, maxFileSize=1024*1024*1024, maxRequestSize=1024*1024*1024 )
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			BookGS C=new BookGS();
			C.setBookid(request.getParameter("bid"));
			C.setBookname(request.getParameter("bname"));
			C.setAuth(request.getParameter("name"));
			C.setSub(request.getParameter("sub"));
			
			Part part=request.getPart("pdf");
			String savepath="F:/test_login/WebContent/book";
			FileUpload F=new FileUpload(part,savepath);
			C.setPdf(F.filename);
			
			boolean st=BJDBCconnection.insertBook(C);
			if(st)
			{
				request.setAttribute("message", "Book added Successfully");
				request.getRequestDispatcher("AddBook.jsp").forward(request, response);
				
			}
			else
			{
				request.setAttribute("message", "Book addition Unsuccessful");
				request.getRequestDispatcher("AddBook.jsp").forward(request, response);
			}
			
			
		}catch (Exception e) {System.out.println(e);}
		
	}

}
