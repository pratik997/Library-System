package Login.Submit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			LoginGetterSetter r=JDBCConnection.checkPassword(id, pass);
			//System.out.println(r.getRole());

			
			if(r!=null && "admin".equals(r.getRole()))
			{   
				HttpSession ses=request.getSession();
				ses.setAttribute("id", id);
				request.setAttribute("message", "Admin");
				request.getRequestDispatcher("Delete.jsp").forward(request, response);
			}
			else if(r!=null && "user".equals(r.getRole()))
			{
				HttpSession ses=request.getSession();
				ses.setAttribute("id", id);
				request.setAttribute("message", "User");
				request.getRequestDispatcher("User.jsp").forward(request, response);//application
			}
			else
			{
				request.setAttribute("message", "NotFound");
			}
		}catch(Exception e) {System.out.println(e);}
		
		
	}

}
