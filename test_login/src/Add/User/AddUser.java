package Add.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.Submit.LoginGetterSetter;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		try{
			HttpSession ses=request.getSession();
			if(ses.getAttribute("id")==null)
			{
				response.sendRedirect("Login.jsp");
			}
			else
			{
				
				LoginGetterSetter C=new LoginGetterSetter();
				  C.setLoginid(request.getParameter("id"));
				  C.setUsername(request.getParameter("un"));
				  C.setPassword(request.getParameter("pass"));
				  C.setRole(request.getParameter("ro"));
				  
				  boolean st=AddUserController.addUser(C);    
				  if(st)
				  {
					  out.println("User Addition Successful");
					  request.setAttribute("message", "User added Successfully");
					  request.getRequestDispatcher("Add.jsp").forward(request, response);
					  
				  }
				  else
				  {
					  out.println("User Addition Unsuccessful Try Again");  
				  }
			}
			  
			
	}catch(Exception e)
		{out.println(e);}
		// TODO Auto-generated method stub
	}

}
