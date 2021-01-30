package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDelete {

	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","Sap1999@j");
		String sql = "DELETE FROM faculty WHERE name=?";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, "Sakshi");
		 
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("A user was deleted successfully!");
		}
		String sql1 = "select * from faculty" ;
		 
		Statement statement1 = con.createStatement();
		ResultSet result = statement1.executeQuery(sql1);
		
		int count = 0;
		while(result.next()) {
			String subject = result.getString("subject");
			String Id = result.getString("Id");
			
			
			String output = "student #%d: %s - %s ";
			System.out.println(String.format(output,count++,subject,Id));
		}
		}
		catch(Exception e) {
			System.out.println(e);

		}
		
	}

}
