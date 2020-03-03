package exampleprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConnectionDB {
	private Connection connection;
	private static Statement statement;
	private static ResultSet rs;
	PreparedStatement prSt = null;
	@BeforeClass()
	public void setup() throws ClassNotFoundException, SQLException
	{
		String databaseURL = "jdbc:mysql://localhost:3306/selenium";
		String user = "root";
		String password = "root";
		connection = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connecting to Database...");
		connection = DriverManager.getConnection(databaseURL, user, password);
		if (connection != null) {
			System.out.println("Connected to the Database...");

		}}
	@Test()
	public void getEmployeesFromDataBase() throws SQLException
	{
		//code to execute the select query
		//String query = "select * from seleniumusers where firstname='test123'";
		/*String query = "select * from seleniumusers";
     	statement=connection.createStatement();
     	rs=statement.executeQuery(query);
     	System.out.println(rs);
     	while(rs.next())
     	{
     		String username= rs.getString("firstname");
     		//String emailid= rs.getString("email"); or
     		String emailid= rs.getString(2);
     		System.out.println(username +"\t"+ emailid);

     	}*/
		
		
	// code to update and select the query
		
		/*statement=connection.createStatement();
		String query = "update seleniumusers set firstname='john' where email='test@gmail.com'";
		int count = statement.executeUpdate(query);
		System.out.println("Updated queries: "+count);
		String selectquery = "select * from seleniumusers";
		rs=statement.executeQuery(selectquery);
		System.out.println("After updates the values");
		while(rs.next())
     	{
     		String username= rs.getString("firstname");
     		//String emailid= rs.getString("email"); or
     		String emailid= rs.getString(2);
     		System.out.println(username +"\t"+ emailid);

     	}*/
		
		//code for insert the values by using prepared statement.
		/*String insertquery = "insert into seleniumusers(firstname,email,id) values(?,?,?)";
		prSt = connection.prepareStatement(insertquery);
		prSt.setString(1, "smith");
		prSt.setString(2, "one@123.com");
		prSt.setInt(3, 123);
		//count will give you how many records got updated
		int count = prSt.executeUpdate();
		System.out.println(count);
	      //Run the same query with different values
		prSt.setString(1, "smithson");
		prSt.setString(2, "two@123.com");
		prSt.setInt(3, 154);
		count = prSt.executeUpdate();
		System.out.println(count);
		String query = "select * from seleniumusers";
     	statement=connection.createStatement();
     	rs=statement.executeQuery(query);
     	System.out.println(rs);
     	while(rs.next())
     	{
     		String username= rs.getString("firstname");
     		//String emailid= rs.getString("email"); or
     		String emailid= rs.getString(2);
     		int id= rs.getInt(3);
     		System.out.println(username +"\t"+ emailid+"\t"+id);

     	}
		*/
		
		//code to delete the record--JDBC Statement + Delete records example

		
		/*String deletequery = "delete from seleniumusers where id=123";
		statement=connection.createStatement();
		statement.executeUpdate(deletequery);
		 System.out.println("Record deleted successfully");*/
		 
		 //JDBC PreparedStatement + Delete records example
		 /*String deletequery = "delete from seleniumusers where id=?";
		 PreparedStatement stmt = connection.prepareStatement(deletequery);
		 {
			// i'm deleting the row where the id is "154"
			 stmt.setInt(1,154);
			 stmt.executeUpdate();
			   System.out.println("Record deleted successfully");
		 }*/
		
		
		
		
	}

	@AfterClass
	public void tearDown() {
		if (connection != null) {
			try {
				System.out.println("Closing Database Connection...");
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	}
}
