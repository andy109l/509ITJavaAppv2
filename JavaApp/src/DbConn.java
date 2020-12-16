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
	/**
	 * concatenates connection sting to the database
	 */
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
	/**
	 * retrieves personal contacts data using select_all_personal stored procedure, formats it to ResultSet
	 * @return
	 */
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
	/**
	 * retrieves businss contacts data using select_all_business stored procedure, formats it to ResultSet
	 * @return
	 */
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
	/**
	 * Updates the personal contact data in the database based on the id, using the update_personal stored procedure
	 * @param id
	 * @param first_name
	 * @param last_name
	 * @param email
	 * @param phone_number
	 * @param address_line_1
	 * @param address_line_2
	 * @param postcode
	 * @param country
	 */
	public void UpdatePersonal(String id, String first_name,String last_name,String email,String phone_number,String address_line_1,String address_line_2,String postcode,String country) 
	{
		ResultSet rs=null;
		String sql="{call update_personal(?,?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst = con.prepareCall(sql);
			cst.setString(1 ,id);
			cst.setString(2 ,first_name);
			cst.setString(3 ,last_name);
			cst.setString(4 ,email);
			cst.setString(5 ,phone_number);
			cst.setString(6 ,address_line_1);
			cst.setString(7 ,address_line_2);
			cst.setString(8 ,postcode);
			cst.setString(9 ,country);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Updates the business contact data in the database based on the id, using the update_business stored procedure
	 * @param id
	 * @param first_name
	 * @param last_name
	 * @param email
	 * @param address_line_1
	 * @param address_line_2
	 * @param postcode
	 * @param country
	 * @param company
	 * @param business_phone_number
	 */
	public void UpdateBusiness(String id, String first_name,String last_name,String email,String address_line_1,String address_line_2,String postcode,String country,String company,String business_phone_number) 
	{
		ResultSet rs=null;
		String sql="{call update_business(?,?,?,?,?,?,?,?,?,?)}";
		try {
			java.sql.CallableStatement cst = con.prepareCall(sql);
			cst.setString(1 ,id);
			cst.setString(2 ,first_name);
			cst.setString(3 ,last_name);
			cst.setString(4 ,email);
			cst.setString(5 ,address_line_1);
			cst.setString(6 ,address_line_2);
			cst.setString(7 ,postcode);
			cst.setString(8 ,country);
			cst.setString(9 ,company);
			cst.setString(10 ,business_phone_number);
			rs=cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Insets the personal contact data from the object into database using the add_personal stored procedure
	 * @param first_name
	 * @param last_name
	 * @param email
	 * @param phone_number
	 * @param address_line_1
	 * @param address_line_2
	 * @param postcode
	 * @param country
	 */
	public void InsertPersonal(String first_name,String last_name,String email,String phone_number,String address_line_1,String address_line_2,String postcode,String country) 
	{
		String sql="{call add_personal(?,?,?,?,?,?,?,?)}";
		
		try {
			java.sql.CallableStatement cst = con.prepareCall(sql);
			cst.setString(1 ,first_name);
			cst.setString(2 ,last_name);
			cst.setString(3 ,email);
			cst.setString(4 ,phone_number);
			cst.setString(5 ,address_line_1);
			cst.setString(6 ,address_line_2);
			cst.setString(7 ,postcode);
			cst.setString(8 ,country);
			cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Insets the business contact data from the object into database using the add_business stored procedure
	 * @param first_name
	 * @param last_name
	 * @param email
	 * @param address_line_1
	 * @param address_line_2
	 * @param postcode
	 * @param country
	 * @param company
	 * @param business_phone_number
	 */
	public void InsertBusiness(String first_name,String last_name,String email,String address_line_1,String address_line_2,String postcode,String country,String company,String business_phone_number) 
	{
		String sql="{call add_business(?,?,?,?,?,?,?,?,?)}";
		
		try {
			java.sql.CallableStatement cst = con.prepareCall(sql);
			cst.setString(1 ,first_name);
			cst.setString(2 ,last_name);
			cst.setString(3 ,email);
			cst.setString(4 ,address_line_1);
			cst.setString(5 ,address_line_2);
			cst.setString(6 ,postcode);
			cst.setString(7 ,country);
			cst.setString(8 ,company);
			cst.setString(9 ,business_phone_number);
			cst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Deletes the personal contact data in the database based on the id, using the delete_business stored procedure
	 * @param id
	 */
	public void DeletePersonal (String id)
	{
		String sql="{call delete_personal(?)}";
		java.sql.CallableStatement cst;
		try {
			cst = con.prepareCall(sql);
			cst.setString(1 ,id);
			cst.executeQuery();
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Deletes the business contact data in the database based on the id, using the delete_business stored procedure
	 * @param id
	 */
	public void DeleteBusiness (String id)
	{
		String sql="{call delete_business(?)}";
		java.sql.CallableStatement cst;
		try {
			cst = con.prepareCall(sql);
			cst.setString(1 ,id);
			cst.executeQuery();
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
