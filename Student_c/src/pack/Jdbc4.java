package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//1.load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Establish the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleDB","root","Sap1999@j");
			
		
		String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, "shubham");
		statement.setString(2, "Sap1999@j");
		statement.setString(3, "shubham jaiswal");
		statement.setString(4, "amashubhamjaiswal@gmail.com");
		 
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		}
		String sql1 = "SELECT * FROM Users";
		 
		Statement statement1 = con.createStatement();
		ResultSet result = statement1.executeQuery(sql1);
		 
		int count = 0;
		 
		while (result.next()){
		    String name = result.getString(2);
		    String pass = result.getString(3);
		    String fullname = result.getString("fullname");
		    String email = result.getString("email");
		 
		    String output = "User #%d: %s - %s - %s - %s";
		    System.out.println(String.format(output,count++,name ,pass, fullname,email));
		}
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
