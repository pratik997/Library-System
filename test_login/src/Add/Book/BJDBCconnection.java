package Add.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class BJDBCconnection {
	static PreparedStatement ps;
	final static String protocol="jdbc:mysql://localhost:3306/test";
	final static String user="root";
	final static String password="root123";
		public static boolean insertBook(BookGS C)
		{  
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection(protocol,user,password);
			String smt= "insert into bookf(subject,bookid,bookname,auth,book) values (?,?,?,?,?)";
			PreparedStatement statement=cn.prepareStatement(smt);
			statement.setString(1, C.getSub());
			statement.setString(2, C.getBookid());
			statement.setString(3, C.getBookname());
			statement.setString(4, C.getAuth());
			statement.setString(5, C.getPdf());
			statement.executeUpdate();
			return true;
			}
		
		catch(Exception e)
		{System.out.println(e);}
		return false;	
		}
		
		
public static ResultSet DisplayAll()
		{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection(protocol,user,password);
			Statement smt=cn.createStatement();
			ResultSet rs=smt.executeQuery("select * from book");
			return(rs);
			
		}catch(Exception e)
		{
		System.out.println(e);
		return null;
		}
		
	}


}
