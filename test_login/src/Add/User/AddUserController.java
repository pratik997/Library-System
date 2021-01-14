package Add.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import Login.Submit.LoginGetterSetter;




public class AddUserController {
	static PreparedStatement ps;
	final static String protocol="jdbc:mysql://localhost:3306/test";
	final static String user="root";
	final static String password="root123";
	
	public static boolean addUser(LoginGetterSetter C)
	{
		try{

		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection(protocol,user,password);
		Statement smt=cn.createStatement();
		String q="insert into login values('"+C.getLoginid()+"','"+C.getUsername()+"','"+C.getRole()+"','"+C.getPassword()+"')";
		smt.executeUpdate(q);
		 return true;
		
	}catch(Exception e)
	{
	System.out.println(e);
	return false;
	}


}
}