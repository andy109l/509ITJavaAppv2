import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

public class DbConn {
	String connString = "jdbc:mysql://localhost/509itcrudsys";
	String username = "root";
	String password = "";
	Connection con = null;
	
	public DbConn()
	{
		try {
			con = DriverManager.getConnection(connString, username, password);
			System.out.println("Connection Succesful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection Failed");
		}
	}
	
	public ResultSet getAllPersonal() 
	{
		ResultSet rs=null;
		String sql="{call select_all_personal()}";
		try {
			java.sql.CallableStatement cst = con.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public ResultSet getAllBusiness() 
	{
		ResultSet rs=null;
		String sql="{call select_all_business()}";
		try {
			java.sql.CallableStatement cst = con.prepareCall(sql);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
}
