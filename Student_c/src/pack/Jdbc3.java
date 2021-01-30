package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc3 {

	public static void main(String[] args) {
		try {
			//1.load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.Establish the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","Sap1999@j");
			
		String sql = "INSERT INTO faculty (Name,subject,Id) VALUES (?, ?, ?)";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, "shubham");
		statement.setString(2, "DAA");
		statement.setString(3, "3");
		 
		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("A new user was inserted successfully!");
		}
		String sql1 = "SELECT * FROM faculty";
		 
		Statement statement1 = con.createStatement();
		ResultSet result = statement1.executeQuery(sql1);
		 
		int count = 0;
		while (result.next()){
		    String name = result.getString("name");
		    String subject = result.getString("subject");
		    String Id = result.getString("Id");
		   	 
		    String output = "student #%d: %s - %s - %s ";
		    System.out.println(String.format(output,count++,name ,subject,Id));
		}
		}catch(Exception e) {
			System.out.println(e);
		}
			
		}

	}


