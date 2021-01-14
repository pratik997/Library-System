package Login.Submit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;




public class JDBCConnection {
	static PreparedStatement ps;
	final static String protocol="jdbc:mysql://localhost:3306/test";
	final static String user="root";
	final static String password="root123";
	public static LoginGetterSetter checkPassword(String loginid,String pwd)
	{
		LoginGetterSetter A=new LoginGetterSetter();
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection(protocol,user,password);
		
		Statement smt=cn.createStatement();
		String q="select * from login where loginid='"+loginid+"'and pass='"+pwd+"'";
		ResultSet rs=smt.executeQuery(q);
		if(rs.next())
		   {
			
			A.setLoginid(rs.getString(1));
			A.setUsername(rs.getString(2));
			A.setPassword(rs.getString(4));
			A.setRole(rs.getString(3));
			return (A);
		   }
		else{
			 return null;
		    }
		
	    }
	
	catch(Exception e)
	{System.out.println(e);
	 return null;}
	}
		
		
public static ResultSet DisplayAll()
		{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection(protocol,user,password);
			Statement smt=cn.createStatement();
			ResultSet rs=smt.executeQuery("select * from login");
			return(rs);
			
		}catch(Exception e)
		{
		System.out.println(e);
		return null;
		}
		
	}


}
